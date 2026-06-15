package com.example.young.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductRequest {

    @NotBlank(message = "상품명을 입력해주세요")
    private String name;

    @Min(value = 0, message = "가격은 0원 이상이어야 합니다")
    private int price;

    @Min(value = 0, message = "재고는 0 이상이어야 합니다")
    private int stock;
}