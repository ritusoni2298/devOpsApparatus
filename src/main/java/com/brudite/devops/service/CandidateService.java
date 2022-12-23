package com.brudite.devops.service;

import com.brudite.devops.model.Candidate;

import java.util.List;

public interface CandidateService {

    public Candidate enrollCandidate(Candidate candidate);

    public Candidate updateCandidate(Candidate candidate, Long id);

    public void deleteCandidate(Long id);

    public Candidate getCandidateById(Long id);

    List<Candidate> getCandidates();

    public Candidate updateStatusCandidate(String status, Long id);
}
