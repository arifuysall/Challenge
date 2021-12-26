package com.enoca.challenge.mapper;

import com.enoca.challenge.model.dto.CompanyDto;
import com.enoca.challenge.model.entity.Company;
import com.enoca.challenge.model.request.CreateUpdateCompanyRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-26T16:19:32+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_302 (Amazon.com Inc.)"
)
@Component
public class CompanyMapperImpl implements CompanyMapper {

    @Override
    public Company createCompany(CreateUpdateCompanyRequest request) {
        if ( request == null ) {
            return null;
        }

        Company company = new Company();

        company.setCompanyName( request.getCompanyName() );

        return company;
    }

    @Override
    public CompanyDto toCompanyDto(Company company) {
        if ( company == null ) {
            return null;
        }

        CompanyDto companyDto = new CompanyDto();

        if ( company.getId() != null ) {
            companyDto.setId( company.getId() );
        }
        companyDto.setCompanyName( company.getCompanyName() );

        return companyDto;
    }

    @Override
    public void updateCompany(Company company, CreateUpdateCompanyRequest request) {
        if ( request == null ) {
            return;
        }

        company.setCompanyName( request.getCompanyName() );
    }

    @Override
    public List<CompanyDto> toCompanyDtoList(List<Company> companies) {
        if ( companies == null ) {
            return null;
        }

        List<CompanyDto> list = new ArrayList<CompanyDto>( companies.size() );
        for ( Company company : companies ) {
            list.add( toCompanyDto( company ) );
        }

        return list;
    }
}
