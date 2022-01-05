package controller;

import dao.CustomerDao;
import model.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/")
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/create":
                createCustomer(request, response);
                break;
            case "/update":
                updateCustomer(request,response);
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/new":
                shownewForm(request, response);
                break;
            case "/delete":
                deleteCustomerbyId(request, response);
                break;
            case "/edit":
                showEditForm(request,response);
                break;
            default:
                //mặc định tất cả các action sai ở trên đều sẽ trả về trang list
                listCustomer(request, response);
                break;
        }
        //viết phương thức để lấy dữ liệu trả về trang list:

    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        List<Customer> listCustomer = CustomerDao.getALlCustomer();
        request.setAttribute("listCustomer", listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/index.jsp");
        dispatcher.forward(request, response);
    }

    //viết phương thức delete customer theo id:
    private void deleteCustomerbyId(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idCustomer = Integer.parseInt(request.getParameter("id"));
        CustomerDao.deleteCustomer(idCustomer);
        response.sendRedirect("/");
    }

    //viết phương thức hiển thị trang thêm mới customer:
    private void shownewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/newCustomer.jsp");
        dispatcher.forward(request, response);
    }

    //viết phương thức lưu  customer vào data thông qua doPost:
    private void createCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer checkCustomer = CustomerDao.getCustomer(id);
        if (checkCustomer == null) {
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String mail = request.getParameter("mail");
            Customer newCustomer = new Customer(id, name, phone, mail);
            CustomerDao.addCustomer(newCustomer);
            response.sendRedirect("/");
        } else {
            String message = "This Id is already exits";
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String mail = request.getParameter("mail");
            Customer ExitCustomer = new Customer(id, name, phone, mail);
            request.setAttribute("message", message);
            request.setAttribute("customer", ExitCustomer);
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/newCustomer.jsp");
            dispatcher.forward(request, response);
        }

    }
    //viết phương thức update Customer:
    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String mail = request.getParameter("mail");
        Customer updateCustomer= new Customer(id,name,phone,mail);
        CustomerDao.addCustomer(updateCustomer);
        response.sendRedirect("list");
    }

    //viết phương thức hiển thị trạng thái edit
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        Customer customerEdit=CustomerDao.getCustomer(id);
        request.setAttribute("customer",customerEdit);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/editCustomer.jsp");
        dispatcher.forward(request, response);
    }


}