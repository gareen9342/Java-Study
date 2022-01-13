# abstract class

미완성 설계도, 


-> 멤버의 개수에 관계된 것이 아니라, 미완성 메서드를 포함하고 있다는 뜻이ㅏ다. 


## 추상 메서드

: 선언부만을 작성하는 것.
실제 내용은 상속받는 클래스에서 구현하도록 비워 두는 것 

```java
abstract class Player{
  abstract void play(int pos);
  abstract void stop();
}

class AudioPlayer extends Player{
  void play(int pos){
    // do something
  }
  
  void stop(){
    // do something
  }
}

abstract class AbstractPlayer extends Player{
  void play(int pos){
    // do something
  };
}
```


궁극적으로 메서드의 이름과 매개변수, 작업의 결과로 어떤 타입의 값을 반환할 것인가를 결정해주는 역할을 한다. 

여러 클래스에 공통적으로 사용될 수 있는 클래스를 바로 작성하기도 하고, 기존의 클래스의 공통적인 부분을 뽑아서 추상클래스로 만들어 상속하도록 하는 경우도 있다. 

