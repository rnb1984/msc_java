
import java.util.*;
import java.io.*;

import javax.swing.JOptionPane;

/*
 * Robert Burry
 * Code for Assessment one of Algorithms and Data Structures
 */

public class AssOneAlgthm
{
	// Variables for document for FileReader and PrintWriter
	private static FileReader inputDoc, inputDict;
	private static PrintWriter writer;

	/************************************
	 *  		Main Method
	 ************************************/
	public static void main(String[] args)
	{
		spellCheck();
	}

	/************************************
	 *  Helper Method Spell Checker
	 ************************************/
	public static void spellCheck(){
		
		// Set variables for .txt file names
		String docIn,dictIn,oputDoc;
		// Create variables for String Sets
		Set<String> dictionarySet, docSet;
		
		// Start output document
		oputDoc = "MissSpelledWords.txt";
		try {
			try{
				// Print for final output txt
				writer = new PrintWriter (oputDoc);

				// Dictionary in
				dictIn = "dict.txt";
				inputDict= new FileReader (dictIn);
				dictionarySet = getDictLine(inputDict);

				// Document in
				docIn = "doc.txt";
				inputDoc = new FileReader (docIn);
				docSet = getDocLine(inputDoc);

				// Header for Miss Spelled words
				printDividingLine("Miss Spelled Words");

				// Compare Dictionary and Document sets in Loop
				for (String docWord : docSet)
				{
					if (!dictionarySet.contains(docWord)){writer.println(docWord);}
				}
				// Print final line
				printDividingLine("End");
			}
			finally
			{
				// Closes filereader for Dictionary, Document and PrintWriter 
				inputDict.close();
				inputDoc.close();
				writer.close();
			}
		}
		catch(IOException error){
			JOptionPane.showMessageDialog(null, "SUBMIT CORRECT DOCUMENT", "Error",JOptionPane.ERROR_MESSAGE);
		}		
	}

	/************************************
	 *  Method Get Sting from dict.txt
	 ************************************/
	public static Set<String> getDocLine(FileReader inputDoc){
		// Header Document section
		printDividingLine("Document Used");

		// Create Document Set
		Set<String> docSet = new TreeSet<String>();

		// Pass FileReader document to convert to Set method
		docSet.addAll(convertToSet (inputDoc));
		
		// Divide page
		printDividingLine("*");
		
		// Return document Set
		return docSet;
	}

	/************************************
	 *  Method Get Sting from dict.txt
	 ************************************/
	public static Set<String> getDictLine(FileReader inputDict){
		// Header Dictionary section
		printDividingLine("Dictionary Used");
		
		// Create Dictionary Set
		Set<String> dictSet = new TreeSet<String>();
		
		// Pass FileReader dictionary to convert to Set method
		dictSet.addAll(convertToSet (inputDict));
		
		// Divide page
		printDividingLine("*");
		
		// Return dictionary Set
		return dictSet;
	}

	/*********************************************
	 *  Method for splitting up words into List
	 *********************************************/
	public static Set<String> convertToSet (FileReader inputTxt){
		// Scanner in file
		Scanner inputLine = new Scanner(inputTxt);
		
		// Create set
		Set<String> wordSet = new TreeSet<String>();
		String line = " ";
		
		// Split up document by line
		while(inputLine.hasNextLine())
		{
			line = inputLine.nextLine();
			// Print to output file
			writer.println(line);
			// Store in new Set
			for (String word : line.split("[[^A-Z]&&[^a-z]]+"))	wordSet.add(word.toLowerCase());						
		}		
		// Close Scanner
		inputLine.close();
		return wordSet;		
	}	

	/*********************************************
	 *  Method for printing separation lines
	 *********************************************/
	public static String printDividingLine(String header){
		header = "---------" + header + "---------";
		writer.println(String.format("%n%s%n",header));
		return header;
	}
}