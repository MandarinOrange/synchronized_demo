package com.istars;

public class TicketRobert extends Thread{
    private static int index = 1;
    private static final int MAX = 50;


    @Override
    public void run() {
        synchronized (this) { //同步代码块
            while (index <= MAX) {
                System.out.println(Thread.currentThread().getName() + "叫到的号码是：" + index++);
            }
        }
    }

    public static void main(String[] args) {
        TicketRobert t1 = new TicketRobert();
        TicketRobert t2 = new TicketRobert();
        TicketRobert t3 = new TicketRobert();
        t1.start();
        t2.start();
        t3.start();

    }
}
