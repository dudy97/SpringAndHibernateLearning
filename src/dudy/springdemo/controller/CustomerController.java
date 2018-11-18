package dudy.springdemo.controller;

import dudy.springdemo.dao.CustomerDao;
import dudy.springdemo.dao.CustomerDaoImpl;
import dudy.springdemo.entity.Customer;
import dudy.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by admin on 11.11.2018.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService service;
    @GetMapping("/list")
    public String listCustomers(Model model){
        List<Customer> customers = service.getCustomers();
        model.addAttribute("customers", customers);
        return "list-customers";
    }
    @RequestMapping("/showFormForAdd")
    public String formForAdd(Model model){
        Customer theCustomer = new Customer();
        model.addAttribute("customer", theCustomer);
        return "customer-form";
    }
    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam("customerToDeleteId")int theId){
        service.deleteCustomer(theId);
        return "redirect:/customer/list";
    }
    @PostMapping("/saveCustomer")
    public String processForm(@ModelAttribute("customer")Customer theCustomer){
        service.addCustomer(theCustomer);
        return "redirect:/customer/list";
    }
    @GetMapping("/showFormForUpdate")
    public String formForUpdate(@RequestParam("customerId") int theId,
                                Model model){
        Customer customer = service.getCustomer(theId);
        model.addAttribute("customer", customer);
        return "customer-form";
    }

    @PostMapping("/search")
    public String loadCustomerByName(@RequestParam("theSearchName")String theName, Model model){
        List<Customer> selectedCustomers = service.getCustomer(theName);
        model.addAttribute("customers", selectedCustomers);
        return "list-customers";
    }
}
