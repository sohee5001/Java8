package EX3;

import common.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.*;

public class testddd {

    public static  void main(String[] args){

        //lamdasolution(numbers);
//        int[] numbers = {3, 30, 34, 5, 9};

        int[] numbers = {20,200,20};
        String answer = "";

        //int[] temp2 = new int[numbers.length];

        int temp = 0;

        for(int i=0;i<numbers.length;i++){

            for(int j =i; j<numbers.length;j++) {
                int num2 = numbers[j];
                int num1 = numbers[i];
                int num = 1;
                int num1_size = String.valueOf(num1).length() - num;
                int num2_size = String.valueOf(num2).length() - num;

                int remain1 = getresult(num1,num1_size);
                int remain2 = getresult(num2, num2_size);

                while (remain1 == remain2){
                    num++;
                    num1_size = String.valueOf(num1).length() - num < 0 ? -1 : String.valueOf(num1).length() - num;
                    num2_size = String.valueOf(num2).length() - num < 0 ? -1 : String.valueOf(num2).length() - num;

                    if(num2_size < 0 && num1_size <0) {
                        remain1 = 0;
                        remain2 = 1;
                    }else{
                        remain1 = getresult(num1, num1_size);
                        remain2 = getresult(num2, num2_size);

                    }

                }
                if(remain1 < remain2) {
                        temp = num1;
                        numbers[i] = numbers[j];
                        numbers[j] = temp;
                }
            }
            answer += numbers[i] + "/";
        }

        System.out.print("answer 값 은 ==" +answer);

        //double d = stream(arr).average().orElse(0);

       // double d2 = stream(arr).average().getAsDouble();

    }

    public static int getresult(int num, int num_size){

        int temp2 = 1;

        while (num_size > 0) {
            temp2 *= 10;
            num_size--;
        }

        int result = num/ temp2;

        return result;
    }

    public static String solution(int[] numbers) {
        String answer = "";

        int temp = 0;
        int result1 = 0;
        int result2 = 0;


        for (int i=0; i < numbers.length; i++) {
            String number1 = Integer.toString(numbers[i]);

            for(int j=i+1; j < numbers.length; j++){

                String number2 = Integer.toString(numbers[j]);

                int size = 0;
                String end = null;

                result1 =(int)number1.charAt(size) -48;
                result2 =(int)number2.charAt(size) -48;

                while (result1 == result2){
                    size++;
                    if(number1.length() <= size ){
                        result1 = 0;
                    }else{
                        result1 =(int)number1.charAt(size) -48;
                    }

                    if(number2.length() <= size){
                        result2 = 0;
                        end = "end";
                    }else{
                        result2 =(int)number2.charAt(size) -48;
                    }

                    if("end".equals(end)){
                        if(numbers[i] <= numbers[j]){
                            result1 = 3;
                        }else{
                            result2 = 3;
                        }
                    }
                }
                if(result1 < result2){
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }

        for(int a : numbers){
            answer += String.valueOf(a);
        }
        return answer;
    }

    public static void lamdasolution(int[] numbers) {
        String answer = "";

        int temp = 0;
        int result1 = 0;
        int result2 = 0;

       Stream<Integer> intStream = stream(numbers).boxed();

     //   Stream<Integer> intStream = Arrays.stream(numbers).peek(i -> System.out.print(i + "/")).boxed();

//        intStream.forEach((Integer t) -> {
//            System.out.print(t + "/");
//        });

       //intStream.forEach(t -> System.out.print(t + " / "));

       //.iterator().forEach(t -> System.out.print(t + " / "));

        intStream.forEach(System.out::println);



//        int num = 0;
//        for(int i=0;i<temp2.length;i++){
//            for(int j =i; j<temp2.length;j++) {
//                if (temp2[i] < temp2[j]) {
//                    num = temp2[i];
//                    temp2[i] = temp2[j];
//                    temp2[j] = num;
//
//                    num = numbers[i];
//                    numbers[i] = numbers[j];
//                    numbers[j] = num;
//                }
//            }
//            answer += numbers[i];
//        }

    }
}
