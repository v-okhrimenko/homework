import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.List;


public class MainTest {

    @Test
    public void findAverageTest() {
        double delta = 1E-15;
        Collection<Double> testOne = List.of(1.0, 1.0, 1.0);
        Collection<Double> testThree = List.of(1.0, 2.0, 3.0, 4.0, 5.0);
        double result = Main.findAverage(testOne).getAsDouble();
        double result2 = Main.findAverage(null).getAsDouble();
        double result3 = Main.findAverage(testThree).getAsDouble();
        Assert.assertEquals(result, 1.0, delta);
        Assert.assertEquals(result2, 0.0, delta);
        Assert.assertEquals(result3, 3.0, delta);
    }

    @Test
    public void findAverageTestNull() {
        double delta = 1E-15;
        double result2 = Main.findAverage(null).getAsDouble();
        Assert.assertEquals(result2, 0.0, delta);
    }


    @Test
    public void stringToPairs() {
        Collection<String> stringsCollection = List.of("one", "two");
        List<Pairs> listForTest = List.of(new Pairs("one", "ONE"), new Pairs("two", "TWO"));
        Assert.assertEquals(listForTest, Main.stringToUpperCasePairs(stringsCollection));
    }

    @Test
    public void stringToPairsNull() {
        Assert.assertNotNull(Main.stringToUpperCasePairs(null));
    }

    @Test
    public void showLowerCaseWordsWithLengthFour() {
        Collection<String> originCollection = List.of("роль", "боль", "соль", "Мука", "Рука", "Станция", "Металлолом");
        Collection<String> testCollection = List.of("роль", "боль", "соль");
        Collection<String> testingCollection = Main.showLowerCaseWordsWithLengthFour(originCollection);
        Assert.assertEquals(testCollection, testingCollection);
    }

    @Test
    public void showLowerCaseWordsWithLengthFourNull() {
        Assert.assertNotNull(Main.showLowerCaseWordsWithLengthFour(null));
    }
}