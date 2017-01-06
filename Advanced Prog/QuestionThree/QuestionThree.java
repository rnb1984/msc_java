
public class QuestionThree {
	// Main Method
	public static void main(String []args){
		// Files in
		Document myDocument = new Document("MyDocument", 10);
		Document testDocument = new Document("TestDocument", 10);
		Document anotherDocument = new Document("AnotherDocument", 10);
		Document againAnotherDocument = new Document("AgainAnotherDocument", 10);
		Document moreWork = new Document("MoreWork", 10);
		Document bigDocument = new Document("BigDocument", 10);
		Document littleDocument = new Document("LittleDocument", 10);
		Document lastDocument = new Document("LastDocument", 10);
		
		// Create Folders
		Folder myFolder = new Folder("MyFolder");
		Folder anotherFolder = new Folder("AnotherFolder");
		Folder anotherFolderTwo = new Folder("AnotherFolder");
		Folder root = new Folder("Root");
		
		// add files to folders
		root.add(myDocument);
		root.add(testDocument);
		myFolder.add(anotherDocument);
		myFolder.add(againAnotherDocument);
		anotherFolder.add(moreWork);
		anotherFolderTwo.add(bigDocument);
				
		// add folders to folders
		myFolder.add(anotherFolder);
		root.add(myFolder);
		root.add(anotherFolderTwo);
		
		// Remaining files
		root.add(littleDocument);
		root.add(lastDocument);
		
		// Print them out
		root.printOut(" ");
		// Prin out bytes and number of documents
		System.out.println("Total Size = " + root.byteSize() + " bytes \nThe number of Documents is " + root.numDoc());
	}

}
