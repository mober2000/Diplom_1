package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private final String name = "Булочка с корицей";
    private final float price = 100f;
    Bun bun = new Bun(name, price);

    @Test
    public void setBunNameTest() {
        String expected = name;
        String actual = bun.getName();
        assertEquals(expected, actual);
    }

    @Test
    public void setBunPriceTest() {
        float expected = price;
        float actual = bun.getPrice();
        assertEquals(expected, actual, 0.00001);
    }
}
