package MaxBinHeap_A3;

public interface Heap_Interface {
	void insert(double element);
	  void delMax();
	  double getMax();
	  void clear();
	  int size();
	  void build(double [] elements);
	  double[] getHeap();
	  double[] sort(double[] elements);
}
