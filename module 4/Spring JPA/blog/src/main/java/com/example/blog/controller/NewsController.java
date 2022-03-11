package com.example.blog.controller;

import com.example.blog.model.News;
import com.example.blog.service.CategoryService;
import com.example.blog.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

@Controller
@Service
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsService newsService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/index")
    public String loadIndex(Model model){
        model.addAttribute("newsList",newsService.selectAllNews());
        return "index";
    }
    @GetMapping("/list")
    public String listNews(Model model){
        model.addAttribute("newsList",newsService.selectAllNews());
        System.out.println(newsService.selectAllNews().get(0).getCategory());
        return "list";
    }
    @GetMapping("/edit/{id}")
    public String editNews(@PathVariable int id, Model model){
        model.addAttribute("news",newsService.findNewsById(id));
        model.addAttribute("categoryList",categoryService.selectAllCategory());
        return "edit";
    }
    @PostMapping("/update")
    public String updateNews(News news, RedirectAttributes redirectAttributes){
        newsService.saveNews(news);
        redirectAttributes.addFlashAttribute("msg","Cap nhat thanh cong");
        return "redirect:/news/list";
    }
    @GetMapping("delete/{id}")
    public String deleteNews(@PathVariable int id,Model model){
        model.addAttribute("news",newsService.findNewsById(id));
        model.addAttribute("categoryList",categoryService.selectAllCategory());
        return "delete";
    }
    @PostMapping("/remove")
    public String removeNews(News news,RedirectAttributes redirectAttributes){
        newsService.removeNews(news);
        redirectAttributes.addFlashAttribute("msg","Xoa thanh cong");
        return "redirect:/news/list";
    }
    @GetMapping("/create")
    public String createNews(Model model){
        model.addAttribute("news", new News());
        model.addAttribute("categoryList",categoryService.selectAllCategory());
        return "create";
    }
    @PostMapping("/save")
    public String saveNews(News news,RedirectAttributes redirectAttributes){
        LocalDateTime now = LocalDateTime.now();
        news.setCreateDate(now);
        newsService.saveNews(news);
        redirectAttributes.addFlashAttribute("msg","Them moi thanh cong");
        return "redirect:/news/list";
    }
    @GetMapping("/search")
    public String searchNews(@RequestParam("value") String value,Model model){
        model.addAttribute("newsSearch",newsService.findByHeaderContaining(value));
        return "search";
    }
    @GetMapping("/detail/{id}")
    public String detailNews(@PathVariable int id, Model model){
        model.addAttribute("news",newsService.findNewsById(id));
        return "detail";
    }
}