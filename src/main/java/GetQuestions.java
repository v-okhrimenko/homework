import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetQuestions {

    private static final ArrayList<Question> questionArrayList = new ArrayList<>();

    private static String readFile(Path path) {
        StringBuilder text = new StringBuilder();
        try (RandomAccessFile raf = new RandomAccessFile(path.toFile(), "rw")) {

            raf.seek(raf.length() - 9);
            String lastString = raf.readLine();

            if (!lastString.equals("___End___")) {
                raf.seek(raf.length());
                raf.writeBytes("\n___End___");
            }
            raf.seek(0);
//
            while (raf.getFilePointer() < raf.length()) {
                String line = raf.readLine();
                String correctText = new String(line.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);

                if (line.equals("")) {
                    text.append(System.lineSeparator()).append("___End___");
                } else {
                    text.append(correctText).append(System.lineSeparator());
                }
            }
            raf.seek(raf.length() - 9);
            raf.writeBytes("         ");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }

    private static void parseString(String text) {
        Pattern patternAllData = Pattern.compile("@Question(.*?)___End___", Pattern.DOTALL);
        Matcher matcher = patternAllData.matcher(text);
        while (matcher.find()) {

            String allData = matcher.group(1).trim();

            // parse question
            String question = allData.substring(0, allData.indexOf("@Options")).trim();

            //parse answer
            String answer = allData.substring(allData.indexOf("@Key="), allData.indexOf("@Key=") + 6);
            answer = answer.substring(answer.indexOf("=") + 1);

            //parse variant answer count
            String answerCountVariant = allData.substring(allData.indexOf("@Options") + 8, allData.indexOf("@Key=")).trim();
            answerCountVariant = answerCountVariant.substring(1);

            //parse answer variant
            String allVariantsAnswer = allData.substring(allData.indexOf("@Key=") + 6).trim();
            String[] splitVariantOfAnswer = allVariantsAnswer.split(System.lineSeparator());

            questionArrayList.add(new Question(question, answerCountVariant, answer, splitVariantOfAnswer));
        }
    }

    public ArrayList<Question> getQuestions(Path path) {
        parseString(readFile(path));
        return questionArrayList;
    }
}
