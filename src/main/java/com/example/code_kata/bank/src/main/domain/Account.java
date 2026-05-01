package com.example.code_kata.bank.src.main.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * packageName    : com.example.code_kata.bank.src.main.domain
 * fileName       : Account
 * author         : JAEIK
 * date           : 4/27/26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 4/27/26        JAEIK       최초 생성
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Long id;
    private Long customerId;
    private String accountNumber;
    private BigDecimal balance;

    public Account(Long customerId, String accountNumber, BigDecimal balance) {
        this.customerId = customerId;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void minusAmount(BigDecimal amount) {
        if (this.balance.compareTo(amount) < 0) {
            throw new IllegalArgumentException("잔액 부족");
        }
        this.balance = this.balance.subtract(amount);
    }

    public void plusAmount(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("입금 금액은 0 보다 커야합니다.");
        }
        this.balance = this.balance.add(amount);
    }
}
