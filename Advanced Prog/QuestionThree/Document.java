
// Leaf Calss
public class Document implements Resource{
	// Varaibles for document
	private String fileName, indent;
	private int size;
	// Document Constructor Method
	public Document(String name, int size){
		this.fileName = name;
		this.size = size;
		indent = "\t";
	}
	// Interface Method for number of documents
	public int numDoc() {
		// Return how many documents this is
		return 1;
	}
	// Interface Method for byte size of document
	public int byteSize() {
		// Return the size of this document in integer bytes
		return size;
	}
	// Interface Method to print out document
	public void printOut(String indents) {
		// Takes in indents passed and adds to current indents
		this.indent += indents;
		System.out.println(indent + fileName);
	}

	
}
