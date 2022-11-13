package convinience_store.src.main.java.services;

import convinience_store.src.main.java.enums.Gender;
import convinience_store.src.main.java.exceptions.*;
import convinience_store.src.main.java.models.Cashier;
import convinience_store.src.main.java.models.Customer;
import convinience_store.src.main.java.models.Store;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashierServiceTest {

    @Test
    void sell() throws OutOfStockException, EnterValidQuantityException, InsufficientFundsException, NotEnoughQuantityException, ProductNotAvailableException {
        Customer abdul = new Customer(2,"Abdul", Gender.MALE,30000.00);
        CustomerService customerService1 = new CustomerService(abdul);

        customerService1.buyProduct("Noodles", 3);
        Store.allCustomersQueue.add(abdul);

        Cashier cashier = new Cashier();
        CashierService cashierService = new CashierService(cashier);

        String actual = cashierService.sell(abdul);
        String expected = "Abdul, your total balance is N6000.0";

        assertEquals(actual, expected);
    }

    @Test
    void sellToQueue() throws OutOfStockException, EnterValidQuantityException, InsufficientFundsException, NotEnoughQuantityException, ProductNotAvailableException {
        Customer alima = new Customer(1,"Alima", Gender.FEMALE,9000.00);
        Customer abdulllahi = new Customer(2,"Abdulllahi", Gender.MALE,100000.00);
        Customer faith = new Customer(3,"Faith", Gender.FEMALE,30000.00);
        Customer ite = new Customer(4,"Ite", Gender.FEMALE,40000.00);
        Customer mercy = new Customer(5,"Mercy", Gender.FEMALE,50000.00);
        Customer caleb = new Customer(6,"Caleb", Gender.MALE,80000.00);

        CustomerService alimaService = new CustomerService(alima);
        CustomerService abdulService = new CustomerService(abdulllahi);
        CustomerService faithService = new CustomerService(faith);
        CustomerService iteService = new CustomerService(ite);
        CustomerService mercyService = new CustomerService(mercy);
        CustomerService calebService = new CustomerService(caleb);

        Store.allCustomersQueue.add(alima);
        Store.allCustomersQueue.add(abdulllahi);
        Store.allCustomersQueue.add(faith);
        Store.allCustomersQueue.add(ite);
        Store.allCustomersQueue.add(mercy);
        Store.allCustomersQueue.add(caleb);

        int allCustomersBefore = Store.allCustomersQueue.size();

        alimaService.buyProduct("Noodles", 1);
        abdulService.buyProduct("Rice", 9);
        faithService.buyProduct("Spaghetti", 4);
        iteService.buyProduct("Palm Oil", 3);
        mercyService.buyProduct("Macaroni", 4);
        calebService.buyProduct("Semovita", 9);

        Cashier cashier = new Cashier();
        CashierService cashierService = new CashierService(cashier);

        cashierService.sellToQueue(Store.allCustomersQueue);

        int allCustomersAfter = Store.allCustomersQueue.size();

        assertNotEquals(allCustomersBefore, allCustomersAfter);
    }

    @Test
    void issueReceipt() throws OutOfStockException, EnterValidQuantityException, InsufficientFundsException, NotEnoughQuantityException, ProductNotAvailableException {
        Customer abdul = new Customer(2,"Abdul", Gender.MALE,30000.00);
        CustomerService customerService1 = new CustomerService(abdul);

        customerService1.buyProduct("Noodles", 3);
        Store.allCustomersQueue.add(abdul);

        Cashier cashier = new Cashier();
        CashierService cashierService = new CashierService(cashier);

        Double actual =  cashierService.issueReceipt(abdul);;
        Double expected = 6000.00;

        assertEquals(actual, expected);
    }
}