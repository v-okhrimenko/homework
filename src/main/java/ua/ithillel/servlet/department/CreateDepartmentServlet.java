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

@WebServlet("/createDepartment")
public class CreateDepartmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/view/create/addDepartment.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DepartmentManageService dms = new DepartmentManageService();
        try {
            String name = req.getParameter("name");
            if (!name.isEmpty()) {
                Department department = new Department(name);
                dms.add(department);
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
