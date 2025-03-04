package com.diallodev.bank_account_system.bank.adapter.persistence;

import com.diallodev.bank_account_system.bank.application.port.BankAccountRepository;
import com.diallodev.bank_account_system.bank.domain.BankAccount;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryBankAccountRepository implements BankAccountRepository {
    private final ConcurrentHashMap<String, BankAccount> database = new ConcurrentHashMap<>();

    @Override
    public Optional<BankAccount> findById(String id) {
        return Optional.ofNullable(database.get(id));
    }

    @Override
    public void save(BankAccount account) {
        database.put(account.getId(), account);
    }
}
