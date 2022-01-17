package com.cc.sys.Day01;

import java.util.concurrent.Semaphore;

class Foo3 {

    public Foo3() {
        
    }

    Semaphore semaphore_se = new Semaphore(0);
    Semaphore semaphore_third = new Semaphore(0);

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        semaphore_se.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        semaphore_se.acquire(1);
        printSecond.run();
        semaphore_third.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        semaphore_third.acquire(1);
        printThird.run();
    }

}