package ua.ithillel;

import ua.ithillel.model.Employee;
import ua.ithillel.service.EmployeeManageService;
import ua.ithillel.util.AppConfig;

public class EmployeeDataBaseMain {
    public static void main(String[] args) {
        AppConfig.initAppConfig();

        EmployeeManageService ems = new EmployeeManageService();
//        for (Employee e : ems.findAll()) {
//            System.out.println(e);
//        }
        Employee employee = ems.get(1L);
        System.out.println(employee);
    }
}
