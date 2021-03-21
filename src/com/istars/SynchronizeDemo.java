package com.istars;

import java.util.concurrent.TimeUnit;

public class SynchronizeDemo extends Thread{
    //同步静态方法
    public synchronized static void accessResource1(){
        try{
            TimeUnit.SECONDS.sleep(2);
            System.out.println(Thread.currentThread().getName()+" is Running");
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        for (int i = 0; i < 5; i++) {
//            new Thread(SynchronizeDemo::accessResource1).start();
//        }
//    }

    //同步非静态方法
    public synchronized  void accessResource2(){
        try{
            TimeUnit.SECONDS.sleep(2);
            System.out.println(Thread.currentThread().getName()+" is Running");
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        SynchronizeDemo demo2 = new SynchronizeDemo();
//        for (int i = 0; i < 5; i++) {
//            new Thread(demo2::accessResource2).start();
//        }
//    }

    //同步代码块
    public void accessResource3(){
        //（对象）this指的是当前对象,哪个对象调用这个方法就是指哪个对象
        synchronized (this) {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + " is Running");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

//    public static void main(String[] args) {
//        SynchronizeDemo demo3 = new SynchronizeDemo();
//        for (int i = 0; i < 5; i++) {
//            new Thread(demo3::accessResource3).start();
//        }
//    }


    //同步代码块（CLASS类）
    public  void accessResources4(){
        synchronized(SynchronizeDemo.class){//ClassLoader加载的class 放在堆区   Class 指所有的对象
            //由Class类的所有的对象都共同使用这一个锁
            try {
                TimeUnit.MINUTES.sleep(2);
                System.out.println(Thread.currentThread().getName()+" is Running");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        final SynchronizeDemo demo4 = new SynchronizeDemo();
        for (int i = 0; i < 5; i++) {
            new Thread(demo4::accessResources4).start();
        }
    }

}
