import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordBank
{
    private final ArrayList<String> words;

    public WordBank(int difficulty)
    {
        words = new ArrayList<String>();

        // Inserts words that meet the level of the game specified
        try
        {
            // Word Bank list credit goes to  @Xethron:
            // https://github.com/Xethron/Hangman/blob/master/words.txt
            File file = new File("src/words.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine())
            {
                String line = sc.nextLine();
                if (line.length() >= difficulty && (line.length() <= difficulty + 3 || difficulty == 10))
                {
                    words.add(line);
                }
            }
        }
        catch (FileNotFoundException e)
        {
            System.err.println("An error occurred:");
        }
    }

    public String getWord()
    {
        int randSpot = (int) (Math.random() * words.size());

        return words.remove(randSpot);
    }
}
