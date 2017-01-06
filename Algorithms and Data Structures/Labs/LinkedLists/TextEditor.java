package lists;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;

public class TextEditor {
	private List<String> text;
	private int sel; // position of the selected line

	public TextEditor() {
		// Make the text empty.
		//text = new ArrayList<String>(); //delete as appropriate
		text = new LinkedList<String>();
		sel = -1;
	}

	public void select(int p) {
		// Select the line at position p.
		if (p < 0 || p >= text.size())
			throw new NoSuchElementException();
		sel = p;
	}

	public void delete() {
		// Delete the selected line.
		if (sel < 0)
			throw new NoSuchElementException();
		text.remove(sel);
		if (sel == text.size())
			sel--;
	}

	public void find(String str) {
		// Select the next line containing str as a substring.
		// Wrap round to line 0 if necessary.
		if (sel < 0)
			throw new NoSuchElementException();
		int p = sel, n = text.size();
		do {
			String line = text.get(p);
			if (line.indexOf(str) >= 0) {
				// … str found
				sel = p;
				//System.out.println("Found string at line " + p);
				return;
			}
			if (++p == n)
				p = 0;
		} while (p != sel);
		throw new NoSuchElementException(); // str not found
	}

	public void insertAbove(String line) {
		// Insert line immediately above the selected line.
		if (sel < 0)
			throw new NoSuchElementException();
		text.add(sel, line);
		sel++;
	}

	public void insertBelow(String line) {
		// Insert line immediately below the selected line.
		sel++;
		text.add(sel, line);
	}

	public void load(BufferedReader input) throws IOException {
		// Load the entire contents of input into the text.
		for (;;) {
			String line = input.readLine();
			if (line == null)
				break;
			text.addLast(line);
		}
		sel = text.size() - 1; // select last line
	}

	public void save(BufferedWriter output) throws IOException {
		// Save the text to output.
		for (String line : text)
			output.write(line + "\n");
	}
	
	public static void main(String[] args) throws IOException {
		TextEditor theText = new TextEditor();
		BufferedReader input = new BufferedReader(new FileReader("jungleBook.txt"));
		BufferedWriter output = new BufferedWriter(new FileWriter("jungleResults.txt"));
		
		theText.load(input);
		theText.find("Mother"); //select the line containing mother
		theText.insertAbove("This is inserted text: ignore it!");
		theText.save(output);
		
		input.close();
		output.close();
		
		
		
		
	}
	

}
