/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.controller;

import java.util.List;
import lk.ijse.dinemore.dto.OrderDTO;
import lk.ijse.dinemore.observer.Subject;
import lk.ijse.dinemore.proxy.ProxyHandler;
import lk.ijse.dinemore.service.ServiceFactory;
import lk.ijse.dinemore.service.SuperService;
import lk.ijse.dinemore.service.custom.OrderService;

/**
 *
 * @author Ashen Koralage
 */
public class OrderController {

    public static boolean addOrder(OrderDTO odto) throws Exception {
        OrderService orderService = (OrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceType.ORDERS);
        return orderService.addOrder(odto);
    }

    public static boolean deleteOrder(String oid) throws Exception {
        OrderService orderService = (OrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceType.ORDERS);
        return orderService.deleteOrder(oid);
    }

    public static boolean updatestatus(OrderDTO odto) throws Exception {
        OrderService orderService = (OrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceType.ORDERS);
        return orderService.updateStatus(odto);
    }

    public static List<OrderDTO> getAllOrders() throws Exception {
        OrderService orderService = (OrderService) ProxyHandler.getInstance()
                .getService(ServiceFactory.ServiceType.ORDERS);
        return orderService.getAllOrders();
    }

    public static Subject getSubject()throws Exception{
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceType.ORDERS);
    }

    public static boolean reserveOrder(String orderID) throws Exception {
        OrderService orderService = (OrderService) ProxyHandler.getInstance()
                .getService(ServiceFactory.ServiceType.ORDERS);
        return orderService.reserve(orderID);
    }

    public static boolean releaseOrder(String customerID) throws Exception {
        OrderService orderService = (OrderService) ProxyHandler.getInstance()
                .getService(ServiceFactory.ServiceType.ORDERS);
        return orderService.release(customerID);
    }
}
