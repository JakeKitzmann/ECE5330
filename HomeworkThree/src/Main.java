import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        // get number of letters from user and create array of size
        System.out.println("---------");
        System.out.println("Input number of values to encode: ");
        final int SIZE = scanner.nextInt();
        scanner.nextLine(); // consume buffer to maintain next input
        System.out.println();

        // array to store [character,frequency] sets
        String[] inputValues = new String[SIZE];

        for(int i = 0; i < inputValues.length; i++){
            System.out.println("--------------");
            System.out.println("Enter: [letter,frequency]");
            inputValues[i] = scanner.nextLine();
        }

        // print out values for user clarity
        System.out.println("Current values: ");
        for(String string : inputValues){
            System.out.println(string);
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
        System.out.println("-----------------------");
        System.out.println("--Encoding Dictionary--");
        for(String string : dictionary){
            System.out.println(string);
        }
    }
}
