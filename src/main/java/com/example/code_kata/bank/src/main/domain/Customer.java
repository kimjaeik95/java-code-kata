package com.example.code_kata.bank.src.main.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * packageName    : com.example.code_kata.bank.src.main.domain
 * fileName       : customer
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
public class Customer {
    private Long id;

    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public void update(String name) {
        this.name = name;
    }


}
