package com.example.demo.Repositories;
import com.example.demo.Models.FTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.JpaParameters;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FtoRepo extends JpaRepository<FTO, Long> {
    @Override
    Optional<FTO> findById(Long aLong);
}
