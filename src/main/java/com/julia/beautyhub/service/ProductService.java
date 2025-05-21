package com.julia.beautyhub.service;

import com.julia.beautyhub.dto.ProductDTO;
import com.julia.beautyhub.mapper.ProductMapper;
import com.julia.beautyhub.model.Product;
import com.julia.beautyhub.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    public List<ProductDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO save(ProductDTO dto) {
        Product entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    public ProductDTO update(Long id, ProductDTO dto) {
        Product existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com ID: " + id));

        existing.setName(dto.getName());
        existing.setCategory(dto.getCategory());
        existing.setImageUrl(dto.getImageUrl());
        existing.setPrice(dto.getPrice());
        existing.setRating(dto.getRating());

        Product updated = repository.save(existing);
        return mapper.toDTO(updated);
    }
}
