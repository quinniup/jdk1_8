package chapter2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public void prettyPrintApple(List<Apple> apples,ApplePredicate predicate){
        for (Apple apple:apples){
            System.out.println(predicate.outString(apple));
        }
    }
    public static void main(String[] args) {
        Apple apple=new Apple();
        apple.setWeight("100");
        List<Apple> apples=new ArrayList<>();
        apples.add(apple);
        Main test=new Main();
        test.prettyPrintApple(apples, Apple::getWeight);
    }
}
