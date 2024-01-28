import java.lang.reflect.Array;
import java.util.ArrayList;

public class BinaryHeap {

    private ArrayList<Integer> heap;

    // constructor -- creates binary heap with input Arraylist of integers
    public BinaryHeap(ArrayList<Integer> input){

        this.heap = new ArrayList<>(); // create heap
        this.heap.add(0); // set first idx to 0
        this.heap.addAll(input); // add numbers

        buildHeap(0); // apply heap-order property
    }


    // build a heap with integers stored in heap ArrayList
    // left child is 2 * idx, right child is (2 * idx) +1
    public void buildHeap(int idx) {
        int currentNode = heap.get(idx);

        try {
            int leftChild = heap.get(2 * idx);
            int rightChild = heap.get(2 * idx + 1);


            if (currentNode > leftChild || currentNode > rightChild) {
                if (leftChild < rightChild) {
                    heap.set(idx, leftChild);
                    heap.set(2 * idx, currentNode);
                } else {
                    heap.set(idx, rightChild);
                    heap.set(2 * idx + 1, currentNode);
                }
            }
            else {
                idx++;
            }

            buildHeap(idx);
        }
        catch(IndexOutOfBoundsException e){}
    }

    // delete minimum value and return it
    public int deleteMin(){
        int output = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        buildHeap(0);
        return output;
    }

    // call deleteMin and store root values as an arrayList -- return arrayList
    public ArrayList<Integer> outputAndClear(){
        ArrayList<Integer> output = new ArrayList<>();

        int outputInt = this.deleteMin();

        try {
            while (true) {
                output.add(outputInt);
                outputInt = this.deleteMin();
            }
        }
        catch (IndexOutOfBoundsException e){}

        return output;
    }
}
