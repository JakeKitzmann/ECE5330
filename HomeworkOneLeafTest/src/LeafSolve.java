public class LeafSolve{
    public double leafProbability(int n){
        if(n == 0){
            return 1.0;
        }
        else if(n == 1){
            return 0.0;
        }
        else{
            return (1/3.0) + ((2/3.0) * leafProbability(n - 1));
        }
    }
}
