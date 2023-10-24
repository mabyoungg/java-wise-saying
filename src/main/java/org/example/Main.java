package org.example;

import java.util.*;

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
            } else if (status.equals("목록")) {
                app.list();
            } else if (status.startsWith("삭제?id=")) {
                app.delete(status);
            } else if (status.equals("종료")) {
                app.exit();
            }
        }

    }
}

class wiseSaying {
    int count = 1;
    ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

    void create() {
        Map<String, Object> map = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        map.put("번호",count);

        System.out.print("명언 : ");
        String word = sc.next();
        map.put("명언",word);

        System.out.print("작가 : ");
        String author = sc.next();
        map.put("작가", author);

        list.add(map);

        System.out.println(count + "번 명언이 등록되었습니다.");

        count++;

    }

    void list() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("--------------------");

        for (int i = 0; i <= list.size()-1; i++) {
            System.out.print(list.get(i).get("번호"));
            System.out.print(" / ");
            System.out.print(list.get(i).get("작가"));
            System.out.print(" / ");
            System.out.println(list.get(i).get("명언"));
        }


//        Iterator<String> keys = map.keySet().iterator();
//
//        while (keys.hasNext()) {
//            String key = keys.next();
//
//            System.out.println(count + " / " + key + " / " + map.get(key));
//
//            count++;
//        }
    }

    void delete(String status) {
        int index = status.indexOf("=");
        int findNum =  Integer.parseInt(status.substring(index+1));
        int deleteNum = 0;

        for (int i = 0; i <= list.size()-1; i++) {
            if (list.get(i).get("번호").equals(findNum)) {
                deleteNum = i;

                list.remove(deleteNum);
                System.out.println(findNum + "번 명언이 삭제되었습니다.");
            } else {
                System.out.println(findNum + "번 명언은 존재하지 않습니다.");
            }

        }


    }

    void exit() {
        System.exit(0);
    }


}
