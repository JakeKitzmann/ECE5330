import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        // get input and output files from user
        System.out.println("---------");
        System.out.println("Input file path for values to encode:");

        String inputFilePath = scanner.nextLine();
        BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));

        System.out.println("---------");
        System.out.println("Input file path for output");

        String outputFilePath = scanner.nextLine();
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));

        // read size from file
        final int SIZE = Integer.parseInt(reader.readLine());

        // array to store [character,frequency] sets
        String[] inputValues = new String[SIZE];

        for(int i = 0; i < SIZE; i++){
            inputValues[i] = reader.readLine();
        }

        // arrays to store characters and frequencies
        char[] characters = new char[SIZE];
        int[] frequencies = new int[SIZE];

        // split each pair into a character and its frequency, store in their own arrays with matching indices
        int i = 0;
        for(String string : inputValues){
            String[] components = string.split(",");

            char character = components[0].charAt(components[0].length()-1);
            int frequency = Integer.parseInt(components[1].substring(0,components[1].length() - 1));

            characters[i] = character;
            frequencies[i] = frequency;

            i++;
        }

        // run algorithm with the characters and frequency values
        // returns an array list of all the translations
        HuffmansAlgorithm huffmansAlgorithm = new HuffmansAlgorithm();
        ArrayList<String> dictionary = huffmansAlgorithm.huffmansAlgorithm(SIZE, characters, frequencies);

        // output
        System.out.println("---------");
        System.out.println("Success -- Outputting to " + outputFilePath);
        for(String string : dictionary){
            writer.write(string);
            writer.newLine();
            writer.flush();
        }
    }
}
