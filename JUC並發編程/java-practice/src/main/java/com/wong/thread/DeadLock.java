package com.wong.thread;
//死鎖：多個線城互相擁抱著對方需要的資源，然後形成僵持
public class DeadLock {
    public static void main(String[] args) {
        Makeup girl1 = new Makeup(0,"灰姑娘");
        Makeup gril2 = new Makeup(1,"白雪公主");

        girl1.start();
        gril2.start();
        //控制台输出：程序无法正常停止，
        //但是把程序中的两个synchronized块里面的另一个synchronized块拿出即可解决。
    }
}

//口红
class Lipstick{
}

//镜子
class Mirror{
}

class Makeup extends Thread{

    //用static确保只有一份
    static  Lipstick lipstic = new Lipstick();
    static Mirror mirror = new Mirror();

    //选择
    int choice;
    //女孩名字
    String girlName;

    Makeup(int choice,String girlName){
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    //化妝
    public void run() {
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void makeup() throws InterruptedException {
        if(choice == 0){
            synchronized (lipstic){
                System.out.println(this.girlName+"获得口红的锁");
                Thread.sleep(1000);
                //take out of the synchronized block to ->
                synchronized (mirror){
                    System.out.println(this.girlName+"获得镜子的锁");
                }
            }
            //here
            
        }else {
            synchronized (mirror){
                System.out.println(this.girlName+"获得镜子的锁");
                Thread.sleep(2000);
                //take out of the synchronized block to ->
                synchronized (lipstic){
                    System.out.println(this.girlName+"获得口红的锁");
                }
            }
            //here, then the 
        }
    }
}

