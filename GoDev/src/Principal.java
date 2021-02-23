//Código desenvolvido por Gabriel Bertoldi Inácio
public class Principal {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cadastro c = new Cadastro();
		
		c.cadastrarSala("Equipe de desenvolvimento JAVA", 5);
		c.cadastroCafe("Bolinhos Dona Ana", 5);
		
		try {
		//Turma 1
		c.cadastrarAluno("Joaquim", "Almeida");
		c.cadastrarAluno("Maria", "Silva");
		c.cadastrarAluno("Pedro", "da Silva");
		c.cadastrarAluno("Vanessa", "Rodrigues");
		c.cadastrarAluno("Leonardo", "Souza");
		//Turma 2
		c.cadastrarAluno("Veronica", "Silva");
		c.cadastrarAluno("Pierre", "Valenuti");
		c.cadastrarAluno("Rodrigo","Kennedy");
		c.cadastrarAluno("Ada", "Wong");
		c.cadastrarAluno("Chris", "Redfield");
		
		c.tomarCafe();
		c.voltarAula();
		c.tomarCafe();
		c.voltarAula();
		
		c.consultaSala();
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
