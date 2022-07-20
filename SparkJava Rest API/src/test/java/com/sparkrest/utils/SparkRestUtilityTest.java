package com.sparkrest.utils;

import com.sparkrest.exceptions.NotEnoughBalanceException;
import com.sparkrest.models.BankAccount;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SparkRestUtilityTest {

    @Test
    void setupBankAccounts() {
        String expected = "12345";
        SparkRestUtility.setupBankAccounts();
        String actual = SparkRestUtility.getBankAccount(expected).getAccountNumber();
        assertEquals(expected, actual);
    }

    @Test
    void getBankAccount() {

    }

    @Test
    void calculateMoney() {

    }
}