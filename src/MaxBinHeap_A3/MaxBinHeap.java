package MaxBinHeap_A3;

public class MaxBinHeap implements Heap_Interface {
	private double[] array; //load this array
	private int size;
	private static final int arraySize = 10000; //Everything in the array will initially
											  //be null. This is ok! Just build out
											  //from array[1]

	public MaxBinHeap() {
		this.array = new double[arraySize];
		array[0] = Double.NaN;  //0th will be unused for simplicity
							//of child/parent computations...
							//the book/animation page both do this.
		this.size = 0;
	}

	// Please do not remove or modify this method! Used to test your entire Heap.
	// Returns the current heap
	public double[] getHeap() {
		return this.array;
	}

	// Insert element into the heap
	public void insert(double element) {
		// TODO Auto-generated method stub
		size++;
		array[size] = element;
		int current = size;
		while (array[current] > array[parentPosition(current)]) {
			swap(current, parentPosition(current));
			current = parentPosition(current);
			this.bubbleUp();
		}
	}

	// Swap parent and child when traversing up or down
	private void swap(int first, int second) {
		double temp = array[first];
		array[first] = array[second];
		array[second] = temp;
	}

	// Returns true if element as parent
	private boolean hasParent(int position) {
		return parentPosition(position) >= 0;
	}

	// Returns the position of the parent
	private int parentPosition(int position) {
		return position / 2;
	}

	// Returns true if position has a left child
	private boolean hasLeft (int position) {
		return leftChild(position) < size;
	}

	// Returns left child position
	private int leftChild (int position) {
		return (position * 2);
	}

	// Returns true if position has right child
	private boolean hasRight (int position) {
		return rightChild(position) < size;
	}

	// Returns right child position
	private int rightChild(int position) {
		return ((position * 2) + 1);
	}

	// Bubbles up the heap when inserting an element
	private void bubbleUp() {
		int index = size;
		while (hasParent(index) && array[parentPosition(index)] < array[index]) {
			swap(parentPosition(index), index);
			index = parentPosition(index);
		}
	}

	// Bubbles down the heap when deleting the max element
	private void bubbleDown(int position) {
		int smallest = position;
		int leftIndex = 2 * position;
		int rightIndex = 2 * position + 1;
		if (leftIndex < size && array[smallest] < array[leftIndex]) {
			smallest = leftIndex;
		}
		if (rightIndex < size && array[smallest] < array[rightIndex]) {
			smallest = rightIndex;
		}
		if (smallest != position) {
			swap(position, smallest);
			bubbleDown(smallest);
		}
	}

	// Deletes the top of the heap
	public void delMax() {
		// TODO Auto-generated method stub
		array[1] = array[size];
		array[size] = 0;
		bubbleDown(1);
		size--;
	}

	// Returns the element at the top of the heap
	public double getMax() {
		// TODO Auto-generated method stub
		return array[1];
	}

	// Clears the heap
	public void clear() {
		// TODO Auto-generated method stub
		this.array = new double[arraySize];
		array[0] = Double.NaN;
	}

	// Returns the size of the heap
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	// Builds the heap from an array of elements
	public void build(double[] elements) {
		// TODO Auto-generated method stub
		this.clear();
		for (double element : elements) {
			insert(element);
		}
	}

	// Returns a sorted array of the input elements
	public double[] sort(double[] elements) {
		// TODO Auto-generated method
		MaxBinHeap heap = new MaxBinHeap();
		heap.build(elements);
		double[] out = new double[elements.length];
		for (int i = heap.size() - 1; i >= 0; i--) {
			out[i] = heap.getMax();
			heap.delMax();
		}
		return out;
	}
}
