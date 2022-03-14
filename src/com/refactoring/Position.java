package com.refactoring;


public class Position {

  public int _x;
  public int _y;

  /**
   * position 객체를 생성할 때에는 x, y 좌표를 함께 넣어주어야 한다.
   * @param _x
   * @param _y
   */
  public Position(int _x, int _y) {
    this._x = _x;
    this._y = _y;
  }

  /**
   * 로봇을 원하는 만큼 이동시켜줄 수 있는 메서드
   * @param dx
   * @param dy
   */
  public void relativeMove(int dx, int dy) {
    _x += dx;
    _y += dy;
  }
}
