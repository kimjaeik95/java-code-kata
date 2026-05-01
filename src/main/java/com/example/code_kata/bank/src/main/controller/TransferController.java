package com.example.code_kata.bank.src.main.controller;

import com.example.code_kata.bank.src.main.domain.Account;
import com.example.code_kata.bank.src.main.dto.TransferRequest;
import com.example.code_kata.bank.src.main.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName    : com.example.code_kata.bank.src.main.controller
 * fileName       : TransferController
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
@RequestMapping("/api/transfer")
public class TransferController {
    private final TransferService transferService;

    @PostMapping()
    public ResponseEntity<?> transferAccount(@RequestBody TransferRequest transferRequest) {
        Account account = transferService.tranceFer(transferRequest);
        return ResponseEntity.ok().body(account);
    }
}
