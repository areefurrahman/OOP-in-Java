class Employee {
    private String employeeID;
    private String employeeName;
    private double basicSalary;

    public Employee(String employeeID, String employeeName, double basicSalary) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.basicSalary = basicSalary;
    }

    public double calculateAnnualSalary(){
        return basicSalary*12;
    }

    public void displayDetails(){
        System.out.println("Employee ID: " + employeeID + "Employee Name: "+ employeeName + " Basic Salary: " + basicSalary + "Annual Salary: " + calculateAnnualSalary());
    }
}

class Manger extends Employee{
    private double bonus;

    public Manger(String employeeID, String employeeName, double basicSalary, double bonus) {
        super(employeeID, employeeName, basicSalary);
        this.bonus = bonus;
    }

    public double calculateAnnualSalary(){
        return (super.calculateAnnualSalary()) + bonus;
    }

    public void displayMangerDetails(){
        displayDetails();
        System.out.println("Bonus: " + bonus);
    }
}

public class Basic_task_1 {
    public static void main(String[] args) {

        Employee emp1 = new Employee("l1f23ddd33", "Ansir Ali", 45000);
        emp1.displayDetails();
        emp1.calculateAnnualSalary();

        Manger mn1 = new Manger("l1f23ddd33", "Ansir Ali", 45000,200);
        mn1.displayDetails();
        mn1.calculateAnnualSalary();
    }
}
