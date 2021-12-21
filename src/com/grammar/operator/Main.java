package com.grammar.operator;

public class Main {
  public static void main(String[] args) {
    char c1 = 'a';
//    char c2= c1 + 1;// 컴파일에러
    char c2 = 'a' + 1; // 리터럴 간의 연산은, 실행하는 과정동안 변하는 값이 아니기 때문에, 컴파일 시에 컴파일러가 계산해서 그 ㄹ과로 대체
    // 그러니깐 바로 연산의 결과인 b로 대체가 된다는 말인..
    // 수식에 변수가 들어가 있는 경우는 컴파일러가 미리 계산을 할 수가 없다.
  }
}
