package com.example.demo.Repositories;

import com.example.demo.Models.Oi;
import com.example.demo.Models.Patent;
import com.example.demo.Models.Query;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
@Component

public interface PatentRepo extends JpaRepository<Patent, Long> {
 List<Patent> findAllByOi(Oi oi);

    //@Override
    <S extends Patent> S save(Patent p);

    @Override
    <S extends Patent> List<S> saveAll(Iterable<S> entities);
}
