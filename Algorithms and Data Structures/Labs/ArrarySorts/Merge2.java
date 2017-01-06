
public class Merge2{
	public static <E extends Comparable<E>>  void merge (
			E[] a1, int l1, int r1,
			E[] a2, int l2, int r2,
			E[] a3, int l3) {
		// Merge the sorted subarrays a1[l1…r1] and  
		// a2[l2…r2] into a3[l3…].
		int i = l1, j = l2, k = l3;
		while (i <= r1 && j <= r2) {
			int comp = a1[i].compareTo(a2[j]);
			if (comp <= 0) a3[k++] = a1[i++];
			else           a3[k++] = a2[j++];
			}
		while (i <= r1)  a3[k++] = a1[i++];
		while (j <= r2)  a3[k++] = a2[j++];
	}
	
	public static <E extends Comparable<E>> String printArray(E[] a){
		String s="";
		for(E e: a) s+=e+",";
		return s;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] a = {-1,2,3,5,7,12};
		Integer[] b = {0,4,6,8,9,10,11,13};
		Integer[] c = new Integer[14];
		merge(a,0,5,b,0,7,c,0);
		System.out.println(printArray(c));

	}

}
