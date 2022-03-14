package com.refactoring;

public class Direction {
  public int _x;
  public int _y;

  public Direction(int _x, int _y) {
    this._x = _x;
    this._y = _y;
  }

  public void setDirection(int x, int y){
    _x = x;
    _y = y;
  }
}
