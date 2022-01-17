package com.cc.sys.Day01;

class Foo2 {

    public Foo2() {
        
    }
   
    int a = 1;

    public synchronized void first() throws InterruptedException {
        if (a == 1) {
            System.out.println(1);
           a = 2;
           notifyAll();
        } else {
            wait();
        }
        
    }

    public synchronized void second() throws InterruptedException {
        if (a == 2) {
            System.out.println(2);
           a = 3;
           notifyAll();
        } else {
            wait();
        }
        
    }

    public synchronized void third() throws InterruptedException {
        if (a == 3) {
            System.out.println(3);
            notifyAll();
        } else {
            wait();
        }
    }

    public static void main(String[] args)  {

        Foo2 foo2 = new Foo2();

        new Thread(() ->{
            try {
                foo2.first();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() ->{
            try {
                foo2.second();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() ->{
            try {
                foo2.third();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}