# Modifier (제어자)

> 제어자에는 크게 접근 제어자와 그외의 제어자로 나눌 수 있다. 

1. 접근 제어자 :public, protexted, default, private      
2. 그 외 : static, final, abstract, native, transien, synchronized, volatile, strictfp

## static

클래스의, 공통적인 

static 이 붙은 멤버변수와 메서드, 그리고 초기화 블럭은 인스턴스가 아닌 클래스에 관계된 것이기 때문에 인스턴스를 생성하지 않고도 사용할 수 있음. 

인스턴스 메서드와 static 메서드의 근본적인 차이는 메서드 내에서 인스턴스 멤버를 사용하는 가의 여부에 있다. 


-->> 인스턴스 멤버를 사용하지 않는 메서드는 static을 붙여서 static 메서드로 선언하는 것을 고려한다. 

## final : 마지막의, 변경될 수 없는. 

변수에 사용 : 값을 변경할 수 없는 상수

메서드에 사용 :오버라이딩을 할 수 없다. 

클래스에 사용: 자신을 확장하는 자손클래스를 정의할 수없음

## abstract : 추상의, 미완성의

메서드의 선언부만 작성하고 실제 수행내용은 구현하지 않은 추상 메서드를 선언하는 데 이용할 수 있음. 

추상 클래스는 아직 완성되지 않은 메서드가 존재하는 미완성 설계도 이므로 인스턴스를 생성할 수 없다. 

## 생성자의 접근 제어자

생성자에 접근 제어자를 사용함으로써 인스턴스의 생성을 제한할 수 있다.    

₩생성자의 접근 제어자를 private으로 지정하면, 외부에서 생성자에 접근할 수 없으므로 인스턴스를 생성할 수 없게 된다.
클래스 내부에서는 접근 가능 

```java
class Singleton {
  private static Singleton s = new Singleton(); //######### 이렇게 미리 생성해두어야 한다
  private Singleton(){
    //...
  }
  
  public static Singleton getInstance(){
    return s;
  }
}
```

이렇게 생성자를 접근을 막은 후에 static 으로 생성자를 만들어 인스턴스가 미리 생성되게 하고,
staatic으로 인스턴스를 get 하는 메서드를 하나 만드는 식으로 불필요한 인스턴스의 생성을 막을 수 있따. 

예시

## 제어자의 조합

제어자를 정리하기

1. 메서드에 static과 abtract를 함께 사용할 수 없다.    
static 메서드는 몸통이 있는 메서드에만 사용할 수 있기 때문
2. 클래스에 abtract와 final을 동시에 사용할 수 없다.
3. abtract의 접근 제어자가 private일 수 없다.
4. 메서드에 private + final 사용할 필요는 없음 : 접근 제어자가 private 인 메서드는 오버라이딩 될 수 없기 때문 