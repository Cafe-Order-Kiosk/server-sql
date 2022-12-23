package com.kiosk.cafe.dto;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private int no;
    private String id;
    private String pass;
    private String name;
    private String phone;
    private int point;

}
