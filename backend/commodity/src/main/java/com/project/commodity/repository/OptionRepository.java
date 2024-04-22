package com.project.commodity.repository;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.commodity.entity.Options;


public interface OptionRepository extends JpaRepository<Options, UUID> {

}
