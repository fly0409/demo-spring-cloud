package com.iisi.demospringcloud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "EMPLOYEE")
@Accessors(chain = true)
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;

    @Column(name = "EMP_NAME", length = 100, nullable = false)
    private String empName;

    @Column(name = "DB_NUM", length = 100, nullable = false)
    private String dbNum;
}
