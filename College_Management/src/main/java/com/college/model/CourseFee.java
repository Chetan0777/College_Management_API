package com.college.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
@Table(name = "course_fees")
public class CourseFee {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseFeeId;

    @PositiveOrZero(message = "Course fee must be a positive value or zero")
    private int courseFee;

    @OneToOne
    @JoinColumn(name = "college_id")
    private College college;
	
    public CourseFee(int courseFee) {
        this.courseFee = courseFee;
    }
    
    public void setCollege(College college) {
        this.college = college;
    }
    
}
