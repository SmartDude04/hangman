import java.util.ArrayList;

public class Hangman
{
    private String phrase;
    private String userProgress;
    private int numGuesses;
    private int guessesUsed;
    private final ArrayList<Character> prevGuesses;
    private final ArrayList<Character> wrongGuesses;

    public Hangman(int difficulty, int numWords, int numGuesses)
    {
        guessesUsed = 0;
        this.numGuesses = Math.max(numGuesses, -1);

        prevGuesses = new ArrayList<Character>(14);
        wrongGuesses = new ArrayList<Character>();

        WordBank bank = new WordBank(difficulty);

        // Get the phrase and userProgress vars ready
        phrase = "";
        userProgress = "";
        for (int i = 0; i < numWords; i++)
        {
            String newWord = bank.getWord();
            phrase += " " + newWord;

            // Set up userProgress, which will start as hidden
            userProgress += " ";
            for (int j = 0; j < newWord.length(); j++)
            {
                userProgress += "_";
            }
        }

        // Remove the space at the beginning
        // Fencepost problem!
        phrase = phrase.substring(1);
        userProgress = userProgress.substring(1);
    }

    public void makeGuess(char letter)
    {

        // Error checking
        if (!Character.isLetter(letter))
        {
            System.err.println("Value is not a letter!\nNo guesses lost");
            return;
        }

        // Check if the letter has been made before
        for (char prevLetter : prevGuesses)
        {
            if (prevLetter == letter)
            {
                // Letter has been used. Notify the user and don't keep going
                System.err.println("Letter has been guessed before! Try again.");
                if (numGuesses != -1)
                {
                    System.out.println("No guesses lost");
                }
                return;
            }
        }

        // Checks if the letter was in the phrase or not
        boolean placedIn = false;

        // Find where the letter is in the string
        for (int i = 0; i < phrase.length(); i++)
        {
            if (phrase.charAt(i) == letter)
            {
                placedIn = true;
                // If the letter is there, update userProgress accordingly
                userProgress = userProgress.substring(0, i) + phrase.charAt(i) + userProgress.substring(i + 1);
            }
        }

        // If the letter was not placed in, add it to the wrongGuesses list
        if (!placedIn)
        {
            wrongGuesses.add(letter);
        }

        // Update guesses vars
        if (numGuesses != -1 && !placedIn)
        {
            numGuesses--;
        }

        prevGuesses.add(letter);
        guessesUsed++;
    }

    public boolean checkIfWon()
    {
        // Check to see if no underscores exist
        boolean won = true;
        for (int i = 0; i < userProgress.length(); i++)
        {
            if (userProgress.charAt(i) == '_')
            {
                won = false;
                break;
            }
        }

        return won;
    }

    public boolean keepPlaying()
    {
        boolean hasWon = checkIfWon();
        boolean outOfGuesses = numGuesses == 0;

        return !hasWon && !outOfGuesses;
    }

    public int getNumGuesses()
    {
        return numGuesses;
    }

    public int getNumWrongGuesses()
    {
        return wrongGuesses.size();
    }

    public ArrayList<Character> getWrongGuesses()
    {
        return wrongGuesses;
    }

    public int getGuessesUsed()
    {
        return guessesUsed;
    }

    public String getPhrase()
    {
        return phrase;
    }

    public String getUserProgress()
    {
        return userProgress;
    }
}