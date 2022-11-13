package convinience_store.src.main.java.services;

import convinience_store.src.main.java.enums.Gender;
import convinience_store.src.main.java.exceptions.*;
import convinience_store.src.main.java.models.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTest {

    @Test
    void buyProduct() throws OutOfStockException, EnterValidQuantityException, InsufficientFundsException, NotEnoughQuantityException, ProductNotAvailableException {
        Customer alima = new Customer(1,"Alima", Gender.FEMALE,10000.00);
        CustomerService customerService = new CustomerService(alima);
        customerService.buyProduct("Noodles", 3);

        Double actual =  alima.getWallet();
        Double exp = 4000.00;

        assertEquals(actual, exp);
    }
}