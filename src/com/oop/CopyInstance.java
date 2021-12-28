package com.oop;

class Car {
  String color;
  String gearType;
  int door;

  Car(){
    this("white", "auto", 4);
  }

  Car(Car c){ //  복사하는 생성자
    this(c.color,c.gearType,c.door);
  }

  Car(String color, String gearType, int door) {
    this.color = color;
    this.gearType = gearType;
    this.door = door;
  }

  public String toString() {
    return "Car{" +
      "color='" + color + '\'' +
      ", gearType='" + gearType + '\'' +
      ", door=" + door +
      '}';
  }
}


class CarTest{
  public static void main(String[] args) {


    Car c1 = new Car();
    Car c2 = new Car(c1);

    System.out.println(c1.toString());
    System.out.println(c2.toString());

  }
}