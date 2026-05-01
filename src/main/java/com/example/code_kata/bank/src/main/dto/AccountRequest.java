package com.example.code_kata.bank.src.main.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * packageName    : com.example.code_kata.bank.src.main.dto
 * fileName       : AccountRequest
 * author         : JAEIK
 * date           : 5/1/26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 5/1/26        JAEIK       최초 생성
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequest {
    private Long customerId;
    private String accountNumber;
    private BigDecimal balance;
}
