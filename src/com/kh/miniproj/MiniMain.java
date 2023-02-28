package com.kh.miniproj;

import com.kh.miniproj.dao.ProdDAO;
import com.kh.miniproj.vo.ProdVO;

import java.util.List;
import java.util.Scanner;

public class MiniMain {
    public static void main(String[] args) {
        ProdDAO pDao = new ProdDAO();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("====== [EMP Table Command] ====== ");
            System.out.println("메뉴를 선택 하세요 : ");
            System.out.println("[1]SELECT, [2]INSERT, [3]UPDATE, [4]DELETE, [5]EXIT :");
            int sel = sc.nextInt();
            switch (sel){
                case 1:
                    List<ProdVO> list = pDao.productsSelect();
                    pDao.productSelectPrint(list);
                    break;
                case 2:
                    pDao.productsInsert();
                    break;
                case 3:
                case 4:
                case 5:
                    System.out.println("메뉴를 종료 합니다.");

            }
        }

    }



}
