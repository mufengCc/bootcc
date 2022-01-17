package com.cc.sys.Day03;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.concurrent.Semaphore;

@Getter
@Setter
@NoArgsConstructor
class FooBar2 {

    private int n;
    public FooBar2(int n) {
        this.n = n;
    }


    Semaphore foo  = new Semaphore(1);
    Semaphore bar  = new Semaphore(0);


    public void foo() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            foo.acquire();
            System.out.println("你");
            System.out.println("可用数：" + bar.availablePermits());
            bar.release();
            System.out.println("释放之后---：" + bar.availablePermits());
        }
    }

    public void bar() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            bar.acquire();
            System.out.println("好");
            foo.release();
        }
    }



    public static void main(String[] args) {
        FooBar2 fooBar2 = new FooBar2(3);


        new Thread(() -> {
            try {
                fooBar2.foo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                fooBar2.bar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }


}