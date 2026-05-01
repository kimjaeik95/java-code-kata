package com.example.code_kata.bank.src.main.dao;


import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;

/**
 * packageName    : com.example.code_kata.bank.src.main.dao
 * fileName       : TransferDao
 * author         : JAEIK
 * date           : 5/1/26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 5/1/26        JAEIK       최초 생성
 */
@Repository
public class TransferDao {

    public int updateBalance(Connection con, Long accountId, BigDecimal amount) {
        String sql = "UPDATE account SET balance = ? WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBigDecimal(1, amount);
            ps.setLong(2, accountId);
            return ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
