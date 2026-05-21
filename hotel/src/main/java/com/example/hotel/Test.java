package com.example.hotel;

import com.example.hotel.model.Student;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        System.out.println("=====");
        Scanner first = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int count = 0;
        int comment = 0;
        int increase = 0;
        System.out.println("=====");
        if (first.hasNextInt()) { // 注意 while 处理多个 case
            count = first.nextInt();
        }
        System.out.println("=====");
        Scanner second = new Scanner(System.in);
        while (second.hasNextInt()) { // 注意 while 处理多个 case
            int current = count = second.nextInt();
            if(current == 1){
                comment++;
            }else if (current == 2){
                increase++;
            }else if (current == 3){
                if(comment > increase){
                    comment ++ ;
                }else if(comment < increase){
                    increase ++ ;
                }else if(comment == increase){
                    increase ++ ;
                    comment ++ ;
                }
            }
        }
        System.out.println(comment+" "+increase);

    }

    public static void modify(Student student) {
        student.setAge(14);
    }
}
