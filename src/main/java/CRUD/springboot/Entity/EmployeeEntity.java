package CRUD.springboot.Entity;

import jakarta.persistence.*;
import lombok.Data;

import javax.naming.Name;
import java.util.Date;
@Data
@Entity
@Table(name = "mt employee")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp Id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "gender")
    private String gender;
    @Column(name = "address")
    private String address;
    @Column(name = "DOB")
    private Date date;

}
