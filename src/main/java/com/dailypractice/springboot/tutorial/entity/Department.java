package com.dailypractice.springboot.tutorial.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;
    
    @NotBlank(message = "Please Add DepartmentName")
    /*@Length(max=5, min=1)
    @Size(max = 10, min =0)
    @Email
    @Positive*/

    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

}
