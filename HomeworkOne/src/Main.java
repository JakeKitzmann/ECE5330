import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {


        String inputName;
        String outputName;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Input .txt: ");
        inputName = scanner.nextLine();

        System.out.println("Output .txt: ");
        outputName = scanner.nextLine();


        // input init
        FileReader input = new FileReader(inputName);
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
        FileWriter output = new FileWriter(outputName);
        BufferedWriter writer = new BufferedWriter(output);

        // output
        for(int number : outputList){
            writer.write(String.valueOf(number)); // write the number
            writer.newLine(); // new line
            writer.flush(); // flush buffer
        }

    }
}
