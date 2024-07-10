import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuizGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Question> questions = new ArrayList<>(Arrays.asList(
            new Question("What is the capital of France?", new String[]{"A. Paris", "B. London", "C. Berlin", "D. Madrid"}, 'A'),
            new Question("Who invented the telephone?", new String[]{"A. Alexander Graham Bell", "B. Thomas Edison", "C. Nikola Tesla", "D. Michael Faraday"}, 'A'),
            new Question("What is the largest planet in our solar system?", new String[]{"A. Earth", "B. Jupiter", "C. Saturn", "D. Mars"}, 'B'),
            new Question("What year did the Titanic sink?", new String[]{"A. 1912", "B. 1905", "C. 1898", "D. 1923"}, 'A'),
            new Question("What is the capital of Japan?", new String[]{"A. Tokyo", "B. Beijing", "C. Seoul", "D. Bangkok"}, 'A'),
            new Question("Who painted the Mona Lisa?", new String[]{"A. Leonardo da Vinci", "B. Vincent van Gogh", "C. Pablo Picasso", "D. Michelangelo"}, 'A'),
            new Question("What is the largest ocean in the world?", new String[]{"A. Atlantic Ocean", "B. Indian Ocean", "C. Pacific Ocean", "D. Arctic Ocean"}, 'C'),
            new Question("What year did World War II end?", new String[]{"A. 1945", "B. 1939", "C. 1941", "D. 1943"}, 'A')
        ));

        int score = 0;

        for (Question question : questions) {
            System.out.println(question.getQuestion());
            for (String option : question.getOptions()) {
                System.out.println(option);
            }
            System.out.print("Enter your answer (A, B, C, D) or type 'exit' to quit: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            char answer = input.toUpperCase().charAt(0);

            if (answer == question.getCorrectAnswer()) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer was " + question.getCorrectAnswer());
            }
        }

        scanner.close();

        System.out.println("You scored " + score + " out of " + questions.size());
    }
}

class Question {
    private String question;
    private String[] options;
    private char correctAnswer;

    public Question(String question, String[] options, char correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public char getCorrectAnswer() {
        return correctAnswer;
    }
}