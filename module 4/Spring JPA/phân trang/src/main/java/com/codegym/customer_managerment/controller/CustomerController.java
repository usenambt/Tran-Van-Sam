package com.codegym.customer_managerment.controller;

import com.codegym.customer_managerment.model.Customer;
import com.codegym.customer_managerment.model.Province;
import com.codegym.customer_managerment.service.CustomerService;
import com.codegym.customer_managerment.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Autowired
    ProvinceService provinceService;

    @GetMapping("")
    public ModelAndView getCustomerList(@RequestParam(name = "nameCus", required = false,defaultValue = "") String name, @PageableDefault(size = 2) @SortDefault(value = "name", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Customer> customers = customerService.searchByName(name, pageable);
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("customers", customers);
        modelAndView.addObject("nameCus", name);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView getCreatePage(Model model){
        List<Province> provinces = provinceService.findAll();
        model.addAttribute("provinces", provinces);
        return new ModelAndView("create", "customer", new Customer());
    }

    @PostMapping("/create")
    public String saveCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes){
        customerService.saveCustomer(customer);
        redirectAttributes.addFlashAttribute("message", "Create success");
        return "redirect:/";

    }
}
