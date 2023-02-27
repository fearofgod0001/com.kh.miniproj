package com.kh.miniproj;

import com.kh.miniproj.dao.MiniProductDAO;
import com.kh.miniproj.vo.MiniProductsVO;

import java.util.List;
import java.util.Scanner;

public class MiniMain {
    public static void main(String[] args) {
        MiniProductDAO dao = new MiniProductDAO();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("====== [EMP Table Command] ====== ");
            System.out.println("메뉴를 선택 하세요 : ");
            System.out.println("[1]SELECT, [2]INSERT, [3]UPDATE, [4]DELETE, [5]EXIT :");
            int sel = sc.nextInt();
            switch (sel){
                case 1:
                    List<MiniProductsVO> list = dao.productsSelect();
                    dao.productSelectPrint(list);
                case 2:
                case 3:
                case 4:
                case 5:
                    System.out.println("메뉴를 종료 합니다.");

            }
        }

    }



}
