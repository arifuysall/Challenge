package com.enoca.challenge.service;


import com.enoca.challenge.model.dto.CompanyDto;
import com.enoca.challenge.model.entity.Company;
import com.enoca.challenge.model.request.CreateUpdateCompanyRequest;
import com.enoca.challenge.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

import static com.enoca.challenge.mapper.CompanyMapper.COMPANY_MAPPER;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository repository;


    public Company getCompanyEntity(int id){
        return repository.findById(id).orElseThrow(()-> new NotFoundException("Company Not Found!"));
    }


    public CompanyDto createCompany(CreateUpdateCompanyRequest request) {
       Company company = COMPANY_MAPPER.createCompany(request);
       Company savedCompany = repository.save(company);
       return COMPANY_MAPPER.toCompanyDto(savedCompany);
    }


    public CompanyDto getCompany(int id) {
        Company company = getCompanyEntity(id);
        return COMPANY_MAPPER.toCompanyDto(company);
    }

    public List<CompanyDto> getCompanies() {
        return COMPANY_MAPPER.toCompanyDtoList(repository.findAll());
    }

    public CompanyDto updateCompany(int id, CreateUpdateCompanyRequest request) {
        Company company = getCompanyEntity(id);
        COMPANY_MAPPER.updateCompany(company,request);
        Company updatedCompany = repository.save(company);
        return COMPANY_MAPPER.toCompanyDto(updatedCompany);
    }

    public void deleteCompany(int id) {
        repository.deleteById(id);

    }
}
