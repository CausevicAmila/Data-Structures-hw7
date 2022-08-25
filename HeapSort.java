package ibu.edu.homework;

public class HeapSort {
	public static void sort(IPaddress [] ipAddress) {
		BinaryHeap<IPaddress> heap = new BinaryHeap<IPaddress>();	
		
		for (int i = 0; i < ipAddress.length; i++) {			
			heap.insert(ipAddress[i]);							
		}
		
		for (int i = ipAddress.length - 1; i >= 0; i--) {	
			ipAddress[i] = heap.delMax();						
		}
	}
}
