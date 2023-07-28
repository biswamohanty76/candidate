package com.texhibit.candidate.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.texhibit.candidate.dtos.CandidateDto;
import com.texhibit.candidate.entities.Candidate;
import com.texhibit.candidate.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class CandidateController {

    private final CandidateService candidateService;

    @Autowired
    private ObjectMapper objectMapper;

    public CandidateController( final CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping(value="/candidates")
    @CrossOrigin
    public List<CandidateDto> getAll(){
       CandidateDto cand = new CandidateDto();
        cand.setId("1");
        cand.setDob("28-06-1976");
        cand.setName("Biswa");
        cand.setPhone("9886897520");
        cand.setEmail("rinku@bbm.com");
        cand.setGender("Male");
        List<CandidateDto> candidates = new ArrayList<>();
        candidates.add(cand);//candidateService.getAll();
        return candidates;
    }

    @PostMapping("/candidate")
    public Candidate addProduct(@RequestBody Candidate candidate) throws IOException {

        Candidate returnValue = candidateService.addCandidate(candidate);
        return returnValue;
    }

    @PutMapping("/candidate/{id}")
    public Candidate updateCandidate(@PathVariable String id, @RequestBody Candidate candidate){
        return candidateService.updateCandidate(id, candidate);
    }

    @GetMapping("/candidate/{id}")
    public Optional<Candidate> getCandidate(@PathVariable String id){
        return candidateService.getCandidate(id);
    }

    @DeleteMapping("/candidate/{id}")
    public String deleteCandidate(@PathVariable String id){

        return candidateService.deleteCandidate(id);
    }

    @GetMapping("/candidates/count")
    public Integer getCount(){
        return candidateService.getCount();
    }

}
