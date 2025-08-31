public class Student {
    // Private instance variables
    private String studentId;
    private String name;
    private double grade;
    private String course;
    
    // Default constructor
    public Student() {
        this.studentId = "N/A";
        this.name = "Unknown";
        this.grade = 0.0;
        this.course = "Not enrolled";
    }
    
    // Parameterized constructor
    public Student(String studentId, String name, double grade, String course) {
        this.studentId = studentId;
        this.name = name;
        this.grade = grade;
        this.course = course;
    }
    
    // Getter and setter methods
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public double getGrade() { return grade; }
    public void setGrade(double grade) { this.grade = grade; }
    
    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }
    
    // Calculate letter grade
    public String calculateLetterGrade() {
        if (grade >= 90) return "A";
        else if (grade >= 80) return "B";
        else if (grade >= 70) return "C";
        else if (grade >= 60) return "D";
        else return "F";
    }
    
    // Display student information
    public void displayStudent() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("Grade: " + grade);
        System.out.println("Letter Grade: " + calculateLetterGrade());
    }
    
    public static void main(String[] args) {
        // Create student using default constructor, then set values
        Student student1 = new Student();
        student1.setStudentId("S001");
        student1.setName("John Doe");
        student1.setCourse("Computer Science");
        student1.setGrade(85.5);
        
        // Create student using parameterized constructor
        Student student2 = new Student("S002", "Jane Smith", 92.0, "Mathematics");
        
        // Demonstrate getter methods
        System.out.println("=== Student 1 Details ===");
        System.out.println("ID: " + student1.getStudentId());
        System.out.println("Name: " + student1.getName());
        System.out.println("Course: " + student1.getCourse());
        System.out.println("Grade: " + student1.getGrade());
        
        // Show both students' information
        System.out.println("\n=== Student 1 Complete Info ===");
        student1.displayStudent();
        
        System.out.println("\n=== Student 2 Complete Info ===");
        student2.displayStudent();
        
        // Demonstrate setter methods
        student1.setGrade(78.0);
        student2.setCourse("Physics");
        
        System.out.println("\n=== After Updates ===");
        System.out.println("Student 1 new grade: " + student1.getGrade());
        System.out.println("Student 1 new letter grade: " + student1.calculateLetterGrade());
        System.out.println("Student 2 new course: " + student2.getCourse());
    }
}