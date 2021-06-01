import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TestRun {

    private static final ArrayList<Question> wrongAnswer = new ArrayList<>();
    private static int currentQuestionsCounter = 1;
    private static int counter = 0;
    private static int correctAnswers = 0;
    private static int wrongAnswersInt = 0;

    public static void run(Path path, int howManyQuestions) {

        ArrayList<Question> allQuestionList = new GetQuestions().getQuestions(path);
        Question[] questions = getRandomQuestion(howManyQuestions, allQuestionList);
        if (questions.length != howManyQuestions) {
            System.out.println("По умолчанию стоит 15 вопрсов.");
        }

        System.out.println("\nНачнем...");
        Scanner answerScanner = new Scanner(System.in);

        while (currentQuestionsCounter != questions.length + 1) {
            Question tempQuestion = questions[counter];
            System.out.println("\nВопрос " + currentQuestionsCounter + " из " + questions.length + ":");
            System.out.println(tempQuestion.getQuestion() + "\n");
            for (int i = 0; i < tempQuestion.getVariants().length; i++) {
                System.out.println(i + 1 + ". " + tempQuestion.getVariants()[i]);
            }

            System.out.print("\nВыберете ответ: ");
            String answer = answerScanner.nextLine();
            if (checkCorrectEnter(answer, tempQuestion.getVariants().length)) {
                if (answer.equals(tempQuestion.getCorrectAnswerVariant())) {
                    System.out.println("-----Правильно------");
                    correctAnswers++;
                } else {
                    System.out.println("-----Ответ не верный-----");
                    tempQuestion.setAnswer(answer);
                    wrongAnswer.add(tempQuestion);
                    wrongAnswersInt++;
                }
                counter++;
                currentQuestionsCounter++;
            }
        }
        System.out.println("__________________________________________");
        System.out.println("\nВсего верных ответов: " + correctAnswers + " из " + questions.length);
        showResult();
    }

    private static void showResult() {
        if (wrongAnswersInt != 0) {
            System.out.println("\nВы ответили не правильно в таких вопросах:");
            for (Question q : wrongAnswer) {
                System.out.println("\n" + q.getQuestion());
                if (q.getYouAnswer(q.getAnswer()) != null) {
                    System.out.println("Вы ответили:  " + q.getYouAnswer(q.getAnswer()));
                }
                System.out.println("Правильный ответ: " + q.getYouAnswer(q.getCorrectAnswerVariant()));
            }
        }
    }

    private static boolean checkCorrectEnter(String answer, int length) {
        try {
            int answerInt = Integer.parseInt(answer);
            if (answerInt <= length & answerInt != 0) {
                return true;
            }
            System.out.println("Такого ответа нет. Выберете один из вариантов!");
            return false;

        } catch (Exception e) {
            System.out.println("Выберете один из вариантов!");
            return false;
        }
    }

    private static Question[] getRandomQuestion(int howManyQuestions, ArrayList<Question> allQuestionList) {
        ArrayList<Integer> checkIndex = new ArrayList<>();
        int counterQuestion;

        if (howManyQuestions > allQuestionList.size()) {
            System.out.println("Вы выбрали слишком большое количество вопросов. Максимальное количество " + allQuestionList.size());
            counterQuestion = 15;
        } else {
            counterQuestion = howManyQuestions;
        }

        Question[] questionsArray = new Question[counterQuestion];
        for (int i = 0; i < counterQuestion; ) {
            int rnd = new Random().nextInt(allQuestionList.size());
            if (!checkIndex.contains(rnd)) {
                checkIndex.add(rnd);
                questionsArray[i] = allQuestionList.get(rnd);
                i++;
            }
        }
        return questionsArray;
    }
}
