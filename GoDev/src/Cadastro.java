
//C�digo desenvolvido por Gabriel Bertoldi In�cio
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Cadastro implements ICadastro {

	private ArrayList<String> turma1 = new ArrayList<String>();
	private ArrayList<String> turma2 = new ArrayList<String>();
	private ArrayList<String> praca1 = new ArrayList<String>();
	private ArrayList<String> praca2 = new ArrayList<String>();
	private ArrayList<String> totalAlunos = new ArrayList<String>();

	private int lotacao, lotacaoC, totAlunos;
	private int c = 0, c2 = 0, cC = 0, cC2 = 0;
	private String nome, sobrenome, nomeTurma, nomeCafe;
	private boolean criarSala = false, criarCafe = false, tomarCafe = false;

	// Getter e Setter

	public String getNomeCafe() {
		return nomeCafe;
	}

	public void setNomeCafe(String nomeCafe) {
		this.nomeCafe = nomeCafe;
	}
	
	public String getNomeTurma() {
		return nomeTurma;
	}

	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}

	public boolean isTomarCafe() {
		return tomarCafe;
	}

	public void setTomarCafe(boolean tomarCafe) {
		this.tomarCafe = tomarCafe;
	}

	public boolean isCriarCafe() {
		return criarCafe;
	}

	public void setCriarCafe(boolean criarCafe) {
		this.criarCafe = criarCafe;
	}

	public boolean isCriarSala() {
		return criarSala;
	}

	public void setCriarSala(boolean criarSala) {
		this.criarSala = criarSala;
	}

	public int getTotAlunos() {

		return totAlunos;
	}

	public void setTotAlunos(int totAlunos) {

		this.totAlunos = totAlunos;
	}

	public int getcC2() {
		return cC2;
	}

	public void setcC2(int cC2) {
		this.cC2 = cC2;
	}

	public int getcC() {
		return cC;
	}

	public void setcC(int cC) {
		this.cC = cC;
	}

	public int getLotacaoC() {
		return lotacaoC;
	}

	public void setLotacaoC(int lotacaoC) {
		this.lotacaoC = lotacaoC;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public int getC2() {
		return c2;
	}

	public void setC2(int c2) {
		this.c2 = c2;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getLotacao() {
		return lotacao;
	}

	public void setLotacao(int lotacao) {
		this.lotacao = lotacao;
	}

	// M�todo para misturar os alunos, assim quando retornarem para sala estar�o em
	// turmas diferente
	private void juntarAlunos() {
		for (int i = praca1.size() - 1; i >= 0; i--) {
			totalAlunos.add(praca1.get(i));
			praca1.remove(i);
		}
		for (int i = praca2.size() - 1; i >= 0; i--) {
			totalAlunos.add(praca2.get(i));
			praca2.remove(i);
		}

		Collections.shuffle(totalAlunos);
	}

	// INTERFACE

	// Cadastro dos alunos
	@Override
	public void cadastrarAluno(String n, String s) throws Exception {
		// TODO Auto-generated method stub
		if (isCriarSala() == true) {
			setNome(n);
			setSobrenome(s);
			// Analisar caso a sala j� esteja cheia
			if (c < lotacao) {
				turma1.add(getNome() + " " + getSobrenome());
				setC(getC() + 1);

				// Caso a primeira sala esteja cheia os alunos ser�o colocados em uma segunda
				// turma
			} else if (getC() == lotacao) {
				if (c2 < lotacao) {
					turma2.add(getNome() + " " + getSobrenome());
					setC2(getC2() + 1);
				} else {
					throw new Exception("Ambas as salas (ArrayList) est�o cheios, n�o � possivel cadastrar mais alunos.");
				}
			}
		} else {
			throw new Exception("Sala de aula n�o criada, crie uma sala antes de cadastrar os alunos.");
		}
		setTotAlunos(getC() + getC2());
	}

	// Criar sala de aula com nome da turma e o m�ximo de aluno suportado por cada
	// sala
	@Override
	public void cadastrarSala(String n, int t) {
		// TODO Auto-generated method stub
		setNomeTurma(n);
		setLotacao(t);
		setCriarSala(true);
	}

	// Criar area para o caf� podendo escolher a capacidade de cada pra�a de
	// alimenta��o
	@Override
	public void cadastroCafe(String n, int t) {
		// TODO Auto-generated method stub
		setNomeCafe(n);
		setLotacaoC(t);
		setCriarCafe(true);
	}

	// Transfere o conteudo dos arrays da turma para os arrays da pra�a de
	// alimenta��o
	@Override
	public void tomarCafe() throws Exception {
		setcC(0);
		setcC2(0);
		
		if (isCriarCafe()) {
			// Verificar caso haja mais alunos do que vagas na pra�a de caf�
			if (lotacao > lotacaoC) {
				while (cC < lotacaoC) {
					praca1.add(turma1.get(cC));
					turma1.set(cC, "Cadeira Vazia");
					setcC(getcC() + 1);

					// Caso a primeira pra�a esteja lotada os alunos ser�o colocados na segunda pra�a
					if (cC >= lotacaoC && cC < lotacao) {
						cC2 = 0;
						while (cC2 < lotacaoC) {
							praca2.add(turma1.get(cC));
							turma1.set(cC, "Cadeira Vazia");
							setcC(getcC() + 1);
							setcC2(getcC2() + 1);
							if (cC == lotacao && cC < getTotAlunos()) {
								cC = lotacao - lotacaoC;
								while (cC < lotacaoC) {
									praca2.add(turma2.get(cC2));
									turma2.set(cC2, "Cadeira Vazia");
									setcC2(getcC2() + 1);
									setcC(getcC() + 1);
								}
								cC = lotacao + 1;
							}
						}
					}
				}
			}

			// Verificar caso haja exatamente o mesmo n�mero de espa�o em sala de aula e de lugares na pra�a de alimenta��o
			if (getLotacao() == getLotacaoC()) {
				while (cC < lotacaoC) {
					praca1.add(turma1.get(cC));
					turma1.set(cC, "Cadeira Vazia");
					setcC(getcC() + 1);
					if (cC == lotacaoC) {
						while (cC2 < turma2.size()) {
							praca2.add(turma2.get(cC2));
							turma2.set(cC2, "Cadeira Vazia");
							setcC2(getcC2() + 1);
							setcC(getcC() + 1);
						}
					}
				}
			}

			// Verifica caso haja mais vagas na pra�a de caf� do que alunos
			if (lotacaoC > lotacao) {
				do {
					praca1.add(turma1.get(cC));
					turma1.set(cC, "Cadeira Vazia");
					setcC(getcC() + 1);
					if (cC == lotacao && cC < lotacaoC) {
						while (cC < lotacaoC) {
							praca1.add(turma2.get(cC2));
							turma2.set(cC2, "Cadeira Vazia");
							setcC(getcC() + 1);
							setcC2(getcC2() + 1);
						}
					}
				} while (cC < lotacao);
				// Verifica se ainda h� alunos na segunda turma
				if (totAlunos - lotacaoC >= 1) {
					for (int i = 0; i < turma2.size(); i++) {
						if (turma2.get(i).equals("Cadeira Vazia")) {
							// N�o ir� fazer jogar o conteudo Cadeira Vazia para pra�a 2
						} else {
							praca2.add(turma2.get(i));
							turma2.set(i, "Cadeira Vazia");
						}
					}
				}
			}
		} else {
			throw new Exception("A cafeteria n�o foi criada. Use '.cadastroCafe()' para criar uma.");
		}
		setTomarCafe(true);
	}

	// Transfere o conteudo dos arrays da cafeteria para os arrays das salas de aula
	@Override
	public void voltarAula() throws Exception {
		int r = 0;
		if (isTomarCafe()) {
			juntarAlunos();
			// Verifica se tem espa�o na primeira turma e escolhe um aluno aleatorio para ir para a primeira turma
			for (int i = 0; i < lotacao; i++) {
				turma1.set(i, totalAlunos.get(i));
				

				if (i >= lotacao - 1) {
					// Caso a primeira turma esteja cheia, o programa ira colocar os alunos na seguda turma
					i++;
					for (int j = 0; j < turma2.size(); j++) {
						if (turma2.get(j).equals("Cadeira Vazia")) {
							turma2.set(j, totalAlunos.get(i));
							i++;
						}
					}
				}
			}
		} else {
			throw new Exception("Voc� n�o liberou os alunos para tomar caf�, utilize o m�todo .tomarCafe()");
		}
		
		for(int i = totalAlunos.size() - 1; i >= 0; i--) {
			totalAlunos.remove(i);
		}
	}

	@Override
	public void consultaPessoa() {
		// TODO Auto-generated method stub
		int o = 0;
		String nome, sobrenome, nomeCompleto;
		boolean v = false;

		while (o != 3) {
			Scanner scan = new Scanner(System.in);

			System.out.println(
					"1 - Pesquisar por nome completo\n" + "2 - Pesquisar por nome ou sobrenome \n" + "3 - Sair");

			o = scan.nextInt();

			switch (o) {
			// Pesquisa por nome completo do aluno
			case 1:
				System.out.print("Informe o nome: ");
				nome = scan.next();

				System.out.println();

				System.out.print("Informe o sobrenome: ");
				sobrenome = scan.next();

				// Junta o nome e o sobre nome, e converte a primeira letra para maiuscula
				nomeCompleto = (nome.substring(0, 1).toUpperCase() + nome.substring(1)) + " "
						+ (sobrenome.substring(0, 1).toUpperCase() + sobrenome.substring(1));

				// Pesquisa na turma 1
				for (int i = 0; i < lotacao; i++) {
					if (turma1.get(i).equals(nomeCompleto)) {
						System.out.println("O aluno(a) " + nomeCompleto + " est� na turma 1");
						System.out.println();
						v = true;
						break;
						// Pesquisa na turma 2
					} else if (i == lotacao - 1) {
						for (int j = 0; j < totAlunos - lotacao; j++) {
							if (turma2.get(j).equals(nomeCompleto)) {
								System.out.println("O aluno(a) " + nomeCompleto + " est� na turma 2");
								System.out.println();
								v = true;
								break;
							}
						}
					}
				}
				// Pesquisa na pra�a de alimenta��o 1

				for (int i = 0; i < lotacaoC && praca1.size() >= 1; i++) {
					if (praca1.get(i).equals(nomeCompleto)) {
						System.out.println("O aluno(a) " + nomeCompleto + " est� na pra�a de alimenta��o 1");
						System.out.println();
						v = true;
						break;
						// Pesquisa na pra�a de alimenta��o 2
					} else if (i == lotacaoC - 1) {
						for (int j = 0; j < praca2.size(); j++) {
							if (praca2.get(j).equals(nomeCompleto)) {
								System.out.println("O aluno(a) " + nomeCompleto + " est� na pra�a de alimenta��o 2");
								System.out.println();
								v = true;
								break;
							}
						}
					}
				}

				// Imprime uma mensagem caso o nome informado n�o foi encontrado
				if (v == false) {
					System.out.println("O aluno " + nomeCompleto + " n�o consta em nosso banco de dados");
				}
				break;

			case 2:
				// Pesquisa por nome ou sobrenome
				System.out.print("Informe o nome ou sobrenome do aluno: ");
				nome = scan.next();
				// Converter a primeira letra para maiuscula

				nome = nome.substring(0, 1).toUpperCase() + nome.substring(1);
				// Verificar se pessoas contendo o nome ou parte do nome informado est�o em sala
				// de aula
				for (int i = 0; i < turma1.size(); i++) {
					if (turma1.get(i).contains(nome)) {
						System.out.println("Aluno: " + turma1.get(i).toString() + " est� na turma 1");
						v = true;
					}
					if (i == turma1.size() - 1) {
						for (int j = 0; j < turma2.size(); j++) {
							if (turma2.get(j).contains(nome)) {
								System.out.println("Aluno(a): " + turma2.get(j).toString() + " est� na turma 2");
								v = true;
							}
						}
					}
				}
				if (praca1.size() >= 1) {
					for (int i = 0; i < praca1.size(); i++) {
						if (praca1.get(i).contains(nome)) {
							System.out.println("Aluno(a): " + praca1.get(i).toString() + " est� na pra�a 1");
							v = true;
						}
						if (i == praca1.size() - 1) {
							for (int j = 0; j < praca2.size(); j++) {
								if (praca2.get(j).contains(nome)) {
									System.out.println("Aluno(a): " + praca2.get(j).toString() + " est� na pra�a 2");
									v = true;
								}
							}
						}
					}
				}
				// Imprime uma mensagem caso o nome informado n�o foi encontrado
				if (v == false) {
					System.out.println("O nome ou sobrenome: " + nome + " n�o consta em nosso banco de dados");
				}
				break;
			case 3:
				System.out.println("Fechando menu de pesquisa");
			}
		}
	}

	@Override
	public void consultaSala() {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int o = 0;

		while (o != 5) {

			System.out.println("Informe qual sala de aula ou pra�a de alimenta��o deseja pesquisar \n"
					+ "1 = Sala de aula n� 1 \n" + "2 = Sala de aula n� 2 \n" + "3 = Pra�a de alimenta��o 1 \n"
					+ "4 = Pra�a de alimenta��o 2 \n" + "5 = Sair");

			o = scan.nextInt();

			switch (o) {
			case 1:
				if (turma1.size() <= 0) {
					System.out.println("A sala 1 est� vazia");
				} else {
					System.out.println(getNomeTurma());
					System.out.println("Sala de aula 1");
					System.out.println(turma1);
					System.out.println();
				}
				break;

			case 2:
				if (turma2.size() <= 0) {
					System.out.println("A sala 2 est� vazia");
				} else {
					System.out.println(getNomeTurma());
					System.out.println("Sala de aula 2");
					System.out.println(turma2);
				}
				System.out.println();
				break;

			case 3:
				if (praca1.size() <= 0) {
					System.out.println("A pra�a 1 est� vazia");
				} else {
					System.out.println("Pra�a " + getNomeCafe());
					System.out.println("Pra�a de alimenta��o 1");
					System.out.println(praca1);
				}
				System.out.println();
				break;

			case 4:
				if (praca2.size() <= 0) {
					System.out.println("A pra�a 2 est� vazia");
				} else {
					System.out.println("Pra�a " + getNomeCafe());
					System.out.println("Pra�a de alimenta��o 2");
					System.out.println(praca2);
				}
				System.out.println();
				break;

			case 5:
				System.out.println("Fechando Menu");
			}
		}
	}
}
