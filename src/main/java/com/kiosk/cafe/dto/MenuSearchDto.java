package com.kiosk.cafe.dto;

import lombok.*;

@Getter @Setter
@ToString
public class MenuSearchDto {

    // 서칭 관련
    private String type;
    private String name;
    private int priceMiddle;

    // 페이지 관련
    /* 현재 페이지 */
    private Integer pageNum;

    /* 한 페이지 당 보여질 게시물 갯수 */
    private Integer amount;

    /* 스킵 할 게시물 수( (pageNum-1) * amount ) */
    private Integer skip;

    public MenuSearchDto() {
        this(1,10);
        this.skip = 0;
    }

    public MenuSearchDto(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
    }

}
