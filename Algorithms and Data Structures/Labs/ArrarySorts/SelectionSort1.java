
public class SelectionSort1 {
	static void sort (Comparable[] a,
			int left, int right) {
		// Sort a[left…right] into ascending order.
		for (int l = left; l < right; l++) {
			int p = l;
			Comparable least = a[p];
			for (int k = l+1; k <= right; k++){
				int comp = a[k].compareTo(least);
				if (comp < 0) {p = k; least = a[p];
				}
				
			}
			if (p != l) { a[p] = a[l]; a[l] = least; }
			
		}
	}
	
	public static String printArray(Object[] a){
		String s="";
		for(Object o: a) s+=o+",";
		return s;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] a = {4,3,-1,2,17,2,0,4,5};
		sort(a,0,8);
		System.out.println(printArray(a));

	}

}
