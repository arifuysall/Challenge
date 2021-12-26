package com.enoca.challenge.service;


import com.enoca.challenge.model.dto.EmployeeDto;
import com.enoca.challenge.model.entity.Employee;
import com.enoca.challenge.model.request.CreateUpdateEmployeeRequest;
import com.enoca.challenge.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

import static com.enoca.challenge.mapper.EmployeeMapper.EMPLOYEE_MAPPER;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository repository;

    public Employee getEmployeeEntity(int id){
        return repository.findById(id).orElseThrow(()->new NotFoundException("Employee Not Found!"));

    }

    public EmployeeDto createEmployee(CreateUpdateEmployeeRequest request) {
        Employee employee = EMPLOYEE_MAPPER.createEmployee(request);
        Employee savedEmployee = repository.save(employee);
        return EMPLOYEE_MAPPER.toEmployeeDto(savedEmployee);
    }


    public EmployeeDto getEmployee(int id) {
        Employee employee = getEmployeeEntity(id);
        return EMPLOYEE_MAPPER.toEmployeeDto(employee);
    }

    public List<EmployeeDto> getEmployees() {
        return EMPLOYEE_MAPPER.toEmployeeDtoList(repository.findAll());

    }

    public EmployeeDto updateEmployee(int id, CreateUpdateEmployeeRequest request) {
        Employee employee = getEmployeeEntity(id);
        EMPLOYEE_MAPPER.updateEmployee(employee,request);
        Employee updatedEmployee = repository.save(employee);
        return EMPLOYEE_MAPPER.toEmployeeDto(updatedEmployee);
    }

    public void deleteEmployee(int id) {
        repository.deleteById(id);
    }


    public Double raiseForYear(double salary, int age, int years) {
        double raisedSalaryPlusAge;
        for ( int i = 0; i < years ; i ++){
           salary += salary*0.1;
            if ( age >= 20 && age <= 25){
                raisedSalaryPlusAge = salary*0.1;
                salary += raisedSalaryPlusAge;
            }
            else if ( age >= 26 && age <= 30){
                raisedSalaryPlusAge = salary*0.08;
                salary += raisedSalaryPlusAge;
            }
            else if ( age >= 31 && age <= 36){
                raisedSalaryPlusAge = salary*0.05;
                salary += raisedSalaryPlusAge;
            }
            else if ( age > 36){
                raisedSalaryPlusAge = salary*0.03;
                salary += raisedSalaryPlusAge;
            }
            age++;
        }

        return salary;
    }
}
