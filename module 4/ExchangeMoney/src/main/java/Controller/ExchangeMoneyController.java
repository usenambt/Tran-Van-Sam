package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExchangeMoneyController {

    @GetMapping("/exchangemoney")
    public String exchageMoney(){
        return "/exchangemoney";
    }
    @PostMapping("/exchangemoney")
    public String resultExchangeMoney(@RequestParam("rate") Integer rate, @RequestParam("usd") Integer usd, Model model){
        model.addAttribute("result",rate*usd);
        return "/result";
    }
}