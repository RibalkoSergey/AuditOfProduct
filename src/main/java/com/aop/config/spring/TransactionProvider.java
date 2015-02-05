package com.aop.config.spring;

import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.util.Assert;

public class TransactionProvider {

    public static enum TransactionManager {
        AOP("aop-transaction-manager");

        private String name;
        TransactionManager(String name) {this.name = name;}
        public String getName() {return name;}
    }

    private TransactionStatus status;
    private HibernateTransactionManager manager;

    public TransactionProvider(TransactionManager transactionManager) {
        Assert.notNull(ApplicationContextProvider.getApplicationContext(), "Application context must be defined.");
        manager = (HibernateTransactionManager) ApplicationContextProvider.getApplicationContext().getBean(transactionManager.getName());
        status = manager.getTransaction(new DefaultTransactionDefinition());
    }

    public TransactionProvider(TransactionManager transactionManager, int transactionIsolationLevel) {
        Assert.notNull(ApplicationContextProvider.getApplicationContext(), "Application context must be defined.");
        manager = (HibernateTransactionManager) ApplicationContextProvider.getApplicationContext().getBean(transactionManager.getName());
        status = manager.getTransaction(new DefaultTransactionDefinition(transactionIsolationLevel));
    }

    public void commit() {
        manager.commit(status);
    }

    public void rollback() {
        manager.rollback(status);
    }

    public Session getSession() {
        return manager.getSessionFactory().getCurrentSession();
    }

    public boolean isCompleted() {
        return status.isCompleted();
    }
}
