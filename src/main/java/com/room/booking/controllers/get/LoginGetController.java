package com.room.booking.controllers.get;

import com.room.booking.controllers.Controller;
import com.room.booking.domain.Employee;
import com.room.booking.domain.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

/**
 * Created by Alexey on 19.07.2017.
 */
public class LoginGetController implements Controller {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        Employee admin = (Employee) session.getAttribute("admin");
        if(Objects.nonNull(admin) && admin.getRole()== Role.ADMIN){
            try {
                response.sendRedirect("/admin.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Employee employee = (Employee) session.getAttribute("employee");
        if(Objects.nonNull(employee) && admin.getRole()== Role.USER){
            try {
                response.sendRedirect("/roombooking.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            response.sendRedirect("/login.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
