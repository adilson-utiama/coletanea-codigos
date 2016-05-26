package coletanea.codigos.servidor.chat;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class MiniChatServer extends JFrame implements ActionListener, IChat {


	private static final long serialVersionUID = 861837515364211017L;
	private int porta;
	private int filaEspera;
	private JButton bAcao;
	private JTextArea taInfo;
	private JTextField tfNomeSvr;
	private ChatServer servidor;

	public MiniChatServer(int porta, int filaEspera) {
		super("MiniChatServer");
		this.porta = porta;
		this.filaEspera = filaEspera;
		
		inciarLayout();
	}

	@Override
	public void write(String msg) {
		taInfo.append(msg);
		taInfo.setCaretPosition(taInfo.getText().length());

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (bAcao.getText().equals("Iniciar")) {
			startServer();
		} else {
			stopServer();
		}

	}

	private void startServer() {
		try {
			taInfo.setText("");
			servidor = new ChatServer(porta, filaEspera, this,
					tfNomeSvr.getText());
			servidor.start();
			tfNomeSvr.setEditable(false);
			bAcao.setText("Parar");
		} catch (ChatException e) {
			taInfo.setText("Erro: " + e.getMessage());
			e.printStackTrace();
		}
	}

	private void stopServer() {
		servidor.shutdown();
		servidor = null;
		tfNomeSvr.setEditable(true);
		bAcao.setText("Iniciar");
	}
	

	private void inciarLayout() {
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel p = new JPanel(new GridLayout(1, 3));
		p.add(new JLabel("Nome"));
		p.add(tfNomeSvr = new JTextField());
		p.add(bAcao = new JButton("Iniciar"));
		bAcao.addActionListener(this);
		add("North", p);
		JScrollPane sp = new JScrollPane(taInfo = new JTextArea());
		taInfo.setLineWrap(true);
		taInfo.setWrapStyleWord(true);
		taInfo.setEditable(false);
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add("Center", sp);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 200);
	}
	
	public static void main(String[] a) {
		try {
			final MiniChatServer mcs = new MiniChatServer(
					a.length > 0 ? Integer.parseInt(a[0]) : 3000,
					a.length > 1 ? Integer.parseInt(a[1]) : 10);
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					mcs.setVisible(true);
				}
			});
		} catch (NumberFormatException e) {
			System.out.println("Argumento(s) invalido(s)\n"
					+ "Uso: MiniChatServer [porta] [filaEspera]");
			System.exit(-1);
		}
	}


}
