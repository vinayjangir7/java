package com.sparkrest.services;

import com.sparkrest.exceptions.NotEnoughBalanceException;
import com.sparkrest.models.Money;

public interface BankAccountService {

    Object debit(String accountNumber, Money money) throws NotEnoughBalanceException;

    Object credit(String accountNumber, Money money) throws NotEnoughBalanceException;

    Money getBalance(String accountNumber);
}
