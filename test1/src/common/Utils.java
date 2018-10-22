package common;

import Class.Apple;
import Class.DeliveryRegion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utils {

    public static List<Apple> appleList   = new ArrayList<Apple>();

    public static List<DeliveryRegion> deliveryRegionList = new ArrayList<DeliveryRegion>();

    public static void addAppleList(){
        String[] colors = new String[]{"blue", "green", "red", "yellow"};
        Random random = new Random();

        //사과 30개 생성
        for(int i=0; i< 30; i++){
            Apple apple = new Apple();

            int randomNumber = random.nextInt(3);
            apple.setColor(colors[randomNumber]);
            apple.setWeight(random.nextInt(100)+100);  // 100~ 200사이

            appleList.add(apple);
        }
    }
    public static  void appleDeliveryRegionList(){
        String[] regions = new String[]{"서울", "경기","강원도","충북","충남", "경북", "경남","전북","전남"};

        for(String region1 : regions){
            DeliveryRegion deliveryRegion = new DeliveryRegion();

            deliveryRegion.setRegionName(region1);
            addAppleList();

            deliveryRegionList.add(deliveryRegion);
        }

    }
}
