public class EmployeePayroll {
    static class Employee {
        private String empId;
        private String empName;
        private String department;
        private double baseSalary;
        private String empType;
        private static int totalEmployees = 0;
        private static int empCounter = 1;
        
        // Constructor for full-time employees
        public Employee(String empName, String department, double baseSalary) {
            this.empId = generateEmpId();
            this.empName = empName;
            this.department = department;
            this.baseSalary = baseSalary;
            this.empType = "Full-Time";
            totalEmployees++;
        }
        
        // Constructor for part-time employees
        public Employee(String empName, String department, double hourlyRate, int hours) {
            this.empId = generateEmpId();
            this.empName = empName;
            this.department = department;
            this.baseSalary = hourlyRate * hours;
            this.empType = "Part-Time";
            totalEmployees++;
        }
        
        // Constructor for contract employees
        public Employee(String empName, String department, double fixedAmount, String contractType) {
            this.empId = generateEmpId();
            this.empName = empName;
            this.department = department;
            this.baseSalary = fixedAmount;
            this.empType = "Contract-" + contractType;
            totalEmployees++;
        }
        
        private static String generateEmpId() {
            return String.format("EMP%03d", empCounter++);
        }
        
        // Overloaded calculateSalary methods
        public double calculateSalary() {
            // Full-time: base salary + 10% bonus
            return baseSalary * 1.10;
        }
        
        public double calculateSalary(double hourlyRate, int hours) {
            // Part-time: hourly rate × hours
            return hourlyRate * hours;
        }
        
        public double calculateSalary(double fixedAmount) {
            // Contract: fixed amount
            return fixedAmount;
        }
        
        // Overloaded calculateTax methods
        public double calculateTax() {
            // Full-time: 20% tax
            return calculateSalary() * 0.20;
        }
        
        public double calculateTax(String partTime) {
            // Part-time: 15% tax
            return calculateSalary() * 0.15;
        }
        
        public double calculateTax(double contractRate) {
            // Contract: specific rate
            return calculateSalary() * contractRate;
        }
        
        public void generatePaySlip() {
            double salary = calculateSalary();
            double tax = 0;
            
            switch (empType) {
                case "Full-Time":
                    tax = calculateTax();
                    break;
                case "Part-Time":
                    tax = calculateTax("part-time");
                    break;
                default:
                    tax = calculateTax(0.10); // Default 10% for contract
            }
            
            double netSalary = salary - tax;
            
            System.out.println("╔══════════════════════════════════╗");
            System.out.println("║           PAYSLIP                ║");
            System.out.println("╠══════════════════════════════════╣");
            System.out.println("║ Employee ID: " + empId + "              ║");
            System.out.println("║ Name: " + String.format("%-20s", empName) + "║");
            System.out.println("║ Type: " + String.format("%-20s", empType) + "║");
            System.out.println("║ Department: " + String.format("%-16s", department) + "║");
            System.out.println("║ Gross Salary: $" + String.format("%-10.2f", salary) + "   ║");
            System.out.println("║ Tax: $" + String.format("%-15.2f", tax) + "   ║");
            System.out.println("║ Net Salary: $" + String.format("%-12.2f", netSalary) + "   ║");
            System.out.println("╚══════════════════════════════════╝");
        }
        
        public void displayEmployeeInfo() {
            System.out.println("ID: " + empId + " | Name: " + empName + 
                             " | Dept: " + department + " | Type: " + empType);
        }
        
        public static int getTotalEmployees() {
            return totalEmployees;
        }
        
        public static void generatePayrollReport(Employee[] employees) {
            System.out.println("╔══════════════════════════════════════════════════╗");
            System.out.println("║              COMPANY PAYROLL REPORT              ║");
            System.out.println("╠══════════════════════════════════════════════════╣");
            System.out.println("║ Total Employees: " + String.format("%-30d", totalEmployees) + "║");
            
            double totalSalary = 0;
            double totalTax = 0;
            
            for (Employee emp : employees) {
                double salary = emp.calculateSalary();
                double tax = 0;
                
                switch (emp.empType) {
                    case "Full-Time":
                        tax = emp.calculateTax();
                        break;
                    case "Part-Time":
                        tax = emp.calculateTax("part-time");
                        break;
                    default:
                        tax = emp.calculateTax(0.10);
                }
                
                totalSalary += salary;
                totalTax += tax;
            }
            
            System.out.println("║ Total Gross Salary: $" + String.format("%-24.2f", totalSalary) + "║");
            System.out.println("║ Total Tax: $" + String.format("%-31.2f", totalTax) + "║");
            System.out.println("║ Total Net Salary: $" + String.format("%-28.2f", totalSalary - totalTax) + "║");
            System.out.println("╚══════════════════════════════════════════════════╝");
        }
    }
    
    public static void main(String[] args) {
        // Create different types of employees
        Employee[] employees = {
            new Employee("John Doe", "IT", 5000.0),                    // Full-time
            new Employee("Jane Smith", "HR", 25.0, 80),                // Part-time
            new Employee("Mike Johnson", "Finance", 3000.0, "Monthly") // Contract
        };
        
        System.out.println("=== EMPLOYEE INFORMATION ===");
        for (Employee emp : employees) {
            emp.displayEmployeeInfo();
        }
        
        System.out.println("\n=== INDIVIDUAL PAYSLIPS ===");
        for (Employee emp : employees) {
            emp.generatePaySlip();
            System.out.println();
        }
        
        System.out.println("=== METHOD OVERLOADING DEMONSTRATION ===");
        Employee fullTime = employees[0];
        Employee partTime = employees[1];
        Employee contract = employees[2];
        
        // Demonstrate overloaded methods
        System.out.println("Full-time salary: $" + fullTime.calculateSalary());
        System.out.println("Part-time salary: $" + partTime.calculateSalary(25.0, 80));
        System.out.println("Contract salary: $" + contract.calculateSalary(3000.0));
        
        System.out.println("Full-time tax: $" + fullTime.calculateTax());
        System.out.println("Part-time tax: $" + partTime.calculateTax("part-time"));
        System.out.println("Contract tax: $" + contract.calculateTax(0.10));
        
        System.out.println("\n=== COMPANY PAYROLL REPORT ===");
        Employee.generatePayrollReport(employees);
    }
}