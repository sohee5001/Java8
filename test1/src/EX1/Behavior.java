package EX1;

import Class.Apple;

import common.Utils;
import java.util.List;
import java.util.function.Predicate;

public class Behavior {

    static int result1 =0;

    public static void main(String[] args) {
        Utils.addAppleList();

//        (자바 8 이전 버전) 일반적으로 코드 넘겨주는 방법
//         getGreenAppleList(Utils.appleList);
//        (람다식) 일반적으로 코드 넘겨주는 방법
//         getGreenAppleList(Utils.appleList , Apple::isGreenApple);
//
//        (람다식) 메서드 전달
//         getGreenAppleList(Utils.appleList , (Apple a) -> "green".equals(a.getColor()) && a.getWeight() > 150);
//
//        (람다식) 스트림 API 활용. (순차 처리)
//        result1 = (int) Utils.appleList.stream().filter((Apple a) -> "green".equals(a.getColor())  && a.getWeight() > 150).count();
//
//        (람다식) 스트림 API 활용. (병렬 처리)
//        result1 = (int) Utils.appleList.parallelStream().filter((Apple a) -> "green".equals(a.getColor())  && a.getWeight() > 150).count();

        System.out.print("===초록 사과 갯수====="+(result1-1)+"개");

    }
    public static void getGreenAppleList(List<Apple> apples, Predicate<Apple> p){
        for(Apple apple : apples){
            //150이상 녹색인것.
            if(p.test(apple)){
                result1++;
            }
        }
    }

}
