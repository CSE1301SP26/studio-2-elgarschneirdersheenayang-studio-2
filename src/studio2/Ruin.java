import java.util.Scanner;
import java.util.Random;

public class Ruin {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("What is the starting amount?");
        int startAmount = in.nextInt();
        System.out.println("What is the win chance?");
        double winChance = in.nextDouble();
        System.out.println("What is the win limit?");
        int winLimit = in.nextInt();

        // temp storage to no loose starting vars

        int tempStart = startAmount;

        int playCounter = 0;

        System.out.println("How many simulations?");
        int totalSimulation = in.nextInt();
        // x varible for total sim iteration, outcome variable to produe win/loss,
        // string says win/lose not t/f
        // vars for win and loss counter
        int x = 1;
        boolean gameOutcome;
        String winLose;
        int winCount = 0;
        int lossCount = 0;

        // simulate totalSimulation number of games print each one

        while (x <= totalSimulation) {

            // play until success or ruin
            while (tempStart > 0 && tempStart < winLimit) {
                if (Math.random() < winChance) {
                    tempStart++;
                    playCounter++;
                }

                else {
                    tempStart--;
                    playCounter++;
                }
            }
            // outcome win/lose

            if (tempStart >= winLimit) {
                gameOutcome = true;
            } else {
                gameOutcome = false;
            }

            if (gameOutcome) {
                winLose = "WIN";
                winCount++;
            } else {
                winLose = "LOSE";
                lossCount++;
            }

            // game output, iterate x through while loop, reset play counter, reset temp
            // starting
            System.out.println("Simulation " + x + ": " + playCounter + " " + winLose);
            playCounter = 0;
            tempStart = startAmount;
            x++;
        }
        System.out.print("Wins: " + winCount + " LossesL " + lossCount);

    }
}
