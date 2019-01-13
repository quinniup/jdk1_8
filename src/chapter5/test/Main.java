package chapter5.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class Main {

    /*
        8.找到交易额最小的交易
     */
    public static void getMinTrader(List<Trahsaction> trahsactions) {
        Optional<Trahsaction> trahsaction = trahsactions.stream()
                .min(Comparator.comparing(Trahsaction::getValue));
        System.out.println(trahsaction.get().toString());
    }


    /*
        7.所有交易中，最高交易额的是多少
     */
    public static void getHigtValue(List<Trahsaction> trahsactions) {
        Optional<Integer> value = trahsactions.stream()
                .map(Trahsaction::getValue)
                .reduce(Integer::max);
        System.out.println(value.get());
    }

    /*
        6.打印生活在剑桥的交易员的所有交易额
     */
    public static void getAllCambridgeValue(List<Trahsaction> trahsactions) {
        trahsactions.stream()
                .filter(trahsaction -> trahsaction.getTrader().getCity() == "Cambridge")
                .map(Trahsaction::getValue)
                .forEach(System.out::println);
    }

    /*
        5.有没有交易员在米兰工作
     */
    public static void isMiLan(List<Trahsaction> trahsactions) {
        boolean isMilan = trahsactions.stream()
                .anyMatch(trahsaction -> trahsaction.getTrader().getCity() == "Milan");
        System.out.println(isMilan);
    }

    /*
        4.返回所有交易员的姓名字符串，并按照字母顺序排序
     */
    public static void sortNameByString(List<Trahsaction> trahsactions) {
        String names = trahsactions.stream()
                .map(trahsaction -> trahsaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(joining(" "));
        System.out.println(names);
    }

    /*
        3.查找所有来自剑桥的交易员，并按照姓名顺序排序
     */
    public static void sortName(List<Trahsaction> trahsactions) {
        trahsactions.stream()
                .map(Trahsaction::getTrader)
                .filter(trader -> trader.getCity() == "Cambridge")
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(trader -> System.out.println(trader.getName()));

    }

    /*
        2.交易员都在哪些不同的城市工作过
     */
    public static void getCity(List<Trahsaction> trahsactions) {
        trahsactions.stream()
                .map(trahsaction -> trahsaction.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
    }

    /*
        1.找出2011年发生的所有交易，并按交易额顺序排序（从低到高）
     */
    public static void sortTrader(List<Trahsaction> trahsactions) {

        trahsactions.stream()
                .filter(trahsaction -> trahsaction.getYear() == 2011)
                .sorted(Comparator.comparing(Trahsaction::getValue))
                .forEach(trahsaction -> System.out.println(trahsaction.getTrader().getName()));
    }

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brain = new Trader("Brain", "Cambridge");

        List<Trahsaction> trahsactions = Arrays.asList(
                new Trahsaction(brain, 2011, 300),
                new Trahsaction(raoul, 2012, 1000),
                new Trahsaction(raoul, 2011, 400),
                new Trahsaction(mario, 2012, 710),
                new Trahsaction(mario, 2012, 700),
                new Trahsaction(alan, 2012, 950)
        );

        getMinTrader(trahsactions);

//        getHigtValue(trahsactions);

//        getAllCambridgeValue(trahsactions);

//        isMiLan(trahsactions);

//        sortNameByString(trahsactions);

//        sortName(trahsactions);

//        getCity(trahsactions);

//        sortTrader(trahsactions);
    }
}
