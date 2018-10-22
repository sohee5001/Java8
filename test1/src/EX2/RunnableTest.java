package EX2;

import Class.Apple;
import common.Utils;

import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.lang.Runnable;
import java.util.stream.Stream;

public class RunnableTest {

    public static void main(String[] args) {

        Utils.addAppleList();
        Apple apple = new Apple();

        Utils.appleList.stream().filter((Apple a) -> a.getWeight() >150);

//        (람다식) 사과 목록 출력하는 방법 ( Stream Api 사용 )
          Stream<Apple> b = Utils.appleList.stream().peek((Apple a) ->  System.out.print(" / "+a.getWeight()));
          b.collect(Collectors.toList());

//        (람다식) 새로운 사과 생성 후 그 사과 가져오기.
          Supplier<Apple> appleSuppiler = () -> new Apple();
          appleSuppiler.get();

//        1. Runnable.
//          a. (자바 8 이전) thread 생성하여 run 실행시 오버라이드한 run 메소드 호출.
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.print("Hello world");
                    }
                });
                t.run();

//         b. (람다식) Thread 생성하여 실행 시 Runnable 인터페이스 사용
                Thread t2 = new Thread(() -> System.out.print("Hello world"));
                t2.run();
//         c. (람다식)
                Runnable r1 = () -> System.out.print("Hello world");
                r1.run();
//          c-2. process 메소드 사용하여 runnable 실행하기.
                process(r1);

//       (람다식) 사과 목록 출력하는 방법 2 ( Runnable 사용 )
          Runnable r2 = () -> Utils.appleList.stream().peek((Apple a) ->  System.out.print(" / "+a.getWeight())).collect(Collectors.toList());
          process(r2);

//       익명의 클래스 사용.
            Runnable r3 = new Runnable() {
                @Override
                public void run() {
                    System.out.print("Hello world2");
                }
            };

//      인수가 없으며 void를 반환하는 람다 표현식.
        process(() -> System.out.print("This is awesome!!"));
    }

    public static void process(Runnable runnable){
        runnable.run();
    }

//    public static  String processFile(BufferedReaderProcessor p) throws IOException{
//        try(BufferedReader br = new BufferedReader(new FileReader("data.txt")));
//        return p.process(br);
//    }

}
