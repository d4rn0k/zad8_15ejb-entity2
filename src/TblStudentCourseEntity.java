
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.EmbeddedId;

import java.io.Serializable;

/**
 * Students ORM Entity.
 *
 * @author Konrad Szwedo
 * @version 0.7L
 */

@Embeddable
class StudentCoursePK implements Serializable {

    static final long serialVersionUID = 1L;
    private int courseId;
    private int studentId;

    /**
     * @return
     */
    @Basic
    @Column(name = "studentId", nullable = false)
    public int getStudentId() {
        return studentId;
    }

    /**
     * @param studentId
     */
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    /**
     * @return
     */
    @Basic
    @Column(name = "courseId", nullable = false)
    public int getCourseId() {
        return courseId;
    }

    /**
     * @param courseId
     */
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }


}

/**
 * Students ORM Entity.
 *
 * @author Konrad Szwedo
 * @version 0.7L
 */
@Entity
@Table(name = "tbl_student_course", schema = "dbo", catalog = "jj")
public class TblStudentCourseEntity {
    private int mark;

    @EmbeddedId
    private StudentCoursePK studentCourseKey;

//    public StudentCoursePK getStudentCourseKey() {
//        return studentCourseKey;
//    }
//
//    /**
//     * @param studentCourse
//     */
//    public void setStudentCourseKey(StudentCoursePK studentCourse) {
//        this.studentCourseKey = studentCourse;
//    }

    /**
     * @return
     */
    @Basic
    @Column(name = "mark")
    public int getMark() {
        return mark;
    }

    /**
     * @param mark
     */
    public void setMark(int mark) {
        this.mark = mark;
    }

    /**
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TblStudentCourseEntity that = (TblStudentCourseEntity) o;

        return mark == that.mark;

    }

    /**
     * @return
     */
    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + mark;
        return result;
    }


}
