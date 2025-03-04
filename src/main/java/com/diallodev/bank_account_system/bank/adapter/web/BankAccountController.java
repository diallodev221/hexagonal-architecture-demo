package com.diallodev.bank_account_system.bank.adapter.web;

import com.diallodev.bank_account_system.bank.application.service.BankAccountService;
import com.diallodev.bank_account_system.bank.domain.BankAccount;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;

@RestController
@RequestMapping("api/accounts")
public class BankAccountController {
    private final BankAccountService service;

    public BankAccountController(BankAccountService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<BankAccount> createAccount(@RequestParam("balance") BigDecimal initialBalance, UriComponentsBuilder uri) {
        BankAccount account = service.createAccount(initialBalance);
        var resourceLocation = uri.path("/api/accounts/{id}")
                .buildAndExpand(account.getId())
                .toUri();
        return ResponseEntity.created(resourceLocation).body(account);
    }

    @PostMapping("/{id}/deposit")
    public ResponseEntity<String> deposit(@PathVariable String id, @RequestParam BigDecimal amount) {
        service.deposit(id, amount);
        return ResponseEntity.ok("Deposit successful");
    }

    @PostMapping("/{id}/withdraw")
    public ResponseEntity<String> withdraw(@PathVariable String id, @RequestParam BigDecimal amount) {
        service.withdraw(id, amount);
        return ResponseEntity.ok("Withdrawal successful");
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankAccount> getAccount(@PathVariable String id) {
        return ResponseEntity.ok(service.getAccount(id));
    }
}
