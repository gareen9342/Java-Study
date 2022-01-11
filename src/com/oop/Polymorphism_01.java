package com.oop;

class Tv{
  String name;
  int price;

  public String toString(){
    System.out.println();
    return null;
  }
}

class CaptionTv extends Tv{
  String color;
  String caption;

  @Override
  public String toString() {
    super.toString();
    return null;
  }
}


class Polymorphism {
  public static void main(String[] args) {
    Tv t = new CaptionTv();

    CaptionTv c = new CaptionTv();

//    System.out.println(t.color); // error
    System.out.println(t.name);
    System.out.println(c.name);

    //
  }
}