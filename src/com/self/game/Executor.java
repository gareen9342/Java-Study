package com.self.game;

public abstract class Executor {
  public abstract void play();
  public void stop(){
    System.exit(0);
  };
}
