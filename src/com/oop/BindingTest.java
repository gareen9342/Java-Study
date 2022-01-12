package com.oop;

class BindingTest {

  public static void main(String[] args) {
    Parenta p = new Childa();
    Childa c = new Childa();

    System.out.println("p.x = "+ p.x); // 100
    System.out.println("c.x = "+ c.x); // 200
  }
}


class Parenta{
  int x = 100;

  void method(){
    System.out.println("parent");
  }
}

class Childa extends Parenta{
  int x = 200;

  void method(){
    System.out.println("child");
  }
}