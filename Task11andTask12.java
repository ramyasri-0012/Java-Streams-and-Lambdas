package Assignment5;

import java.util.*;
import java.util.stream.Collectors;

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
}

public class Task11andTask12 {
    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee(1, "Aman", "IT", 70000, List.of("Java", "Spring")),
                new Employee(2, "Ravi", "HR", 40000, List.of("Recruitment")),
                new Employee(3, "Neha", "IT", 90000, List.of("Java", "Docker")),
                new Employee(4, "Pooja", "Finance", 60000, List.of("Excel", "Accounts")),
                new Employee(5, "Aman", "IT", 70000, List.of("Java", "Spring")));

        List<String> topSkills = employees.stream()
                .filter(e -> e.dept.equals("IT"))
                .filter(e -> e.salary > 60000)
                .flatMap(e -> e.skills.stream())
                .distinct()
                .sorted()
                .limit(3)
                .toList();

        System.out.println("Task 11: Top Skilled High Earners");
        System.out.println(topSkills);

        Map<String, Map<String, Double>> departmentReport = employees.stream()
                .collect(Collectors.groupingBy(
                        e -> e.dept,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> {
                                    double total = list.stream()
                                            .map(emp -> emp.salary)
                                            .reduce(0, Integer::sum);

                                    double count = list.size();
                                    double average = total / count;

                                    Map<String, Double> stats = new HashMap<>();
                                    stats.put("total", total);
                                    stats.put("average", average);
                                    stats.put("count", count);
                                    return stats;
                                })));

        System.out.println("\nTask 12: Department Salary Report");
        System.out.println(departmentReport);
    }
}
