package com.refactoring;

import java.util.StringTokenizer;

public class Robot {
  private final String _name;
  private final Position _position = new Position(0, 0);
  private final Direction _direction  = new Direction(0, 1);

  public Robot(String _name) {
    this._name = _name;
  }

  /**
   * 로봇에게 정해진 대로 명령을 입력하면 이동시켜줄 수 있는 것
   *
   * @param commandSequence
   */
  public void execute(String commandSequence){
    try{

      StringTokenizer tokenizer = new StringTokenizer(commandSequence);
      while(tokenizer.hasMoreTokens()){
        String token = tokenizer.nextToken();
        executeCommand(token);
//        if(!executeCommand(token)){
//          // #### ======= 명령어 오류를 잡아내는 익셉션을 생성하게 됨
//          // 메세지만 표시하면 되므로, 체크되는 예외를 맘ㄴ들면 된다.
//          // 체크되는 예외를 ㄹ만들기 위해서ㅡㄴ java.lang.Exccpetion 의 서브 클래스로 하는 것이 보통
//          System.out.println("Invalid command : " + token);
//          break;
//        }
      }
    }catch(InvalidCommandException e){
      //여기서 예외 처리시, 애매하게 진행된 상황에서
      System.out.println(e.getMessage());
    }
  }
  // end execute

  private void executeCommand(String commandString) throws InvalidCommandException{
    Command command = Command.parseCommand(commandString);
    executeCommand(command);
  }

  @Override
  public String toString() {
    return "Robot{" +
      "_name='" + _name + '\'' +
      ", _position=" + _position +
      ", _direction=" + _direction +
      '}';
  }

  public boolean executeCommand(Command command) throws InvalidCommandException{

    if(command == Command.FORWARD){
      _position.relativeMove(_direction._x, _direction._y);
    }else if(command == Command.BACKWARD){
      _position.relativeMove(-_direction._x, -_direction._y);
    }else if(command == Command.TURN_RIGHT){
      _position.relativeMove(_direction._x, -_direction._y);
    }else if(command == Command.TURN_LEFT){
      _position.relativeMove(-_direction._x, _direction._y);
    }else{
      throw new InvalidCommandException("not valid command");
    }
    return false;
  }
}

/**
 * 체크할 수 있는 오류에 대해선 이런 식으로 커스텀 오류를 만들어 낸다. throw 할 경우 trycatch 처리 및 throws 중 하나를 고려해야 한다.
 */
class InvalidCommandException extends Exception{
  public InvalidCommandException(String message) {
    super(message);
  }

  public InvalidCommandException() {
    super();
  }
}

/**
 * 회복 불가능한 오류에서는 RuntimeException의 서브클래스로 만드는 게 일반적이다.
 * 회복 불가능한 오류를 사용하고 싶다면, 예외가 생길 것인가를 사전에 조사하는 사전체크용 메소드를 준비하느 것이 좋다.
 *
 */
class SystemException extends RuntimeException {
  public SystemException() {
  }
}

/**
 * 그런데, 로봇에 관한 예외를 모아서 처리하고 싶을 수도 있다 (이 경우가 일반적이다.
 * 이럴 경우, RobotException과 같은 좀 더 범용적인 클래스를 준비하는 것이 좋다.
 * 그리고 나머지 익셉션들은 이의 하위 클래스에 두는 것이다
 */
