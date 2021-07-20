package ua.ithillel;

import ua.ithillel.exeption.EmployeeBusinessException;
import ua.ithillel.model.Employee;
import ua.ithillel.service.EmployeeManageService;

public class EmployeeSimpleMain {
    public static void main(String[] args) {
        EmployeeManageService ems = new EmployeeManageService();
        try {
            Employee e1 = new Employee("Назаров Максим Давидович", 35000, 1L, null);
            Long e1Id = ems.add(e1);
            Employee e2 = new Employee("Александрова Аиша Игорьевна", 5000, 1L, e1Id);
            Long e2Id = ems.add(e2);
            Employee e3 = new Employee("Кузьмин Артем Богданович", 5500, 1L, e1Id);
            Long e3Id = ems.add(e3);
            Employee e4 = new Employee("Громова Сафия Владимировна", 6000, 1L, e1Id);
            Long e4Id = ems.add(e4);
            Employee e5 = new Employee("Еремин Ярослав Тимурович", 6000, 1L, e1Id);
            Long e5Id = ems.add(e5);
            Employee e6 = new Employee("Баранов Дмитрий Русланович", 5200, 1L, e1Id);
            Long e6Id = ems.add(e6);
            Employee e7 = new Employee("Еремина София Макаровна", 6500, 1L, e1Id);
            Long e7Id = ems.add(e7);
            Employee e8 = new Employee("Волков Станислав Юрьевич", 45000, 2L, null);
            Long e8Id = ems.add(e8);
            Employee e9 = new Employee("Михайлов Филипп Фёдорович", 15500, 2L, e8Id);
            Long e9Id = ems.add(e9);
            Employee e10 = new Employee("Макаров Алексей Родионович", 15000, 2L, e8Id);
            Long e10Id = ems.add(e10);
            Employee e11 = new Employee("Лебедева Анна Михайловна", 20000, 3L, null);
            Long e11Id = ems.add(e11);
            Employee e12 = new Employee("Тарасова Юлия Глебовна", 22000, 3L, e11Id);
            Long e12Id = ems.add(e12);
            Employee e13 = new Employee("Колосова Алиса Константиновна", 18000, 3L, e11Id);
            Long e13Id = ems.add(e13);
            Employee e14 = new Employee("Сафонов Арсений Егорович", 15000, 3L, e11Id);
            Long e14Id = ems.add(e14);
            Employee e15 = new Employee("Ларина Ирина Львовна", 15000, 3L, e11Id);
            Long e15Id = ems.add(e15);
            Employee e16 = new Employee("Пономарева Евгения Данильевна", 15000, 3L, e11Id);
            Long e16Id = ems.add(e16);
            Employee e17 = new Employee("Журавлева Милана Фёдоровна", 14000, 3L, e11Id);
            Long e17Id = ems.add(e17);
            Employee e18 = new Employee("Никифоров Максим Максимович", 14500, 3L, e11Id);
            Long e18Id = ems.add(e18);
            Employee e19 = new Employee("Макаров Алексей Родионович", 15000, 3L, e11Id);
            Long e19Id = ems.add(e19);
            Employee e20 = new Employee("Колесникова Милана Родионовна", 35000, 4L, null);
            Long e20Id = ems.add(e20);
            Employee e21 = new Employee("Куприянова Евгения Даниловна", 12000, 4L, e19Id);
            Long e21Id = ems.add(e21);
            Employee e22 = new Employee("Чистяков Владимир Артёмович", 13000, 4L, e19Id);
            Long e22Id = ems.add(e22);
            Employee e23 = new Employee("Савицкая София Андреевна", 15000, 4L, e19Id);
            Long e23Id = ems.add(e23);
            Employee e24 = new Employee("Борисова Анна Саввична", 37000, 4L, e19Id);
            Long e24Id = ems.add(e24);
            Employee e25 = new Employee("Греков Артём Маркович", 17000, 4L, e19Id);
            Long e25Id = ems.add(e25);

            Employee employee = new Employee("eee", 123, 1L, null);

            ems.add(employee);
            employee.setId(null);
//        e1.setName("TEST");
//        ems.update(e1);
            System.out.println(employee);
            ems.update(employee);
            System.out.println(ems.findAll());
        } catch (EmployeeBusinessException e) {
            e.printStackTrace();
        }

    }
}
