import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

/*****************************************************
 * 		** Protocol **
 * 1. Stop
 *	 If the Client passes Stop String to Server the session
 * 	 will terminate.
 * 
 * 2. 5,3,-
 * 	Server will subtract two integer numbers if given a minus sign.
 * 
 * 3. 5,3,+
 * 	Server will add two integer numbers if given a plus sign. 
 *  
 *  		** Assumptions **
 *  The Server assumes that the Client will only pass Strings.
 *  It will only caclulate two integers.
 *  It also assumes that the String will either be a set of numbers
 *  containing a plus or minus sign seperate by commas or the
 *  terminate command "Stop".
 *  If an alternative String is passed the server will not
 *  do anything with it.
 * 
 *******************************************************/
public class QuestionTwoClient {
	// Varaibles
	private static int PORT = 8765;
	private static String server = "127.0.0.1";
	private static Socket socket;
	
	// Main Method 
	public static void main(String[] args) throws IOException {
		// Make a socket and try and connect
		socket = new Socket(server,PORT);
		try{
			//Read in from server
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//Print stream to server
			PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
			// List of comands to pass server
			List<String> comands = new ArrayList<String>();
			comands.add("5,3,-");
			comands.add("5,3,+");
			comands.add("Stop");
			//Pass comand to server
			for(String command : comands){
				out.println(command);
				System.out.println(in.readLine());
			}
		}
		finally
		{
			// Close the socket once comands are past
			socket.close();
		}
	}}