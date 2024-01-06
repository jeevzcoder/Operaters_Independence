package com.example.demo.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponseDto {


    Integer took;
    Integer total;
    String code;
    Boolean success;
    Integer nextPage;
    Integer totalPages;
    List<ApiPatentsDto> patents;


}
/*{
  "took" : 10,
  "total" : 214189,
  "code" : 200,
  "success" : true,
  "nextPage" : 2,
  "totalPages" : 21419,
  "patents" : [ {
    "id" : "US2021090136A1",
    "rank" : "0",
    "legalStatus" : "有效专利",
    "type" : "发明申请",
    "title" : "AI TO AI COMMUNICATION",
    "summary" : "A method includes collecting, by a first AI application of a first AI computer, data to include in a dataset. The first AI application of the first AI computer can include an offer for the dataset into an offering platform. The first AI application of the first AI computer can then receive a response to the offer from a second AI application of a second AI computer. The first AI application of the first AI computer can determine whether or not to provide the dataset to the second AI application of the second AI computer. The first AI application of the first AI computer can, based on the determination, provide the dataset to the second AI application of the second AI computer.",
    "applicant" : "Visa International Service Association",
    "applicationDate" : "2020-09-18",
    "applicantAddress" : "US CA San Francisco",
    "mainIpc" : "G06Q30/02",
    "applicationNumber" : "US17025097",
    "documentNumber" : "US20210090136A1",
    "documentDate" : "2021-03-25",
    "inventor" : "Yue Li; Theodore Harris; Tatiana Korolevskaya",
    "currentAssignee" : "Visa International Service Association",
    "currentAssigneeAddress" : "US CA San Francisco",
    "ipc" : "G06Q30/02; G06Q50/00; G06N3/02; H04L9/06",
    "province" : "CA",
    "city" : "CA San Francisco",
    "imagePath" : ""
  }, {
    "id" : "US2022230184A1",*/






