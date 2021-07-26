package ua.ithillel.servlet.department;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.ithillel.exception.DepartmentBusinessException;
import ua.ithillel.model.Department;
import ua.ithillel.service.DepartmentManageService;

import java.io.IOException;
import java.util.Objects;

@WebServlet("/editDepartment")
public class EditDepartmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DepartmentManageService dms = new DepartmentManageService();
        try {
            long id = Long.parseLong(req.getParameter("id"));
            Department department = dms.get(id);
            if (Objects.nonNull(department)) {
                req.setAttribute("department", department);
                getServletContext().getRequestDispatcher("/view/edit/indexDepartment.jsp").forward(req, resp);
            } else {
                getServletContext().getRequestDispatcher("/view/notfound.jsp").forward(req, resp);
            }
        } catch (DepartmentBusinessException | NumberFormatException e) {
            req.setAttribute("message", e.getMessage());
            getServletContext().getRequestDispatcher("/view/error.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DepartmentManageService dms = new DepartmentManageService();
        try {
            long id = Long.parseLong(req.getParameter("id"));
            String name = req.getParameter("name");
            if (!name.isEmpty()) {
                Department department = new Department(name);
                department.setId(id);
                dms.update(department);
                resp.sendRedirect(req.getContextPath() + "/find?d=department");
            } else {
                throw new DepartmentBusinessException("Имя отдела не может быть пустым");
            }

        } catch (DepartmentBusinessException e) {
            req.setAttribute("message", e.getMessage());
            getServletContext().getRequestDispatcher("/view/error.jsp").forward(req, resp);
        }
    }
}
