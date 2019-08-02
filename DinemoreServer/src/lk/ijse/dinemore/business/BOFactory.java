/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.business;

import lk.ijse.dinemore.business.custom.impl.OrderBOImpl;

/**
 *
 * @author Ashen Koralage
 */
public class BOFactory implements SuperBO{

    public enum BOTypes {
        ORDERS;
    }
    private static BOFactory bOFactory;

    public static BOFactory getInstance() {
        if (bOFactory == null) {
            bOFactory = new BOFactory();
        }
        return bOFactory;
    }

    public SuperBO getBO(BOTypes bOTypes) {
        switch (bOTypes) {
            case ORDERS:
                return (SuperBO) new OrderBOImpl();
            default:
                return null;
        }
    }
}
