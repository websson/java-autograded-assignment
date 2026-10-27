# Gradebook (Java, autograded with JUnit)

Write a small gradebook class: record scores, average them, turn averages into
letter grades and find the top student.

## What you are building

Everything goes in `Gradebook.java`:

1. `addScore(student, score)`: record a score out of 100. Anything outside
   0-100 throws `IllegalArgumentException`.
2. `scoresFor(student)` and `average(student)`: a student's scores in order,
   and their average (0.0 when there are none).
3. `letter(average)`: A from 90, B from 80, C from 70, D from 60, F below.
4. `report()`: every student's letter grade, by name.
5. `topStudent()`: the highest average; ties go to the name that comes first
   alphabetically.

The comments in the file give the exact rules.

## Getting started

Open `Gradebook.java` in your lab and replace each
`throw new UnsupportedOperationException("TODO")` with your code. Press
**Run the tests** as often as you like: the checks fail until the methods
work. They don't cover every case, and the marking tests use other data, so
think about edge cases too. Press **Submit** when you're done.

## How this is marked

| Criterion | Points |
|---|---|
| Scores recorded, copied and range-checked | 25 |
| Averages correct, including students with no scores | 20 |
| Letter bands correct at their edges | 25 |
| Report and top student, including ties | 30 |

---

## For teachers

This repository is an example assignment in the layout
[Uppcoder](https://portal.uppcoder.com/education?utm_source=github&utm_medium=repo&utm_campaign=example-assignment-java)
uses for coding assignments. It is the Java version of
[python-autograded-assignment](https://github.com/websson/python-autograded-assignment).

| Path | What it holds | Who sees it |
|---|---|---|
| `README.md` | The instructions | Students (as ASSIGNMENT.md) |
| `starter/` | The code every student starts from | Students |
| `tests/public/` | JUnit 5 checks students run with "Run the tests" | Teachers and TAs |
| `tests/hidden/` | The JUnit 5 marking tests | Teachers only |
| `solution/` | The reference solution | Teachers only |
| `pom.xml` | Maven build: compiles `starter/`, runs every test in `tests/` | Teachers |
| `.autograder/config.yaml` | How the tests are run and scored | Teachers |

Try it locally with Java 17+ and Maven: `mvn test` fails against the starter,
and `mvn test -Dcode=solution` passes (12 tests).

To use it in a course, copy the repository (keep your copy private, since it
holds the solution and the marking tests) and import its URL into an Uppcoder
course. Each student gets their own copy of the starter in a ready coding lab
in the browser, and every submission is marked by the tests. Uppcoder runs on
its own or inside Moodle, Canvas, Blackboard or Brightspace over LTI 1.3, and works as a
[GitHub Classroom alternative](https://portal.uppcoder.com/github-classroom-alternative?utm_source=github&utm_medium=repo&utm_campaign=example-assignment-java).

The same workflow step by step, with pictures (in Python): [autograde assignments with tests and a rubric in Canvas or Moodle](https://portal.uppcoder.com/guides/autograde-python-canvas-moodle?utm_source=github&utm_medium=repo&utm_campaign=example-assignment-java).

To see a coding lab run inside Moodle without an account, from the teacher's and the student's side: [the Moodle demo](https://demo.uppcoder.com/demo/education-moodle?utm_source=github&utm_medium=repo&utm_campaign=example-assignment-java).

MIT licensed: use it, change it, hand it out.
