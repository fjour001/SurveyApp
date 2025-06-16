import java.util.Scanner;

public class SurveyApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] questions = {
            "1. How satisfied are you with our customer service?",
            "2. How would you rate the quality of our products?",
            "3. How likely are you to recommend us to a friend?",
            "4. How easy was it to navigate our website?",
            "5. How satisfied are you with your overall experience?"
        };

        int[] ratings = new int[questions.length];
        int total = 0;

        System.out.println("Rate each question from 1 (Strongly Disagree) to 5 (Strongly Agree).");

        for (int i = 0; i < questions.length; i++) {
            System.out.print(questions[i] + " ");
            try {
                int response = scanner.nextInt();

                if (response < 1 || response > 5) {
                    System.out.println("Invalid rating. Please enter a number from 1 to 5.");
                    i--; // ask the same question again
                    continue;
                }

                ratings[i] = response;
                total += response;

            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // clear invalid input
                i--; // ask the same question again
            }
        }

        System.out.println("\nSurvey Results (Stars Represent Rating):");
        for (int i = 0; i < questions.length; i++) {
            System.out.print(questions[i] + " " + ratings[i] + ": ");
            for (int j = 0; j < ratings[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        double average = (double) total / questions.length;
        System.out.printf("\nAverage Rating: %.2f out of 5\n", average);

        scanner.close();
    }
}
