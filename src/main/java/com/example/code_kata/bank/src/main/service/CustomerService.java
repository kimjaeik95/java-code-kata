package com.example.code_kata.bank.src.main.service;

import com.example.code_kata.bank.src.main.dao.CustomerDao;
import com.example.code_kata.bank.src.main.domain.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName    : com.example.code_kata.bank.src.main.service
 * fileName       : CustomerService
 * author         : JAEIK
 * date           : 4/27/26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 4/27/26        JAEIK       최초 생성
 */
@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerDao customerDao;

    public Customer createCustomer(String name) {
        Customer customer = new Customer(name);
        customerDao.save(customer);
        return customer;
    }

    public List<Customer> allCustomer() {
         return customerDao.findAll();
    }

    public Customer findByCustomer(Long id) {
        Customer customer = customerDao.findByCustomer(id)
                .orElseThrow(() -> new IllegalArgumentException("고객이 없습니다."));
        return customer;
    }

    public void deleteFindById(Long id) {
        customerDao.deleteCustomer(id);
    }

    public Customer updateCustomer(Long id, String name) {
        customerDao.updateCustomer(id, name);

        Customer customer = new Customer();
        customer.update(name);
        return customer;
    }
}
