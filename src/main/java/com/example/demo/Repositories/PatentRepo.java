package com.example.demo.Repositories;

import com.example.demo.Models.FTO;
import com.example.demo.Models.Patent;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Component
@Getter
@Setter
@Slf4j
public class PatentRepo {
   List<Patent> pastPatents;

   public PatentRepo(List<Patent> pastPatents) {
      this.pastPatents = pastPatents;
   }

   public void savePatents(List<Patent> pat){
      log.info("saving the patents");
      pastPatents.addAll(pat);
   }

   // @Override
   //List<Patent> findAllByFto(FTO fto);



    //List<Patent> findAllByFTO(FTO );
}
