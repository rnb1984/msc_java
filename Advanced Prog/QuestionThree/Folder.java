import java.util.ArrayList;
import java.util.List;

// Composite Class
public class Folder implements Resource {
	// Varaibles for folder
	private String folderName;
	private List<Resource> files;
	private int size, numFiles;
	public String indentation;
	// Folder Constructor Method
	public Folder(String name){
		this.files = new ArrayList<Resource>();
		this.folderName = name;
		indentation = "\t";
	}
	// Interface Method for number of documents only in folder
	// This does not count folders folders
	public int numDoc(){
		return numFiles;
	}
	// Interface Method for byte size of document
	public int byteSize() {
		return size;
	}
	// Interface Method to print out document
	public void printOut(String indents) {
		// Takes in indents passed and adds to current indents
		indentation += indents;
		folderName = indentation + "Folder: "+ folderName + " Contains: ";
		System.out.println(folderName);
		for (Resource file: files)
			file.printOut(indentation);
	}
	// Composite add Method
	public void add(Resource file){
		// Increse the size of rescourses in folder
		size += file.byteSize();
		// Increse the number of rescourses in folder
		numFiles += file.numDoc();
		this.files.add(file);
	}
	// Composite remove Method
	public void remove(Resource file){
		this.files.remove(file);
	}
}

