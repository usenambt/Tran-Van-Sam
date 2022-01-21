package service;

import common.Check;
import repository.CustomerRepository;
import repository.CustomerRepositoryImpl;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Override
    public List<Customer> selectAllCustomer() {
        return customerRepository.selectAllCustomer();
    }

    @Override
    public String save(Customer customer)  {
        String msg;
        if (!Check.checkIdCustomer(customer.getCustomerId())){
            return msg="Loi ID";
        } else if(!Check.checkEmailException(customer.getEmail())){
            return msg="Loi email";
        } else{
            customerRepository.save(customer);
            return msg="Thanh cong";
        }

    }

    @Override
    public void remove(String customerid) {
        customerRepository.remove(customerid);
    }

    @Override
    public Customer findCustomerById(String customerId) {
        return customerRepository.findCustomerById(customerId);
    }

    @Override
    public void update(String customerId, Customer customer) {

        customerRepository.update(customerId,customer);
    }

    @Override
    public String findNameCustomer(String customerId) {
        return customerRepository.findNameCustomer(customerId);
    }

    @Override
    public int getLastCustomerId() {
        return customerRepository.getLastCustomerId();
    }
}