package org.example.base;

import org.example.domain.wisesaying.WiseSayingController;

import java.util.*;

public class App {
    private Scanner scanner;

    public App() {

        scanner = new Scanner(System.in);

    }

    public void run() {

        System.out.println("== 명언 앱 ==");

        WiseSayingController wiseSayingController = new WiseSayingController(scanner);

        while (true) {
            System.out.print("명령) ");
            String status = scanner.nextLine();

            InputRequest inputRequest = new InputRequest(status);

            switch (inputRequest.getAction()) {
                case "등록":
                    wiseSayingController.create();
                    break;
                case "목록":
                    wiseSayingController.list();
                    break;
                case "삭제":
                    wiseSayingController.delete(inputRequest);
                    break;
                case "수정":
                    wiseSayingController.update(inputRequest);
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
