package coletanea.codigos.jdbc;

import coletanea.codigos.modelo.CadastroDAO;

public class TesteRemocao {

	public static void main(String[] args) {
		
		CadastroDAO dao = new CadastroDAO();
		dao.remover(8);
		
	}
}
