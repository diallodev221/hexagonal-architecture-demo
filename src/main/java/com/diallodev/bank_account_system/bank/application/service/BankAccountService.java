package com.diallodev.bank_account_system.bank.application.service;

import com.diallodev.bank_account_system.bank.application.port.BankAccountRepository;
import com.diallodev.bank_account_system.bank.domain.BankAccount;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class BankAccountService {

    private final BankAccountRepository repository;

    public BankAccountService(BankAccountRepository repository) {
        this.repository = repository;
    }

    public BankAccount createAccount(BigDecimal initialBalance) {
        String accountId = UUID.randomUUID().toString();
        BankAccount account = new BankAccount(accountId, initialBalance);
        repository.save(account);
        return account;
    }

    public void deposit(String id, BigDecimal amount) {
        BankAccount account = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));
        account.deposit(amount);
        repository.save(account);
    }

    public void withdraw(String id, BigDecimal amount) {
        BankAccount account = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));
        account.withdraw(amount);
        repository.save(account);
    }

    public BankAccount getAccount(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));
    }
}