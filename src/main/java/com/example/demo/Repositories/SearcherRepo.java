package com.example.demo.Repositories;

import com.example.demo.Models.Oi;
import com.example.demo.Models.Patent;
import com.example.demo.Models.Query;
import com.example.demo.Models.Searcher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SearcherRepo extends JpaRepository<Searcher, Long> {
    List<Searcher> findAllByOi(Oi oi);
}
