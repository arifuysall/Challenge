package com.enoca.challenge.controller;

import com.enoca.challenge.model.dto.EmployeeDto;
import com.enoca.challenge.model.request.CreateUpdateEmployeeRequest;
import com.enoca.challenge.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("employees")
public class EmployeeController {
    private final EmployeeService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDto createEmployee(@RequestBody CreateUpdateEmployeeRequest request){
        return service.createEmployee(request);
    }

    @GetMapping("{id}")
    public EmployeeDto getEmployee(@PathVariable int id){
        return service.getEmployee(id);
    }

    @GetMapping
    public List<EmployeeDto> getEmployees(){
        return service.getEmployees();
    }
    @PutMapping("{id}")
    public EmployeeDto updateEmployee(@PathVariable int id, @RequestBody CreateUpdateEmployeeRequest request){
        return service.updateEmployee(id,request);
    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable int id){
       service.deleteEmployee(id);
    }

    @GetMapping("/salaryCalculator")
    public Double raiseForYear(double salary, int age, int years){
        return service.raiseForYear(salary,age,years);
    }
}
