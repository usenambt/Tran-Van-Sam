package repository;

import model.CustomerType;
import service.CustomerTypeService;
import service.CustomerTypeServiceImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    CustomerTypeService customerTypeService = new CustomerTypeServiceImpl();

    @Override
    public List<Customer> selectAllCustomer() {
        List<Customer> customerList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try (Connection connection = DBConnection.getConnection()) {
            preparedStatement = connection.prepareStatement("select customers.*,customertype.CustomerTypeName from customers inner join customertype on customers.CustomerTypeId=customertype.CustomerTypeId");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String customerId = resultSet.getString("customerid");
                String customerName = resultSet.getString("customername");
                String birthday = resultSet.getString("birthday");
                String idCard = resultSet.getString("idcard");
                String phoneNumber = resultSet.getString("phonenumber");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String customerTypeId = resultSet.getString("customertypeid");
                String customerTypeName = resultSet.getString("customertypename");
                CustomerType customerType = new CustomerType(customerTypeId,customerTypeName);
                Customer customer = new Customer(customerId, customerName, birthday, idCard, phoneNumber, email, customerType, address);
                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.getMessage();
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
            } catch (SQLException e) {
                e.getMessage();
            }
            DBConnection.close();
        }
        return customerList;
    }

    @Override
    public void save(Customer customer) {
        PreparedStatement preparedStatement = null;
        try (Connection connection = DBConnection.getConnection()) {
            preparedStatement = connection.prepareStatement("insert into customers(customerid,customername,birthday,idcard,phonenumber,email,customertypeid,address) values (?,?,?,?,?,?,?,?)");

            preparedStatement.setString(1, customer.getCustomerId());
            preparedStatement.setString(2, customer.getCustomerName());
            preparedStatement.setString(3, customer.getBirthday());
            preparedStatement.setString(4, customer.getIdCard());
            preparedStatement.setString(5, customer.getPhoneNumber());
            preparedStatement.setString(6, customer.getEmail());
            preparedStatement.setString(7, customer.getCustomerType().getCustomerTypeId());
            preparedStatement.setString(8, customer.getAddress());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.getMessage();
                }
                DBConnection.close();
            }


        }
    }

    @Override
    public void remove(String customerid) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("delete from customers where customerid=?");
            preparedStatement.setString(1, customerid);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DBConnection.close();
        }


    }

    @Override
    public Customer findCustomerById(String customerId) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Customer customer = null;

        try {
            preparedStatement = connection.prepareStatement("select * from customers where customerid=?");
            preparedStatement.setString(1, customerId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String customerName = resultSet.getString("customername");
                String birthday = resultSet.getString("birthday");
                String idCard = resultSet.getString("idcard");
                String phoneNumber = resultSet.getString("phonenumber");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String customerTypeId = resultSet.getString("customertypeid");
                CustomerType customerType = customerTypeService.findCustomerTypeById(customerTypeId);
                customer = new Customer(customerId, customerName, birthday, idCard, phoneNumber, email, customerType, address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }   finally {
            try {
                resultSet.close();
                preparedStatement.close();
            } catch (SQLException e){
                e.getMessage();
            }
            DBConnection.close();
        }
        return customer;
    }

    @Override
    public void update(String customerId, Customer customer) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("update customers set customername=?, birthday=?,idcard=?, phonenumber=?,email=?,customertypeid=?,address=? where customerid=? ");
            preparedStatement.setString(1, customer.getCustomerName());
            preparedStatement.setString(2, customer.getBirthday());
            preparedStatement.setString(3, customer.getIdCard());
            preparedStatement.setString(4, customer.getPhoneNumber());
            preparedStatement.setString(5, customer.getEmail());
            preparedStatement.setString(6, customer.getCustomerType().getCustomerTypeId());
            preparedStatement.setString(7, customer.getAddress());
            preparedStatement.setString(8, customerId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                preparedStatement.close();
            } catch (SQLException e){
                e.getMessage();
            }
            DBConnection.close();
        }
    }

    @Override
    public String findNameCustomer(String customerId) {
        Connection connection =DBConnection.getConnection();
        CallableStatement callableStatement=null;
        ResultSet resultSet=null;
        String customerName=null;

        try {
            callableStatement=connection.prepareCall("call findNameCustomer(?,?)");
            callableStatement.setString(1,customerId);
            callableStatement.executeQuery();
            customerName=callableStatement.getString(2);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                callableStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        DBConnection.close();
        return  customerName;
    }

    @Override
    public int getLastCustomerId() {
        Connection connection=DBConnection.getConnection();
        CallableStatement callableStatement=null;
        ResultSet resultSet=null;
        String lastCustomerId=null;
        int lastCustomerId_Int=0;
        try {
            callableStatement=connection.prepareCall("call getLastCustomerId(?) ");
            callableStatement.executeQuery();
            lastCustomerId= callableStatement.getString(1);
            lastCustomerId_Int=Integer.parseInt(lastCustomerId.substring(3)) ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lastCustomerId_Int;
    }
}