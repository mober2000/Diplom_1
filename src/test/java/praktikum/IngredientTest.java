package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {
    private final String name = "Кетчуп";
    private final float price = 100f;
    Ingredient ingredient = new Ingredient(SAUCE, name, price);

    @Test
    public void callGetNameIngredientTest() {
        String expected = name;
        String actual = ingredient.getName();
        assertEquals(expected, actual);
    }

    @Test
    public void callGetPriceIngredientTest() {
        float expected = price;
        float actual = ingredient.getPrice();
        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void callGetTypeIngredientTest() {
        IngredientType expected = SAUCE;
        IngredientType actual = ingredient.getType();
        assertEquals(expected, actual);
    }
}
