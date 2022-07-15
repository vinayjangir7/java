package com.thread.example.interrupt;

import java.math.BigInteger;

public class InterruptAndDaemonThreadExample {
    public static void main(String[] args) {
        Thread blockingThread = new BlockingThread();
        blockingThread.start();
        //blockingThread.interrupt();

        Thread longComputationThread = new LongComputationThread(new BigInteger("2"), new BigInteger("10000000"));
        //longComputationThread.setDaemon(true);
        longComputationThread.start();
        longComputationThread.interrupt();
    }

    private static class BlockingThread extends Thread {
        @Override
        public void run() {
            try {
                sleep(5000000);
            } catch (InterruptedException e) {
                System.out.println("Thread got interrupted");
            }
        }
    }

    private static class LongComputationThread extends Thread {
        BigInteger base;
        BigInteger power;

        LongComputationThread(BigInteger base, BigInteger power){
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            BigInteger result = BigInteger.ONE;
            for (BigInteger i = BigInteger.ONE; i.compareTo(power) != 1; i = i.add(BigInteger.ONE)){
                if(Thread.interrupted()){
                    System.out.println("Thread got interrupted 1");
                }
                result = result.multiply(base);
            }
            System.out.println(result);
        }
    }
}
