package com.example.code_kata.bank.src.main.dao;

import com.example.code_kata.bank.src.main.config.JdbcConfig;
import com.example.code_kata.bank.src.main.domain.Account;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * packageName    : com.example.code_kata.bank.src.main.dao
 * fileName       : AccountDao
 * author         : JAEIK
 * date           : 4/30/26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 4/30/26        JAEIK       최초 생성
 */
@Repository
public class AccountDao {

    public void createAccount(Account account) {
        String sql = "INSERT INTO account (customer_id, account_number, balance) VALUES (?,?,?)";
        try {
           Connection con = JdbcConfig.getConnection();
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setLong(1, account.getCustomerId());
           ps.setString(2,account.getAccountNumber());
           ps.setBigDecimal(3, account.getBalance());
           ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Account> findAll() {
        String sql = "SELECT * FROM account";
        List<Account> list = new ArrayList<>();

        try {
            Connection con = JdbcConfig.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account account = new Account(
                       rs.getLong("id"),
                       rs.getLong("customer_id"),
                       rs.getString(("account_number")),
                       rs.getBigDecimal("balance")
                );
                list.add(account);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public Optional<Account> findById(Long id) {
        String sql = "SELECT * FROM account WHERE id = ?";
        try {
            Connection con = JdbcConfig.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return Optional.of(new Account(
                        rs.getLong("id"),
                        rs.getLong("customer_id"),
                        rs.getString("account_number"),
                        rs.getBigDecimal("balance")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public Optional<Account> transacFindById(Connection con, Long id) {
        String sql = "SELECT * FROM account WHERE id = ? FOR UPDATE";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return Optional.of(new Account(
                        rs.getLong("id"),
                        rs.getLong("customer_id"),
                        rs.getString("account_number"),
                        rs.getBigDecimal("balance")
                ));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteById(Long id) {
        String sql = "DELETE FROM account WHERE id = ?";
        try {
            Connection con = JdbcConfig.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
