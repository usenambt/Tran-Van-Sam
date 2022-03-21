package com.example.phonemanager.controller;

import com.example.phonemanager.model.Phone;
import com.example.phonemanager.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("phones")
public class PhoneController {
    @Autowired
    private PhoneService phoneService;
    @GetMapping("")
    public ResponseEntity<List<Phone>> loadPhone(){
        List<Phone> phoneList=phoneService.selectAllPhone();
        return new ResponseEntity<>(phoneList,HttpStatus.OK);
    }


    @PostMapping("")
    public ResponseEntity<?> savePhone(@Valid @RequestBody Phone phone, BindingResult bindingResult){
        if(bindingResult.hasErrors()){

        }
        phoneService.savePhone(phone);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>deletePhone(@PathVariable int id){
        phoneService.deletePhone(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Phone> editPhone(@PathVariable int id){
        Phone phone=phoneService.findPhoneById(id);
        return new ResponseEntity<>(phone,HttpStatus.OK);
    }


    @PutMapping("update/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable int id, @RequestBody Phone phone){
        Phone currentPhone=phoneService.findPhoneById(id);
        if(currentPhone==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentPhone.setModel(phone.getModel());
        currentPhone.setPrice(phone.getPrice());
        currentPhone.setProducer(phone.getProducer());
        phoneService.savePhone(currentPhone);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}