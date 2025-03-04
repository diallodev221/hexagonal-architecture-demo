package com.diallodev.bank_account_system.bank.application.port;

import com.diallodev.bank_account_system.bank.domain.BankAccount;

import java.util.Optional;

public interface BankAccountRepository {
    Optional<BankAccount> findById(String id);
    void save(BankAccount account);
}
