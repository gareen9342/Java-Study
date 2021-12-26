package com.oop;

 class Concatenate {
   public static void main(String[] args) {
     System.out.println(concatenate(",","a"));
     System.out.println(concatenate(",","a","b"));
     System.out.println(concatenate(",", new String[]{"a","b", "c"})); // 내부적으로는 배열을 이용하고 있는 것
   }

   static String concatenate(String delim, String... args) {
     String result = "";
     // 이런 식으로 가지고 와서 쓸 수 있음
     for(String str : args){
       result += str + delim;
     }
     return result;
   }
   // 이렇게 만들어진 메서드를 오버로딩 할 경우, 메서드를 호출했을 때 구별되지 않아 에러가 발생할 수 있다.


}
