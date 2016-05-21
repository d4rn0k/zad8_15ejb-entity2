import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * Students ORM Entity.
 *
 * @author Konrad Szwedo
 * @version 0.7L
 */
@Entity
@Table(name = "tbl_courses", schema = "dbo", catalog = "jj")
public class TblCoursesEntity {
    private int id;
    private String courseName;

    /**
     * @return
     */
    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return
     */
    @Basic
    @Column(name = "courseName")
    public String getCourseName() {
        return courseName;
    }

    /**
     * @param courseName
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TblCoursesEntity that = (TblCoursesEntity) o;

        return id == that.id && (courseName != null ?
                courseName.equals(that.courseName) : that.courseName == null);

    }

    /**
     * @return
     */
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (courseName != null ? courseName.hashCode() : 0);
        return result;
    }
}
