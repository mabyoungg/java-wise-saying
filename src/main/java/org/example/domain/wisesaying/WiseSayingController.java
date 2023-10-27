package org.example.domain.wisesaying;

import org.example.base.InputRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private Scanner scanner;
    private int count;
    private List<WiseSaying> list;

    public WiseSayingController(Scanner scanner) {
        this.scanner = scanner;
        list = new ArrayList<>();
        count = 1;
        initTestData();
    }

    private void initTestData() {
        for (int i = 1; i < 11; i++) {

            write("명언" + i, "작가" + i);

        }

    }

    public void create() {

        System.out.print("명언 : ");
        String word = scanner.nextLine();

        System.out.print("작가 : ");
        String author = scanner.nextLine();

        WiseSaying wiseSaying = write(word, author);

        System.out.printf("%d번 명언이 등록되었습니다. \n", wiseSaying.getCount());

    }

    public void list() {

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
    public void delete(InputRequest inputRequest) {

        int id = inputRequest.getIndexByParam("id", 0);

        int index = getIndexByList(id);

        try {
            list.remove(index);
            System.out.println(id + "번 명언이 삭제되었습니다.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("존재하지 않는 ID 입니다.");
        }

    }

    public void update(InputRequest inputRequest) {

        int id = inputRequest.getIndexByParam("id", 0);

        int index = getIndexByList(id);

        try {
            WiseSaying wiseSaying = list.get(index);

            System.out.printf("명언(기존): %s \n", wiseSaying.getWord());
            System.out.print("명언: ");
            String word = scanner.nextLine();

            System.out.printf("작가(기존): %s \n", wiseSaying.getAuthor());
            System.out.print("작가: ");
            String author = scanner.nextLine();

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

    private WiseSaying write(String word, String author) {

        int id = count;

        WiseSaying wiseSaying = new WiseSaying(id, word, author);
        list.add(wiseSaying);

        count++;

        return wiseSaying ;
    }



}
