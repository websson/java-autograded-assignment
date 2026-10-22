import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

/** Tests students run with "Run the tests". The marking tests check the same ideas with other data. */
class GradebookTest {

    @Test
    void recordsScoresInOrder() {
        Gradebook g = new Gradebook();
        g.addScore("Ana", 80);
        g.addScore("Ana", 90);
        assertEquals(List.of(80, 90), g.scoresFor("Ana"));
    }

    @Test
    void averagesScores() {
        Gradebook g = new Gradebook();
        g.addScore("Ana", 80);
        g.addScore("Ana", 91);
        assertEquals(85.5, g.average("Ana"), 1e-9);
    }

    @Test
    void lettersFollowTheBands() {
        assertEquals('A', Gradebook.letter(95));
        assertEquals('B', Gradebook.letter(85));
        assertEquals('F', Gradebook.letter(40));
    }

    @Test
    void rejectsScoresOutOfRange() {
        Gradebook g = new Gradebook();
        assertThrows(IllegalArgumentException.class, () -> g.addScore("Ana", 101));
    }

    @Test
    void findsTheTopStudent() {
        Gradebook g = new Gradebook();
        g.addScore("Ana", 70);
        g.addScore("Ben", 88);
        assertEquals("Ben", g.topStudent());
    }
}
