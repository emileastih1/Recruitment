package com.tasks.coursemanagment.model.entity;


import com.tasks.coursemanagment.common.model.entity.BaseEntity;

//TODO : not used
/*@Setter @Getter
@Entity
@Table(name = "course_schedule")
@Where(clause = "deleted <> true")
@SQLDelete(sql = "UPDATE {h-schema} course_schedule SET deleted=true WHERE id =?",check = ResultCheckStyle.COUNT)
@NoArgsConstructor
@AllArgsConstructor*/
public class CourseSchedule extends BaseEntity {
    /*private LocalDateTime startAt;
    private LocalDateTime endAt;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private UserProfile instractor;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "course_student",
            joinColumns = { @JoinColumn(name = "course_schedule_id") },
            inverseJoinColumns = { @JoinColumn(name = "student_id") }
    )
    private Set<Student> student;*/

}
