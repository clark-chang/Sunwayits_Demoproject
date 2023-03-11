package com.example.Demoproject.repo;


import com.example.Demoproject.model.Coin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoinRepo extends JpaRepository<Coin, Long> {
}