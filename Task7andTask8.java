package Assignment5;

import java.util.List;

public class Task7andTask8 {

static class Employee {
    int id;
    String name;
    String dept;
    int salary;
    List<String> skills;

    Employee(int id, String name, String dept, int salary, List<String> skills) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        this.skills = skills;
    }
}

public static void main(String[] args) {

        List<Employee> employees = List.of(
            new Employee(1, "Aman", "IT", 70000, List.of("Java", "Spring")),
            new Employee(2, "Ravi", "HR", 40000, List.of("Recruitment")),
            new Employee(3, "Neha", "IT", 90000, List.of("Java", "Docker")),
            new Employee(4, "Pooja", "Finance", 60000, List.of("Excel", "Accounts")),
            new Employee(5, "Aman", "IT", 70000, List.of("Java", "Spring"))
        );

        int totalSalary = employees.stream()
                .map(e -> e.salary)
                .reduce(0, Integer::sum);

        System.out.println("Total Salary: " + totalSalary);

        int sumOfSalaries = employees.stream()
                .map(e -> e.salary)
                .reduce(0, Integer::sum);

        long count = employees.stream().count();

        double averageSalary = (double) sumOfSalaries / count;

        System.out.println("Average Salary: " + averageSalary);
    }
}
