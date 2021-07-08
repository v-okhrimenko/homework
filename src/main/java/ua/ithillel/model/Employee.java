package ua.ithillel.model;

import lombok.Data;

@Data
public class Employee {
    private Long id;
    private String name;
    private Integer salary;
    private Long departmentId;
    private Long chiefId;

    public Employee() {
    }

    public Employee(String name, Integer salary, Long departmentId, Long chiefId) {
        this.name = name;
        this.salary = salary;
        this.departmentId = departmentId;
        this.chiefId = chiefId;
    }
}
