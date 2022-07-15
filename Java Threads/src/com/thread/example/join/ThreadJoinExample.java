package com.thread.example.join;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreadJoinExample {
    public static void main(String[] args) {
        List<Long> numbers = new ArrayList<>(Arrays.asList(10000000000L, 3435L, 35435L, 2324L, 4656L, 23L));
        List<FactorialThread> threadList = new ArrayList<>();
        for (Long l : numbers) {
            FactorialThread t = new FactorialThread(l);
            threadList.add(t);
        }

        for (Thread t : threadList) {
            t.setDaemon(true); // Making threads daemon thread makes sure that application execution gets completed even if the threads are still working
            t.start();
        }

        for (Thread t : threadList) {
            try {
                t.join(2000); // After 2 seconds if thread is not done its work then join method will return/terminate
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < numbers.size(); i++) {
            FactorialThread t = threadList.get(i);
            if (t.isFinished()) {
                System.out.println("Factorial of " + numbers.get(i) + " is " + t.getResult());
            } else {
                System.out.println("The calculation for " + numbers.get(i) + " is still in progress");
            }
        }
    }

    private static class FactorialThread extends Thread {

        BigInteger result = BigInteger.ONE;
        long number;
        boolean isFinished;

        FactorialThread(long inputNumber) {
            this.number = inputNumber;
        }

        @Override
        public void run() {
            result = factorial(number);
            isFinished = true;
        }

        private BigInteger factorial(long number) {
            BigInteger tempResult = BigInteger.ONE;
            for (long i = number; i > 0; i--) {
                tempResult = tempResult.multiply(new BigInteger(String.valueOf(number)));
            }
            return tempResult;
        }

        public boolean isFinished() {
            return this.isFinished;
        }

        public BigInteger getResult() {
            return result;
        }
    }
}
