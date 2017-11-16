import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChatServer {
	
	List<PrintWriter> escritores = new ArrayList<>();
	
	public ChatServer() {		
		ServerSocket server;
		int porta = 5003;
		
		try {
			server = new ServerSocket(porta);
			System.out.println("Servidor iniciado na porta "+ porta);
			while (true) {
				Socket socket = server.accept();
				new Thread(new EscutaCliente(socket)).start();
				PrintWriter p = new PrintWriter(socket.getOutputStream());
				escritores.add(p);
			}
		} catch (IOException e) {
			System.out.println("Servidor nao pode ser iniciado na porta "+ porta);
			System.exit(-1);
		}
	}

	private void encaminharParaTodos(String texto) {
		for (PrintWriter w : escritores) {
			try {
				w.println(texto);
				w.flush();
			} catch (Exception e) {
				
			}
		}
	}
	
	private class EscutaCliente implements Runnable {
		Scanner leitor;

		public EscutaCliente(Socket socket) {
			try {
				leitor = new Scanner(socket.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			String texto;
			try {
				while((texto = leitor.nextLine()) != null) {
					System.out.println(texto);
					encaminharParaTodos(texto);
				}
			} catch (Exception e) {
				System.out.println("Cliente saiu!");
			}
		}

	}

	public static void main(String[] args) {
		new ChatServer();
	}

}
