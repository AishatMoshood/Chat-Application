package convinience_store.src.main.java.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {

    @Test
    void readProducts() {
        Store aishaStore = new Store();
        int allProductsListBefore = aishaStore.getFromAvailableProductsList().size();

        aishaStore.readProducts("src/main/resources/products.csv");

        int allProductsListAfter = aishaStore.getFromAvailableProductsList().size();

        assertNotEquals(allProductsListBefore,allProductsListAfter);
    }
}