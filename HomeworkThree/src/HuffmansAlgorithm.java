import java.lang.reflect.Array;
import java.util.*;

public class HuffmansAlgorithm {
    private PriorityQueue<Node> queue;
    ArrayList<String> output = new ArrayList<>();


    public ArrayList<String> huffmansAlgorithm(int size, char[] characters, int[] frequencies){

        // first create minHeap -- we want to order the characters from smallest
        // to largest frequency, a binary heap will accomplish that.

        Queue queue = new PriorityQueue<Node>(size, new FrequencyComparison()); // init priority queue based on frequency of characters

        // create nodes from character and frequency array and add to queue for minHeap
        for(int i = 0; i < size; i++){
            Node node = new Node();

            // set the node's character and frequency corresponding to node input number
            node.character = characters[i];
            node.frequency = frequencies[i];

            // we don't know the left or right neighbors this node should have yet so assign to null
            node.leftChild = null;
            node.rightChild = null;

            queue.add(node);
        }

        Node root = null; // initialize root node of smallest frequency pair

        // This part should directly follow the pseudocode in page 214
        if(size == 2){ // if the size is two we can just manually assign the values
            // use poll to remove them from the queue
            Node y = (Node) queue.poll();
            Node z = (Node) queue.poll();

            output.add(y.character + " -- " + "0");
            output.add(z.character + " -- " + "1");
        }
        else{ // otherwise we need to recursively assign them
            while(queue.size() > 1){
                // y and z are the lowest frequency elements
                Node y = (Node) queue.poll();
                Node z = (Node) queue.poll();

                // create node w to replace the two nodes with their combined frequency
                Node w = new Node();
                w.frequency = y.frequency + z.frequency;
                w.character = '.'; // filler char

                w.leftChild = y;
                w.rightChild = z;
                root = w;

                queue.add(w);
            }
            assignCode(root, "");
        }

        // recursively assign code values from here

        return output;
    }

    public void assignCode(Node root, String string){

        // recursive base case
        if(root.leftChild == null && root.rightChild == null){
            this.output.add(root.character + " -- " + string);
            return;
        }

        assignCode(root.leftChild, string + "0");
        assignCode(root.rightChild, string + "1");
    }

    private class Node{
        int frequency;
        char character;

        Node leftChild;
        Node rightChild;
    }

    private class FrequencyComparison implements Comparator<Node>{

        @Override
        public int compare(Node a, Node b) {
            return a.frequency - b.frequency;
        }
    }
}

