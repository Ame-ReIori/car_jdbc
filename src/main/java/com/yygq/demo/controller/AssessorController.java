package com.yygq.demo.controller;

import cn.hutool.core.lang.Dict;
import com.yygq.demo.entity.Assessor;
import com.yygq.demo.service.AssessorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @RequestMapping(value = "/assessor/id")
    public Dict getCar(@RequestParam(value = "assessorId")Long assessorId){
        Assessor assessor = assessorService.getAssessor(assessorId);
        return Dict.create().set("code", 200).set("msg", "success").set("data", assessor);
    }

    @RequestMapping(value = "/assessor")
    public Dict getAllAssessors(){
        List<Assessor> assessorList = assessorService.getAll();
        return Dict.create().set("code", 200).set("msg", "success").set("data", assessorList);
    }
}
