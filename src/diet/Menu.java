package diet;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * Represents a complete menu.
 * 
 * It can be made up of both packaged products and servings of given recipes.
 *
 */
public class Menu implements NutritionalElement {

	/**
	 * Adds a given serving size of a recipe.
	 * The recipe is a name of a recipe defined in the {@code food}
	 * argument of the constructor.
	 * 
	 * @param recipe the name of the recipe to be used as ingredient
	 * @param quantity the amount in grams of the recipe to be used
	 * @return the same Menu to allow method chaining
	 */
	
	private String name;
	private Food food;
	private double cal, prot, carb, fat;

	private HashMap<NutritionalElement, Double> recipes = new HashMap<NutritionalElement, Double>();
	private List<NutritionalElement> products = new ArrayList<NutritionalElement>();

	public Menu(String name, Food food) {
		this.name = name;
		this.food = food;
	}

    public Menu addRecipe(String recipe, double quantity) {
		NutritionalElement recp = food.getRecipe(recipe);
		this.prot += quantity*recp.getProteins()/100;
		this.cal += quantity*recp.getCalories()/100;
		this.fat += quantity*recp.getFat()/100;
		this.carb += quantity*recp.getCarbs()/100;
		recipes.put(recp, quantity);
		return this;
	}

	/**
	 * Adds a unit of a packaged product.
	 * The product is a name of a product defined in the {@code food}
	 * argument of the constructor.
	 * 
	 * @param product the name of the product to be used as ingredient
	 * @return the same Menu to allow method chaining
	 */
    public Menu addProduct(String product) {
		NutritionalElement prod = food.getProduct(product);
		this.prot += prod.getProteins();
		this.cal += prod.getCalories();
		this.fat += prod.getFat();
		this.carb += prod.getCarbs();
		products.add(prod);
		return null;
	}

	@Override
	public String getName() {
		return name;
	}

	/**
	 * Total KCal in the menu
	 */

	@Override
	public double getCalories() {
		return cal;
	}

	/**
	 * Total proteins in the menu
	 */
	@Override
	public double getProteins() {
		return prot;
	}

	/**
	 * Total carbs in the menu
	 */
	@Override
	public double getCarbs() {
		return carb;
	}

	/**
	 * Total fats in the menu
	 */
	@Override
	public double getFat() {
		return fat;
	}

	/**
	 * Indicates whether the nutritional values returned by the other methods
	 * refer to a conventional 100g quantity of nutritional element,
	 * or to a unit of element.
	 * 
	 * For the {@link Menu} class it must always return {@code false}:
	 * nutritional values are provided for the whole menu.
	 * 
	 * @return boolean indicator
	 */
	@Override
	public boolean per100g() {
		return false;
	}
}