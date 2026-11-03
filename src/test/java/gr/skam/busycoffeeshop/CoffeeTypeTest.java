package gr.skam.busycoffeeshop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CoffeeTypeTest {

    @Test
    void fromNameFindsExactName() {
        assertEquals(CoffeeType.LATTE, CoffeeType.fromName("Latte"));
    }

    @Test
    void fromNameIgnoresCaseAndSpaces() {
        assertEquals(CoffeeType.LATTE, CoffeeType.fromName("  latte "));
    }

    @Test
    void fromNameWorksForTwoWordNames() {
        assertEquals(CoffeeType.FREDDO_ESPRESSO, CoffeeType.fromName("freddo espresso"));
    }

    @Test
    void fromNameThrowsForUnknownName() {
        assertThrows(InvalidProductNameException.class, () -> CoffeeType.fromName("tea"));
    }

    @Test
    void priceAndDisplayNameAreCorrect() {
        assertEquals(2.50, CoffeeType.FRAPPE.getPrice(), 0.001);
        assertEquals("Frappe", CoffeeType.FRAPPE.getDisplayName());
    }
}