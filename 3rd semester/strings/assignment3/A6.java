class Employee {
    String empId;
    String empName;
    String department;
    String designation;
    double baseSalary;
    String joinDate;
    boolean[] attendanceRecord;

    Employee(String id, String name, String dept, String desig, double salary, String join) {
        empId = id;
        empName = name;
        department = dept;
        designation = desig;
        baseSalary = salary;
        joinDate = join;
        attendanceRecord = new boolean[30];
    }

    void markAttendance(int day, boolean present) {
        if (day >= 1 && day <= attendanceRecord.length) attendanceRecord[day - 1] = present;
    }

    int getPresentDays() {
        int c = 0;
        for (boolean b : attendanceRecord) if (b) c++;
        return c;
    }

    double calculateSalary(int workingDaysPerMonth) {
        int present = getPresentDays();
        return baseSalary * present / workingDaysPerMonth;
    }
}

class Department {
    String deptId;
    String deptName;
    Employee manager;
    Employee[] employees;
    double budget;

    Department(String id, String name, Employee mgr, int cap, double bud) {
        deptId = id;
        deptName = name;
        manager = mgr;
        employees = new Employee[cap];
        budget = bud;
    }

    void addEmployee(Employee e) {
        for (int i = 0; i < employees.length; i++) if (employees[i] == null) { employees[i] = e; break; }
    }
}

class PayrollSystem {
    static int totalEmployees = 0;
    static String companyName = "TechCorp";
    static double totalSalaryExpense = 0;
    static int workingDaysPerMonth = 22;

    static double calculateCompanyPayroll(Employee[] list) {
        double sum = 0;
        for (Employee e : list) if (e != null) sum += e.calculateSalary(workingDaysPerMonth);
        totalSalaryExpense = sum;
        return sum;
    }
}

public class A6 {
    public static void main(String[] args) {
        Employee e1 = new Employee("E1", "Rohit", "Dev", "Engineer", 50000, "2022-05-01");
        Employee e2 = new Employee("E2", "Sara", "Dev", "Engineer", 45000, "2023-03-15");
        for (int i = 1; i <= 22; i++) { e1.markAttendance(i, i % 2 == 1); e2.markAttendance(i, true); }
        Department d = new Department("D1", "Development", e1, 10, 1000000);
        d.addEmployee(e1);
        d.addEmployee(e2);
        Employee[] all = { e1, e2 };
        double total = PayrollSystem.calculateCompanyPayroll(all);
        System.out.println("Company Payroll: " + total);
        System.out.println(e1.empName + " Salary: " + e1.calculateSalary(PayrollSystem.workingDaysPerMonth));
    }
}
