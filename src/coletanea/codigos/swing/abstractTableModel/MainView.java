package coletanea.codigos.swing.abstractTableModel;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class MainView extends JFrame {

	private static final long serialVersionUID = 1L;

	private JButton adicionar, editar, remover;
	private JTextField nome, descricao, preco;
	private JLabel tituloLabel, nomeLabel, descricaoLabel, precoLabel;
	private JTable tabela;
	private TabelaModelo modelo = new TabelaModelo();
	private Dimension tabelaSize = new Dimension(350, 450);
	private Dimension botoesTabelaSize = new Dimension(350, 150);
	private Dimension textField = new Dimension(380, 25);

	public MainView() {
		setTitle("CRUD com JAVA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 700);

		intiComponents();
		initListeners();
		intiLayout();

	}

	private void initListeners() {
		adicionar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if(!nome.getText().isEmpty()){
					Produto produto = geraProduto();

					modelo.addRow(produto);

				}else{
					JOptionPane.showMessageDialog(null, "Preencha os dados...");
				}
					
				nome.setText(null);
				descricao.setText(null);
				preco.setText(null);

			}

			
		});
		
		remover.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tabela.getSelectedRow();
				modelo.remove(selectedRow);
				
				
			}
		});
		
		editar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tabela.getSelectedRow();
				Produto produto = geraProduto();
				modelo.altera(selectedRow, produto);
				
			}
		});

	}

	private void intiLayout() {
		Container c = getContentPane();
		c.setLayout(new BorderLayout());

		JPanel painelTitulo = new JPanel();
		painelTitulo.add(tituloLabel);

		JPanel painelTabela = new JPanel();
		JScrollPane sp = new JScrollPane(tabela);
		painelTabela.add(sp);

		JPanel painelBotoes = new JPanel(new FlowLayout());
		painelBotoes.setPreferredSize(botoesTabelaSize);
		painelBotoes.add(nomeLabel);
		painelBotoes.add(nome);
		painelBotoes.add(descricaoLabel);
		painelBotoes.add(descricao);
		painelBotoes.add(precoLabel);
		painelBotoes.add(preco);
		painelBotoes.add(adicionar);
		painelBotoes.add(editar);
		painelBotoes.add(remover);

		c.add(painelTitulo, "North");
		c.add(painelTabela, "Center");
		c.add(painelBotoes, "South");

	}

	private void intiComponents() {
		tituloLabel = new JLabel("Cadastro de Produtos");

		adicionar = new JButton("Adicionar");
		editar = new JButton("Editar");
		remover = new JButton("Remover");

		nome = new JTextField();
		nome.setPreferredSize(textField);
		descricao = new JTextField();
		descricao.setPreferredSize(textField);
		preco = new JTextField();
		preco.setPreferredSize(textField);

		nomeLabel = new JLabel("Nome: ");
		descricaoLabel = new JLabel("Descrição: ");
		precoLabel = new JLabel("Preço: ");

		tabela = new JTable();
		tabela.setModel(modelo);
		tabela.setPreferredSize(tabelaSize);
		

	}
	
	private Produto geraProduto() {
		String nomeProduto = nome.getText();
		String descricaoProduto = descricao.getText();
		String p = preco.getText();
		Produto produto = new Produto(nomeProduto,
				descricaoProduto, p);
		return produto;
	}

}
