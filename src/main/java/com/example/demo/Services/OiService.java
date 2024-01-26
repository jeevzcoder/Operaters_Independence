package com.example.demo.Services;
import com.example.demo.DTOs.OiCCOutputDto;
import com.example.demo.Models.*;
import com.example.demo.Repositories.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

//
@Service
@Slf4j
public class OiService implements IOiService {
    RestTemplate restTemplate;

    AssetTeamRepo aTeamRepo;
    SearcherRepo searcherRepo;
    OiRepo oiRepo;
    PatentRepo patentRepo;
    QueryRepo queryRepo;
    GetPatentsFromApi patentsFromApi;
    EmailService emailService;
    @Autowired
    public OiService(RestTemplate restTemplate,  AssetTeamRepo aTeamRepo,SearcherRepo searcherRepo, OiRepo oiRepo, PatentRepo patentRepo, QueryRepo queryRepo, GetPatentsFromApi patentsFromApi, EmailService emailService) {
        this.restTemplate = restTemplate;
        this.aTeamRepo=aTeamRepo;
        this.searcherRepo=searcherRepo;
        this.oiRepo = oiRepo;
        this.patentRepo = patentRepo;
        this.queryRepo=queryRepo;
        this.emailService=emailService;
        this.patentsFromApi=patentsFromApi;
    }

    public List<OiCCOutputDto> detectChanges(Long id) throws Exception {

       /*Optional<List<Oi>> optionalOis=oiRepo.findAll();
        if(optionalOis.isEmpty()){
            //return new OiCCOutputDto();
            return null;
        }
        List<Oi> ois=optionalOis.get();*/
        //List<Patent> pastPatents=patentRepo.getPastPatents();
        List<Oi> ois=oiRepo.findAll();
        List<OiCCOutputDto> result=new ArrayList<>();
        List<Oi> responseOi=new ArrayList<>();

        //Checking for every FTO is there any new additions
        for(Oi oi_local:ois){
            System.out.println(oi_local.getName());
            String q_local=queryRepo.findByOi(oi_local).getQuery();
            //String q_local="AI";
            List<Patent> pastPatents= patentRepo.findAllByOi(oi_local);
            List<Patent> presentPatents=patentsFromApi.callAPIAndGetResponse(q_local);
            List<Patent> deltaPat=checkNewPatents(presentPatents,pastPatents);



            if (deltaPat!=null){
                for(Patent p: deltaPat){
                    p.setOi(oi_local);
                }
                /*OiCCOutputDto outputDto= new OiCCOutputDto();
                outputDto.setOIName(oi_local.getName());
                outputDto.setDateOfLastCompletion(new Date());
                outputDto.setTotalChanges(deltaPat.size());
                outputDto.setNewPatents(deltaPat);
                result.add(outputDto);*/
                patentRepo.saveAll(deltaPat);
                OiCCOutputDto outputDto=new OiCCOutputDto();
                outputDto.setOIName(oi_local.getName());
                outputDto.setTotalChanges(deltaPat.size());
                outputDto.setNewPatents(deltaPat);
                outputDto.setDateOfLastCompletion(new Date());


                //oiResponse.setPatents(deltaPat);
                result.add(outputDto);
                sendMail(deltaPat,oi_local);


            }

        }

        return result;
    }



    public  List<Patent> checkNewPatents(List<Patent> currentPat, List<Patent> pastPat) throws Exception{

        StringBuilder pPat= new StringBuilder();
        List<Patent> uniPat=new ArrayList<>();
        System.out.println("Past Patents");

            for(Patent p:pastPat){
                System.out.println(p.getPatId());
                pPat.append( p.getPatId()); }

        System.out.println("New PAT");
            for(Patent p:currentPat){
                if(!pPat.toString().contains(p.getPatId())){
                    System.out.println(p.getPatId());
                    uniPat.add(p); } }

        return uniPat;
    }

    private void sendMail(List<Patent> deltaPatents,Oi oi_local) throws Exception{
        StringBuilder deltaPatentsString= new StringBuilder(new String());
        for(Patent p: deltaPatents){
            deltaPatentsString.append(p.getPatId());
            deltaPatentsString.append(" ");
        }
        List<AssetTeam> assetTeams=aTeamRepo.findAllByOi(oi_local);
        List<Searcher> searchers=searcherRepo.findAllByOi(oi_local);
        List<String> toAddress=new ArrayList<>();
        for(AssetTeam team:assetTeams){
            toAddress.add(team.getEmailId());
        }
        for(Searcher team:searchers){
            toAddress.add(team.getEmailId());
        }


        emailService.sendEmail(toAddress, "FTO Update", deltaPatentsString.toString());

    }
}