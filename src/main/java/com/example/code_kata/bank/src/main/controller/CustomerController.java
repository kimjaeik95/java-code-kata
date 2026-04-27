package com.example.code_kata.bank.src.main.controller;

import com.example.code_kata.bank.src.main.domain.Customer;
import com.example.code_kata.bank.src.main.dto.UpdateCustomerRequest;
import com.example.code_kata.bank.src.main.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * packageName    : com.example.code_kata.bank.src.main.controller
 * fileName       : BankController
 * author         : JAEIK
 * date           : 4/27/26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 4/27/26        JAEIK       최초 생성
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping()
    public ResponseEntity<?> createCustomer(@RequestParam String name) {
        Customer customer = customerService.createCustomer(name);
        return ResponseEntity.ok().body(customer);
    }

    @GetMapping()
    public ResponseEntity<?> allCustomer() {
        List<Customer> customer = customerService.allCustomer();
        return ResponseEntity.ok().body(customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteByIdCustomer(@PathVariable("id") Long id) {
        customerService.deleteFindById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable("id") Long id, @RequestBody UpdateCustomerRequest request) {
        Customer customer = customerService.updateCustomer(id, request.getName());
        return ResponseEntity.ok().body(customer);
    }
}
