package com.thread.example.join;

import java.math.BigInteger;

public class JoinAssignment {

    public static void main(String[] args) {
        System.out.println(calculateResult(new BigInteger("2"), new BigInteger("2"), new BigInteger("2"), new BigInteger("2")));
    }

    public static BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) {
        BigInteger result = BigInteger.ONE;
        /*
            Calculate result = ( base1 ^ power1 ) + (base2 ^ power2).
            Where each calculation in (..) is calculated on a different thread
        */
        PowerCalculatingThread thread = new PowerCalculatingThread(base1, power1);
        PowerCalculatingThread thread1 = new PowerCalculatingThread(base2, power2);
        thread.start();
        thread1.start();

        try {
            thread.join();
            thread1.join();
            result = thread.getResult().add(thread1.getResult());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static class PowerCalculatingThread extends Thread {
        private BigInteger result = BigInteger.ONE;
        private BigInteger base;
        private BigInteger power;

        public PowerCalculatingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
           /*
           Implement the calculation of result = base ^ power
           */
            for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
                result = result.multiply(base);
            }

            /*for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
                result = result.multiply(base);
            }*/
        }

        public BigInteger getResult() {
            return result;
        }
    }
}
