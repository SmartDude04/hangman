import java.util.ArrayList;
import java.util.Scanner;

public class HangmanPlayer
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Hangman!");
        System.out.println("-------------------\n");

        System.out.print("What difficulty do you want (1-10)? ");
        int difficulty = input.nextInt();
        input.nextLine();
        System.out.print("How many words do you want (1-5)? ");
        int numWords = input.nextInt();
        input.nextLine();
        System.out.print("Do you want to limit your number of guesses (yes/no)? ");
        String limit = input.nextLine();

        boolean limitGuesses = limit.equals("yes");
        int numGuesses = -1;
        if (limitGuesses)
        {
            numGuesses = 14;
        }

        // Perform checks on passed in values
        if (difficulty < 1 || difficulty > 10)
        {
            System.out.println("***");
            System.out.println("Difficulty was not in the desired range (1-10)...");
            System.out.println("Setting difficulty to 5\n***");
            difficulty = 5;
        }
        if (numWords < 1 || numWords > 5)
        {
            System.out.println("***");
            System.out.println("Number of words was not in the desired range (1-5)...");
            System.out.println("Setting number of words to 1\n***");
            numWords = 1;
        }


        Hangman game = new Hangman(difficulty, numWords, numGuesses);
        HangmanVisual visual = new HangmanVisual();

        // Start the game!
        System.out.println("\n\nCan you guess the word?\n");

        while (game.keepPlaying())
        {
            // If they want to only have a set num of guesses, display that
            int guessesLeft = game.getNumGuesses();

            System.out.println();
            if (guessesLeft != -1)
            {
                System.out.println("Guesses remaining: " + guessesLeft);
            }
            
            // Display current progress
            if (guessesLeft != -1)
            {
                System.out.println(visual.getVisual(game.getNumWrongGuesses()));
            }
            System.out.println(game.getUserProgress());

            // Display letters used
            System.out.print("Wrong letters used:");
            ArrayList<Character> wrongLetters = game.getWrongGuesses();
            for (char letter : wrongLetters)
            {
                System.out.print(" " + letter);
            }


            // Ask for a letter
            System.out.print("\nEnter a letter: ");
            String guess = input.nextLine();
            char letter = !guess.isEmpty() ? guess.charAt(0) : '1';

            // Update the game
            game.makeGuess(letter);
        }

        // Once the game is over, display how the user did
        if (game.checkIfWon())
        {
            System.out.println("You won!");
            System.out.println("Your phrase was: " + game.getPhrase());
            System.out.println("Guesses used: " + game.getGuessesUsed());
        }
        else
        {
            System.out.println("You lost!");
            System.out.println("Your phrase was: " + game.getPhrase());
        }
    }
}
