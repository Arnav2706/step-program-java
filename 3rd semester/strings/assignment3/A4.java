class Subject {
    String subjectCode;
    String subjectName;
    int credits;
    String instructor;

    Subject(String c, String n, int cr, String i) {
        subjectCode = c;
        subjectName = n;
        credits = cr;
        instructor = i;
    }
}

class Student {
    String studentId;
    String studentName;
    String className;
    String[] subjects;
    double[][] marks;
    double gpa;

    static int totalStudents = 0;
    static String schoolName = "Spring High";
    static String[] gradingScale = {"A", "B", "C", "D", "F"};
    static double passPercentage = 40;

    Student(String id, String name, String cls, String[] subs) {
        studentId = id;
        studentName = name;
        className = cls;
        subjects = subs;
        marks = new double[subs.length][3];
        totalStudents++;
    }

    void addMarks(String subject, double mark) {
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i].equals(subject)) {
                for (int j = 0; j < marks[i].length; j++) {
                    if (marks[i][j] == 0) {
                        marks[i][j] = mark;
                        break;
                    }
                }
            }
        }
    }

    void calculateGPA() {
        double sum = 0, c = 0;
        for (int i = 0; i < subjects.length; i++) {
            double avg = (marks[i][0] + marks[i][1] + marks[i][2]) / 3.0;
            sum += avg;
            c++;
        }
        gpa = (sum / c) / 10;
    }

    String grade(double p) {
        if (p >= 85) return "A";
        if (p >= 70) return "B";
        if (p >= 55) return "C";
        if (p >= 40) return "D";
        return "F";
    }

    void generateReportCard() {
        calculateGPA();
        System.out.println("\n" + schoolName + " | " + studentName + " | " + className);
        for (int i = 0; i < subjects.length; i++) {
            double avg = (marks[i][0] + marks[i][1] + marks[i][2]) / 3.0;
            System.out.println(subjects[i] + " " + avg + " Grade: " + grade(avg));
        }
        System.out.println("GPA: " + gpa);
    }

    boolean checkPromotionEligibility() {
        for (int i = 0; i < subjects.length; i++) {
            double avg = (marks[i][0] + marks[i][1] + marks[i][2]) / 3.0;
            if (avg < passPercentage) return false;
        }
        return true;
    }

    static double calculateClassAverage(Student[] students) {
        double s = 0;
        int n = 0;
        for (Student st : students) {
            if (st != null) {
                st.calculateGPA();
                s += st.gpa;
                n++;
            }
        }
        return n == 0 ? 0 : s / n;
    }

    static Student[] getTopPerformers(Student[] students, int count) {
        Student[] a = students.clone();
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] != null && a[i] != null && a[j].gpa > a[i].gpa) {
                    Student t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                }
            }
        }
        Student[] r = new Student[count];
        int k = 0;
        for (Student st : a) {
            if (st != null && k < count) r[k++] = st;
        }
        return r;
    }

    static void setGradingScale(String[] gs) {
        gradingScale = gs;
    }

    static void generateSchoolReport() {
        System.out.println("Total Students: " + totalStudents);
    }
}

public class A4 {
    public static void main(String[] args) {
        String[] subs = {"Math", "Science", "English"};

        Student s1 = new Student("S1", "Ria", "X-A", subs);
        Student s2 = new Student("S2", "Kabir", "X-A", subs);
        Student s3 = new Student("S3", "Meera", "X-A", subs);

        s1.addMarks("Math", 90);
        s1.addMarks("Math", 80);
        s1.addMarks("Math", 85);
        s1.addMarks("Science", 70);
        s1.addMarks("Science", 75);
        s1.addMarks("Science", 72);
        s1.addMarks("English", 88);
        s1.addMarks("English", 85);
        s1.addMarks("English", 90);

        s2.addMarks("Math", 60);
        s2.addMarks("Math", 55);
        s2.addMarks("Math", 65);
        s2.addMarks("Science", 68);
        s2.addMarks("Science", 70);
        s2.addMarks("Science", 66);
        s2.addMarks("English", 58);
        s2.addMarks("English", 60);
        s2.addMarks("English", 62);

        s3.addMarks("Math", 95);
        s3.addMarks("Math", 92);
        s3.addMarks("Math", 94);
        s3.addMarks("Science", 89);
        s3.addMarks("Science", 90);
        s3.addMarks("Science", 88);
        s3.addMarks("English", 91);
        s3.addMarks("English", 93);
        s3.addMarks("English", 92);

        s1.generateReportCard();
        s2.generateReportCard();
        s3.generateReportCard();

        Student[] arr = {s1, s2, s3};
        System.out.println("\nClass Average GPA: " + Student.calculateClassAverage(arr));

        Student[] top = Student.getTopPerformers(arr, 2);
        for (Student t : top) {
            System.out.println("Top Performer: " + t.studentName + " GPA: " + t.gpa);
        }
    }
}
