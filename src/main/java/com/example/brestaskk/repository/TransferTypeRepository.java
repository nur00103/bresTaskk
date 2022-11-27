package com.example.brestaskk.repository;

import com.example.brestaskk.entity.TransferType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransferTypeRepository extends JpaRepository<TransferType,Long> {

    Optional<TransferType> findByIdAndActive(Long id,Integer active);
    Optional<TransferType> findByNameAndActive(String name,Integer active);

}
