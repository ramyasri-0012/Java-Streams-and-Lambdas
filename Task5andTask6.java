package Assignment5;

import java.util.List;
import java.util.Set;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Task5andTask6 {
    
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

        @Override
        public String toString() {
            return name + " | " + dept + " | " + salary;
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

        List<Employee> result = employees.stream()
                .sorted(Comparator.comparingInt((Employee e) -> e.salary).reversed())
                .skip(1)
                .limit(2)
                .toList();

        System.out.println("2nd and 3rd Highest Paid Employees:");
        result.forEach(System.out::println);

        Set<String> uniqueSkills = employees.stream()
                .flatMap(e -> e.skills.stream())
                .distinct()
                .collect(Collectors.toSet());

        System.out.println("\nUnique Skills:");
        uniqueSkills.forEach(System.out::println);
    }
}
