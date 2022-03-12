package com.self.game.jiroe;

import com.self.game.Executor;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 지뢰 게임을 실행시에 50 * 50,의 지뢰판을 할당한다.
 * 몇 개의 지뢰를 심을 건지 결정한다.
 * 지뢰를 다 심고 나서는 물어봄 -> 클릭할 숫자판의 인덱스 번호를 입력하세요
 * 입력은 . 을 기준으로 x.y 축으로 받게 된다.
 * 클릭했을때 주변 칸을 검사해서 갯수를 보여준다.
 *
 * 예시
 * X X X
 * X X 1
 * X X X
 *
 * 없을 경우엔 주변칸을 재귀적으로 열어줌
 */
public class JiroeGame extends Executor {
  // TODO : executor를 interface로 만들기
  // TODO : 메소드를 기능 단위로 쪼개기
  private static final int BOX_COUNT = 10;
  private static final int MIN_JIROE = 1;
  private static final int MAX_JIROE = 9;
  private static final String UNCHECKED = "□";
  private static final String CHECKED = "X";
  // ====  end 상수


  private static boolean[][] jiroes;
  private static String[][] checksArr;

  private static int jiroeCount;
  // 게임을 실행하는 역할
  public void play(){
    jiroes = new boolean[BOX_COUNT + 2][BOX_COUNT + 2];
    checksArr = new String[BOX_COUNT + 2][BOX_COUNT + 2];

    initDeepArr(checksArr, UNCHECKED);

    Scanner sc = new Scanner(System.in);

    System.out.println("심을 지뢰의 개수를 입력하세요");
    jiroeCount = sc.nextInt();

    if(jiroeCount > MAX_JIROE || jiroeCount < MIN_JIROE){
      throw new NotValidJiroeCountException();
    }

    System.out.println("입력한 지뢰의 개수 = "+ jiroeCount);

    while( jiroeCount-- > 0){
      setJiroes();
    }

    for(;;){
      // 지뢰를 밟으면 꺼짐, 더이상 깔 지뢰가 없을 때 꺼짐
      System.out.println("좌표를 입력해주세요");
      String[] answer = sc.nextLine().split(".");

      if(answer.length>2){
        System.out.println("X.Y 형태의 좌표를 입력하세요 범위는 1부터 10까지");
        continue;
      }

      // 지뢰 밟았는지 검사.
      int xco = Integer.parseInt(answer[0]);
      int yco = Integer.parseInt(answer[1]);

      boolean isJiroe = jiroes[xco][yco];

      if(isJiroe){
        System.out.println("지뢰를 밟으셨습니다. 게임을 종료합니다.");
        break;
      }

      checksArr[xco][yco] = CHECKED;
      printDeepArr(checksArr);
    }
  }
  // end play

  public void stop() {
    super.stop();
  }
  // end stop

  private void initDeepArr(String[][] deepArr, String initVal) {
    for(String[] itemArr : deepArr){
      Arrays.fill(itemArr, initVal);
    }
  }

  /**
   * 지뢰를 지뢰판에 심는다.
   */
  public void setJiroes(){

    int xNum = (int)(Math.random() * BOX_COUNT) + 1;
    int yNum = (int)(Math.random() * BOX_COUNT) + 1;

    boolean isJiroeExisted = jiroes[xNum][yNum];

    System.out.println("isJiroeExisted = " + isJiroeExisted);

    if(isJiroeExisted){
      setJiroes();
    }else{
      jiroes[xNum][yNum] = true;
    }

  }

  /**
   * 2차원 배열의 출력, boolean
   * @param deepArr
   */
  public void printDeepArr(boolean[][] deepArr){
    for(int i=0; i<deepArr.length; i++){
      int inrLen = deepArr[i].length;
      String rowStr = "";
      for (int j=0; j<inrLen; j++){ // true false 말이 너무 길어서 보기 힘들어서 이렇게 함
        rowStr += deepArr[i][j] ? 1 : 0;
        rowStr += " ";
      }
      System.out.println(rowStr);
    }
  }

  public void printDeepArr(String[][] deepArr){
    for(int i=0; i<deepArr.length; i++){
      int inrLen = deepArr[i].length;
      String rowStr = "";
      for (int j=0; j<inrLen; j++){ // true false 말이 너무 길어서 보기 힘들어서 이렇게 함
        rowStr += deepArr[i][j];
        rowStr += " ";
      }
      System.out.println(rowStr);
    }
  }
}

class NotValidJiroeCountException extends IllegalArgumentException {
  private static final String message = "범위를 벗어났습니다.";

  NotValidJiroeCountException(){
    super(message);
  }

  NotValidJiroeCountException( String message ){
    System.out.println("custom message : " + message);
  }
}
