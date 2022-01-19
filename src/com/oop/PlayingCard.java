package com.oop;

public interface PlayingCard {
  public static final int SPACE = 4;
  final int DIAMOND = 3;
  static int HEART = 2;
  int CLOVER = 1;

  public abstract String getCardNumber();
  String getCardKind();
}


class Unit{

}

interface Movable{
  void move(int x, int y);
}

interface Attackable{
  void attack(Unit u);
}

interface Fitable extends Movable, Attackable{ // 이렇게 인터페이스는 다중 상속이 가능하다.

}