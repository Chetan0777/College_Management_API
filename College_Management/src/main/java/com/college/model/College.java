package com.college.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
@Table(name = "colleges")
public class College {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int collegeId;

    @NotBlank(message = "College name is required!")
    private String collegeName;

    @NotBlank(message = "Course name is required!")
    private String courseName;

    @NotBlank(message = "Course duration is required!")
    private String duration;
    
    @NotBlank(message = "Accommodation type is required!")
    private String type;

    @PositiveOrZero(message = "Accommodation fee must be a positive value or zero")
    private int accommodationFee;

    @OneToOne(mappedBy = "college", cascade = CascadeType.ALL)
    private CourseFee courseFee;

    public void setCourseFee(CourseFee courseFee) {
        this.courseFee = courseFee;
        courseFee.setCollege(this);
    }

}
