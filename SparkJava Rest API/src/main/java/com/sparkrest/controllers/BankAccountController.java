package com.sparkrest.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sparkrest.constants.AppConstants;
import com.sparkrest.exceptions.NotEnoughBalanceException;
import com.sparkrest.models.ErrorResponse;
import com.sparkrest.models.Money;
import com.sparkrest.services.impl.BankAccountServiceImpl;
import org.eclipse.jetty.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;

import java.time.LocalDateTime;

public class BankAccountController {
    private static final BankAccountServiceImpl bankAccountServiceImpl = new BankAccountServiceImpl();

    Logger log = LoggerFactory.getLogger(BankAccountController.class);

    public Object debit(final Request request, final Response response) {
        try {
            Gson gson = new GsonBuilder().create();
            Money money = gson.fromJson(request.body(), Money.class);
            bankAccountServiceImpl.debit(request.params(AppConstants.ACCOUNT_NUMBER), money);
        } catch (NotEnoughBalanceException e) {
            e.printStackTrace();
        response.status(HttpStatus.OK_200);
        }
        return response;
    }

    public Object credit(final Request request, final Response response) {
        Money money = new Money();
        money.setAmount(0);
        money.setCurrency("INR");
        response.status(HttpStatus.OK_200);
        try {
            bankAccountServiceImpl.credit(request.params(AppConstants.ACCOUNT_NUMBER), money);
            response.body();
        } catch (NotEnoughBalanceException e) {
            log.error("Not enough balance for transaction", e);
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setTimeStamp(LocalDateTime.now());
            errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR_500);
            errorResponse.setTitle(e.getClass().getSimpleName());
            errorResponse.setDetail(AppConstants.NOT_ENOUGH_BALANCE_DESCRIPTION);
            return errorResponse;
        }
        return response;
    }

    public Object getBalance(final Request request, final Response response) {
        Money balance = bankAccountServiceImpl.getBalance(request.params(":accountNumber"));
        response.status(HttpStatus.OK_200);
        Gson gson = new Gson();
        response.header("content-type", "application/json");
        return gson.toJson(balance);
    }
}
