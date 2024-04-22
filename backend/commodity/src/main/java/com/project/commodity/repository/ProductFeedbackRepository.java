package com.project.commodity.repository;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.commodity.entity.ProductFeedback;



public interface ProductFeedbackRepository extends JpaRepository<ProductFeedback, UUID> {

    List<ProductFeedback> findByProductId(UUID productId);

}
