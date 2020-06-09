
public class ClienteEspecial extends Cliente {
	static final int dividaMaxima = 50000;
	static final String tipo = "CE";

	/*
	 * Construtor da Classe ClienteEspecial Este construtor invoca o construtor da
	 * classe Cliente.
	 */
	ClienteEspecial(String nome, int cpf, int valor) {
		super(nome, cpf, valor);
	}

	/* Metodo que retorna o valor do atributo tipo do objeto atual */
	String retornaTipo() {
		return tipo;
	}

	/*
	 * A mesma logica do obterEmprestimo na classe Cliente, com diferenca apenas na
	 * constante de divida maxima, maior na classe ClienteEspecial
	 */

	public boolean obterEmprestimo(int valor) {
		if (valor > 0) {
			int total = valor + getValorDaDivida();
			if (total > dividaMaxima) {
				return false;
			}
			int novaDivida = getValorDaDivida() + valor;
			setValorDaDivida(novaDivida);

			int novaContaCorrente = getValorContaCorrente() + valor;
			setValorContaCorrente(novaContaCorrente);

			return true;

		}

		return false;
	}

}