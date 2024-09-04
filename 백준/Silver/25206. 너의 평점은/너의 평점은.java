import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Subject> subjects = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            String line = sc.nextLine().trim();
            subjects.add(new Subject(line)); // line="name score rank"
        }

        double sum = Subject.sum(subjects);
        double length = Subject.length(subjects);

        if (sum == 0 || length == 0) {
            System.out.printf("%.6f", 0.00000);
        } else {
            System.out.printf("%.6f", sum / length);
        }
    }

    static class Subject {
        String name;
        String rank;
        double score;
        double gradePoint;

        public static double sum(List<Subject> subjects) {
            return subjects.stream()
                    .mapToDouble(s -> s.gradePoint >= 0 ? s.score * s.gradePoint : 0)
                    .sum();
        }

        public static double length(List<Subject> subjects) {
            return subjects.stream()
                    .filter(s -> s.gradePoint >= 0)
                    .mapToDouble(s -> s.score)
                    .sum();
        }

        public Subject(String line) {
            String[] parts = line.split(" ");
            this.name = parts[0];
            this.score = Double.parseDouble(parts[1]);
            this.rank = parts[2];
            this.gradePoint = getGradePoint(this.rank);
        }

        private double getGradePoint(String rank) {
            switch (rank) {
                case "A+": return 4.5;
                case "A0": return 4.0;
                case "B+": return 3.5;
                case "B0": return 3.0;
                case "C+": return 2.5;
                case "C0": return 2.0;
                case "D+": return 1.5;
                case "D0": return 1.0;
                case "F" : return 0.0;
                default  : return -1;
            }
        }
    }
}