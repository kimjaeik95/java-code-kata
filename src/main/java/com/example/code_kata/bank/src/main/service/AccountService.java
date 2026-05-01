package com.example.code_kata.bank.src.main.service;


import com.example.code_kata.bank.src.main.dao.AccountDao;
import com.example.code_kata.bank.src.main.dao.CustomerDao;
import com.example.code_kata.bank.src.main.domain.Account;
import com.example.code_kata.bank.src.main.domain.Customer;
import com.example.code_kata.bank.src.main.dto.AccountRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName    : com.example.code_kata.bank.src.main.service
 * fileName       : AccountService
 * author         : JAEIK
 * date           : 5/1/26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 5/1/26        JAEIK       최초 생성
 */
@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountDao accountDao;
    private final CustomerDao customerDao;

    public Account createAccount(AccountRequest accountRequest) {
        Customer customer = customerDao.findByCustomer(accountRequest.getCustomerId())
                .orElseThrow(() -> new IllegalArgumentException("고객이 없습니다."));

        Account account = new Account(
                customer.getId(),
                accountRequest.getAccountNumber(),
                accountRequest.getBalance());

        accountDao.createAccount(account);
        return account;
    }

    public List<Account> findAllAccount() {
        return accountDao.findAll();
    }

    public Account findByAccount(Long id) {
        Account account =  accountDao.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(" 계좌가 없습니다."));
        return account;
    }

    public void deleteAccount(Long id) {
        accountDao.deleteById(id);
    }
}
