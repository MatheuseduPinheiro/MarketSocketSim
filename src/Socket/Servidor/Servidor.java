package Socket.Servidor;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main(String[] args) throws IOException {
		
		
		try {
				
			//Definir a porta	
			//ta amarelo
			ServerSocket serverSocket = new ServerSocket(3000);
			//pegar a informação da coneção
			Socket socket = serverSocket.accept();
			System.out.println("Servidor Inicializado!");
			
			//Ler as informações e mandar de volta para o cliente
			InputStreamReader inputReader = new InputStreamReader(socket.getInputStream());
			PrintStream saida = new PrintStream(socket.getOutputStream());
			BufferedReader reader = new BufferedReader(inputReader);
			String mensagem=reader.readLine();
			while(mensagem!=null) {
					saida.print("Servidor"+mensagem);
			} 
				
		}catch(Exception e) {
			System.err.println("Servidor não autenticado");
		}
		
		
		
	}
	
}

