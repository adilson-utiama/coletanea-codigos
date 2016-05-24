package coletanea.codigos.jdbc;

import java.util.List;

import coletanea.codigos.modelo.Cadastro;
import coletanea.codigos.modelo.CadastroDAO;

public class TesteListagem {

	
	public static void main(String[] args) {
		
		CadastroDAO dao = new CadastroDAO();
		List<Cadastro> cadastros = dao.listarCadastros();
		
		for (Cadastro cadastro : cadastros) {
			System.out.println(cadastro.getId());
			System.out.println(cadastro.getNome());
			System.out.println(cadastro.getSobrenome());
			System.out.println(cadastro.getDataCadastro());
			System.out.println("-------------------------------");
		}
	}
}
