package com.brudite.devops.service;


import com.brudite.devops.exception.ResourceNotFoundException;
import com.brudite.devops.model.Candidate;
import com.brudite.devops.model.StageStatus;
import com.brudite.devops.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateServiceImpl implements CandidateService{

    @Autowired
    CandidateRepository candidateRepository;

    @Override
    public Candidate enrollCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    @Override
    public Candidate updateCandidate(Candidate candidate, Long id) {
        Optional<Candidate> candidateTemp = candidateRepository.findById(id);
        if(candidateTemp.isPresent()){
            Candidate candidate1 = candidateTemp.get();
            candidate1.setCollege(candidate.getCollege());
            candidate1.setName(candidate.getName());
            candidate1.setTaskCompleted(candidate.getTaskCompleted());
            candidate1.setUsername(candidate.getUsername());
            candidate1.setYearOfEducation(candidate.getYearOfEducation());
            return candidateRepository.save(candidate1);
        }
        throw new ResourceNotFoundException("Candidate with ID "+ id +" not found");
    }

    @Override
    public void deleteCandidate(Long id) {
        Optional<Candidate> candidateOptional = candidateRepository.findById(id);
        if(candidateOptional.isPresent()){
            Candidate candidate = candidateOptional.get();
            candidateRepository.delete(candidate);
        }else {
            throw new ResourceNotFoundException("Candidate with ID "+ id +" not found");
        }
    }

    @Override
    public Candidate getCandidateById(Long id) {
        Optional<Candidate> candidateOptional = candidateRepository.findById(id);
        return candidateOptional.orElseThrow(() -> new ResourceNotFoundException("Candidate with ID "+ id +" not found"));
    }

    @Override
    public List<Candidate> getCandidates() {
        return candidateRepository.findAll();
    }

    @Override
    public Candidate updateStatusCandidate(String status, Long id) {
        Optional<Candidate> candidate = candidateRepository.findById(id);
        if(candidate.isPresent()){
            if("Next Step".equals(status)) {
                Candidate candidate1 = candidate.get();
                Integer newStatusCode = candidate1.getStageStatusCode() + 1;
                if(newStatusCode == StageStatus.STEP_THREE.getStatusCode()){
                    candidate1.setTaskCompleted(true);
                }
                candidate1.setStageStatusCode(newStatusCode);
                candidateRepository.save(candidate1);
            }else if("Previous Step".equals(status)) {
                Candidate candidate1 = candidate.get();
                Integer newStatusCode = candidate1.getStageStatusCode() - 1;
                if(newStatusCode>0) {
                    candidate1.setStageStatusCode(newStatusCode);
                } else {
                    candidate1.setStageStatusCode(0);
                }
                candidateRepository.save(candidate1);
            }
        } else {
            throw new ResourceNotFoundException("Candidate with ID "+ id +" not found");
        }
        throw new ResourceNotFoundException("Candidate with ID "+ id +" not found");
    }
}
