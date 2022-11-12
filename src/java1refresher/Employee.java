package java1refresher;

import java.text.NumberFormat;

public class Employee extends Person implements Comparable<Employee>, Cloneable {
    private double salary;

    public Employee() {
        super();
        this.salary = 30000;
    }
    public Employee(double salary) {
        super();
        setSalary(salary);
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        if(salary < 0) {
            throw new IllegalArgumentException("Salary must be 0 or greater");
        }
        this.salary = salary;
    }

    @Override
    public String toString(){
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return super.getFirstName() + " earns " + currency.format(this.salary) + " per year.";
    }

    @Override
    public int compareTo(Employee o) {
        return (int)(this.salary - o.salary) * -1;
    }

    public Employee clone() {
        try{
            return (Employee) super.clone();
        } catch(CloneNotSupportedException e){
            throw new RuntimeException(e);
        }
    }
}