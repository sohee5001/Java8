package Class;

public class Apple {

    String color;
    int weight;

    public Apple(){ }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isGreenApple(Apple apple1, Apple apple2) {
        return apple1.getWeight() > apple2.getWeight();
    }
}
