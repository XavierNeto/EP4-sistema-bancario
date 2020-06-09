
public class Cliente extends Pessoa implements InterfaceCliente {
	static final int dividaMaxima = 30000;
	static final String tipo = "C";
	private int valorContaCorrente;
	private int valorDaDivida;

	/*
	 * Construtor da Classe Cliente Este construtor invoca o construtor da classe
	 * Pessoa e inicializa os dois atributos do objeto que esta sendo instanciado.
	 */
	Cliente(String nome, int cpf, int valorInicial) {
		super(nome, cpf);
		valorContaCorrente = valorInicial;
		valorDaDivida = 0;
	}

	/* Metodo que retorna o valor do atributo tipo do objeto atual */
	String retornaTipo() {
		return tipo;
	}

	protected int getValorContaCorrente() {
		return valorContaCorrente;
	}

	protected int getValorDaDivida() {
		return valorDaDivida;
	}

	protected void setValorContaCorrente(int valor) {
		valorContaCorrente = valor;
	}

	protected void setValorDaDivida(int valor) {
		valorDaDivida = valor;
	}

	/*
	 * Metodo para o cliente atual obter um emprestimo de acordo com o valor passado
	 * por parametro Caso o valor do parametro seja menor ou igual a zero, o metodo
	 * deve retornar false Caso contrario ha duas situacoes: 1a) se o valor do
	 * parametro mais o valor do atributo valorDaDivida for maior do que o valor da
	 * constante dividaMaxima, o metodo deve retornar false 2a) caso contrario, o
	 * atributo valorDaDivida deve ser incrementado em valor, o atributo
	 * valorContaCorrente deve ser incrementado em valor e o metodo deve retornar
	 * true
	 */
	public boolean obterEmprestimo(int valor) {

		/* Checando com o if se o valor eh positivo */

		if (valor > 0) {

			/* Caso seja, mais um if eh usado para checar a situacao 1a */

			int total = valor + getValorDaDivida();
			if (total > dividaMaxima) {
				return false;
			}

			/* No caso da situacao 2a, o valor da divida eh somado ao valor do parametro */

			setValorDaDivida(getValorDaDivida() + valor);

			/*
			 * Em seguida o valor da conta corrente eh acrescido com o novo emprestimo
			 * realizado
			 */

			setValorContaCorrente(getValorContaCorrente() + valor);

			return true;

		}

		// Se o valor for menor ou igual a 0, false eh retornado

		return false;
	}

	/*
	 * Metodo para o cliente atual pagar parte de sua divida de acordo com o valor
	 * passado por parametro Caso o valor do parametro seja menor ou igual a zero, o
	 * metodo deve retornar false Caso contrario ha duas situacoes: 1a) se o valor
	 * do parametro for maior do que o valorDaDivida ou for maior do que
	 * valorContaCorrente, o metodo deve retornar false 2a) caso contrario, o
	 * atributo valorDaDivida deve ser decrementado em valor, o atributo
	 * valorContaCorrente deve ser decrementado em valor e o metodo deve retornar
	 * true
	 */
	public boolean pagarEmprestimo(int valor) {

		/* Testar com if se o valor do parametro eh maiior que 0 */

		if (valor > 0) {

			/* Mais um if testando a situacao 1a */

			if (valor > getValorDaDivida() || valor > getValorContaCorrente()) {
				return false;
			}

			/*
			 * Caso ocorra a situacao 2a, o valor da divida eh decrementado em valor do
			 * parametro, assim como o valor da conta corrente
			 */

			setValorDaDivida(getValorDaDivida() - valor);

			setValorContaCorrente(getValorContaCorrente() - valor);

			return true;

		}

		// Caso o valor do parametro seja menor ou igual a 0, false eh retornado

		return false;
	}

	/*
	 * Metodo que retorna true caso valorContaCorrente seja menor do que
	 * valorDaDivida. Caso contrario, retorna false.
	 */
	public boolean negativado() {

		// if utilizado para checar se o valor da divida eh maior que o saldo da conta

		if (getValorContaCorrente() < getValorDaDivida()) {

			// Caso seja, true é retornado

			return true;
		}

		// Caso o saldo seja maior que a divida, false eh retornado

		return false;
	}

	/*
	 * Metodo para o cliente atual realizar um saque do valor passado por parametro
	 * Caso o valor do parametro seja menor ou igual a zero, o metodo deve retornar
	 * false Caso contrario ha duas situacoes: 1a) se o valor do parametro for maior
	 * do que o valor do atributo valorContaCorrente, o metodo deve retornar false
	 * 2a) caso contrario, o atributo valorContaCorrente deve ser decrementado em
	 * valor e o metodo deve retornar true
	 */
	public boolean realizarSaque(int valor) {

		// Aqui o if eh usado para checar se o valor do parametro eh positivo

		if (valor > 0) {

			// Mais um if para verificar a situacao 1a

			if (valor > getValorContaCorrente()) {

				// Caso 1a aconteca, false eh retornado

				return false;
			}

			/*
			 * Se 2a acontecer, o valor do parametro eh descontado do saldo da conta
			 * corrente, e retornado true
			 */

			setValorContaCorrente(getValorContaCorrente() - valor);

			return true;
		}

		return false;
	}
}