package com.brudite.devops.controller;

import com.brudite.devops.model.Candidate;
import com.brudite.devops.service.CandidateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CandidateController {

//    @Autowired
//    CandidateService candidateService;
//
//    @GetMapping("/enroll")
//    public String enrollForm(Candidate candidate){
//        return "addcandidate";
//    }

    @GetMapping("/index")
    public String showUserList(Model model) {
//        model.addAttribute("candidates", candidateService.getCandidates());
        return "index";
    }

//    @PostMapping("/addcandidate")
//    public String addCandidate(@Valid Candidate user, BindingResult result, Model model){
//        if(result.hasErrors()){
//            return "/addcandidate";
//        }
//        candidateService.enrollCandidate(user);
//        return "redirect:/index";
//    }
}
