package org.example.domain;

import java.util.*;

public class App {
    private Scanner sc;
    private int count;
    private List<WiseSaying> list;


    public App() {
        sc = new Scanner(System.in);
        list = new ArrayList<>();
        count = 1;
    }

    public void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String status = sc.nextLine();

            InputRequest inputRequest = new InputRequest(status);

            switch (inputRequest.getAction()) {
                case "등록":
                    create();
                    break;
                case "목록":
                    list();
                    break;
                case "삭제":
                    delete(inputRequest);
                    break;
                case "수정":
                    update(inputRequest);
                    break;
                case "종료":
                    return;
            }

        }

    }

//    ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

//    txt 불러오기
//    ArrayList<Map<String, Object>> list = txtLoad("data.txt");

    //    json 불러오기
//    ArrayList<Map<String, Object>> list = jsonLoad("data.json");


    private void create() {
        int id = count;

        System.out.print("명언 : ");
        String word = sc.nextLine();

        System.out.print("작가 : ");
        String author = sc.nextLine();

        WiseSaying wiseSaying = new WiseSaying(id, word, author);

        list.add(wiseSaying);

        System.out.println(count + "번 명언이 등록되었습니다.");

        count++;
    }

    private void list() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("--------------------");

        if (list.isEmpty()) {
            System.out.println("등록된 명언이 없습니다.");
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying = list.get(i);

            System.out.printf("%d / %s / %s \n", wiseSaying.getCount(), wiseSaying.getAuthor(), wiseSaying.getWord());
        }

    }

    // ex: 삭제?id=3&type=ai&save=true
    private void delete(InputRequest inputRequest) {
        int id = inputRequest.getIndexByParam("id", 0);

        int index = getIndexByList(id);

        try {
            list.remove(index);
            System.out.println(id + "번 명언이 삭제되었습니다.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("존재하지 않는 ID 입니다.");
        }

    }

    private void update(InputRequest inputRequest) {
        int id = inputRequest.getIndexByParam("id", 0);

        int index = getIndexByList(id);

        try {
            WiseSaying wiseSaying = list.get(index);

            System.out.printf("명언(기존): %s \n", wiseSaying.getWord());
            System.out.print("명언: ");
            String word = sc.nextLine();

            System.out.printf("작가(기존): %s \n", wiseSaying.getAuthor());
            System.out.print("작가: ");
            String author = sc.nextLine();

            wiseSaying.setWord(word);
            wiseSaying.setAuthor(author);

            System.out.printf("%d번 명언이 수정되었습니다. \n", id);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("존재하지 않는 ID 입니다.");
        }

    }

    private int getIndexByList(int id) {

        for (int i = 0; i < list.size(); i++) {
            WiseSaying wiseSaying = list.get(i);

            if (wiseSaying.getCount() == id) {
                return i;
            }
        }

        return -1;

    }


//
//    ArrayList<Map<String, Object>> txtLoad(String fileName) {
//        ArrayList<Map<String, Object>> loadedList = new ArrayList<>();
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
//            loadedList = (ArrayList<Map<String, Object>>) ois.readObject();
//
//            this.count = (int)loadedList.get(loadedList.size()-1).get("id")+1;
//
//            System.out.println("데이터를 파일에서 불러왔습니다.");
//        } catch (Exception e) {
//            System.err.println("파일 불러오기 중 오류가 발생했습니다: " + e.getMessage());
//        }
//        return loadedList;
//    }
//
//    void txtSave() {
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.txt"))) {
//            oos.writeObject(list);
//            System.out.println("데이터를 파일에 저장했습니다.");
//        } catch (Exception e) {
//            System.err.println("파일 저장 중 오류가 발생했습니다: " + e.getMessage());
//        }
//    }
//
//    void jsonBuild() {
//        StringBuilder jsonString = new StringBuilder("[");
//        for (Map<String, Object> map : list) {
//            jsonString.append("{");
//            for (Map.Entry<String, Object> entry : map.entrySet()) {
//                jsonString.append("\"").append(entry.getKey()).append("\":\"").append(entry.getValue()).append("\",");
//            }
//            jsonString.deleteCharAt(jsonString.length() - 1); // 마지막 쉼표 제거
//            jsonString.append("},");
//        }
//        if (list.size() > 0) {
//            jsonString.deleteCharAt(jsonString.length() - 1); // 마지막 쉼표 제거
//        }
//        jsonString.append("]");
//
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data.json"))) {
//            writer.write(jsonString.toString());
//            System.out.println("data.json 파일의 내용이 갱신되었습니다.");
//        } catch (IOException e) {
//            System.err.println("파일 저장 중 오류가 발생했습니다: " + e.getMessage());
//        }
//
//    }
//
//    ArrayList<Map<String, Object>> jsonLoad(String fileName) {
//        ArrayList<Map<String, Object>> loadedList = new ArrayList<>();
//        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
//            StringBuilder jsonString = new StringBuilder();
//            String line;
//            while ((line = reader.readLine()) != null) {
//                jsonString.append(line);
//            }
//
//            loadedList = jsonStringToList(jsonString.toString());
//
//            this.count = (int)loadedList.get(loadedList.size()-1).get("id")+1;
//
////            String count = (String) loadedList.get(loadedList.size()-1).get("id");
////            this.count = Integer.parseInt(count) + 1;
//
//        } catch (IOException e) {
//            System.err.println("파일 불러오기 중 오류가 발생했습니다: " + e.getMessage());
//        }
//        return loadedList;
//    }
//
//    ArrayList<Map<String, Object>> jsonStringToList(String jsonString) {
//        ArrayList<Map<String, Object>> list = new ArrayList<>();
//
//        jsonString = jsonString.replace(" ", "");
//
//        String[] items = jsonString.substring(2, jsonString.length() - 2).split("\\},\\{");
//        for (String item : items) {
//            String[] keyValuePairs = item.split(",");
//            Map<String, Object> map = new HashMap<>();
//            for (String pair : keyValuePairs) {
//                String[] entry = pair.split(":");
//                String key = entry[0].trim().replace("\"", "");
//                String value = entry[1].trim().replace("\"", "");
//
//                if (key.equals("id")) {
//                    int intValue = Integer.parseInt(value);
//                    map.put(key, intValue);
//                } else {
//                    map.put(key, value);
//                }
//            }
//            list.add(map);
//        }
//
//        return list;
//
//    }
//
//
//    void exit() {
////        try {
////            ObjectOutputStream ouput = new ObjectOutputStream(new FileOutputStream("./data.txt"));
////            ouput.writeObject(list);
////            ouput.close();
////        } catch (Exception e) {
////
////        }
//
//        System.exit(0);
//    }


}
