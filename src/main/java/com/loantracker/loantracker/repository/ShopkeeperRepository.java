package com.loantracker.loantracker.repository;

import com.loantracker.loantracker.entity.Shopkeeper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShopkeeperRepository extends JpaRepository<Shopkeeper, Long> {
    Optional<Shopkeeper> findByMobile(String mobile);
}