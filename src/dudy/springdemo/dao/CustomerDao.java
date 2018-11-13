package dudy.springdemo.dao;

import dudy.springdemo.entity.Customer;

import java.util.List;

/**
 * Created by admin on 11.11.2018.
 */
public interface CustomerDao {
    public List<Customer> getCustomers();
    void addCustomer(Customer customer);

    Customer getCustomer(int theId);
}
