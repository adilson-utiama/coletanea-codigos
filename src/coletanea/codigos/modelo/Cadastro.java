package coletanea.codigos.modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Cadastro {

	private int id;
	private String nome;
	private String sobrenome;
	private int idade;
	private String endereco;
	private String telefone;
	private String dataCadastro;
	
	
	public Cadastro(){}
	
	public Cadastro(int id, String nome, String sobrenome, int idade, String endereco, String telefone, String dataCadastro){
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.idade = idade;
		this.endereco = endereco;
		this.telefone = telefone;
		this.dataCadastro = dataCadastro;
		
	}
		
	public void setId(int id){
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Calendar data) {
		Date date = data.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String string = sdf.format(date);
		this.dataCadastro = string;
	}

	
	
}
