// Component Interface
public interface Resource {
	// ByteSize Method returns the calculation of the total bytes within a resource in int of Bytes
	public int byteSize();
	// PrintsOut Method will print out all contents of a resource
	public void printOut(String indents);
	// Returns the total number of documents within a resource
	public int numDoc();

}
