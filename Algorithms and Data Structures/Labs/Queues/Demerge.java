package queues;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Demerge {
	
	public static Person readPerson(BufferedReader input) throws IOException{
		if(input.ready()){
		String s = input.readLine();
		
		System.out.println("String is " +  s);
		Scanner lineScanner = new Scanner(s);
		String fem = lineScanner.next();
		boolean female =false;
		if(fem.equals("F")) female = true;
		int age = lineScanner.nextInt();
		String fN = lineScanner.next();
		String lN = lineScanner.next();
		lineScanner.close();
		return new Person(female,age,fN,lN);
		}
		return null;
		
	}

	public static void writePerson(BufferedWriter output, Person p) throws IOException{
		output.write(p.toString()+"\n");
		output.flush();
	}

	public static void reSort(BufferedReader input, BufferedWriter output)
			throws IOException {
		// Copy a file of person records from input to output,
		// rearranged such that females precede males but their
		// order is otherwise unchanged.
		java.util.Queue<Person> // have to include this to avoid confusion with
								// our Queue interface
		females = new LinkedList<Person>(), males = new LinkedList<Person>();
		for (;;) {
			Person p = readPerson(input);
			//System.out.println("read person " + p);
			if (p == null)
				break; // end of input
			if (p.isFemale())
				females.add(p);// java.util.Queue method is add, not addLast
			else
				males.add(p);
		}
		while (!females.isEmpty()) {
			Person f = females.remove(); // java.util.Queue again
			writePerson(output, f);
		}
		while (!males.isEmpty()) {
			Person m = males.remove();
			writePerson(output, m);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new FileReader("people.txt"));
		BufferedWriter output = new BufferedWriter(new FileWriter("results.txt"));
		
		reSort(input,output);
		input.close();
		output.close();

	}

}
