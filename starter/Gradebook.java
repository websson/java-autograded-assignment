import java.util.List;
import java.util.Map;

/**
 * A gradebook for one class: student names and their scores out of 100.
 *
 * Fill in every method that throws UnsupportedOperationException. Keep the
 * method names and parameters as they are: the tests call them.
 */
public class Gradebook {

    /** Records a score for a student. Scores outside 0-100 throw IllegalArgumentException. */
    public void addScore(String student, int score) {
        throw new UnsupportedOperationException("TODO");
    }

    /** Every score recorded for the student, in the order they were added; empty if none. */
    public List<Integer> scoresFor(String student) {
        throw new UnsupportedOperationException("TODO");
    }

    /** The student's average score, or 0.0 if they have none. */
    public double average(String student) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * The letter for an average: A from 90, B from 80, C from 70, D from 60,
     * F below 60.
     */
    public static char letter(double average) {
        throw new UnsupportedOperationException("TODO");
    }

    /** Each student's letter grade, by name. */
    public Map<String, Character> report() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * The student with the highest average. Ties go to the name that comes
     * first alphabetically. Throws IllegalStateException if there are no students.
     */
    public String topStudent() {
        throw new UnsupportedOperationException("TODO");
    }
}
