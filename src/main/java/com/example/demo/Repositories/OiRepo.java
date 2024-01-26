package com.example.demo.Repositories;
import com.example.demo.Models.Oi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OiRepo extends JpaRepository<Oi, Long> {


    @Override
   List<Oi>  findAll();
    Oi save(Oi oi);
}
