public class RunTimeTesting {
    public static void main(String[] args){
        double startTime = System.nanoTime();

        for(int i = 0; i < 1000; i++){
            for(int j = 0; j < i; j++){
                System.out.println(j);
            }
        }


        double endTime   = System.nanoTime();
        double totalTime = (endTime - startTime) / 1000;
        System.out.println("Run Time: " + totalTime + " milliseconds");
    }
}
