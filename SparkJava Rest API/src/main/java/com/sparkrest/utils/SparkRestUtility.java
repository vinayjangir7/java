package com.sparkrest.utils;

import com.sparkrest.exceptions.NotEnoughBalanceException;
import com.sparkrest.enums.AccountStatus;
import com.sparkrest.enums.AccountType;
import com.sparkrest.models.Address;
import com.sparkrest.models.BankAccount;
import com.sparkrest.models.Money;
import com.sparkrest.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

public class SparkRestUtility {

    private static final Map<String, BankAccount> bankAccountMap = new HashMap<>();
    private static final int MULTIPLIER_VALUE = 1000;
    private static final Logger logger = LoggerFactory.getLogger(SparkRestUtility.class);

    private SparkRestUtility() {
        throw new IllegalStateException("Utility class");
    }

    public static void setupBankAccounts() {
        String accountNumber = "12345";
        BankAccount bankAccount = new BankAccount(accountNumber);
        bankAccount.setUser(createUser());
        bankAccount.setBalance(createMoney());
        bankAccount.setAccountType(AccountType.SAVINGS);
        bankAccount.setAccountStatus(AccountStatus.ACTIVE);
        bankAccountMap.put(accountNumber, bankAccount);
    }

    public static BankAccount getBankAccount(String accountNumber) {
        return bankAccountMap.get(accountNumber);
    }

    private static User createUser() {
        LocalDateTime localDateTime = LocalDateTime.now();
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setGender("Male");
        user.setPhoneNumber("1234567890");
        user.setDateOfBirth(localDateTime);
        user.setAddress(createAddress());
        return user;
    }

    private static Address createAddress() {
        Address address = new Address();
        address.setHouseNumber("3030");
        address.setStreet("Raver Croft Drive");
        address.setCity("Elizabethton");
        address.setState("Tennessee");
        address.setCountry("USA");
        address.setZipCode(37643);
        return address;
    }

    private static Money createMoney() {
        Money money = new Money();
        try {
            Random random = SecureRandom.getInstanceStrong();
            money.setCurrency("USD");
            money.setAmount(roundOff(random.nextDouble() * MULTIPLIER_VALUE));
        } catch (NoSuchAlgorithmException e) {
            logger.error("Error occurred", e);
        }
        return money;
    }

    private static double roundOff(double input) {
        return Math.round(input * 100d) / 100d;
    }

    public static Money calculateMoney(Money current, Money fromReq, boolean isDebit) throws NotEnoughBalanceException {
        Money updatedBalance = new Money();
        updatedBalance.setCurrency(current.getCurrency());
        Optional<Money> optional = Optional.ofNullable(current);
        Optional<Money> optional1 = Optional.ofNullable(fromReq);
        if (optional.isPresent() && optional1.isPresent()) {
            if (isDebit) {
                if (current.getAmount() > fromReq.getAmount() && current.getAmount() > 0) {
                    updatedBalance.setAmount(current.getAmount() - fromReq.getAmount());
                } else {
                    throw new NotEnoughBalanceException("Current account balance is not sufficient");
                }
            } else {
                updatedBalance.setAmount(current.getAmount() + fromReq.getAmount());
            }
        }
        return updatedBalance;
    }
}
