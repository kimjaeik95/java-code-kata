package com.example.code_kata.bank.src.main.controller;

import com.example.code_kata.bank.src.main.domain.Account;
import com.example.code_kata.bank.src.main.dto.AccountRequest;
import com.example.code_kata.bank.src.main.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * packageName    : com.example.code_kata.bank.src.main.controller
 * fileName       : AccountController
 * author         : JAEIK
 * date           : 5/1/26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 5/1/26        JAEIK       최초 생성
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/account")
public class AccountController {
    private final AccountService accountService;

    @PostMapping()
    public ResponseEntity<?> createAccount(@RequestBody AccountRequest request) {
        Account account = accountService.createAccount(request);
        return ResponseEntity.ok().body(account);
    }

    @GetMapping()
    public ResponseEntity<?> findAllAccount() {
        List<Account> accounts = accountService.findAllAccount();
        return ResponseEntity.ok().body(accounts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findByAccount(@PathVariable Long id) {
        Account account = accountService.findByAccount(id);
        return ResponseEntity.ok().body(account);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }
}
