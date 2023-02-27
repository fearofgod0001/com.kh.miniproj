package com.kh.miniproj.dao;

import com.kh.miniproj.util.Common;
import com.kh.miniproj.vo.MiniProductsVO;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MiniProductDAO {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    Scanner sc = new Scanner(System.in);

    public List<MiniProductsVO> productsSelect(){
        List<MiniProductsVO> list = new ArrayList<>();
        try{
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String sqlp = "SELECT * FROM PRODUCTS";
            rs = stmt.executeQuery(sqlp);

            while(rs.next()){
                String pID = rs.getString("PRODUCT_ID");
                String pName = rs.getString("PRODUCT_NAME");
                String color = rs.getString("COLOR");
                String pSize = rs.getString("PSIZE");
                int price = rs.getInt("PRICE");
                int stkQuan= rs.getInt("STOCK_QUANTITY");
                MiniProductsVO voP = new MiniProductsVO(pID, pName, color, pSize, price, stkQuan);
                list.add(voP);
            }
            Common.close(rs);
            Common.close(stmt);
            Common.close(conn);

        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public void productSelectPrint(List<MiniProductsVO>list){
        for(MiniProductsVO p : list) {
            System.out.println("상품ID : " + p.getpID());
            System.out.println("상품명 : " + p.getpName());
            System.out.println("색상 : " + p.getColor());
            System.out.println("사이즈  : " + p.getpSize());
            System.out.println("가격 : " +p.getPrice());
            System.out.println("재고수량 : " + p.getStkQuan());
            System.out.println("-------------------");

        }
    }


}
