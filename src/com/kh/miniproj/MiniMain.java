package com.kh.miniproj;

import com.kh.miniproj.dao.*;
import com.kh.miniproj.vo.*;
import java.util.List;
import java.util.Scanner;

public class MiniMain {
    public static void main(String[] args) {
        ProdDAO pDao = new ProdDAO();
        CustomersDAO cDao = new CustomersDAO();
        OrdersDAO oDao = new OrdersDAO();
        OrderItemsDAO oiDao = new OrderItemsDAO();
        CartDAO ctDao = new CartDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("조회 할 정보를 선택하세요 : ");
            System.out.println("[1]상품 정보, [2]고객 정보, [3]주문 정보, [4]주문 상품 정보, [5]장바구니, [6] 종료 :");
            int sel1 = sc.nextInt();
            switch (sel1) {
                case 1:
                    List<ProdVO> listP = pDao.productsSelect();
                    pDao.productSelectPrint(listP);

                case 2:
                    List<CustomersVO> listC = cDao.CustomerSelect();
                    cDao.CustomerSelectPrint(listC);
                    System.out.println("조회한 테이블의 수정을 선택하세요 : ");
                    System.out.println("[1]INSERT, [2]UPDATE, [3]DELETE, [4]EXIT :");
                    int sel3 = sc.nextInt();
                    switch (sel3){
                        case 1: cDao.CustomerInsert(); break;
                        case 2: cDao.customerUpdate(); break;
                        case 3: cDao.customerDelete(); break;
                        case 4: break;
                        }

                case 3:
                    List<OrdersVO> listO = oDao.ordersSelect();
                    oDao.ordersSelectPrint(listO);
                    System.out.println("조회한 테이블의 수정을 선택하세요 : ");
                    System.out.println("[1]INSERT, [2]UPDATE, [3]DELETE, [4]EXIT :");
                    int sel4 = sc.nextInt();
                    switch (sel4){
                        case 1: oDao.ordersInsert(); break;
                        case 2: oDao.ordersUpdate(); break;
                        case 3: oDao.ordersDelete(); break;
                        case 4: break;
                    }

                case 4:
                    List<OrderItemsVO> listOI = oiDao.orderItemssSelect();
                    oiDao.orderItemsSelectPrint(listOI);
                    System.out.println("조회한 테이블의 수정을 선택하세요 : ");
                    System.out.println("[1]INSERT, [2]UPDATE, [3]DELETE, [4]EXIT :");
                    int sel5 = sc.nextInt();
                    switch (sel5){
                        case 1: oiDao.orderItemsInsert(); break;
                        case 2: oiDao.orderItemsUpdate(); break;
                        case 3: oiDao.orderItemsDelete(); break;
                        case 4: break;
                    }

                case 5:
                    List<CartVO> listCT = ctDao.CartSelect();
                    ctDao.CartSelectPrint(listCT);
                    System.out.println("조회한 테이블의 수정을 선택하세요 : ");
                    System.out.println("[1]INSERT, [2]UPDATE, [3]DELETE, [4]EXIT :");
                    int sel6 = sc.nextInt();
                    switch (sel6){
                        case 1: ctDao.cartInsert(); break;
                        case 2: ctDao.cartUpdate(); break;
                        case 3: ctDao.cartDelete(); break;
                        case 4: break;
                    }

                case 6:
                    System.out.println("메뉴를 종료 합니다.");
                    break;
            }
        }
    }
}





