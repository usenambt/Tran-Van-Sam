package dao;

import model.Customer;

import java.util.*;


public class CustomerDao {
    private static final Map<Integer, Customer> listCUSTOMER = new HashMap<Integer,Customer>();
    static {
        initCustomer();
    }

    private static void initCustomer() {
        Customer cus1 = new Customer(1, "Tran Sam", "0990400718", "transamxy@gmail.com");
        Customer cus2 = new Customer(2, "Tran Quy", "0906471343", "tranquyxy@gmail.com");
        Customer cus3 = new Customer(3, "Tran Ty", "0909090933", "trantyxy@gmail.com");
        Customer cus4 = new Customer(4, "oc cho4", "0905678903", "asdhaifa444@gmail.com");
        listCUSTOMER.put(cus1.getId(), cus1);
        listCUSTOMER.put(cus2.getId(), cus2);
        listCUSTOMER.put(cus3.getId(), cus3);
        listCUSTOMER.put(cus4.getId(), cus4);
    }

    //viết phương thức xử lý get thông tin chi tiết của 1 customer theo id
    public static Customer getCustomer(int customerId) {
        return listCUSTOMER.get(customerId);

    }

    //viết phương thức thêm mới 1 customer:
    public static void addCustomer(Customer customer) {

        listCUSTOMER.put(customer.getId(),customer);
    }

    //Viết phương thức update thông tin 1 customer theo id:
    public static Customer updateCustomder (Customer customer){
        listCUSTOMER.put(customer.getId(), customer);
        return customer;
    }
    //viết phương thức xóa 1 customer theo id:
    public static void deleteCustomer(int customerId){
        listCUSTOMER.remove(customerId);
    }

    //viết phương thức lấy tất cả các customer:
    public static List<Customer> getALlCustomer() {
        Collection<Customer> c=listCUSTOMER.values();
        List<Customer> list=new ArrayList<Customer>();
        list.addAll(c);
        return list;
    }
}

