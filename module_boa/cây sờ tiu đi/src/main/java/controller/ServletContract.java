package controller;

import model.Contract;
import model.Customer;
import model.Employee;
import model.Service;
import service.*;
import sun.security.pkcs11.wrapper.Functions;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ContractServlet", urlPatterns = "/contract")
public class ContractServlet extends HttpServlet {
    ContractService contractService = new ContractServiceImpl();
    ServiceService serviceService = new ServiceServiceImpl();
    CustomerService customerService = new CustomerServiceImpl();
    EmployeeService employeeService = new EmployeeServiceImpl();

    void showContract(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("contractList", contractService.selectAllContract());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/contract/listcontract.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("create")){
            String customerId=request.getParameter("customerid");
            String customerName=customerService.findNameCustomer(customerId);
            Customer customer=new Customer(customerId,customerName);
            String serviceId=request.getParameter("serviceid");
            String serviceName=serviceService.findNameService(serviceId);
            Service service=new Service(serviceId,serviceName);
            int employeeId=Integer.parseInt(request.getParameter("employeeid"));
            String employeeName=employeeService.findNameEmployee(employeeId);
            Employee employee=new Employee(employeeId,employeeName);
            String beginDate=request.getParameter("begindate");
            String finishDate=request.getParameter("finishdate");
            int firstPayment=Integer.parseInt(request.getParameter("firstpayment"));
            int totalPayment=Integer.parseInt(request.getParameter("totalpayment"));
            Contract contract=new Contract(customer,service,employee,beginDate,finishDate,firstPayment,totalPayment);
            contractService.save(contract);
            showContract(request,response);
        } else if (action.equals("edit")){
            int contractId=Integer.parseInt(request.getParameter("contractid"));
            String customerId=request.getParameter("customerid");
            String customerName=customerService.findNameCustomer(customerId);
            Customer customer=new Customer(customerId,customerName);
            String serviceId=request.getParameter("serviceid");
            String serviceName=serviceService.findNameService(serviceId);
            Service service=new Service(serviceId,serviceName);
            int employeeId=Integer.parseInt(request.getParameter("employeeid"));
            String employeeName=employeeService.findNameEmployee(employeeId);
            Employee employee=new Employee(employeeId,employeeName);
            String beginDate=request.getParameter("begindate");
            String finishDate=request.getParameter("finishdate");
            int firstPayment=Integer.parseInt(request.getParameter("firstpayment"));
            int totalPayment=Integer.parseInt(request.getParameter("totalpayment"));
            Contract contract=new Contract(customer,service,employee,beginDate,finishDate,firstPayment,totalPayment);
            contractService.update(contractId,contract);
            showContract(request,response);
        } else if(action.equals("find")){
            String valueFind=request.getParameter("find");
            request.setAttribute("contractListFind",contractService.findContract(valueFind));
            request.setAttribute("valuefind",valueFind);
            showContract(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {

            showContract(request,response);
        } else if (action.equals("create")) {
            request.setAttribute("serviceList", serviceService.selectAllService());
            request.setAttribute("customerList", customerService.selectAllCustomer());
            request.setAttribute("employeeList", employeeService.selectAllemployee());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/contract/addcontract.jsp");
            dispatcher.forward(request, response);
        } else if(action.equals("edit")){
            int contractId=Integer.parseInt(request.getParameter("id"));
            request.setAttribute("serviceList", serviceService.selectAllService());
            request.setAttribute("customerList", customerService.selectAllCustomer());
            request.setAttribute("employeeList", employeeService.selectAllemployee());
            request.setAttribute("contract",contractService.findContractById(contractId));
            RequestDispatcher dispatcher = request.getRequestDispatcher("/contract/editcontract.jsp");
            dispatcher.forward(request, response);
        } else if (action.equals("delete")){
            int contractId=Integer.parseInt(request.getParameter("id")) ;
            contractService.delete(contractId);
            showContract(request,response);
        }

    }
}