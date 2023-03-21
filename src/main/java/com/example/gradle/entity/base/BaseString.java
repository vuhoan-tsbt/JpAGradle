package com.example.gradle.entity.base;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
@Data
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseString implements Serializable {


    @Column(name = "created_at",updatable = false )
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updateAt;

}
