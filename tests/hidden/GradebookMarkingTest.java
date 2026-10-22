import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

/** Marking tests. Students never see them; TAs do not either. */
class GradebookMarkingTest {

    @Test
    void unknownStudentHasNoScoresAndAZeroAverage() {
        Gradebook g = new Gradebook();
        assertEquals(List.of(), g.scoresFor("Nobody"));
        assertEquals(0.0, g.average("Nobody"), 1e-9);
    }

    @Test
    void bandEdgesBelongToTheHigherLetter() {
        assertEquals('A', Gradebook.letter(90));
        assertEquals('C', Gradebook.letter(70));
        assertEquals('D', Gradebook.letter(60));
        assertEquals('F', Gradebook.letter(59.99));
    }

    @Test
    void zeroAndHundredAreAllowed() {
        Gradebook g = new Gradebook();
        g.addScore("Ana", 0);
        g.addScore("Ana", 100);
        assertEquals(50.0, g.average("Ana"), 1e-9);
        assertThrows(IllegalArgumentException.class, () -> g.addScore("Ana", -1));
    }

    @Test
    void reportGivesEveryStudentALetter() {
        Gradebook g = new Gradebook();
        g.addScore("Ana", 92);
        g.addScore("Ben", 75);
        g.addScore("Cy", 50);
        assertEquals(Map.of("Ana", 'A', "Ben", 'C', "Cy", 'F'), g.report());
    }

    @Test
    void tiesGoToTheFirstNameAlphabetically() {
        Gradebook g = new Gradebook();
        g.addScore("Zoe", 90);
        g.addScore("Ana", 90);
        assertEquals("Ana", g.topStudent());
    }

    @Test
    void noStudentsMeansNoTopStudent() {
        assertThrows(IllegalStateException.class, () -> new Gradebook().topStudent());
    }

    @Test
    void scoresForReturnsACopy() {
        Gradebook g = new Gradebook();
        g.addScore("Ana", 80);
        try {
            g.scoresFor("Ana").add(5);
        } catch (UnsupportedOperationException ignored) {
            // an unmodifiable list is fine too
        }
        assertEquals(List.of(80), g.scoresFor("Ana"));
    }
}
