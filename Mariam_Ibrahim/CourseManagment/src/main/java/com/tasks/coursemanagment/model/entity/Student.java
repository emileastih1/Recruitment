package com.tasks.coursemanagment.model.entity;


import com.tasks.coursemanagment.common.model.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.time.LocalDate;
import java.time.Period;

@Setter @Getter
@Entity
@Table(name = "student")
@Where(clause = "deleted <> true")
@SQLDelete(sql = "UPDATE {h-schema}student SET deleted=true WHERE id =?",check = ResultCheckStyle.COUNT)
@NoArgsConstructor
public class Student extends BaseEntity {

    @Column(name ="name")
    private String name;

    @Column(name = "birth_of_date")
    private LocalDate birthOfDate;

    @Transient
    private int getAge(){
        Period between = Period.between(LocalDate.now(), getBirthOfDate());
        return between.getYears();
    };

}
