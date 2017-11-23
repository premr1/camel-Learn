package cc.notsoclever.examples.cxf.wsdlfirst.server;

import cc.notsoclever.customerservice.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.*;

public class CustomerServiceImpl implements CustomerService {

    private static final transient Logger LOG = LoggerFactory.getLogger(CustomerServiceImpl.class);

    private Map<String, Customer> customers = new HashMap<String, Customer>();

    public CustomerServiceImpl() {
        Customer customer = new Customer();
        String name = "Johns, Mary";
        customer.setName(name);
        customer.getAddress().add("Pine Street 200");
        Date bDate = new GregorianCalendar(2009, 1, 1).getTime();
        customer.setBirthDate(bDate);
        customer.setNumOrders(1);
        customer.setRevenue(10000);
        customer.setTest(new BigDecimal(1.5));
        customer.setType(CustomerType.BUSINESS);
        customers.put(name, customer);

        customer = new Customer();
        name = "Johns, Marvin";
        customer.setName(name);
        customer.getAddress().add("Oak Street 201");
        bDate = new GregorianCalendar(2010, 1, 1).getTime();
        customer.setBirthDate(bDate);
        customer.setNumOrders(1);
        customer.setRevenue(30000);
        customer.setTest(new BigDecimal(1.5));
        customer.setType(CustomerType.PRIVATE);
        customers.put(name, customer);

        customer = new Customer();
        name = "Jones";
        customer.setName(name);
        customer.getAddress().add("Oak Street 201");
        bDate = new GregorianCalendar(2010, 1, 1).getTime();
        customer.setBirthDate(bDate);
        customer.setNumOrders(1);
        customer.setRevenue(30000);
        customer.setTest(new BigDecimal(1.5));
        customer.setType(CustomerType.PRIVATE);
        customers.put(name, customer);
    }

    @Override
    public List<Customer> getCustomersByName(String name) throws NoSuchCustomerException {

        List<Customer> results = new ArrayList<Customer>();

        for (Customer customer : customers.values()) {
            if (customer.getName().startsWith(name)) {
                results.add(customer);
            }
        }

        if (results.size() == 0) {
            NoSuchCustomer noSuchCustomer = new NoSuchCustomer();
            noSuchCustomer.setCustomerName(name);
            throw new NoSuchCustomerException("Did not find any matching customer for name=" + name,
                    noSuchCustomer);
        }

        return results;
    }

    @Override
    public Customer updateCustomer(Customer customer) throws NoSuchCustomerException {
        if (customers.containsKey(customer.getName())) {
            customers.put(customer.getName(), customer);
        } else {
            NoSuchCustomer noSuchCustomer = new NoSuchCustomer();
            noSuchCustomer.setCustomerName(customer.getName());
            throw new NoSuchCustomerException("Did not find any matching customer for name=" + customer.getName(),
                    noSuchCustomer);
        }
        return customer;
    }

}