
import java.net.*;
import java.io.*;

// Question Two
public class QuestionTwoServer {
	// Varaibles
	private static int PORT = 8765;
	private static ServerSocket listener;
	private static Socket client;
	
	// Solve Method for sums from client
	public static String solve(String lineIn, boolean add){
		Integer solved = 0;
		String [] line = lineIn.split("[-+,]");
		int firstNumber = Integer.parseInt(line[0]);
		int secNumber = Integer.parseInt(line[1]);
		// Boolean passed is false the take away from each other
		if (!add)
			solved = firstNumber - secNumber;
		else
			solved = firstNumber + secNumber;
		return solved.toString();
		}

	// Main Method
	public static void main(String[] args) throws IOException {
		// Make a server object
		listener = new ServerSocket(PORT);
		// Wait for a connection and create a client
		client = listener.accept();
		try{
			//Read in from client
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			//Print stream to client
			PrintWriter out = new PrintWriter(client.getOutputStream(),true);
			// Wait for Client to send something
			while(true){
				// Read in the line from client
				String lineIn = in.readLine();
				// Stop if connectin if Client sends "Stop"
				if (lineIn.equals("Stop")){
					out.println("Session Terminated");
					System.out.print("Session Terminated");
					break;
				}
				else{
					// If sum from client ends with - solve sum and pass back to client
					if (lineIn.endsWith("-"))
						out.println("Answer " + solve(lineIn, false));
					// If sum from client ends with + solve sum and pass back to client
					else if (lineIn.endsWith("+"))
						out.println("Answer " + solve(lineIn, true));
				}
			}
		}catch(Exception e){}
		finally
		{
			try{
				// Close the connection
				client.close();
			}catch(Exception e){}}

	}
}
