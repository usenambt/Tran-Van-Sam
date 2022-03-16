package com.example.demo.Controller;

import com.example.demo.model.News;
import com.example.demo.service.CategoryService;
import com.example.demo.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.Optional;

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
        model.addAttribute("newsList",newsService.selectAllNewsIndex());
        return "index";
    }
    @GetMapping("/list")
    public String listNews(@RequestParam(value = "page",defaultValue = "0") int page,Model model){
        model.addAttribute("categoryList",categoryService.selectAllCategory());
        model.addAttribute("newsList",newsService.selectAllNews(PageRequest.of(page,4)));
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
    public String searchNews(@RequestParam(value = "page",defaultValue = "0") int page, Optional<String> value,Optional<Integer> idcategory, Model model, Pageable pageable){
        if(value.isPresent()){
            model.addAttribute("newsSearch",newsService.findByHeaderContaining(value.get(),PageRequest.of(page,2)));
            model.addAttribute("value",value);
        }
        else {
            model.addAttribute("newsSearch",newsService.findByCategory_Id(idcategory.get(),pageable));
        }


        return "search";
    }
    @GetMapping("/detail/{id}")
    public String detailNews(@PathVariable int id, Model model){
        model.addAttribute("news",newsService.findNewsById(id));
        return "detail";
    }


}