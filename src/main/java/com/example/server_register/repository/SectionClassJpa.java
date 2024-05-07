package com.example.server_register.repository;

import com.example.server_register.model.SectionClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionClassJpa extends JpaRepository<SectionClass, Integer> {

    boolean existsById(Integer id);
}
