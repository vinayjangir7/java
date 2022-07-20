package com.sparkrest.models;

import com.sparkrest.enums.AccountStatus;
import com.sparkrest.enums.AccountType;

public class BankAccount {
    private final String accountNumber;
    private User user;
    private Money balance;
    private AccountType accountType;
    private AccountStatus accountStatus;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public User getUser() {
        return user;
    }

    public Money getBalance() {
        return balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    /*public static class BankAccountBuilder {
        private final String accountNumber;
        private User user;
        private Money balance;
        private AccountType accountType;
        private AccountStatus accountStatus;

        public BankAccountBuilder(String accountNumber) {
            this.accountNumber = accountNumber;
        }

        public BankAccountBuilder setUser(User user) {
            this.user = user;
            return this;
        }

        public BankAccountBuilder setMoney(Money balance) {
            this.balance = balance;
            return this;
        }

        public BankAccountBuilder setAccountType(AccountType accountType) {
            this.accountType = accountType;
            return this;
        }

        public BankAccountBuilder setAccountStatus(AccountStatus accountStatus) {
            this.accountStatus = accountStatus;
            return this;
        }

        public BankAccount build() {
            return new BankAccount(this);
        }
    }*/

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", user=" + user +
                ", balance=" + balance +
                ", accountType=" + accountType +
                ", accountStatus=" + accountStatus +
                '}';
    }
}
