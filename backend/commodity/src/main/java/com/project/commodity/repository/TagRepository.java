package com.project.commodity.repository;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.commodity.entity.Tag;




public interface TagRepository extends JpaRepository<Tag, UUID> {

}
