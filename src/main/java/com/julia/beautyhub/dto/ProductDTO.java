package com.julia.beautyhub.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {
    private Long id;
    private String name;
    private String category;
    private String imageUrl;
    private Double price;
    private Double rating;
}
