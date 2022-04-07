package com.example.koduocnuathoi.controller;

import com.example.koduocnuathoi.service.QuestionService;
import com.example.koduocnuathoi.service.QuestionTypeService;
import com.example.koduocnuathoi.service.TrangthaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@RequestMapping("question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private QuestionTypeService questionTypeService;
    @Autowired
    private TrangthaiService trangthaiService;

    @GetMapping("")
    public String listQuestion(Model model) {
        model.addAttribute("questionTypeList", questionTypeService.selectAllQuestionType());
        model.addAttribute("questionList", questionService.selectAllQuestion());
        return "list";
    }
}