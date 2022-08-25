package ibu.edu.homework;

public class BinaryHeap<Item extends Comparable<Item>> {
	
	@SuppressWarnings({ "unchecked" })
	public Item[] pq = (Item[]) new Comparable[2];
	public int length = 0;
	
// Insert a new element into the priority queue
	public void insert(Item data) {
		if (pq.length == length + 1) {			
			resize(2 * pq.length);			
		}
		pq[++length] = data;					
		swim(length);							
	}
	
// node promotion: swim up the node to its correct position
	private void swim(int k) {
		while (k > 1 && less(k/2, k)) {		
			swap(k, k/2);					
			k = k/2;						
		}
	}
	// remove the max priority item
	public Item delMax() {
		Item max = pq[1];								
		swap(1, length--);								
		pq[length + 1] = null;							
		  
		if (length > 0 && length == pq.length / 4) {	
			resize(pq.length / 2);			  			
		}
		
		sink(1);										
		return max;									
	}
	
	//sink down a node to its correct position
	private void sink(int k) { 
		while (2*k <= length) {						
			int j = 2 * k;							
			if (j < length && less(j, j + 1)) {		
				j++;								
			}
			
			if (!less(k, j)) {						
				break;								
			}
			
			swap(k, j);								
			k = j;									
		}
	}
	
	public boolean isEmpty() {
		return length == 0;
	}

	public int size() {
		return length;
	}
//create a new internal array with a given capacity
	@SuppressWarnings("unchecked")
	private void resize(int capacity) {
		Item[] copy = (Item[]) new Comparable[capacity];		
		for (int i = 1; i <= length; i++) {						
			copy[i] = pq[i];									
		}												
		pq = copy;												
	}

	private boolean less(int a, int b) {
		return pq[a].compareTo(pq[b]) < 0;
	}
	

	private void swap(int a, int b) {
		Item temp = pq[a];
		pq[a] = pq[b];
		pq[b] = temp;
	}
	
}