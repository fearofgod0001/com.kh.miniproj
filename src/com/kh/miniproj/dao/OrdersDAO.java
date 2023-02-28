package com.kh.miniproj.dao;


import com.kh.miniproj.util.Common;
import com.kh.miniproj.vo.OrdersVO;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    public class OrdersDAO {
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);

        public List<OrdersVO> ordersSelect(){
            List<OrdersVO> list = new ArrayList<>();
            try{
                conn = Common.getConnection();
                stmt = conn.createStatement();
                String spl = "SELECT * FROM ORDERS";
                rs = stmt.executeQuery(spl);

                while(rs.next()){
                    String order_id = rs.getNString("ORDER_ID");
                    String customer_id = rs.getNString("CUSTOMER_ID");
                    BigDecimal total_cost = rs.getBigDecimal("TOTAL_COST");
                    Date date = rs.getDate("ORDER_DATE");
                    String payment_method = rs.getNString("PAYMENT_METHOD");
                    String shipping_address = rs.getNString("SHIPPING_ADDRESS");
                    OrdersVO oVo = new OrdersVO(order_id, customer_id, total_cost, date, payment_method, shipping_address);
                    list.add(oVo);
                }
                Common.close(rs);       // 연결과 역순으로 해제
                Common.close((stmt));
                Common.close(conn);

            } catch(Exception e){
                e.printStackTrace();
            }
            return list;
        }
        public void ordersSelectPrint(List<OrdersVO> list){
            for(OrdersVO o : list){
                System.out.println("주문ID : " + o.getOrder_id());
                System.out.println("고객ID : " + o.getCustomer_id());
                System.out.println("총합가격 : " + o.getTotal_cost());
                System.out.println("주문일자 : " + o.getOrder_date());
                System.out.println("결제방법 : " + o.getPayment_method());
                System.out.println("배송지 : " + o.getShipping_address());
                System.out.println("--------------------------------");
            }
        }
        public void ordersInsert(){
            System.out.print(" 주문정보를 입력하세요. ");
            System.out.print(" 주문ID : ");
            String ORDER_ID = sc.next();
            System.out.println("고객ID : ");
            String CUSTOMER_ID = sc.next();
            System.out.println("총합가격 : ");
            BigDecimal TOTAL_COST = sc.nextBigDecimal();
//        System.out.println("주문일자 : ");
//        String order_date = sc.next();
            System.out.println("결제방법 : ");
            String PAYMENT_METHOD = sc.next();
            System.out.println("배송지 : ");
            String SHIPPING_ADDRESS = sc.next();

            String sql = "INSERT INTO ORDERS(ORDER_ID, CUSTOMER_ID, TOTAL_COST, ORDER_DATE, PAYMENT_METHOD, SHIPPING_ADDRESS) VALUES (?,?,?,SYSDATE,?,?)";

            try{
                conn = Common.getConnection();
                pStmt = conn.prepareStatement(sql);
                pStmt.setString(1, ORDER_ID);
                pStmt.setString(2, CUSTOMER_ID);
                pStmt.setBigDecimal(3, TOTAL_COST);
                pStmt.setString(4,PAYMENT_METHOD);
                pStmt.setString(5, SHIPPING_ADDRESS);
                int ret = pStmt.executeUpdate();
                System.out.println("Return : " + ret);
            } catch(Exception e){
                e.printStackTrace();
            }
            Common.close(stmt);
            Common.close(conn);

        }

        public void ordersUpdate(){
            System.out.println("변경할 고객ID를 입력 하세요 : ");
            String ORDER_ID = sc.next();
            System.out.print("결제 방법 : ");
            String PAYMENT_METHOD = sc.next();
            System.out.print("배송지 : ");
            String SHIPPING_ADDRESS = sc.next();

            String sql = "UPDATE ORDERS SET PAYMENT_METHOD = ?, SHIPPING_ADDRESS = ? WHERE ORDER_ID = ?";

            try {
                conn = Common.getConnection();
                pStmt = conn.prepareStatement(sql);
                pStmt.setString(1,PAYMENT_METHOD);
                pStmt.setString(2,SHIPPING_ADDRESS);
                pStmt.setString(3,ORDER_ID);
                pStmt.executeUpdate();

            }catch (Exception e){
                e.printStackTrace();
            }
            Common.close(pStmt);
            Common.close(conn);
        }
        public void ordersDelete(){
            System.out.print("삭제할 ID를 입력하세요 : ");
            String ORDER_ID = sc.next();
            String sql = "DELETE FROM EMP WHERE ORDER_ID = ?";

            try{
                conn = Common.getConnection();
                pStmt = conn.prepareStatement(sql);
                pStmt.setString(1, ORDER_ID);
                pStmt.executeUpdate();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

