package com.oop;

public class Main {
  // 반환 값이 없는 메서드에서 연산결과를 넘길 수 있는 방법
  static int add(int a, int b){
    return  a+b;
  }

  static void add(int a, int b, int[] result){
    result[0] = a+b;
  }

  public static void main(String[] args) {

  }
}
