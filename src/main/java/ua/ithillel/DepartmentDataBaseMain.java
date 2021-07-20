package ua.ithillel;

import ua.ithillel.model.Department;
import ua.ithillel.service.DepartmentManageService;
import ua.ithillel.util.AppConfig;

public class DepartmentDataBaseMain {
    public static void main(String[] args) {
        AppConfig.initAppConfig();

        DepartmentManageService dms = new DepartmentManageService();
//        for (Department e : dms.findAll()) {
//            System.out.println(e);
//        }
//        System.out.println("_______________");
//        System.out.println(dms.get(1L));

        //System.out.println(dms.get(2L));

        System.out.println(dms.add(new Department("new added 1")));
        System.out.println(dms.add(new Department("new added 2")));

        Department department = dms.get(25l);
        Department department2 = new Department();


        //System.out.println("id: " + department.getId());
        //department.setName("nnnnn");
        //dms.update(department);
        dms.delete(1L);
        //System.out.println(dms.findAll());


    }
}
