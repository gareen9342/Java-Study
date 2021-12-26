package com.oop;

class CardTest {
  public static void main(String[] args) {
    System.out.println(Card.width);
    System.out.println(Card.width);

    Card c1 = new Card();
    c1.kind = "Heart";
    c1.number = 7;

    Card c2 = new Card();
    c2.kind = "Spade";
    c2.number = 4;

    System.out.println("c2.kind + c2.number = " + c2.kind + c2.number + "width heght = "+  c2.width  + " height = " + c2.height);
    System.out.println("c1 = " + c1.kind+ c1.number + "width heght = "+  c1.width  + " height = " + c1.height);

    System.out.println("width와 height값을 변경한다. ");
    c1.width = 300;
    c1.height = 600;

    System.out.println("c2.kind + c2.number = " + c2.kind + c2.number + "width heght = "+  c2.width  + " height = " + c2.height);
    System.out.println("c1 = " + c1.kind+ c1.number + "width heght = "+  c1.width  + " height = " + c1.height);

  }
}

class Card{
  String kind;
  int number;
  static int width = 100;// class var
  static int height = 250;
}
