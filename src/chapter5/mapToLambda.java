package chapter5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class mapToLambda {

    /*
        1.求给定数字列表的平方和并一一打印
     */
    public static void learning5_2_1() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers
                .stream()
                .map(n -> n * n)
                .forEach(n -> System.out.print("Value:" + n + "\n"));
    }

    /*
        2.给定两个数字列表，返回所有数对
     */
    public static void learning5_2_2() {
        List<Integer> number1 = Arrays.asList(1, 2, 3);
        List<Integer> number2 = Arrays.asList(3, 4);
        List<int[]> results = number1
                .stream()
                .flatMap(i -> number2
                        .stream()
                        .map(j -> new int[]{i, j}))
                .collect(Collectors.toList());
        results.stream()
                .forEach(a -> System.out.println(a[0] + "," + a[1]));
    }

    /*
        3.勾股数
     */
    public static void learning5_6() {
        Stream<double[]> pythagoreanTriples = IntStream.rangeClosed(1, 100)
                .limit(5)
                .boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .limit(5)
                        .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)})
                        .filter(t -> t[2] % 1 == 0));
        pythagoreanTriples.forEach(t -> System.out.print((int) t[0] + "," + (int) t[1] + "," + (int) t[2] + "\n"));
    }

    public static void main(String[] args) {
        learning5_6();

    }
}
