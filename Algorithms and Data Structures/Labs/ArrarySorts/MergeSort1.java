public class MergeSort1{
	public static void merge (
			Comparable[] a1, int l1, int r1,
			Comparable[] a2, int l2, int r2,
			Comparable[] a3, int l3) {
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
	
	public static void mergeSort(
			Comparable[] a, int l1, int r1){
		if(l1<r1){
			int m = (l1 + r1)/2;
			mergeSort(a,l1,m);
			mergeSort(a,m+1,r1);
			Comparable[] b = new Comparable[r1-l1+1];
			merge(a,l1,m,a,m+1,r1,b,0);
			for(int i=l1;i<=r1;i++) a[i] = b[i-l1];
			
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
		mergeSort(a,0,8);
		System.out.println(printArray(a));

	}

}
