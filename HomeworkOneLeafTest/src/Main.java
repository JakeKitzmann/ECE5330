import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        LeafSolve leafSolve = new LeafSolve();

        int n = 5;

        double probN = leafSolve.leafProbability(n);

        System.out.println("Probability at n = " + n  + ": " +  probN);
    }




}
