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
@Table(name = "tbl_students")
public class TblStudentsEntity {
    private int id;
    private String firstName;
    private String lastName;

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
    @Column(name = "firstName")
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return
     */
    @Basic
    @Column(name = "lastName")
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /** Method
     * @param o a
     * @return a
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TblStudentsEntity that = (TblStudentsEntity) o;

        return id == that.id && (firstName != null ?
                firstName.equals(that.firstName) : that.firstName == null &&
                (lastName != null ? lastName.equals(that.lastName) :
                        that.lastName == null));

    }

    /**
     * @return a
     */
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }
}
