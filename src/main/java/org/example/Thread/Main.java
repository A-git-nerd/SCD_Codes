package org.example.Thread;

class MyThread extends Thread {
    @Override
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println("Thread running: " + i);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start(); // starts new thread

        //  Thread t = new Thread(new MyTask());
        // t.start();
    }
}
