package coletanea.codigos.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import coletanea.codigos.jdbc.ConnectionFactory;


public class CadastroDAO {

	private Connection con = null;
	private final String tabela = "cadastro";
	
		
	public CadastroDAO(){
		this.con = new ConnectionFactory().getConnection();
	}
	
	public void inserir(Cadastro cadastro){
		String sql = "INSERT INTO " + tabela + " (nome, sobrenome, idade, endereco, telefone, data)"
				+ " values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = this.con.prepareStatement(sql);
			ps.setString(1, cadastro.getNome());
			ps.setString(2, cadastro.getSobrenome());
			ps.setInt(3, cadastro.getIdade());
			ps.setString(4, cadastro.getEndereco());
			ps.setString(5, cadastro.getTelefone());
			ps.setString(6, cadastro.getDataCadastro().toString());
			
			ps.execute();
			
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void remover(int id){
		String sql = "DELETE FROM " + tabela + " WHERE id=?";
		try {
			PreparedStatement ps = this.con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			ps.close();
			con.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void alterar(Cadastro cadastro){
		
		String sql = "UPDATE " + tabela + " SET nome=?, sobrenome=?, idade=?, endereco=?, telefone=?, data=? WHERE id=?";
		try {
			PreparedStatement ps = this.con.prepareStatement(sql);
			ps.setString(1, cadastro.getNome());
			ps.setString(2, cadastro.getSobrenome());
			ps.setInt(3, cadastro.getIdade());
			ps.setString(4, cadastro.getEndereco());
			ps.setString(5, cadastro.getTelefone());
			ps.setString(6, cadastro.getDataCadastro().toString());
			ps.setInt(7, cadastro.getId());
			
			ps.execute();
			
			ps.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Cadastro> listarCadastros(){
		List<Cadastro> cadastros = new ArrayList<>();
		String sql = "SELECT * FROM " + tabela;
		try {
			PreparedStatement ps = this.con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				CadastroBuilder builder = new CadastroBuilder();
				Cadastro cadastro = builder.id(rs.getInt(1))
					.nome(rs.getString("nome"))
					.sobrenome(rs.getString("sobrenome"))
					.idade(rs.getInt("idade"))
					.endereco(rs.getString("endereco"))
					.telefone(rs.getString("telefone"))
					.naData(rs.getString("data"))
					.gerarCadastro();
				
				cadastros.add(cadastro);
			}
			ps.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cadastros;
	}
	
	
}
