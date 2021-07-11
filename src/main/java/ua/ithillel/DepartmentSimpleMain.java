package ua.ithillel;

import ua.ithillel.model.Department;
import ua.ithillel.service.DepartmentManageService;

public class DepartmentSimpleMain {
    public static void main(String[] args) {
        DepartmentManageService dms = new DepartmentManageService();
        Department d1 = new Department("Административный отдел");
        dms.add(d1);
        Department d2 = new Department("Юридический отдел");
        dms.add(d2);
        Department d3 = new Department("Кредитный отдел");
        dms.add(d3);
        Department d4 = new Department("Отдел бухгалтерского учета и отчетности");
        dms.add(d4);
        Department d5 = new Department("Отдел информационных технологий");
        dms.add(d5);
        Department d6 = new Department("Отдел кадров");
        dms.add(d6);

        System.out.println(dms.findAll());
        System.out.println("____________");

        d1.setName("New department");
        dms.update(d1);
        System.out.println(dms.findAll());
        System.out.println("____________");

        dms.delete(d2.getId());
        System.out.println(dms.findAll());
        System.out.println("____________");

    }
}
