/**
 * Auxiliary Class to keep tuple.
 *
 * @author Konrad Szwedo
 * @version 0.7L
 */
public class StudentGradeTuple {

    /**
     * FirstName
     */
    private String firstName;
    /**
     * LastName
     */
    private String lastName;
    /**
     * Mark
     */
    private int mark;

    /**
     * Public constructor.
     *
     * @param first firstName
     * @param last  lastName
     * @param mark  mark
     */
    public StudentGradeTuple(String first, String last, int mark) {
        this.firstName = first;
        this.lastName = last;
        this.mark = mark;
    }

    /**
     * Getter.
     *
     * @return lastName
     */
    String getFirstName() {
        return firstName;
    }


    /**
     * Getter.
     *
     * @return LastName
     */
    String getLastName() {
        return lastName;
    }

    /**
     * @return
     */
    int getMark() {
        return mark;
    }


}
