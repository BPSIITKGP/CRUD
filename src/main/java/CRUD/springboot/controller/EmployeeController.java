package CRUD.springboot.controller;

import CRUD.springboot.Entity.EmployeeEntity;
import CRUD.springboot.service.EmployeeService;
import CRUD.springboot.service.impl.EmployeeServiceImpl;
import CRUD.springboot.service.impl.EmployeeServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping
    public List<EmployeeEntity> findAllEmployee(){
        return employeeService.findAllEmployee();
    }
//
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeEntity> findEmployeeById(@PathVariable("id") Long id){
        EmployeeEntity employeeEntity = employeeService.findById(id);
        ResponseEntity<EmployeeEntity> responseEntity = new ResponseEntity<>(employeeEntity, HttpStatus.OK);
        return  responseEntity;
    }

    @PostMapping()
    public ResponseEntity<EmployeeEntity> saveEmployee(@RequestBody EmployeeEntity employeeEntity){
        return new ResponseEntity<EmployeeEntity>(employeeService.saveEmployee(employeeEntity), HttpStatus.CREATED) ;
    }

//    @PutMapping
//    public EmployeeEntity updateEmployee(@RequestBody EmployeeEntity employeeEntity){
//        return employeeService.updateEmployee(employeeEntity);
//    }
//
//    @GetMapping("/{id}")
//    public void deleteEmployee(@PathVariable("id") Long id){
//         employeeService.deleteEmployee(id);
//    }
}
