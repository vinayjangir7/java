package com.thread.example.thread;

public class ThreadDemo {

    public static void main(String[] args) {
        /*Thread thread = new Thread(() -> {
            System.out.println("Welcome");
            throw new RuntimeException("Exception");
        });
        thread.setName("New Thread");

        thread.setUncaughtExceptionHandler((t, e) -> {
            System.out.println(e.getMessage());
        });
        thread.start();*/

        Thread t = new NewThread();
        t.start();
    }

    private static class NewThread extends Thread {
        @Override
        public void run() {
            System.out.println("Welcome Again");
        }
    }
}
