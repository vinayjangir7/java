package com.sparkrest;

import com.sparkrest.controllers.BankAccountController;
import com.sparkrest.utils.JsonResponseTransformer;
import com.sparkrest.utils.SparkRestUtility;
import org.slf4j.LoggerFactory;

import static spark.Spark.*;

public class BankApplication {
    public static void main(String[] args) {
        var bankAccountController = new BankAccountController();
        var log = LoggerFactory.getLogger(BankAccountController.class);
        var jsonTransformer = new JsonResponseTransformer();

        SparkRestUtility.setupBankAccounts();

        port(8000);
        path("/api", () -> {
            before("/*", (q, a) -> log.info("Received api call"));
            path("/account", () -> {
                post("/debit", bankAccountController::debit, jsonTransformer);
                post("/credit", bankAccountController::credit, jsonTransformer);
                get("/balance/:accountNumber", bankAccountController::getBalance, jsonTransformer);
            });
        });
    }
}
