package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ContractDetailServlet", urlPatterns = "/contractdetail")
public class ContractDetailServlet extends HttpServlet {
    DetailContractService detailContractService=new DetailContractServiceImpl();
    AttachServiceService attachServiceService=new AttachServiceServiceImpl();
    ContractService contractService=new ContractServiceImpl();
    void showDetailContract(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("detailContractList",detailContractService.selectAllDetailContract());
        RequestDispatcher dispatcher=request.getRequestDispatcher("/contractdetail/listcontractdetail.jsp");
        dispatcher.forward(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action =request.getParameter("action");
        if (action.equals("edit")){
            int detailContractId=Integer.parseInt(request.getParameter("detailcontractid")) ;
            String attachServiceId =request.getParameter("attachserviceid");
            AttachService attachService=new AttachService(attachServiceId);
            int contractId=Integer.parseInt(request.getParameter("contractid"));
            Contract contract = new Contract(contractId);
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            DetailContract detailContract = new DetailContract(detailContractId,attachService,contract,quantity);
            detailContractService.updateDetailContract(detailContractId,detailContract);
            showDetailContract(request,response);

        } else if(action.equals("create")){
            String attachServiceId =request.getParameter("attachserviceid");
            AttachService attachService=new AttachService(attachServiceId);
            int contractId=Integer.parseInt(request.getParameter("contractid"));
            Contract contract = new Contract(contractId);
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            DetailContract detailContract = new DetailContract(attachService,contract,quantity);
            detailContractService.saveDetailContract(detailContract);
            showDetailContract(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if(action==null){
            request.setAttribute("detailContractList",detailContractService.selectAllDetailContract());
            RequestDispatcher dispatcher=request.getRequestDispatcher("/contractdetail/listcontractdetail.jsp");
            dispatcher.forward(request,response);
        }else if(action.equals("delete")){
            int detailContractId=Integer.parseInt(request.getParameter("id"));
            detailContractService.removeDetailContract(detailContractId);
            showDetailContract(request,response);
        }else if(action.equals("edit")){
            int detailContractId=Integer.parseInt(request.getParameter("id"));
            request.setAttribute("detailContract",detailContractService.findDetailContractById(detailContractId));
            request.setAttribute("attachService",attachServiceService.selectAllAttachService());
            request.setAttribute("contract",contractService.selectAllContract());
            RequestDispatcher dispatcher=request.getRequestDispatcher("/contractdetail/editcontractdetail.jsp");
            dispatcher.forward(request,response);
        } else if (action.equals("create")){
            request.setAttribute("attachService",attachServiceService.selectAllAttachService());
            request.setAttribute("contract",contractService.selectAllContract());
            RequestDispatcher dispatcher=request.getRequestDispatcher("/contractdetail/addcontractdetail.jsp");
            dispatcher.forward(request,response);
        }
    }
}
