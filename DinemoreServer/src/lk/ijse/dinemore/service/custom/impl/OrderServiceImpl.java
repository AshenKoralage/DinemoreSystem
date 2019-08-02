/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.service.custom.impl;

import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.dinemore.business.BOFactory;
import lk.ijse.dinemore.business.custom.OrderBO;
import lk.ijse.dinemore.dto.OrderDTO;
import lk.ijse.dinemore.observer.Observer;
import lk.ijse.dinemore.observer.Subject;
import lk.ijse.dinemore.reservation.impl.ReservationImpl;

/**
 *
 * @author Ashen Koralage
 */
public class OrderServiceImpl extends UnicastRemoteObject implements lk.ijse.dinemore.service.custom.OrderService, Subject {

    private OrderBO orderBO;
    private static ArrayList<Observer> alObservers = new ArrayList<>();
    private static ReservationImpl<OrderServiceImpl> cusResBook = new ReservationImpl<>();

    public OrderServiceImpl() throws Exception {
        orderBO = (OrderBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ORDERS);
    }

    @Override
    public boolean addOrder(OrderDTO orderDTO) throws Exception {
        boolean addOrder = orderBO.addOrder(orderDTO);
        notifyObservers();
        return addOrder;
    }

    @Override
    public boolean deleteOrder(String oid) throws Exception {
        boolean deleteOrder = orderBO.deleteOrder(oid);
        notifyObservers();
        return deleteOrder;
    }

    @Override
    public OrderDTO searchOrder(String oid) throws Exception {
        return orderBO.searchOrder(oid);
    }

    @Override
    public boolean updateStatus(OrderDTO orderDTO) throws Exception {
        boolean updateStatus=orderBO.updateStatus(orderDTO);
        notifyObservers();
        return updateStatus;
    }

    @Override
    public List<OrderDTO> getAllOrders() throws Exception {
         return orderBO.getAllOrders();
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        return cusResBook.reserve(id, this);
    }

    @Override
    public boolean release(Object id) throws Exception {
         return cusResBook.relese(id);
    }

    @Override
    public void registerObserver(Observer observer) throws Exception {
         alObservers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) throws Exception {
         alObservers.remove(observer);
    }

    @Override
    public void notifyObservers() throws Exception {
       new Thread(()->{
           for (Observer observer : alObservers) {
               try {
                   observer.updateObservers();
               } catch (Exception e) {
                   Logger.getLogger(OrderServiceImpl.class.getName()).log(Level.SEVERE, null, e);
               }
           }
       }).start();
    }

}
