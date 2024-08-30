import javax.swing.JOptionPane;
import java.util.Random;

public class NumberGuessingGame {

    private static final int MAX_ATTEMPTS = 10; // Maximum number of attempts
    private static final int TOTAL_ROUNDS = 3; // Total number of rounds
    private static int score = 0;

    public static void main(String[] args) {
        Random random = new Random();
        int round = 1;

        while (round <= TOTAL_ROUNDS) {
            int numberToGuess = random.nextInt(100) + 1; // Random number between 1 and 100
            int attemptsLeft = MAX_ATTEMPTS;
            boolean hasGuessedCorrectly = false;

            JOptionPane.showMessageDialog(null, "Round " + round + " - Guess the number between 1 and 100!");

            while (attemptsLeft > 0) {
                String input = JOptionPane.showInputDialog("Enter your guess (" + attemptsLeft + " attempts left):");
                if (input == null) {
                    JOptionPane.showMessageDialog(null, "Game canceled.");
                    return;
                }

                try {
                    int guess = Integer.parseInt(input);
                    if (guess < 1 || guess > 100) {
                        JOptionPane.showMessageDialog(null, "Please enter a number between 1 and 100.");
                        continue;
                    }

                    if (guess < numberToGuess) {
                        JOptionPane.showMessageDialog(null, "Too low!");
                    } else if (guess > numberToGuess) {
                        JOptionPane.showMessageDialog(null, "Too high!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number!");
                        hasGuessedCorrectly = true;
                        int points = MAX_ATTEMPTS - (MAX_ATTEMPTS - attemptsLeft);
                        score += points;
                        break;
                    }

                    attemptsLeft--;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
                }
            }

            if (!hasGuessedCorrectly) {
                JOptionPane.showMessageDialog(null, "Sorry, you're out of attempts! The number was " + numberToGuess);
            }

            round++;
        }

        JOptionPane.showMessageDialog(null, "Game Over! Your final score is: " + score);
    }
}
