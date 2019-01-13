package chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static <T> List<T> filter(List<T> list,Predicate<T> predicate){
        List<T> results=new ArrayList<>();
        for (T s:list){
            if( predicate.test(s)){
                results.add(s);
            }
        }
        return results;
    }

    public static void main(String []args){
        List<String> params= Arrays.asList("1");
        Predicate<String> nonEmptyStringPredicate=(String s)->!s.isEmpty();
        List<String> nonEmptyList=filter(params,nonEmptyStringPredicate);

    }
}
