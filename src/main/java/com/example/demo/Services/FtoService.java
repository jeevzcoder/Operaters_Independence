package com.example.demo.Services;
import com.example.demo.Models.FTO;
import com.example.demo.Models.Patent;
import com.example.demo.Repositories.FtoRepo;
import com.example.demo.Repositories.PatentRepo;
import com.example.demo.Repositories.QueryRepo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//
@Service
@Slf4j
public class FtoService implements IFtoService{

    RestTemplate restTemplate;
    FtoRepo ftoRepo;
    PatentRepo patentRepo;
    QueryRepo queryRepo;

    @Autowired
    GetPatentsFromApi patentsFromApi;

    //logger.info("Adding this"+pat);



    @Autowired
    public FtoService(RestTemplate restTemplate, FtoRepo ftoRepo, PatentRepo patentRepo, QueryRepo queryRepo,GetPatentsFromApi patentsFromApi) {
        this.restTemplate = restTemplate;
        this.ftoRepo = ftoRepo;
        this.patentRepo = patentRepo;
        this.queryRepo=queryRepo;
        this.patentsFromApi=patentsFromApi;
    }

    public List<Patent> detectChanges(Long id) throws Exception {
        /*Optional<FTO> optFto = ftoRepo.findById(id);
        if(optFto.isEmpty()){
            return null;
            If this is null means this is the first time youre doing this FTO so save all the details of the FTO
        }
        FTO fto =optFto.get();
        List<Patent> pastPatents=patentRepo.findAllByFto(fto);
        //Query query= queryRepo.findByFTO(fto);
        //Modify the query when required
        //String query="AI";*/
        List<Patent> pastPatents=patentRepo.getPastPatents();
        String query="";
        List<Patent> presentPatents=patentsFromApi.callAPIAndGetResponse(query);
        log.info("Calling Detect Changes");
        //return presentPatents;

        return checkNewPatents(presentPatents,pastPatents);
    }

    private List<Patent> checkNewPatents(List<Patent> currentPat, List<Patent> pastPat){
        List<String> pPat=new ArrayList<>();
        List<Patent> uniPat=new ArrayList<>();

            for(Patent p:pastPat){
                pPat.add(p.getPatId()); }

            for(Patent p:currentPat){
                if(!pPat.contains(p.getPatId())){
                    System.out.println(p.getPatId());
                    uniPat.add(p); } }


        patentRepo.savePatents(uniPat);


        return uniPat;
    }
}