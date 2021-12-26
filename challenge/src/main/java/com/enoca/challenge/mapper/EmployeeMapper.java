package com.enoca.challenge.mapper;

import com.enoca.challenge.model.dto.EmployeeDto;
import com.enoca.challenge.model.entity.Employee;
import com.enoca.challenge.model.request.CreateUpdateEmployeeRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeMapper EMPLOYEE_MAPPER = Mappers.getMapper(EmployeeMapper.class);

    Employee createEmployee(CreateUpdateEmployeeRequest request);

    EmployeeDto toEmployeeDto(Employee employee);

    void updateEmployee(@MappingTarget Employee employee, CreateUpdateEmployeeRequest request);

    List<EmployeeDto> toEmployeeDtoList(List<Employee> employees);


}
