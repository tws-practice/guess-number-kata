import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        test_init_stream();

        test_map_operation();

//        complex_api();
        stream_operate_object();
    }

    private static void stream_operate_object() {
        List<Person> persons = Arrays.asList(new Person("Jason", 25),
                new Person("Tim", 35),
                new Person("Aima", 18),
                new Person("James", 18),
                new Person("Tony", 25));
        Map<Integer, List<Person>> collect = persons.stream()
                .collect(Collectors.groupingBy(Person::getAge));
        System.out.println(collect);

        Double averageAge = persons.stream().collect(Collectors.averagingInt(Person::getAge));
        System.out.println(averageAge);
    }

    private static void test_map_operation() {
        List<Integer> list2 = IntStream.range(1, 100).boxed().collect(Collectors.toList());
        Map<Integer, Integer> map = list2.stream().collect(Collectors.toMap(p -> p, q -> q * 3));
        System.out.println(map);

        List<Integer> list3 = new Random()
                .ints(-100, 100)
                .limit(250).boxed()
                .collect(Collectors.toList());
        Optional<Integer> max = list3.stream().reduce(Math::max);
        max.ifPresent(value -> System.out.println(value));


        String[] names = new String[]{
                "Fred Edwards", "Anna Cox", "Deborah Patterson", "Ruth Torres", "Shawn Powell",
                "Rose Thompson", "Rachel Barnes", "Eugene Ramirez", "Earl Flores", "Janice Reed", "Sarah Miller",
                "Patricia Kelly", "Carl Hall", "Craig Wright", "Martha Phillips", "Thomas Howard", "Steve Martinez",
                "Diana Bailey", "Kathleen Hughes", "Russell Anderson", "Theresa Perry", "Anna Cox"};
        List<String> ls = Arrays.asList(names)
                .parallelStream()
                .filter(s -> s.startsWith("C"))
                .collect(Collectors.toList());
        System.out.println(ls.toString());

        Arrays.asList(names)
                .stream()
                .map(String::toUpperCase)
                .sorted()
                .distinct()
                .limit(5)
//                .collect(Collectors.joining())
                .forEach(System.out::print);
    }

    private static void test_init_stream() {
        IntStream.range(0, 10).forEach(value ->
                System.out.print(value + " "));

        System.out.println();

        List<Integer> intList0 = IntStream.range(1, 100).boxed().collect(Collectors.toList());
        System.out.print(intList0.stream().count() + " ");

        System.out.println();

        Double avarage = intList0.stream().collect(Collectors.averagingInt(item -> item));
        System.out.println(avarage);

        System.out.println();
        List<Integer> intList1 = IntStream.range(1, 100).boxed().collect(Collectors.toList());
        IntSummaryStatistics iss = intList1.stream().collect(Collectors.summarizingInt(value -> value));
        System.out.println(iss);
    }

    static void test2() {
        // 计算偶数个数
        List<Integer> list = Arrays.asList(3, 2, 12, 5, 6, 11, 13);
        long count = list.stream()
                .filter(x -> x % 2 == 0).count();
        System.out.println(count);
        // 筛选出偶数列表
        List<Integer> evenList = list.stream()
                .filter(x -> x % 2 == 0).collect(Collectors.toList());
        System.out.println(evenList);
        // 筛选出偶数列表, 然后全部元素加1
        List<Integer> plusList = list.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x + 1).collect(Collectors.toList());
        System.out.println(plusList);
        // 全部偶数求和
        int sum = list.stream()
                .filter(x -> x % 2 == 0)
                .mapToInt(Integer::intValue).sum();
        System.out.println(sum);
        // 全部偶数求和
        sum = list.stream()
                .filter(x -> x % 2 == 0)
                .reduce(0, (x, y) -> x + y);
        System.out.println(sum);
    }

    private static void complex_api() {
        Stream<List<Integer>> stream = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4, 5));
        stream.flatMap(list -> list.stream())
                .forEach(i -> System.out.println(i));
    }

    public static void executeMthodWithFunctionParams() {
        List<String> languages = Arrays.asList("Java", "Python", "scala", "Shell", "R");
        System.out.println("Language starts with J: ");
        filterTest(languages, x -> x.startsWith("J"));
        System.out.println("\nLanguage ends with a: ");
        filterTest(languages, x -> x.endsWith("a"));
        System.out.println("\nAll languages: ");
        filterTest(languages, x -> true);
        System.out.println("\nNo languages: ");
        filterTest(languages, x -> false);
        System.out.println("\nLanguage length bigger three: ");
        filterTest(languages, x -> x.length() > 4);
    }

    public static void filterTest(List<String> languages, Predicate<String> condition) {
        languages.stream().filter(x -> condition.test(x)).forEach(x -> System.out.println(x + " "));
    }
}
