//package com.highradius.servlets;
//
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.google.gson.Gson;
//import com.highradius.implementation.InvoiceDao;
//import com.highradius.implementation.InvoiceDaoImpl;
//
//@WebServlet("/Delete-Invoice")
//public class DeleteUserServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    private InvoiceDao invoiceDao;
//    private Gson gson;
//
//    public void init() {
//        invoiceDao = new InvoiceDaoImpl();
//        gson = new Gson();
//    }
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        try {
//            // Retrieve the JSON array of customer order IDs from the request body
//            String requestBody = request.getReader().lines().reduce("", (accumulator, current) -> accumulator + current);
//            int[] customerOrderIds = gson.fromJson(requestBody, int[].class);
//
//            // Perform the delete operation for each customer order ID in the backend
//            for (int customerOrderId : customerOrderIds) {
//                boolean deleted = invoiceDao.deleteInvoice(customerOrderId);
//
//                if (!deleted) {
//                	// Send a response back to the client
//                    response.setContentType("text/plain");
//                    response.getWriter().println("Invoice(s) not deleted");
//                }
//            }
//
//            // Send a response back to the client
//            response.setContentType("text/plain");
//            response.getWriter().println("Invoice(s) deleted successfully");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}