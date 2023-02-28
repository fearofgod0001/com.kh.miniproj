package com.kh.miniproj.dao;


import com.kh.miniproj.util.Common;
import com.kh.miniproj.vo.CustomersVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
    public class CustomersDAO {

        Connection conn = null;
        Statement stmt = null;
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);

        public List<CustomersVO> CustomerSelect() {
            List<CustomersVO> list = new ArrayList<>();
            try {
                conn = Common.getConnection();
                stmt = conn.createStatement();
                String sqlc = "SELECT * FROM CUSTOMERS";
                rs = stmt.executeQuery(sqlc);

                while (rs.next()) {
                    String CUSTOMER_ID = rs.getString("CUSTOMER_ID");
                    String CUSTOMER_NAME = rs.getString("CUSTOMER_NAME");
                    String PASSWORD = rs.getString("PASSWORD");
                    String GENDER = rs.getNString("GENDER");
                    String PHONE_NUMBER = rs.getString("PHONE_NUMBER");
                    String EMAIL = rs.getString("EMAIL");
                    String ADDRESS = rs.getString("ADDRESS");
                    Date REGISTRATION_DATE = rs.getDate("REGISTRATION_DATE");

                    CustomersVO cVo = new CustomersVO(CUSTOMER_ID,CUSTOMER_NAME,PASSWORD,GENDER,PHONE_NUMBER,
                            EMAIL,ADDRESS,REGISTRATION_DATE);
                    list.add(cVo);
                }
                Common.close(rs);
                Common.close(stmt);
                Common.close(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return list;
        }

        public void CustomerSelectPrint(List<CustomersVO> list) {
            for (CustomersVO c : list) {
                System.out.println("아이디 : " + c.getCustomer_id());
                System.out.println("이름 : " + c.getCustomer_name());
                System.out.println("비밀번호 : " + c.getPassword());
                System.out.println("성별 : " + c.getGender());
                System.out.println("전화번호 : " + c.getPhone_number());
                System.out.println("이메일 : " + c.getEmail());
                System.out.println("주소 : " + c.getAddress());
                System.out.println("가입일자 : " + c.getRegistration_date());
                System.out.println("----------------------------------------");
            }
        }
        public void CustomerInsert() {
            System.out.println("아이디 : ");
            String customer_id = sc.next();
            System.out.println("이름 : ");
            String customer_name = sc.next();
            System.out.println("비밀번호 : ");
            String password = sc.next();
            System.out.println("성별 : ");
            String gender = sc.next();
            System.out.println("전화번호 : ");
            String phone_number = sc.next();
            System.out.println("이메일 : ");
            String email = sc.next();
            System.out.println("주소 : ");
            String address = sc.next();
//        System.out.println("가입일자 : ");
//        String registration_date = sc.next();

            String sql = "INSERT INTO CUSTOMERS(CUSTOMER_ID, CUSTOMER_NAME, PASSWORD ,GENDER, PHONE_NUMBER, EMAIL, ADDRESS, REGISTRATION_DATE) VALUES(?,?,?,?,?,?,?,SYSDATE)";

            try {
                conn = Common.getConnection();
                pStmt = conn.prepareStatement(sql);
                pStmt.setString(1, customer_id);
                pStmt.setString(2, customer_name);
                pStmt.setString(3, password);
                pStmt.setString(4, gender);
                pStmt.setString(5, phone_number);
                pStmt.setString(6, email);
                pStmt.setString(7, address);

                int ret = pStmt.executeUpdate();
                System.out.println("Return : " + ret);
            }catch (Exception e) {
                e.printStackTrace();
            }
            Common.close(conn);
            Common.close(stmt);
        }
        public void customerUpdate() {
            System.out.print("변경할 회원의 아이디를 입력하세요 : ");
            String customer_id = sc.next();
            System.out.print("이름 : ");
            String customer_name = sc.next();
            System.out.print("비밀번호 : ");
            String password = sc.next();
            System.out.print("성별 : ");
            String gender = sc.next();
            System.out.print("전화번호 : ");
            String phone_number = sc.next();
            System.out.print("이메일 : ");
            String email = sc.next();
            System.out.print("주소 : ");
            String address = sc.next();

            String sql = "UPDATE CUSTOMERS SET CUSTOMER_NAME = ?, PASSWORD = ?, GENDER = ?, PHONE_NUMBER = ?, EMAIL = ?, ADDRESS = ?, REGISTRATION_DATE = ? WHERE CUSTOMER_ID =?" ;

            try {
                conn = Common.getConnection();
                pStmt = conn.prepareStatement(sql);
                pStmt.setString(1, customer_id);
                pStmt.setString(2, customer_name);
                pStmt.setString(3, password);
                pStmt.setString(4, gender);
                pStmt.setString(5,phone_number);
                pStmt.setString(6, email);
                pStmt.setString(7, address);
            }catch (Exception e) {
                e.printStackTrace();
            }
            Common.close(pStmt);
            Common.close(conn);
        }
        public void customerDelete() {
            System.out.print("삭제할 아이디를 입력 하세요 : ");
            String customer_id = sc.next();
            String sql = "DELETE FROM CUSTOMERS WHERE CUSTOMER_ID = ?";

            try {
                conn = Common.getConnection();
                pStmt = conn.prepareStatement(sql);
                pStmt.setString(1, customer_id);
                pStmt.executeUpdate();
            }catch (Exception e) {
                e.printStackTrace();
            }
            Common.close(pStmt);
            Common.close(conn);
        }
    }