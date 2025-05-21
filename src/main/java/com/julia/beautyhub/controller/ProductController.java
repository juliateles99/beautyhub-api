package com.julia.beautyhub.controller;

import com.julia.beautyhub.dto.ProductDTO;
import com.julia.beautyhub.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category) {
        return ResponseEntity.ok(service.findFiltered(name, category));
    }

    @PostMapping
    public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
