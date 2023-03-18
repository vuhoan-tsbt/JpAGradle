package com.example.gradle.entity;

import com.example.gradle.entity.base.BaseString;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseString {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer id;
    @Column(name = "user_code", length = 12)
    private String userCode;
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "address")
    private String address;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updateAt;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "tax_code")
    private String taxCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return Objects.equals(userCode, that.userCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userCode);
    }

    @Override
    public String toString() {
        return "User{" +
                "userCode=" + userCode + "}";
    }

}
