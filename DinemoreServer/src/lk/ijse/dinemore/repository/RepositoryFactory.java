/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.repository;

import lk.ijse.dinemore.repository.custom.impl.OrderRepositoryImpl;

/**
 *
 * @author Ashen Koralage
 */
public class RepositoryFactory {

    public enum RepositoryTypes {
        ORDERS;
    }
    public static RepositoryFactory repositoryFactory;

    public RepositoryFactory() {
    }

    public static RepositoryFactory getInstance() {
        if (repositoryFactory == null) {
            repositoryFactory = new RepositoryFactory();
        }
        return repositoryFactory;
    }

    public SuperRepository getRepository(RepositoryTypes repositoryTypes) {

        switch (repositoryTypes) {
            case ORDERS:
                return (SuperRepository) new OrderRepositoryImpl();
            default:
                return null;
        }
    }

}
