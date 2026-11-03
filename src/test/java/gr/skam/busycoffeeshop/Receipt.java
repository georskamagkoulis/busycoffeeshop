package gr.skam.busycoffeeshop;

import org.junit.jupiter.api.Test;

import java.beans.Transient;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReceiptTest {

    @Test
    void lineTotalWithoutDiscount() {
        var coffee = Coffee.of(CoffeeType.FREDDO_ESPRESSO, 4, false, SugarLevel.NONE);
        var order = Order.create(coffee, 4);

        assertEquals(9.20, Receipt.lineTotal(order), 0.001);
    }

    @Test
    void lineTotalWithDiscountForMoreThanTenCups() {
        var coffee = Coffee.of(CoffeeType.FREDDO_ESPRESSO, 11, false, SugarLevel.NONE);
        var order = Order.create(coffee, 11);

        assertEquals(22.77, Receipt.lineTotal(order), 0.001);
    }
   
}


