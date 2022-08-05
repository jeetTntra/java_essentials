package DesignPatterns.CreationalPattern.FactoryMethodPattern;

public class Client {

  public static void main(String[] args) {
    Car car = AbstractCarFactory.orderCar("LXI");
    car.deliver();
  }
}
