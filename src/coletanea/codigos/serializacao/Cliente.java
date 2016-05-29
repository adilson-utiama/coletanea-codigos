package coletanea.codigos.serializacao;

import java.io.Serializable;
import java.util.Calendar;

public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3484973852692762964L;

	private String nome;
	private int codigo;
	private String descricao;
	private Calendar dataCadastro;
	
	private transient String naoSerializa; //nao serializa
	
	public Cliente(){}

	public Cliente(String nome, int codigo, String descricao,
			Calendar dataCadastro) {
		super();
		this.nome = nome;
		this.codigo = codigo;
		this.descricao = descricao;
		this.dataCadastro = dataCadastro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public String getNaoSerializa() {
		return naoSerializa;
	}
	
	public void setNaoSerializa(String naoSerializa) {
		this.naoSerializa = naoSerializa;
	}

}
