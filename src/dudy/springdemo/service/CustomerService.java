package dudy.springdemo.service;

import dudy.springdemo.entity.Customer;

import java.util.List;

/**
 * Created by admin on 12.11.2018.
 */
public interface CustomerService {
    public List<Customer> getCustomers();

    void addCustomer(Customer theCustomer);

    Customer getCustomer(int theId);
}
