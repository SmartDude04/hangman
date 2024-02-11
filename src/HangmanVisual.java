public class HangmanVisual
{
    String[] steps;

    public HangmanVisual()
    {
        steps = new String[15];

        steps[0] = """
                  +---+ \s
                  |   | \s
                      | \s
                      | \s
                      | \s
                      | \s
                =========""";

        steps[1] = """
                  +---+ \s
                  |   | \s
                  O   | \s
                      | \s
                      | \s
                      | \s
                =========""";

        steps[2] = """
                  +---+ \s
                  |   | \s
                  O   | \s
                  |   | \s
                      | \s
                      | \s
                =========""";

        steps[3] = """
                  +---+ \s
                  |   | \s
                  O   | \s
                 /|   | \s
                      | \s
                      | \s
                =========""";

        steps[4] = """
                  +---+ \s
                  |   | \s
                  O   | \s
                 /|\\  | \s
                      | \s
                      | \s
                =========""";

        steps[5] = """
                  +---+ \s
                  |   | \s
                  O   | \s
                 /|\\  | \s
                 /    | \s
                      | \s
                =========""";

        steps[6] = """
                  +---+ \s
                  |   | \s
                  O   | \s
                 /|\\  | \s
                 / \\  | \s
                      | \s
                =========""";

        steps[7] = """
                  +---+ \s
                  |   | \s
                  O   | \s
                 /|\\  | \s
                 / \\\\ | \s
                      | \s
                =========""";

        steps[8] = """
                  +---+ \s
                  |   | \s
                  O   | \s
                 /|\\  | \s
                // \\\\ | \s
                      | \s
                =========""";

        steps[9] = """
                  +---+ \s
                  |   | \s
                  O   | \s
                 /|\\  | \s
                // \\\\ | \s
                    \\ | \s
                =========""";

        steps[10] = """
                  +---+ \s
                  |   | \s
                  O   | \s
                 /|\\  | \s
                // \\\\ | \s
                /   \\ | \s
                =========""";

        steps[11] = """
                  +---+ \s
                  |   | \s
                  O   | \s
                 /|\\  | \s
                // \\\\ | \s
                /   \\ | \s
                =========""";

        steps[12] = """
                  +---+ \s
                  |   | \s
                      |\s
                 /O   | \s
                 /|\\  | \s
                // \\\\ | \s
                /   \\ | \s
                =========""";

        steps[13] = """
                  +---+ \s
                  |   | \s
                  _   |\s
                 /O   | \s
                 /|\\  | \s
                // \\\\ | \s
                /   \\ | \s
                =========""";

        steps[14] = """
                  +---+ \s
                  |   | \s
                  _   |\s
                 /O\\  | \s
                 /|\\  | \s
                // \\\\ | \s
                /   \\ | \s
                =========""";
    }

    public String getVisual(int guessesUsed)
    {
        return steps[guessesUsed];
    }
}