package com.manyPieces.wordGame.word;

import lombok.*;

import java.util.List;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class KornResponseDto {
    private Channel channel;
}

@Getter
@Setter
class Channel {
    private Integer total;
    private Integer num;
    private String title;
    private Integer start;
    private String description;
    private List<Item> item;
    private String link;
    private String lastbuilddate;
}

@Getter
@Setter
class Item {
    private String sup_no;
    private String word;
    private String target_code;
    private Sense sense;
    private String pos;
}

@Getter
@Setter
class Sense {
    private String definition;
    private String link;
    private String type;
}