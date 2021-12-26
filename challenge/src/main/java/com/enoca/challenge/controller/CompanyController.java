package com.enoca.challenge.controller;

import com.enoca.challenge.model.dto.CompanyDto;
import com.enoca.challenge.model.request.CreateUpdateCompanyRequest;
import com.enoca.challenge.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("companies")
public class CompanyController {
    private final CompanyService service;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompanyDto createCompany(@RequestBody CreateUpdateCompanyRequest request){
        return service.createCompany(request);
    }
    @GetMapping("{id}")
    public CompanyDto getCompany(@PathVariable int id){
        return service.getCompany(id);
    }

    @GetMapping
    public List<CompanyDto> getCompanies(){
        return service.getCompanies();
    }

    @PutMapping("{id}")
    public CompanyDto updateCompany(@PathVariable int id, CreateUpdateCompanyRequest request){
        return service.updateCompany(id,request);

    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCompany(@PathVariable int id){
        service.deleteCompany(id);
    }

}
