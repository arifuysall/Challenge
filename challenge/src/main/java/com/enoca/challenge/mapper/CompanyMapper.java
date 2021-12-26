package com.enoca.challenge.mapper;

import com.enoca.challenge.model.dto.CompanyDto;
import com.enoca.challenge.model.entity.Company;
import com.enoca.challenge.model.request.CreateUpdateCompanyRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    CompanyMapper COMPANY_MAPPER = Mappers.getMapper(CompanyMapper.class);

    Company createCompany(CreateUpdateCompanyRequest request);

    CompanyDto toCompanyDto(Company company);

    void updateCompany(@MappingTarget Company company, CreateUpdateCompanyRequest request);

    List<CompanyDto> toCompanyDtoList(List<Company> companies);

}
