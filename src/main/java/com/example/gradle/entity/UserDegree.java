package com.example.gradle.entity;

import com.example.gradle.entity.base.BaseString;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "user_degree")
@NoArgsConstructor
@AllArgsConstructor
public class UserDegree extends BaseString {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "user_id")
    private User users;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "type_degree_id", updatable = false, insertable = false)
    private Degree typeDegree;
}
