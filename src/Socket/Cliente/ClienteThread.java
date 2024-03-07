package Socket.Cliente;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClienteThread extends Thread {

	private Socket socket;

	public ClienteThread(Socket socket) {
		this.socket=socket;
	}
	
	@Override
	public void run()  {
		try {
			//TENTAR Ler as informações e mandar de volta para o cliente
			InputStreamReader inputReader = new InputStreamReader(socket.getInputStream());
			BufferedReader reader = new BufferedReader(inputReader);
			String mensagem=reader.readLine();
			
			while(mensagem!=null) {
				System.out.println("Cliente:"+mensagem);
					
			}     
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
