package DesignPatterns.CreationalPattern.FactoryMethodPattern;

public class AbstractCarFactory {
  protected static Car createCar(String variant) {
    switch (variant) {
      case "LXI":
        return new LXi();
      case "VXI":
        return new VXi();
      case "ZXI":
        return new ZXi();
    }
    return null;
  }

  public static Car orderCar(String variant) {
    return createCar(variant);
  }
}

