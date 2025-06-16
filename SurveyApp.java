import java.util.Scanner;

public class SurveyApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] questions = {
            "What is your rating of our customer service (1-poor, 2-fair, 3-good, 4-excellent, 5-outstanding)? ",
            "What is your rating of the quality of our products (1-poor, 2-fair, 3-good, 4-excellent, 5-outstanding)? ",
            "How likely are you to recommend us to a friend (1-poor, 2-fair, 3-good, 4-excellent, 5-outstanding)? ",
            "How easy was it to navigate our website (1-poor, 2-fair, 3-good, 4-excellent, 5-outstanding)? ",
            "How satisfied are you with your overall experience (1-poor, 2-fair, 3-good, 4-excellent, 5-outstanding)? "
        };

        int[] ratings = new int[questions.length];
        int total = 0;

        for (int i = 0; i < questions.length; i++) {
            while (true) {
                System.out.print(questions[i]);

                try {
                    int response = scanner.nextInt();

                    if (response >= 1 && response <= 5) {
                        ratings[i] = response;
                        total += response;
                        break; // valid input, exit the loop
                    } else {
                        System.out.println("Invalid rating. Please enter a number between 1 and 5.");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a numeric value.");
                    scanner.next(); // clear the invalid input
                }
            }
        }

        // Display stars representing ratings
        System.out.println();
        for (int rating : ratings) {
            for (int j = 0; j < rating; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Calculate and display average
        double average = (double) total / ratings.length;
        System.out.printf("\nYour average rating is %.1f\n", average);

        scanner.close();
    }
}
