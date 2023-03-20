package com.example.gradle.entity;

import com.example.gradle.entity.base.BaseString;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Accessors(chain = true)
@Table(name = "department")
@NoArgsConstructor
@AllArgsConstructor
public class Department extends BaseString {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="value")
    private Float value;
}
