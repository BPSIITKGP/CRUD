package CRUD.springboot.service.impl;

import CRUD.springboot.Entity.EmployeeEntity;
import CRUD.springboot.exception.ResourceNotFoundException;
import CRUD.springboot.repository.EmployeeRepository;
import CRUD.springboot.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeEntity> findAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeEntity findById(Long id) {
        Optional<EmployeeEntity> emp = employeeRepository.findById(id);
        if(emp.isPresent()) return (emp.get());
        else{
           throw new ResourceNotFoundException();
        }
    }

    @Override
    public EmployeeEntity saveEmployee(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }

    @Override
    public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
