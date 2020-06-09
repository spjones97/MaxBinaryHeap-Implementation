# Overview
You are going to build in Java a Binary Heap (BHEAP). It will be done by building a maximum binary heap (BHEAP) with the numerically largest priority at the root of the tree.

Once your basic BHEAP is done and working properly, you will add to the ADT a Heap Sort function. The sort is passed an array of doubles as parameter, and produces an array of doubles as return value with the doubles sorted from smallest to largest (smallest double in array slot 0).

# Notes on Operations
## insert
Ordering is done based on the doubles as priorities. In the test data we use, the double priorities will be unique -- there will be no duplicate values.

## getMax
This operation returns a double. It does NOT alter the heap. The heap has the same elements in the same arrangement after as it did before. If getMax is done on an empty heap, return Double.NaN .

## delMax
This operation removes the root element from the heap. The size of the heap goes down by 1 (if the heap was not already empty). If delMax is done on an empty heap, treat it as a no-op... i.e., do nothing other than return void.

## build
The build operation should start with an empty heap. This means empty the internal heap array first before anything else. It receives an array of elements (doubles) as input. The effect is to produce a valid heap that contains exactly those input elements. This means when done the heap will have both a proper structure and will exhibit heap order.

Build is not the same as doing an insert for every element in the array. It is the special O(N) operation from the text (and shown in class) that starts with placing all elements into the heap array with no regard to heap order. You then go to the parent of the last node, and bubble down as needed. Go to the next node back towards the root, bubble down as needed. Repeat until you have done the root.

## size
The size operation simply returns the count of how many elements are in the heap. It should be 0 if the heap is empty, and always return a 0 or greater.

## sort
This method will use the head to sort... i.e., heap sort. It will receive an array of elements (double) is some order and it will return an array containing those same elements in increasing order with the smallest element in array slot 0. The sort will be done by emptying the interal heap array and then building a valid heap from the elements in the input array. Then repeated delMax() operations should be done to extract the elements in sorted order, and those elements put into the return array. Pay attention to the fact that you have max bin heap but need the sort to be increasing smallest to largest.

# Testing and Output
For testing, use the animation page given in class to get test cases and examples of correct behavior. Make sure your code is doing the same.

Their is no specific output or format required for this assignment. We assume you will use the "print" capability provided (and potentially expand on it) to test your code beyond the scope of the oracle.

Furthermore, please note that just because the Oracle gives you 100, you are not guaranteed any specific grade on the assignment. We do try to put as many things as we can in there edge-case wise, but testing your programs is your responsibility. The main goal of the Oracle is to provide some direction. However, it is not the end-all be-all determiner of correctness. Please do not use this tool as a crutch.
