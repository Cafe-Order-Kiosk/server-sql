package com.kiosk.cafe.dto;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Menu {
    private int no;

    private String type;
    private String name;
    private boolean shot;
    private boolean syrup;

    private int priceSmall;
    private int priceMiddle;
    private int priceLarge;

    private String saveFolderName;
    private String saveFileName;
    private String originFileName;

    private int menuSaleCount;
}