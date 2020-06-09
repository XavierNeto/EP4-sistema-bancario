/*********************************************************************/
/**   ACH2001 - Introdução à Programação                            **/
/**   EACH-USP - Primeiro Semestre de 2020                          **/
/**   <2020194> - <Norton Trevisan Roman>                           **/
/**                                                                 **/
/**   Quarto Exercício-Programa                                     **/
/**                                                                 **/
/**   <Augusto Xavier Neto>                   <11367581>            **/
/**                                                                 **/
/**   <27/06/2020>                                                  **/
/*********************************************************************/

public class Banco {
	private Gerente[] gerentes;
	private int numGerentes;

	/*
	 * Construtor da Classe Banco Inicializa os dois atributos do objeto que esta
	 * sendo instanciado.
	 */
	Banco() {
		gerentes = new Gerente[10];
		numGerentes = 0;
	}

	/*
	 * Metodo para Imprimir informacoes gerais sobre o banco atual
	 */
	void imprimir() {
		System.out.println("#########################################################################");
		System.out.println("Imprimindo informacoes do banco.");
		System.out.println("Ha " + numGerentes + " gerente(s) neste banco.");
		Gerente ger;
		for (int g = 0; g < numGerentes; g++) {
			ger = gerentes[g];
			System.out.println("Gerente: " + ger.nome + "\tCPF: " + ger.cpf);
			ger.imprimirClientes();
		}
		System.out.println("#########################################################################");
	}

	/*
	 * Metodo para adicionar um gerente no arranjo de gerentes do banco. Caso o
	 * numero de gerentes seja igual a 10, nao deve adicionar e deve retornar false.
	 * Caso contrario, ha duas situacoes: 1a: o gerente ja consta no arranjo de
	 * gerentes (verifique isso usando o numero do cpf), neste caso o gerente nao
	 * deve ser reinserido e o metodo deve retornar false; 2a: o gerente passado
	 * como parametro nao consta no arranjo de gerentes: o gerente deve ser
	 * adicionado na posicao numGerentes, o atributo numGerentes deve ser
	 * incrementado em 1 e o metodo deve retornar true.
	 */
	boolean adicionarGerente(Gerente gerente) {

		// Verificar se ja existe 10 gerentes usando o if

		if (numGerentes < 10) {

			/*
			 * Percorrer todo o vetor comparando cada elemento para ver se já existe um cpf
			 * igual
			 */

			for (int i = 0; i < numGerentes; i++) {

				if (gerentes[i].cpf == gerente.cpf) {
					return false;
				}
			}

			/*
			 * Caso nao exista um cpf igual, o elemento sera colocado na posicao
			 * numGerentes, e posteriormente numGerentes sera incrementado em 1 para estar
			 * pronto para a proxima adicao
			 */

			gerentes[numGerentes] = gerente;
			numGerentes++;

			return true;
		}

		// Caso ja exista 10 gerentes, false eh retornado

		return false;
	}
}