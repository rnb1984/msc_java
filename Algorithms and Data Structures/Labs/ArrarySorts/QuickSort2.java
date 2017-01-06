public class QuickSort2{
	public static   <E extends Comparable<E>> int partition(
			E[] a, int left, int right) {
		int p=left;
		E pivot=a[left];
		for(int r=left+1;r<=right;r++){
			if(a[r].compareTo(pivot)<0){
				a[p]=a[r];
				a[r]=a[p+1];
				a[p+1]=pivot;
				p++;
			}
		}
		return p;
	}

	
	public static <E extends Comparable<E>> void quickSort(
			E[] a, int left, int right){
		 if(left<right){
			 int p=partition(a,left,right);
			 quickSort(a,left,p-1);
			 quickSort(a,p+1,right);
			    
			
		}
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
		Integer[] a = {4,3,-1,2,11,2,0,4,5};
		quickSort(a,0,8);
		System.out.println(printArray(a));

	}

}
