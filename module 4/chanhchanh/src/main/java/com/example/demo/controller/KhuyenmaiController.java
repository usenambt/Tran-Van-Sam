package com.example.demo.controller;


import com.example.demo.model.Khuyenmai;
import com.example.demo.service.KhuyenmaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
@RequestMapping("khuyenmai")
public class KhuyenmaiController {
    @Autowired
    private KhuyenmaiService khuyenmaiService;

    @GetMapping("")
    public String listKhuyenmai( Model model) {

        model.addAttribute("khuyenmaiList", khuyenmaiService.selectAllKhuyenmai());

        return "list";
    }
    @GetMapping("create")
    public String createKhuyenmai(Model model){
        model.addAttribute("khuyenmai", new Khuyenmai());
        return "create";
    }
    @PostMapping("create")
    public String saveKhuyenmai(@Valid  Khuyenmai khuyenmai, BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            return "create";
        }
        khuyenmaiService.saveKhuyenmai(khuyenmai);
        return "redirect:/khuyenmai";
    }

    @GetMapping("detail/{khuyenmaiId}")
    public String detailKhuyenmai(@PathVariable int khuyenmaiId,Model model){
        model.addAttribute("khuyenmai", khuyenmaiService.findKhuyenmaiById(khuyenmaiId));
        return "detail";
    }

    @GetMapping("edit/{khuyenmaiId}")
    public String editKhuyenmai(@PathVariable int khuyenmaiId, Model model){
        model.addAttribute("khuyenmai", khuyenmaiService.findKhuyenmaiById(khuyenmaiId));
        return "edit";
    }
    @PostMapping("edit")
    public String updateKhuyenmai(Khuyenmai khuyenmai){
        khuyenmaiService.saveKhuyenmai(khuyenmai);
        return "redirect:/khuyenmai";
    }

    @GetMapping("delete/{khuyenmaiId}")
    public String delete(@PathVariable("khuyenmaiId") Integer khuyenmaiId, Model model){
        model.addAttribute("khuyenmai", this.khuyenmaiService.findKhuyenmaiById(khuyenmaiId));
        return "delete";
    }

    @PostMapping("delete")
    public String deleteKhuyenmai(@RequestParam("khuyenmaiId") int khuyenmaiId){
        khuyenmaiService.deleteKhuyenmai(khuyenmaiId);
        return "redirect:/khuyenmai";
    }

    @GetMapping("search")
    public String searchKhuyenmai(@RequestParam(value = "batdau", defaultValue = "") LocalDate batdau,
                                  @RequestParam(value = "ketthuc", defaultValue = "") String ketthuc,
                                 @RequestParam(value = "giamgia", defaultValue = "") String giamgia,
                                 Model model){

        model.addAttribute("batdauSearch", batdau);
        model.addAttribute("ketthucSearch", ketthuc);
        model.addAttribute("giamgiaSearch", giamgia);
        model.addAttribute("khuyenmaiList",khuyenmaiService.selectAllKhuyenmai());


        model.addAttribute("khuyenmaiList", khuyenmaiService.findAllByBatDauKetThucGiamGia(batdau,ketthuc,giamgia));

        return "list";
    }



}