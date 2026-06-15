package com.example.young.service;

import com.example.young.dto.ProductRequest;
import com.example.young.dto.ProductResponse;
import com.example.young.entity.Product;
import com.example.young.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    // 상품 생성하기
    public ProductResponse createProduct(ProductRequest request) {

        Product product = Product.builder()
                .name(request.getName())
                .price(request.getPrice())
                .stock(request.getStock())
                .build();

        return new ProductResponse(productRepository.save(product));
    }

    // 상품 가져오기
    @Transactional(readOnly = true)
    public ProductResponse getProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("상품을 찾을 수 없습니다."));

        return new ProductResponse(product);
    }

    // 모든 상품 리스트 조회
    @Transactional(readOnly = true)
    public List<ProductResponse> getProducts(){
        return productRepository.findAll().stream()
                .map(ProductResponse::new)
                .toList();
    }

    // 상품 업데이트
    public ProductResponse updateProduct(Long id, ProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("상품을 찾을 수 없습니다."));
        product.update(request.getName(), request.getPrice());
        return new ProductResponse(product);
    }

    // 상품 삭제 (가벼운삭제)
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("상품을 찾을 수 없습니다."));
        product.delete();
    }
}
