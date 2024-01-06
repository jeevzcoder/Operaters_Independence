package com.example.demo.Repositories;

import com.example.demo.Models.FTO;
import com.example.demo.Models.Patent;
import com.example.demo.Models.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface QueryRepo extends JpaRepository<Query, String> {
   //@Override
    Query findByFto(FTO fto);

}


