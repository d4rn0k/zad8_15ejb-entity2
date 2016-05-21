import pl.jrj.game.IGameRemote;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Grade application Class.
 *
 * @author Konrad Szwedo
 * @version 0.7L
 */
public class Grade {

    static final long SERIALVERSIONUID = 1L;
    /**
     * Course name for query.
     */
    private static String questionedCourseName;

    /**
     * First name of student.
     */
    private static String questionedFirstName;

    /**
     * Last name of student.
     */
    private static String questionedLastName;

    /**
     * Game Remote Bean.
     */
    @EJB
    private static IGameRemote gameRemoteBean;

    /**
     * Main method for Grade app.
     *
     * @param args program arguments array.
     */
    public static void main(String[] args) {
        float answer = 0f;

        try {
            float median;
            int thisStudentMark = 0;
            List<StudentGradeTuple> courseGradesList;
            EntityManager entityManager;

            ((IGameRemote) new InitialContext()
                    .lookup("java:global/" +
                            "ejb-project/GameManager!pl.jrj.game.IGameRemote"))
                    .register(8, "98123");

            entityManager = Persistence
                    .createEntityManagerFactory("myPersistence")
                    .createEntityManager();

            getParamsFromFile(args[0]);
            courseGradesList = getAllGradesForCourse(entityManager);

            for (StudentGradeTuple tuple : courseGradesList) {
                if (questionedFirstName.equals(tuple.getFirstName()) &&
                        questionedLastName.equals(tuple.getLastName())) {
                    thisStudentMark = tuple.getMark();
                }
            }

            median = getMedian(courseGradesList);
            answer = (thisStudentMark - median) / median * 100;
        } catch (Exception exception) {
            answer = 20f;
        } finally {
            System.out.format(Locale.US, "Wynik : %d%%\n", Math.round(answer));
        }
    }

    /**
     * Calculate Median for given list.
     *
     * @param studentGradeTuples input students with grades
     * @return Float Median
     */
    private static float getMedian(List<StudentGradeTuple> studentGradeTuples) {
        float returnedMedian;

        int listSize = studentGradeTuples.size();

        if (listSize % 2 == 0) {
            returnedMedian = studentGradeTuples.get((listSize / 2) - 1)
                    .getMark() +
                    studentGradeTuples.get((listSize / 2)).getMark();
            returnedMedian /= 2;
        } else {
            returnedMedian = studentGradeTuples.get((listSize / 2)).getMark();
        }

        return returnedMedian;
    }

    /**
     * Retrieves tuple list from DB.
     *
     * @param em EntityManager object to performs query.
     * @return students tuple list.
     */
    @SuppressWarnings("unchecked")
    private static List<StudentGradeTuple> getAllGradesForCourse(
            EntityManager em) {
        Query studentsForCourse = em.createQuery("" +
                "SELECT NEW StudentGradeTuple( s.firstName, s.lastName, sc.mark )" +
                "FROM TblStudentCourseEntity sc " +
                "JOIN TblCoursesEntity c ON c.id = sc.studentCourseKey.courseId " +
                "JOIN TblStudentsEntity s ON s.id = sc.studentCourseKey.studentId " +
                "WHERE c.courseName =:questionedCourseName " +
                "ORDER BY sc.mark ASC ");

        studentsForCourse.setParameter("questionedCourseName",
                questionedCourseName);

        return studentsForCourse.getResultList();
    }

    /**
     * Gets course name and student name from file.
     *
     * @param fileName file to open.
     * @throws FileNotFoundException When file not found.
     * @throws ParseException        When parse fail.
     */
    private static void getParamsFromFile(String fileName)
            throws FileNotFoundException, ParseException {

        Scanner scanner = new Scanner(new File(fileName));
        String[] firstAndLastName;

        questionedCourseName = scanner.nextLine();
        firstAndLastName = scanner.nextLine().split("\\s+");

        questionedFirstName = firstAndLastName[0];
        questionedLastName = firstAndLastName[1];
    }
}
