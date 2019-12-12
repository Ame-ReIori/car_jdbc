package com.yygq.demo.controller;

import com.yygq.demo.service.AssessorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * assessor controller
 *
 * @author ame
 */
@RestController
@Slf4j
public class AssessorController {

    private final AssessorService assessorService;

    @Autowired
    public AssessorController(AssessorService assessorService){
        this.assessorService = assessorService;
    }
}
