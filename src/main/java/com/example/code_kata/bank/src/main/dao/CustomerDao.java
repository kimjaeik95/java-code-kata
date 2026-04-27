package com.example.code_kata.bank.src.main.dao;

import com.example.code_kata.bank.src.main.config.JdbcConfig;
import com.example.code_kata.bank.src.main.domain.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * packageName    : com.example.code_kata.bank.src.main.dao
 * fileName       : CustomerDao
 * author         : JAEIK
 * date           : 4/27/26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 4/27/26        JAEIK       최초 생성
 */
@Repository
public class CustomerDao {
    /*
       Data Access Object DB 접근하는 객체
       역할 :
       Connection 연결 -> SQL 작성 -> 쿼리실행 -> 결과처리 ResultSet 객체변환
     */


    public void save(Customer customer) {
        String sql = "INSERT INTO customer (name) VALUES (?)";

        try (Connection con = JdbcConfig.getConnection()) {
            PreparedStatement st = con.prepareStatement(sql); // 인젝션 방어, Sql 미리캐싱 , 반복적인 사용할때
            st.setString(1, customer.getName());
            int rs = st.executeUpdate();
            System.out.println("insert row :" + rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Customer> findAll() {
        String sql = "SELECT * FROM customer";
        List<Customer> list = new ArrayList<>();
        try (Connection con = JdbcConfig.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer(
                        rs.getLong("id"),
                        rs.getString("name")
                );

                list.add(customer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public void deleteCustomer(Long id) {
        String sql = "DELETE FROM customer WHERE id = ?";

        try {
            Connection con = JdbcConfig.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            int rs = ps.executeUpdate();
            System.out.println("Delete id " + rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateCustomer(Long id, String name) {
        String sql = "UPDATE customer SET name = ? WHERE id = ?";

        try {
            Connection con = JdbcConfig.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setLong(2, id);

            int rs = ps.executeUpdate();
            System.out.println("update id" + rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}