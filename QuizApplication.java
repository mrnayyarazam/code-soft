import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication {

    static class Question {
        String question;
        String[] options;
        int correctAnswer;

        Question(String question, String[] options, int correctAnswer) {
            this.question = question;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Question[] questions = {

            new Question(
                    "Which language is known as platform independent?",
                    new String[]{"C", "C++", "Java", "Assembly"},
                    3
            ),

            new Question(
                    "Which keyword is used to inherit a class in Java?",
                    new String[]{"this", "extends", "implements", "super"},
                    2
            ),

            new Question(
                    "Which method is the entry point of a Java program?",
                    new String[]{"start()", "run()", "main()", "execute()"},
                    3
            ),

            new Question(
                    "Which data type stores true or false?",
                    new String[]{"int", "boolean", "char", "double"},
                    2
            ),

            new Question(
                    "Which collection does not allow duplicate elements?",
                    new String[]{"List", "ArrayList", "Set", "Queue"},
                    3
            )
        };

        int score = 0;
        int timeLimit = 10;

        System.out.println("===== JAVA QUIZ =====");

        for (int i = 0; i < questions.length; i++) {

            Question q = questions[i];

            System.out.println("\nQuestion " + (i + 1));
            System.out.println(q.question);

            for (int j = 0; j < q.options.length; j++) {
                System.out.println((j + 1) + ". " + q.options[j]);
            }

            System.out.println("You have " + timeLimit + " seconds.");

            final int[] answer = {-1};

            Timer timer = new Timer();

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("\nTime's up!");
                    answer[0] = 0;
                }
            }, timeLimit * 1000);

            System.out.print("Enter your answer: ");

            try {
                answer[0] = sc.nextInt();
            } catch (Exception e) {
                sc.nextLine();
            }

            timer.cancel();

            if (answer[0] == q.correctAnswer) {
                System.out.println("Correct!");
                score++;
            } else if (answer[0] != 0) {
                System.out.println("Incorrect!");
            }
        }

        System.out.println("\n===== QUIZ RESULT =====");
        System.out.println("Total Questions : " + questions.length);
        System.out.println("Correct Answers : " + score);
        System.out.println("Wrong Answers   : "
                + (questions.length - score));
        System.out.println("Final Score     : " + score
                + "/" + questions.length);

        sc.close();
    }
}