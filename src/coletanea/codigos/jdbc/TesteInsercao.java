package coletanea.codigos.jdbc;

import coletanea.codigos.modelo.Cadastro;
import coletanea.codigos.modelo.CadastroBuilder;
import coletanea.codigos.modelo.CadastroDAO;


public class TesteInsercao {

	public static void main(String[] args) {
		
		CadastroBuilder builder = new CadastroBuilder();
		Cadastro cadastro = builder.nome("Wilson")
			.sobrenome("Silva")
			.idade(37)
			.endereco("Rua dos JAveiros")
			.telefone("1234-5678")
			.naData().gerarCadastro();
		
		CadastroDAO dao = new CadastroDAO();
		dao.inserir(cadastro);
		
	}
}
