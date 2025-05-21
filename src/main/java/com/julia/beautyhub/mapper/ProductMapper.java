package com.julia.beautyhub.mapper;

import com.julia.beautyhub.dto.ProductDTO;
import com.julia.beautyhub.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO toDTO(Product product);
    Product toEntity(ProductDTO dto);
}
