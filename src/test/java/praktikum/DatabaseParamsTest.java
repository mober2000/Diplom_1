package praktikum;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static praktikum.IngredientType.SAUCE;
import static praktikum.IngredientType.FILLING;
import static org.junit.Assert.assertEquals;

public class DatabaseParamsTest {
    Database database = new Database();
    Burger burger = new Burger();
    private List<Ingredient> ingredientList = new ArrayList<>();
    List<Ingredient> ingredients = database.availableIngredients();

    @Test
    public void DatabaseIngredientTest() {
        Ingredient ingredientTest = new Ingredient(SAUCE, "hot sauce", 100);
        burger.addIngredient(ingredientTest);

        assertEquals(ingredientTest, ingredients.get(0));
    }
}
