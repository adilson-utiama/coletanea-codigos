package coletanea.codigos.jdbc;

import coletanea.codigos.modelo.Cadastro;
import coletanea.codigos.modelo.CadastroBuilder;
import coletanea.codigos.modelo.CadastroDAO;

public class TesteAlteracao {

	public static void main(String[] args) {
		
		CadastroBuilder builder = new CadastroBuilder();
		Cadastro cadastro = builder.id(5)
			.nome("Wilsnn")
			.sobrenome("Amauti")
			.idade(73)
			.endereco("Av. Cruzeiro do Sul")
			.telefone("3851-8775")
			.naData().gerarCadastro();
		
		CadastroDAO dao = new CadastroDAO();
		dao.alterar(cadastro);
	}
}
