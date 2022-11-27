package com.example.brestaskk.repository;

import com.example.brestaskk.entity.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerTypeRepository extends JpaRepository<CustomerType,Long> {

    public Optional<CustomerType> findByNameAndActive(String name, Integer active);
    public Optional<CustomerType> findByIdAndActive(Long id, Integer active);
}
