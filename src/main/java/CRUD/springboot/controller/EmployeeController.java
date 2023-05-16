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

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeEntity> updateEmployee(@RequestBody EmployeeEntity employeeEntity, @PathVariable("id") Long id){

        Optional<EmployeeEntity> employeeEntity1 = Optional.ofNullable(employeeService.findById(id));
        if (employeeEntity1.isPresent()) {
            EmployeeEntity existingEmploy = employeeEntity1.get();

            // Update the properties of the existing Employ
            existingEmploy.setName(employeeEntity.getName());
            existingEmploy.setDate(employeeEntity.getDate());
            existingEmploy.setAddress(employeeEntity.getAddress());
            existingEmploy.setGender(employeeEntity.getGender());
            // Save the updated Employee
            return new ResponseEntity<EmployeeEntity>(employeeService.saveEmployee(existingEmploy), HttpStatus.CREATED) ;
        }
        return new ResponseEntity<EmployeeEntity>(employeeService.updateEmployee(employeeEntity), HttpStatus.CREATED) ;
    }
//
    @GetMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable("id") Long id){
         employeeService.deleteEmployee(id);
    }
}
