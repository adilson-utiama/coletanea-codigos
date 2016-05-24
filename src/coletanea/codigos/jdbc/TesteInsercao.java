package coletanea.codigos.jdbc;

import coletanea.codigos.modelo.Cadastro;
import coletanea.codigos.modelo.CadastroBuilder;
import coletanea.codigos.modelo.CadastroDAO;


public class TesteInsercao {

	public static void main(String[] args) {
		
		CadastroBuilder builder = new CadastroBuilder();
		Cadastro cadastro = builder.nome("Adilson")
			.sobrenome("Utiama")
			.idade(37)
			.endereco("Rua Dona Cecilia Santana")
			.telefone("2957-4676")
			.naData().gerarCadastro();
		
		CadastroDAO dao = new CadastroDAO();
		dao.inserir(cadastro);
		
	}
}
