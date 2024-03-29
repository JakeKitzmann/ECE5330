import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        // input init
        FileReader input = new FileReader("HomeworkOne/src/input.txt");
        BufferedReader reader = new BufferedReader(input);

        // read numbers to arraylist
        String numString = reader.readLine();
        ArrayList<Integer> unsortedNumbers = new ArrayList<>();

        while(numString != null){
            Integer num = Integer.parseInt(numString);
            unsortedNumbers.add(num);
            numString = reader.readLine();
        }

        // create binary heap with numbers
        BinaryHeap binaryHeap = new BinaryHeap(unsortedNumbers);

        // clear list and store in order with deleteMin going to an arrayList for output
        ArrayList<Integer> outputList = binaryHeap.outputAndClear();


        // output init
        FileWriter output = new FileWriter("HomeworkOne/src/output.txt");
        BufferedWriter writer = new BufferedWriter(output);

        // output
        for(int number : outputList){
            writer.write(String.valueOf(number)); // write the number
            writer.newLine(); // new line
            writer.flush(); // flush buffer
        }

    }
}
