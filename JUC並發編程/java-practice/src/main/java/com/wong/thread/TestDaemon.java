package com.wong.thread;

//测试守护线程:上帝保佑
public class TestDaemon {
  public static void main(String[] args) {
      God god = new God();
      You you = new You();
      Thread thread = new Thread(god);
      //默认是false表示用户线程,而正常的线程都是用户线程
      thread.setDaemon(true);

      thread.start();

      new Thread(you).start();
  }
}

class God implements Runnable{
  @Override
  public void run() {
      while (true){
          System.out.println("God bless you");
      }
  }
}

class You implements Runnable{
  @Override
  public void run() {
      for (int i = 0; i < 36500; i++) {
          System.out.println("live...");
      }
      System.out.println("go die...");
  }
}