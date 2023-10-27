package org.example.domain.wisesaying;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class WiseSaying {

    @Getter
    private int count;
    @Getter
    @Setter
    private String word;
    @Getter
    @Setter
    private String author;

}
