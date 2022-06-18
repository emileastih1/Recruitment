package com.tasks.coursemanagment.model.entity;

import com.tasks.coursemanagment.common.model.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.util.ObjectUtils;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Setter @Getter
@Entity
@Table(name = "course")
@Where(clause = "deleted <> true")
@SQLDelete(sql = "UPDATE {h-schema} course SET deleted=true WHERE id =?",check = ResultCheckStyle.COUNT)
@NoArgsConstructor
@AllArgsConstructor
public class Course extends BaseEntity {

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "description")
    private String description;
//
    @Column(name = "steps")
    @ElementCollection
    private Set<String> steps;

    //current solution JUST for quick assignment
    /** TODO: should have another table for course_schedule
     * that related to students
     * NOT direct between students and course
     * **/
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "course_student",
            joinColumns = { @JoinColumn(name = "course_id") },
            inverseJoinColumns = { @JoinColumn(name = "student_id") }
    )
    private Set<Student> student;


    @Override
    public boolean equals(Object obj) {
        if(super.equals(obj)) return true;
        if(ObjectUtils.isEmpty(obj)) return false;
        if(!(obj instanceof Course)) return false;
        Course courseObj= (Course) obj;
        return this.getId().equals(courseObj.getId());

    }

}