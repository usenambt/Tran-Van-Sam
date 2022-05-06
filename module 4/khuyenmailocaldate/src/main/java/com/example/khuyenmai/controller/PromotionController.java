package com.example.khuyenmai.controller;

import com.example.khuyenmai.service.PromotionService;
import com.example.khuyenmai.model.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("")
public class PromotionController {
    @Autowired
    PromotionService promotionService;
    @GetMapping("")
    public String loadPromotion(Model model){
        model.addAttribute("promotionLists",promotionService.selectAllPromotion());
        return "list";
    }
    @GetMapping("create")
    public String createPromotion(Model model){
        model.addAttribute("promotion", new Promotion());
        return "create";
    }
    @PostMapping("save")
    public String savePromotion(Promotion promotion){
        promotionService.savePromotion(promotion);
        return "redirect:/";
    }
    @GetMapping("edit/{id}")
    public String editPromotion(@PathVariable int id, Model model){
        model.addAttribute("promotion",promotionService.findPromotionById(id));
        return "create";
    }
    @GetMapping("delete/{id}")
    public String deletePromotion(@PathVariable int id, Model model){
        promotionService.deletePromotion(promotionService.findPromotionById(id));
        return "redirect:/";
    }
    @GetMapping("search")
    public String searchPromotion(@RequestParam String timestart, String timeend, Model model){
        model.addAttribute("promotionLists",promotionService.searchPromotion(timestart,timeend));
        return "list";
    }


}
