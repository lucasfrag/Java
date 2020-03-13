import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatCliente extends JFrame {

	JTextField textoParaEnviar;
	Socket socket;
	PrintWriter escritor;
	static String nome;
	JTextArea textoRecebido;
	Scanner leitor;

	private class EscutaServidor implements Runnable {

		@Override
		public void run() {
			System.out.println(nome + "esta conectado!");
			
			try {
				String texto;
				while((texto = leitor.nextLine()) != null) {
					textoRecebido.append(texto + "\n");
				}
			} catch (Exception e) {
				
			}
		}

	}

	public ChatCliente(String nome) {
		super("Chat: " + nome);
		this.nome = nome;

		textoParaEnviar = new JTextField();
		JButton botao = new JButton("Enviar");
		botao.addActionListener(new EnviarListener());

		Container envio = new JPanel();
		envio.setLayout(new BorderLayout());
		envio.add(BorderLayout.CENTER, textoParaEnviar);
		envio.add(BorderLayout.EAST, botao);
		getContentPane().add(BorderLayout.SOUTH, envio);

		textoRecebido = new JTextArea();
		JScrollPane scroll = new JScrollPane(textoRecebido);

		getContentPane().add(BorderLayout.CENTER, scroll);

		configurarRede();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setVisible(true);
	}

	private class EnviarListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			escritor.println(nome + ": " + textoParaEnviar.getText());
			escritor.flush();
			textoParaEnviar.setText("");
			textoParaEnviar.requestFocus();
		}

	}

	private void configurarRede() {
		try {
			socket = new Socket("127.0.0.1", 5003);
			escritor = new PrintWriter(socket.getOutputStream());
			leitor = new Scanner(socket.getInputStream());
			new Thread(new EscutaServidor()).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public static void main(String[] args) {
		nome = JOptionPane.showInputDialog("Informe o seu nome: ");
		new ChatCliente(nome);
	}

}
