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
            if (status.equals("종료")) {
                app.exit();

            }
        }

    }
}

class wiseSaying {
    void exit() {
        System.exit(0);
    }
}
