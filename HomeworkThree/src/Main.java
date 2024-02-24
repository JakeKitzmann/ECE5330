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

        String[] inputValues = new String[SIZE];

        for(int i = 0; i < inputValues.length; i++){
            System.out.println("--------------");
            System.out.println("Enter: [letter,frequency]");
            inputValues[i] = scanner.nextLine();
        }

        System.out.println("Current values: ");
        for(String string : inputValues){
            System.out.println(string);
        }

        // init arrays to store characters and frequencies
        char[] characters = new char[SIZE];
        int[] frequencies = new int[SIZE];

        int i = 0;
        for(String string : inputValues){
            String[] components = string.split(",");

            char character = components[0].charAt(components[0].length()-1);
            int frequency = Integer.parseInt(components[1].substring(0,components[1].length() - 1));

            System.out.print(character);
            System.out.println("  " + frequency);

            characters[i] = character;
            frequencies[i] = frequency;

            i++;
        }

        HuffmansAlgorithm huffmansAlgorithm = new HuffmansAlgorithm();
        ArrayList<String> dictionary = huffmansAlgorithm.huffmansAlgorithm(SIZE, characters, frequencies);

        // Ouptut
        System.out.println("-----------------------");
        System.out.println("--Encoding Dictionary--");
        for(String string : dictionary){
            System.out.println(string);
        }
    }
}
