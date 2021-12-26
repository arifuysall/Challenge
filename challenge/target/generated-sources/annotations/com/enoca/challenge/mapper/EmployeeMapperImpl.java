package com.enoca.challenge.mapper;

import com.enoca.challenge.model.dto.EmployeeDto;
import com.enoca.challenge.model.dto.EmployeeDto.EmployeeDtoBuilder;
import com.enoca.challenge.model.entity.Employee;
import com.enoca.challenge.model.entity.Employee.EmployeeBuilder;
import com.enoca.challenge.model.request.CreateUpdateEmployeeRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-26T16:19:42+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_302 (Amazon.com Inc.)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public Employee createEmployee(CreateUpdateEmployeeRequest request) {
        if ( request == null ) {
            return null;
        }

        EmployeeBuilder employee = Employee.builder();

        employee.name( request.getName() );
        employee.surname( request.getSurname() );
        employee.age( request.getAge() );
        employee.socialSecurityNumber( String.valueOf( request.getSocialSecurityNumber() ) );
        employee.department( request.getDepartment() );
        employee.salary( request.getSalary() );
        employee.workYear( request.getWorkYear() );
        employee.companyId( request.getCompanyId() );

        return employee.build();
    }

    @Override
    public EmployeeDto toEmployeeDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDtoBuilder employeeDto = EmployeeDto.builder();

        if ( employee.getId() != null ) {
            employeeDto.id( employee.getId() );
        }
        employeeDto.name( employee.getName() );
        employeeDto.surname( employee.getSurname() );
        if ( employee.getSocialSecurityNumber() != null ) {
            employeeDto.socialSecurityNumber( Integer.parseInt( employee.getSocialSecurityNumber() ) );
        }
        employeeDto.department( employee.getDepartment() );
        if ( employee.getSalary() != null ) {
            employeeDto.salary( employee.getSalary() );
        }
        if ( employee.getCompanyId() != null ) {
            employeeDto.companyId( employee.getCompanyId() );
        }
        if ( employee.getWorkYear() != null ) {
            employeeDto.workYear( employee.getWorkYear() );
        }

        return employeeDto.build();
    }

    @Override
    public void updateEmployee(Employee employee, CreateUpdateEmployeeRequest request) {
        if ( request == null ) {
            return;
        }

        employee.setName( request.getName() );
        employee.setSurname( request.getSurname() );
        employee.setAge( request.getAge() );
        employee.setSocialSecurityNumber( String.valueOf( request.getSocialSecurityNumber() ) );
        employee.setDepartment( request.getDepartment() );
        employee.setSalary( request.getSalary() );
        employee.setWorkYear( request.getWorkYear() );
        employee.setCompanyId( request.getCompanyId() );
    }

    @Override
    public List<EmployeeDto> toEmployeeDtoList(List<Employee> employees) {
        if ( employees == null ) {
            return null;
        }

        List<EmployeeDto> list = new ArrayList<EmployeeDto>( employees.size() );
        for ( Employee employee : employees ) {
            list.add( toEmployeeDto( employee ) );
        }

        return list;
    }
}
