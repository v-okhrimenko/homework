package ua.ithillel.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.ithillel.exception.DepartmentBusinessException;
import ua.ithillel.exception.EmployeeBusinessException;
import ua.ithillel.model.Department;
import ua.ithillel.model.Employee;
import ua.ithillel.model.EmployeeWithDepartment;
import ua.ithillel.service.DepartmentManageService;
import ua.ithillel.service.EmployeeManageService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@WebServlet("/find")
public class FindAllServlet extends HttpServlet {

    static void sort(List<Department> departmentList) {
        departmentList.sort(Comparator.comparing(Department::getId));
        departmentList.sort((o1, o2) -> {
            Long x1 = o1.getId();
            Long x2 = o2.getId();
            int sComp = x1.compareTo(x2);
            if (sComp != 0) {
                return sComp;
            }
            x1 = o1.getId();
            x2 = o2.getId();
            return x1.compareTo(x2);
        });
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeManageService ems = new EmployeeManageService();
        DepartmentManageService dms = new DepartmentManageService();
        List<EmployeeWithDepartment> employeeWithDepartmentList = new ArrayList<>();
        try {
            List<Employee> employeeList = ems.findAll();
            List<Department> departmentList = dms.findAll();
            for (Employee e : employeeList) {
                if (e.getDepartmentId() == null) {
                    e.setDepartmentId(0L);
                }
                String departmentName = departmentList.stream()
                        .filter(d -> d.getId().equals(e.getDepartmentId()))
                        .map(Department::getName)
                        .findAny()
                        .orElse("Отдел отсутствует");


                employeeWithDepartmentList.add(new EmployeeWithDepartment(
                        e.getId(),
                        e.getName(),
                        e.getSalary(),
                        e.getDepartmentId(),
                        e.getChiefId(),
                        departmentName
                ));
            }
            sort(departmentList);
//            employeeWithDepartmentList.sort(Comparator.comparing(EmployeeWithDepartment::getDepartment));
            employeeWithDepartmentList.sort((o1, o2) -> {
                String x1 = o1.getDepartment();
                String x2 = o2.getDepartment();
                int sComp = x1.compareTo(x2);
                if (sComp != 0) {
                    return sComp;
                }
                x1 = o1.getName();
                x2 = o2.getName();
                return x1.compareTo(x2);
            });

            if (req.getParameter("d").equals("employee")) {
                req.setAttribute("employees", employeeWithDepartmentList);
                req.setAttribute("departments", departmentList);
                getServletContext().getRequestDispatcher("/view/findAll/index.jsp").forward(req, resp);
            }
            if (req.getParameter("d").equals("department")) {
                req.setAttribute("department", departmentList);
                getServletContext().getRequestDispatcher("/view/findAll/indexDepartment.jsp").forward(req, resp);
            }

        } catch (EmployeeBusinessException | DepartmentBusinessException e) {
            resp.setContentType("text/html; charset=UTF-8");
            PrintWriter printWriter = resp.getWriter();
            printWriter.println("<html>");
            printWriter.println("<body>");
            printWriter.println(e.getMessage());
            printWriter.println("</body>");
            printWriter.println("</html>");
            printWriter.close();
        }
    }
}
