package EX1;

import Class.Apple;
import common.Utils;

import java.util.List;
import java.util.stream.Collectors;

public class Stream {

//    static List<Apple> result   = new ArrayList<Apple>();
//    static Apple apple = new Apple();
    static int result1 =0;


    public static void main(String[] args) {
        Utils.addAppleList();

//        (자바 8 이전 버전) 일반적으로 코드 넘겨주는 방법
//         getGreenAppleList(result);
//         (자바 8 버전) 일반적으로 코드 넘겨주는 방법
//         getGreenAppleList(result , Apple::isGreenApple);

//        (람다식) 메서드 전달
//        getGreenAppleList(result , (Apple a) -> "green".equals(a.getColor()));
//
//        (람다식) 스트림 API 활용. (순차 처리)
        result1 = (int) Utils.appleList.stream().filter((Apple a) -> "green".equals(a.getColor())).count();

//        (람다식) 스트림 API 활용. (병렬 처리)
        result1 =  (int) Utils.appleList.parallelStream().filter((Apple a) -> "green".equals(a.getColor())).count();

//         .collect() 사용하여 정렬된 값 result2에 값을 연결시켜줌.
        List<Apple> result2 = Utils.appleList.stream().filter((Apple a) -> "green".equals(a.getColor())).collect(Collectors.toList());

        for(Apple a : result2){
            System.out.print("/"+a.getColor());
        }

        System.out.print("===초록 사과 갯수====="+(result1-1)+"개");

    }
//    public static void getGreenAppleList(List<Apple> apples, Predicate<Apple> p){
//        for(Apple apple : apples){
//            if(p.test(apple)){
//                result1++;
//            }
//        }
//    }



}
