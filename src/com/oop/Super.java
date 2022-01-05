package com.oop;

class Super {
}

class PointTest{
  public static void main(String[] args) {
    Point3D p3 = new Point3D(1,2,3);
  }

}

class Point{
  int x, y;

  Point(int x, int y){
    this.x = x ;
    this.y = y;
  }

  String getLocation(){
    return "x = " + x + "y= "+ y;
  }
}
/**
 * 조상 클래스의 멤버볁수는 조상의 생성자에 의해 초기화되돍 해야함
 *
 */
class Point3D extends Point{
  int z;
  Point3D(int x, int y, int z){
    super(x, y);//반드시 부모의 생성자를 호출해야한다.  어떤 생성자를 가지고 인스턴스를 초기화 하고 말고가 굉장히 중요하다.

    this.x = x;
    this.y = y;
    this.z = z;

  }
}
