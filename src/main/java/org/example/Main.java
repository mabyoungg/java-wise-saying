package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        wiseSaying app = new wiseSaying();

        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");

            Scanner sc = new Scanner(System.in);
            String status = sc.next();
            if (status.equals("등록")) {
                app.create();
            } else if (status.equals("종료")) {
                app.exit();
            }
        }

    }
}

class wiseSaying {
    void create() {
        Scanner sc = new Scanner(System.in);
        System.out.print("명언 : ");
        String status = sc.next();
        System.out.print("작가 : ");
        String author = sc.next();
    }
    void exit() {
        System.exit(0);
    }
}
