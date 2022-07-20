package com.sparkrest.services.impl;

import com.sparkrest.exceptions.NotEnoughBalanceException;
import com.sparkrest.models.BankAccount;
import com.sparkrest.models.Money;
import com.sparkrest.services.BankAccountService;
import com.sparkrest.utils.SparkRestUtility;

public class BankAccountServiceImpl implements BankAccountService {
    @Override
    public Object debit(String accountNumber, Money money) throws NotEnoughBalanceException {
        BankAccount account = SparkRestUtility.getBankAccount(accountNumber);
        Money currentBalance = account.getBalance();
        Money updatedBalance = SparkRestUtility.calculateMoney(currentBalance, money, true);
        account.setBalance(updatedBalance);
        return updatedBalance;
    }

    @Override
    public Object credit(String accountNumber, Money money) throws NotEnoughBalanceException {
        BankAccount account = SparkRestUtility.getBankAccount(accountNumber);
        Money currentBalance = account.getBalance();
        Money updatedBalance = SparkRestUtility.calculateMoney(currentBalance, money, false);
        account.setBalance(updatedBalance);
        return updatedBalance;
    }

    @Override
    public Money getBalance(String accountNumber) {
        return SparkRestUtility.getBankAccount(accountNumber).getBalance();
    }
}
