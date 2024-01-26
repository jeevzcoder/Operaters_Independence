package com.example.demo.Repositories;

import com.example.demo.Models.Oi;
import com.example.demo.Models.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryRepo extends JpaRepository<Query, Long> {
   //@Override
    Query findByOi(Oi oi);

}


