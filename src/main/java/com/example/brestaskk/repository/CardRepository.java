package com.example.brestaskk.repository;

import com.example.brestaskk.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card,Long> {

    Optional<Card> findByIdAndActive(Long id,Integer active);
    List<Card> findAllByActive(Integer active);
}
