package ua.ithillel;

import ua.ithillel.model.Department;
import ua.ithillel.service.DepartmentManageService;
import ua.ithillel.util.AppConfig;

public class DepartmentDataBaseMain {
    public static void main(String[] args) {
        AppConfig.initAppConfig();

        DepartmentManageService dms = new DepartmentManageService();
        for (Department e : dms.findAll()) {
            System.out.println(e);
        }
        System.out.println("_______________");
        System.out.println(dms.get(1L));
    }
}
