package com.example.gradle.dto;

import com.example.gradle.repository.projection.GetUserDetailsDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDetailsDto {
    private Integer id;
    private String fullName;
    private String email;
    private String phone;
    private String dateOfBirth;
    private String address;
    private String taxCode;
    private String userCode;
    private String avatar;
    private String otherDepartment;
    private String otherDivision;
    private String otherPosition;
    private String level;
    private String degree;

    public UserDetailsDto(GetUserDetailsDto detailsDto) {
        this.id = detailsDto.getId();
        this.fullName = detailsDto.getFullName();
        this.email = detailsDto.getEmail();
        this.phone = detailsDto.getPhone();
        this.dateOfBirth = detailsDto.getDateOfBirth();
        this.address = detailsDto.getAddress();
        this.taxCode = detailsDto.getTaxCode();
        this.userCode = detailsDto.getUserCode();
        this.avatar = detailsDto.getAvatar();
        this.otherDepartment = detailsDto.getOtherDepartment();
        this.otherDivision = detailsDto.getOtherDivision();
        this.otherPosition = detailsDto.getOtherPosition();
        this.level = detailsDto.getLevel();
        this.degree = detailsDto.getDegree();
    }
}
