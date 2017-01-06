package stacks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class FileReversal {

	/**
	 * @param args
	 */
	public static void reverse (
			BufferedReader input,
			BufferedWriter output)
					throws IOException {
		// Make output contain the lines of input in reverse 
		// order.
		Stack<String> lineStack = 
		new Stack<String>();
		for (;;) {
			String line = input.readLine();
			if (line == null)  break;  // end of input
			lineStack.push(line);
			}
		input.close();
		while (! lineStack.empty()) {
			String line = lineStack.pop();
			output.write(line + "\n");
			}
		output.close();
		}

		
	

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new FileReader("inputFile"));
		BufferedWriter output = new BufferedWriter(new FileWriter("outputFile"));
		reverse(input,output);
		input.close();
		output.close();
		
		

	}

}
