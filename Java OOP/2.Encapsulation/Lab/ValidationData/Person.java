package ValidationData;

import java.text.DecimalFormat;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
    }

    public void setAge(int age) {
        if (age <= 0){
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    public void setFirstName(String firstName) {
        if (firstName.length() < 3){
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() < 3){
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        }
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 460){
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }

    public void increaseSalary(double percentage) {
        double currentSalary;
        if (this.getAge() < 30) {
            currentSalary = this.getSalary() + (this.getSalary() * percentage / 200);
        } else {
            currentSalary = this.getSalary() + (this.getSalary() * percentage / 100);
        }
        this.setSalary(currentSalary);
    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("#.0####");
        return String.format("%s %s gets %s leva", firstName, lastName, formatter.format(salary));
    }
}
