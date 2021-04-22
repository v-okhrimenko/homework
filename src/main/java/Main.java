import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Collection<Double> doublesList = List.of(1., 2., 3., 4., 5., 6., 7., 8., 9., 10.);
        double average = findAverage(doublesList).getAsDouble();
        System.out.println(average);
        System.out.println("");

        Collection<String> stringsCollection = List.of("one", "two", "three", "four", "five");
        List<Pairs> mapCollection = stringToUpperCasePairs(stringsCollection);
        System.out.println(mapCollection);
        System.out.println("");

        Collection<String> stringsLengthsCollection = List.of("Меню","отит", "Лифт", "июль","Роль", "Змей", "Бобр",
                "Игла", "Луна", "овес", "Метеорит", "гагры", "Бетономешалка", "гидропоника");
        showLowerCaseWordsWithLengthFour(stringsLengthsCollection).forEach(System.out::println);
    }

    public static List<Pairs> stringToUpperCasePairs(Collection<String> collection) {
        return Optional.ofNullable(collection)
                .orElse(List.of())
                .stream()
                .map(s -> new Pairs(s, s.toUpperCase()))
                .collect(Collectors.toList());
    }

    public static OptionalDouble findAverage(Collection<Double> integersArrayList) {
        return Optional.ofNullable(integersArrayList)
                .orElse(List.of(0.0))
                .stream()
                .mapToDouble(Double::doubleValue)
                .average();
    }

    public static Collection<String> showLowerCaseWordsWithLengthFour(Collection<String> stringCollection) {
        return Optional.ofNullable(stringCollection)
                .orElse(List.of())
                .stream()
                .filter((s)-> s.length()==4 && s.equals(s.toLowerCase()))
                .collect(Collectors.toList());
    }
}
