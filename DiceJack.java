import java.util.Scanner;

public class DiceJack {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int roll1 = rollDice();
        int roll2 = rollDice();
        int roll3 = rollDice();

        System.out.println("Enter three numbers between 1 and 6");
        
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        int num3 = scan.nextInt();

        if (num1 < 1 || num2 < 1 || num3 < 1){
            System.out.println("Numbers cannot be less than 1. Shutting the game down");
            System.exit(0);
        }

        if (num1 > 6 || num2 > 6 || num3 > 6){
            System.out.println("Numbers cannot be higher than 6. Shutting the game down");
            System.exit(0);
        }

        int sumOfNumbers = num1 + num2 + num3;
        int sumDiceRolls = roll1 + roll2 + roll3;
        System.out.println("\nYour chosen numbers are: " + num1 + " " + num2 + " " + num3 );
        System.out.println("Your rolled numbers are: " + roll1 + " " + roll2 + " " + roll3 );
        System.out.println("\nDice sum = " + sumDiceRolls + ". Number sum = " + sumOfNumbers);

        if (checkWin(sumDiceRolls, sumOfNumbers)){
            System.out.println("Congrats, you win!\n");
        } else {
            System.out.println("Sorry, you lose.\n");
        }

        scan.close();
    }

    public static int rollDice(){
        double randomNumber = Math.random() * 7;
        randomNumber += 1;
        return (int)randomNumber;
    }

    public static boolean checkWin(int sumDiceRolls, int sumOfNumbers){
        return (sumOfNumbers > sumDiceRolls && sumOfNumbers - sumDiceRolls < 3);
    }
}

/*
 * User wins if sum of dice rolls is smaller than the sum of numbers chosen
 * AND if the difference between the two numbers is less than three
 */
