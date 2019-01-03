package EX2;

import Class.Apple;
import Class.DeliveryRegion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.*;
import common.Utils;

public class Comparator2 {

    public static void main(String[] args) {
//        1. 사과 리스트  정렬 해보기

//          a. (자바 8 이전 버전) 사과 리스트에 compareTo 사용하여 정렬 해보기
                Utils.addAppleList();
                Utils.appleList.sort(new Comparator<Apple>() {
                      @Override
                      public int compare(Apple o1 , Apple o2) {
                          return String.valueOf(o1.getWeight()).compareTo(String.valueOf(o2.getWeight()));
                      }
                });

//          b. (람다식) Comparator 인터페이스 사용.
                Utils.appleList.sort((Comparator<Apple>) (o1, o2) -> String.valueOf(o1.getWeight()).compareTo(String.valueOf(o2.getWeight())));

//          c.  (람다식) 사과 리스트에 compareTo 메소드 사용하여 무게별 정렬 하기
                Utils.appleList.sort((o1, o2) -> String.valueOf(o1.getWeight()).compareTo(String.valueOf(o2.getWeight())));

//          d.  (람다식) 간략화.
                Utils.appleList.sort(Comparator.comparing(o -> String.valueOf(o.getWeight())));

//          e. (람다식) 스트림 API 활용 하여 사과 리스트 무게별 내림 차순 정렬하기
//              Utils.appleList = Utils.appleList.stream().filter((Apple apple) -> "green".equals(apple.getColor()) && apple.getWeight() > 130).collect(Collectors.toList());
//              Utils.appleList.sort(comparing(Apple::getWeight)); //무게 내림 차순

//        int count =0;

//        System.out.println("==== 초록 사과 무게 내림차순 정렬 ====");
//        for(Apple apple : Utils.appleList){
//            System.out.print(" / "+apple.getWeight());
//        }


        String a = null;

//      문제 : (람다식)  배달 지역은 서울이다. 서울에 배달될 사과 목록 중에 색깔은 초록색이며 130g 이상인 사과만 출력해라.
        List<Apple> regions = Utils.deliveryRegionList.stream()
                .filter((region) -> region.getRegionName().startsWith("서"))
                .flatMap((region) -> region.getAppleList().stream())
                .filter((apple) -> apple.getColor().equals("green") && apple.getWeight() > 130)
                .collect(Collectors.toList());

    }

}
