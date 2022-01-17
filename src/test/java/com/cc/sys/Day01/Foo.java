package com.cc.sys.Day01;

import java.util.concurrent.CountDownLatch;

class Foo {

    public Foo() {

    }



    CountDownLatch secondDownLatch = new CountDownLatch(1);
    CountDownLatch thirdDownLatch = new CountDownLatch(1);

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        secondDownLatch.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        secondDownLatch.await();
        printSecond.run();
        thirdDownLatch.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        thirdDownLatch.await();
        printThird.run();
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("222");
            break;
        }
    }
}