package com.cc.sys.Day03;


class FooBar {
    private int n;

    public FooBar(int n) {
        this.n = n;
    }


    private Object object = new Object();
    private boolean flag = false;


    public void foo() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (object) {
                System.out.println("你");
                object.wait();
                object.notifyAll();
            }


        }

    }

    public void bar() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (object) {
                if (!flag) {
                    System.out.println("好");
                    flag = false;
                    object.notifyAll();
                    object.wait();
                }
            }
        }
    }

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(3);
        new Thread(() -> {
            try {
                fooBar.foo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                fooBar.bar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }


}