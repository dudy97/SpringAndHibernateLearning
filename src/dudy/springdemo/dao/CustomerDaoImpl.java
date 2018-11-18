package dudy.springdemo.dao;

import dudy.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * Created by admin on 11.11.2018.
 */
@Repository
public class CustomerDaoImpl implements CustomerDao {
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public List<Customer> getCustomers() {
        Session session = sessionFactory.getCurrentSession();
        Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);
        List<Customer> customers = query.getResultList();
        return customers;
    }

    @Override
    public void addCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int theId) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class,theId);
        return customer;
    }

    @Override
    public void deleteCustomer(int theId) {
        Session session = sessionFactory.getCurrentSession();
        Customer customerToDelete = session.get(Customer.class, theId);
        session.delete(customerToDelete);
    }

    @Override
    public List<Customer> getCustomer(String theName) {
        Session session = sessionFactory.getCurrentSession();
        Query<Customer>query = null;
        if(theName != null && theName.trim().length() > 0) {
            query= session.createQuery("FROM Customer c where c.name LIKE CONCAT('%', :theName, '%')");
            query.setString("theName", theName);
        }
        else{
            query = session.createQuery("from Customer order by lastName", Customer.class);
        }
        List<Customer> list = query.getResultList();
        return list;
    }
}
