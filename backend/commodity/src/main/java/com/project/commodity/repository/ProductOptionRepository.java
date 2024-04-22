package com.project.commodity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.commodity.entity.ProductOption;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductOptionRepository extends JpaRepository<ProductOption, UUID> {
    List<ProductOption> findByProductId(UUID productId);
    List<ProductOption> findByOptionId(UUID optionId);
    void deleteByProductIdAndOptionId(UUID productId, UUID optionId);
    void deleteByProductId(UUID productId);
    void deleteByOptionId(UUID optionId);
}
