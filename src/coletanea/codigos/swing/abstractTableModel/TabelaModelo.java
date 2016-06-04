package coletanea.codigos.swing.abstractTableModel;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TabelaModelo extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private List<Produto> produtos = new ArrayList<>();
	private String[] colunas = { "Nome", "Descrição", "Preço" };

	//Adiciona Produto na Lista
	public void addRow(Produto produto) {
		this.produtos.add(produto);
		this.fireTableDataChanged();
	}

	// Coloca nomes nas colunas
	public String getColumnName(int num) {
		return this.colunas[num];
	}
	
	public void remove(int linha){
		this.produtos.remove(linha);
		this.fireTableDataChanged();
	}
	
	public void altera(int linha, Produto produto){
		this.produtos.get(linha).setNome(produto.getNome());
		this.produtos.get(linha).setDescricao(produto.getDescricao());
		this.produtos.get(linha).setPreco(produto.getPreco());
		this.fireTableDataChanged();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		return this.produtos.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {

		switch (coluna) {
		case 0:
			return produtos.get(linha).getNome();
		case 1:
			return produtos.get(linha).getDescricao();
		case 2:
			return produtos.get(linha).getPreco();
		}
		return null;
	}
	

	
	
	

}
