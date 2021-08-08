import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/chat")
public class ChatServer {

	//Set of all clients currently connected to Chat Server
	private static Set<Session> clients = 
		    Collections.synchronizedSet(new HashSet<Session>());
	
	
	@OnOpen
	public void onOpen(Session session){
	    System.out.println("Client connected to Chat Server ...");
	    // Add session to the connected sessions set
	    clients.add(session);
	}
	
	@OnClose
	public void onClose(Session session){
	    System.out.println("Connection to Chat Server closed...");
	 // Remove session from the connected sessions set
	    clients.remove(session);
	}
	
	@OnMessage
	public String onMessage(String message, Session session) 
			throws IOException{
		
	    System.out.println("Message from the client: " + message);
	    
	    //Broadcast message to all clients 
	    synchronized(clients){
	        // Iterate over the connected sessions
	        // and broadcast the received message
	        for(Session client : clients){
	          if (!client.equals(session)){
	            client.getBasicRemote().sendText(message);
	          }
	        }
	      }
	    
	    
	    return message;
	}
	
	@OnError
	public void onError(Throwable e){
		System.out.print(e.getMessage());
	    e.printStackTrace();
	}
	
}
