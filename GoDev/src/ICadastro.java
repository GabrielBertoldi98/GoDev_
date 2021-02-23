//Código desenvolvido por  Gabriel Bertoldi Inácio

public interface ICadastro {

	public void cadastrarAluno(String n, String s) throws Exception;
	public void cadastrarSala(String n,int t);
	public void cadastroCafe(String n, int t);
	public void consultaPessoa();
	public void consultaSala();
	public void tomarCafe() throws Exception;
	public void voltarAula() throws Exception;
}
