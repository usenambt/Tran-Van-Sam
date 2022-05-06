package com.example.demo.controller;


import com.example.demo.model.Question;
import com.example.demo.service.QuestionService;
import com.example.demo.service.QuestionService;
import com.example.demo.service.QuestionTypeService;
import com.example.demo.service.TrangthaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
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
    public String listQuestion( @RequestParam(value = "page", defaultValue = "0") int page, Model model){
        model.addAttribute("checklist",true);

        model.addAttribute("questionTypeList", questionTypeService.selectAllQuestionType());

        model.addAttribute("questionList", questionService.selectAllQuestion(PageRequest.of(page,2)));

        return "list";
    }
    @GetMapping("create")
    public String createQuestion(Model model){
        model.addAttribute("question", new Question());
        model.addAttribute("trangthaiList",trangthaiService.selectAllTrangthai());
        model.addAttribute("questionTypeList", questionTypeService.selectAllQuestionType());
        return "create";
    }
    @PostMapping("create")
    public String saveQuestion(@Valid  Question question, BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("trangthaiList",trangthaiService.selectAllTrangthai());
            model.addAttribute("questionTypeList", questionTypeService.selectAllQuestionType());
            return "create";

        }
        questionService.saveQuestion(question);
        return "redirect:/question";
    }

    @GetMapping("detail/{questionId}")
    public String detailQuestion(@PathVariable int questionId,Model model){
        model.addAttribute("question", questionService.findQuestionById(questionId));
        return "detail";
    }

    @GetMapping("edit/{questionId}")
    public String editQuestion(@PathVariable int questionId, Model model){
        model.addAttribute("question", questionService.findQuestionById(questionId));
        model.addAttribute("trangthaiList",trangthaiService.selectAllTrangthai());
        model.addAttribute("questionTypeList", questionTypeService.selectAllQuestionType());
        return "edit";
    }
    @PostMapping("edit")
    public String updateQuestion(Question question){
        questionService.saveQuestion(question);
        return "redirect:/question";
    }

    @GetMapping("delete/{questionId}")
    public String delete(@PathVariable("questionId") Integer questionId, Model model){
        model.addAttribute("question", this.questionService.findQuestionById(questionId));
        return "delete";
    }

    @PostMapping("delete")
    public String deleteQuestion(@RequestParam("questionId") int questionId){
        questionService.deleteQuestion(questionId);
        return "redirect:/question";
    }

    @GetMapping("search")
    public String searchQuestion(@RequestParam(value = "title", defaultValue = "") String title,
                                 @RequestParam(value = "typeId", defaultValue = "") Integer typeId,
                                 @RequestParam(value = "page", defaultValue = "0") int page, Model model){
        model.addAttribute("checksearch",true);
        model.addAttribute("titleSearch", title);
        model.addAttribute("typeIdSearch", typeId);

        model.addAttribute("questionTypeList", questionTypeService.selectAllQuestionType());

        model.addAttribute("questionList", questionService.findAllByTitleAndType(title,typeId,PageRequest.of(page,1)));

        return "list";
    }



}