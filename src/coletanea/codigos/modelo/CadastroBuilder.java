package coletanea.codigos.modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CadastroBuilder {

	private int id;
	private String nome;
	private String sobrenome;
	private int idade;
	private String endereco;
	private String telefone;
	private String dataCadastro;
	
	public CadastroBuilder id(int id){
		this.id = id;
		return this;
	}
	
	private String formatarData(){
		Date date = Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String data = sdf.format(date);
		return data;
	}
	
		
	public CadastroBuilder nome(String nome){
		this.nome = nome;
		return this;
	}
	
	public CadastroBuilder sobrenome(String sobrenome){
		this.sobrenome = sobrenome;
		return this;
	}
	
	public CadastroBuilder idade(int idade){
		this.idade = idade;
		return this;
	}
	
	public CadastroBuilder endereco(String endereco){
		this.endereco = endereco;
		return this;
	}
	
	public CadastroBuilder telefone(String telefone){
		this.telefone = telefone;
		return this;
	}
	
	public CadastroBuilder naData(){
		this.dataCadastro = formatarData();
		return this;
	}
	
	public CadastroBuilder naData(String data){
		this.dataCadastro = data;
		return this;
	}
	
	public Cadastro gerarCadastro(){
		return new Cadastro(id, nome, sobrenome, idade, endereco, telefone, dataCadastro);
	}
	
}
