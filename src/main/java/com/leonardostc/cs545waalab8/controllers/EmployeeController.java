package com.leonardostc.cs545waalab8.controllers;

import com.leonardostc.cs545waalab8.domain.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/pageForm")
    public String getFormPage(){
        return "/employee/form";
    }

    @PostMapping("/restful")
    public @ResponseBody
    Employee save(@Valid @RequestBody Employee employee){
        return employee;
    }


}
