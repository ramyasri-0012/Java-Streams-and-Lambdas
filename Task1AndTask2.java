
package Assignment5;

import java.util.List;

class Employee {
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

    @Override
    public String toString() {
        return name + " | " + dept + " | " + salary;
    }
}

public class Task1AndTask2 {
    public static void main(String[] args) {

        List<Employee> employees = List.of(
            new Employee(1, "Aman", "IT", 70000, List.of("Java", "Spring")),
            new Employee(2, "Ravi", "HR", 40000, List.of("Recruitment")),
            new Employee(3, "Neha", "IT", 90000, List.of("Java", "Docker")),
            new Employee(4, "Pooja", "Finance", 60000, List.of("Excel", "Accounts")),
            new Employee(5, "Aman", "IT", 70000, List.of("Java", "Spring"))
        );

        List<Employee> highSalaryEmployees = employees.stream()
                .filter(e -> e.salary > 60000)
                .toList();

        System.out.println("Employees with salary > 60000:");
        highSalaryEmployees.forEach(System.out::println);

         List<String> names = employees.stream()
                .map(e -> e.name)
                .toList();

        System.out.println("\nEmployee Names:");
        names.forEach(System.out::println);

    }
}
