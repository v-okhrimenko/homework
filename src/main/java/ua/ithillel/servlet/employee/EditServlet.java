package ua.ithillel.servlet.employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.ithillel.exception.DepartmentBusinessException;
import ua.ithillel.exception.EmployeeBusinessException;
import ua.ithillel.model.Department;
import ua.ithillel.model.Employee;
import ua.ithillel.service.DepartmentManageService;
import ua.ithillel.service.EmployeeManageService;

import java.io.IOException;
import java.util.Objects;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeManageService ems = new EmployeeManageService();
        DepartmentManageService dms = new DepartmentManageService();

        try {
            long id = Long.parseLong(req.getParameter("id"));
            Employee employee = ems.get(id);

            String depName = dms.findAll().stream().filter(d -> d.getId().equals(employee.getDepartmentId()))
                    .map(Department::getName)
                    .findAny()
                    .orElse("Отдел отсутствует");
//            String depName = dms.findAll().stream().filter(d->d.getId().equals(employee.getDepartmentId())).findFirst().get().getName();
            if (Objects.nonNull(employee)) {
                req.setAttribute("employee", employee);
                req.setAttribute("departmentId", employee);
                req.setAttribute("departmentName", depName);

                getServletContext().getRequestDispatcher("/view/edit/index.jsp").forward(req, resp);
            } else {
                getServletContext().getRequestDispatcher("/view/notfound.jsp").forward(req, resp);
            }
        } catch (EmployeeBusinessException | NumberFormatException | DepartmentBusinessException e) {
            req.setAttribute("message", e.getMessage());
            getServletContext().getRequestDispatcher("/view/error.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeManageService ems = new EmployeeManageService();
        DepartmentManageService dms = new DepartmentManageService();
        try {
            long id = Long.parseLong(req.getParameter("id"));
            String name = req.getParameter("name");
            int salary = Integer.parseInt(req.getParameter("salary"));
//            long departmentId = Long.parseLong(req.getParameter("departmentId"));
            String departmentName = req.getParameter("departmentName");
            long departmentId = dms.findAll().stream().filter(d -> d.getName().equals(departmentName)).findFirst().get().getId();
            String chiefIdParam = req.getParameter("chiefId");
            Long chiefId = null;
            if (Objects.nonNull(chiefIdParam) && chiefIdParam.length() > 0) {
                chiefId = Long.parseLong(chiefIdParam);
            }
            Employee employee = new Employee(id, name, salary, departmentId, chiefId);
            ems.update(employee);
            resp.sendRedirect(req.getContextPath());
        } catch (EmployeeBusinessException | DepartmentBusinessException e) {
            req.setAttribute("message", e.getMessage());
            getServletContext().getRequestDispatcher("/view/error.jsp").forward(req, resp);
        }
    }
}
