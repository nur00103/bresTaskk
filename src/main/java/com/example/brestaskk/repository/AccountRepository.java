package com.example.brestaskk.repository;

import com.example.brestaskk.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

    Optional<Account> findByIdAndActive(Long id,Integer active);
    List<Account> findAllByActive(Integer active);
}
