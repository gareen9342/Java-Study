package com.grammar.variables;

public class FloatToBinEx {
  public static void main(String[] args) {
    float f = 9.1234567f; // 16진수로 출력시,
    int i = Float.floatToRawIntBits(f);

    System.out.printf("%f%n",f);//9.123457 잘려나간 2진수가 첫 번째 자리의 값이 1이라서 반올림되어 01 -> 10으로 변경됨
    System.out.printf("%X%n",i);//4111F9AE
  }
}
