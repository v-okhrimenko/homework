import java.util.Arrays;

public class Question {

    private final String question;
    private final String variantOfAnswer;
    private final String correctAnswerVariant;
    private final String[] variants;
    private String answer;

    public Question(String question, String variantOfAnswer, String correctAnswerVariant, String[] variants) {

        this.question = question;
        this.variantOfAnswer = variantOfAnswer;
        this.correctAnswerVariant = correctAnswerVariant;
        this.variants = variants;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswerVariant() {
        return correctAnswerVariant;
    }

    public String[] getVariants() {
        return variants;
    }

    public String getYouAnswer(String answer) {
        int answerId = 1;
        for (int i = 0; i <= variants.length; i++) {
            if (answerId == Integer.parseInt(answer)) {
                return variants[i];

            } else {
                answerId++;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Question: " + question + "\n" +
                "Count of answer variant (String): " + variantOfAnswer + "\n" +
                "Correct answer (int): " + correctAnswerVariant + "\n" +
                "Variants of answer: " + Arrays.toString(variants) + "\n" +
                "__________________________________________________\n";
    }
}
