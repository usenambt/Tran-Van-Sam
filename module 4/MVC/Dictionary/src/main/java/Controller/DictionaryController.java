package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import repository.DictionaryRepository;
import repository.DictionaryRepositoryImpl;

@Controller
public class DictionaryController {
    @GetMapping("/dictionary")
    public String dictionary(){
        return "/dictionary";
    }
    @PostMapping("/search")
    public  String search(@RequestParam("word") String word, Model model){
        DictionaryRepository dictionaryRepository=new DictionaryRepositoryImpl();
        String result= dictionaryRepository.search(word);
        model.addAttribute("word", word);
        model.addAttribute("result",result);
        return "/result";
    }
}