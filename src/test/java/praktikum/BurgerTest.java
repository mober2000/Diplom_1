package praktikum;

import org.junit.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;
import static praktikum.IngredientType.SAUCE;
import static praktikum.IngredientType.FILLING;

public class BurgerTest {
    Burger burger = new Burger();
    Ingredient ingredientFirst = new Ingredient(SAUCE, "Редька", 100);
    Ingredient ingredientSecond = new Ingredient(SAUCE, "Помидор", 200);
    Ingredient ingredientThird = new Ingredient(FILLING, "Редис", 300);

    @Test
    public void checkAddIngredientOnIngredientList() {
        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);
        burger.addIngredient(ingredientThird);
        assertEquals(ingredientFirst, burger.ingredients.get(0));
        assertEquals(ingredientSecond, burger.ingredients.get(1));
        assertEquals(ingredientThird, burger.ingredients.get(2));
    }

    @Test
    public void removeIngredientOnIngredientList() {
        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);
        burger.addIngredient(ingredientThird);
        burger.removeIngredient(0);
        assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void moveIngredientOnIngredientList() {
        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);
        burger.addIngredient(ingredientThird);
        burger.moveIngredient(1, 2);
        assertEquals(ingredientThird, burger.ingredients.get(1));
        assertEquals(ingredientSecond, burger.ingredients.get(2));
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(new Bun("Булочка с корицей", 100));
        assertEquals("Булочка с корицей", burger.bun.getName());
        assertEquals(100, burger.bun.getPrice(), 0.0002);
    }

    @Test
    public void getSumPriceTest() {
        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);
        burger.addIngredient(ingredientThird);
        burger.setBuns(new Bun("Булочка с корицей", 100));
        assertEquals(800, burger.getPrice(), 0.00001);
    }

    @Test
    public void getReceipt() throws IOException {
        String reference = Files.readString(Paths.get("src/test/java/praktikum/Recept"));
        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);
        burger.addIngredient(ingredientThird);
        burger.setBuns(new Bun("Булочка с корицей", 100));
        String actual = burger.getReceipt();
        assertEquals(reference, actual);
    }
}