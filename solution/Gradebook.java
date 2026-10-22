import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/** Reference solution. Students never see this folder. */
public class Gradebook {

    private final Map<String, List<Integer>> scores = new TreeMap<>();

    public void addScore(String student, int score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("score must be 0-100: " + score);
        }
        scores.computeIfAbsent(student, s -> new ArrayList<>()).add(score);
    }

    public List<Integer> scoresFor(String student) {
        return new ArrayList<>(scores.getOrDefault(student, List.of()));
    }

    public double average(String student) {
        List<Integer> s = scores.getOrDefault(student, List.of());
        return s.isEmpty() ? 0.0 : s.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    public static char letter(double average) {
        if (average >= 90) return 'A';
        if (average >= 80) return 'B';
        if (average >= 70) return 'C';
        if (average >= 60) return 'D';
        return 'F';
    }

    public Map<String, Character> report() {
        Map<String, Character> out = new TreeMap<>();
        for (String student : scores.keySet()) {
            out.put(student, letter(average(student)));
        }
        return out;
    }

    public String topStudent() {
        String best = null;
        for (String student : scores.keySet()) {  // TreeMap: alphabetical, so ties keep the first
            if (best == null || average(student) > average(best)) {
                best = student;
            }
        }
        if (best == null) {
            throw new IllegalStateException("no students");
        }
        return best;
    }
}
