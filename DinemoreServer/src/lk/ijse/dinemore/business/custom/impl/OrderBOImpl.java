/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.business.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.dinemore.business.custom.OrderBO;
import lk.ijse.dinemore.dto.OrderDTO;
import lk.ijse.dinemore.entity.Orders;
import lk.ijse.dinemore.entity.Orders;
import lk.ijse.dinemore.repository.RepositoryFactory;
import lk.ijse.dinemore.repository.custom.OrderRepository;
import lk.ijse.dinemore.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Ashen Koralage
 */
public class OrderBOImpl implements OrderBO {

    private OrderRepository orderRepository;

    public OrderBOImpl() {
        orderRepository = (OrderRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.ORDERS);
    }

    @Override
    public boolean addOrder(OrderDTO orderDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            orderRepository.setSesstion(session);
            session.beginTransaction();
            Orders order = new Orders(
                    orderDTO.getOrderID(),
                    orderDTO.getReceptionID(),
                    orderDTO.getDate(),
                    orderDTO.getTime(),
                    orderDTO.getCustomerName(),
                    orderDTO.getTp(),
                    orderDTO.getQty()
            );

            boolean result = orderRepository.save(order);
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public boolean deleteOrder(String oid) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            orderRepository.setSesstion(session);
            session.beginTransaction();
            Orders order = orderRepository.findByID(oid);
            boolean result = false;
            if (order != null) {
                result = orderRepository.delete(order);
            }
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public OrderDTO searchOrder(String oid) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateStatus(OrderDTO orderDTO) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OrderDTO> getAllOrders() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            orderRepository.setSesstion(session);
            session.beginTransaction();
            List<Orders> orders = orderRepository.findAll();
            session.getTransaction().commit();
            if (orders != null) {
                System.out.println("Not Null");
                List<OrderDTO> alOrders = new ArrayList<>();
                  for (Orders order : orders) {
                    OrderDTO orderDTO = new OrderDTO(
                           order.getOrderId(),
                            order.getReceptionID(),
                            order.getDate(),
                            order.getQty(),
                            order.getTime(),
                            order.getCustomerName(),
                            order.getTp()
                    );
                    
                    System.out.println("Hello :"+order.getOrderId());
                    alOrders.add(orderDTO);
                }
                return alOrders;
            } else {
                return null;
            }
        }
    }

}
