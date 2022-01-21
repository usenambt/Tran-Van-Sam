package repository;

import java.util.List;

public interface CustomerRepository {
    List<Customer> selectAllCustomer();
    void save (Customer customer);
    void remove(String customerid);
    Customer findCustomerById(String customerId);
    void update(String customerId, Customer customer);
    String findNameCustomer(String customerId);
    int getLastCustomerId ();

}
}
