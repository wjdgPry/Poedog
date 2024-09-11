package com.shop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewDto {
    private Long id;
    private String username;
    private String content;
    private int rating;
}