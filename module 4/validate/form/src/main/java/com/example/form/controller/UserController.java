package com.example.form.controller;

import com.example.form.model.User;
import com.example.form.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@Service
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("")
    public String loadList(Model model){
        model.addAttribute("userList",userService.selectAllUser());
        return "list";
    }
    @GetMapping("/create")
    public String createUser(Model model){
        model.addAttribute("user",new User());
        return "create";
    }
    @PostMapping("/save")
    public String saveUser(@Valid User user, BindingResult bindingResult){
        new User().validate(user,bindingResult);
        if(bindingResult.hasErrors()){
            return "create";
        }
        userService.saveUser(user);
        return "redirect:/user";
    }

}