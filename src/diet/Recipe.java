package diet;

import java.util.HashMap;

/**
 * Represents a recipe of the diet.
 * 
 * A recipe consists of a a set of ingredients that are given amounts of raw materials.
 * The overall nutritional values of a recipe can be computed
 * on the basis of the ingredients' values and are expressed per 100g
 * 
 *
 */
public class Recipe implements NutritionalElement {
	
	/**
	 * Adds the given quantity of an ingredient to the recipe.
	 * The ingredient is a raw material.
	 * 
	 * @param material the name of the raw material to be used as ingredient
	 * @param quantity the amount in grams of the raw material to be used
	 * @return the same Recipe object, it allows method chaining.
	 */

	private String name;
	private Food food;
	private NutritionalElement Material;
	private HashMap<NutritionalElement, Double> ingredients = new HashMap<NutritionalElement, Double>();
	private double cal, protein, carb, fat;

	public Recipe(String name, Food food) {
		this.name = name;
		this.food = food;
	}

	public Recipe addIngredient(String material, double quantity) {
		Material = food.getRawMaterial(material);
		this.protein += quantity*Material.getProteins()/100;
		this.cal += quantity*Material.getCalories()/100;
		this.fat += quantity*Material.getFat()/100;
		this.carb += quantity*Material.getCarbs()/100;
		ingredients.put(Material, quantity);
		return this;
	}

	@Override
	public String getName() {
		return name;
	}


	@Override
	public double getCalories() {
		return cal;
	}
	

	@Override
	public double getProteins() {
		return protein;
	}

	@Override
	public double getCarbs() {
		return carb;
	}

	@Override
	public double getFat() {
		return fat;
	}

	/**
	 * Indicates whether the nutritional values returned by the other methods
	 * refer to a conventional 100g quantity of nutritional element,
	 * or to a unit of element.
	 * 
	 * For the {@link Recipe} class it must always return {@code true}:
	 * a recipe expresses nutritional values per 100g
	 * 
	 * @return boolean indicator
	 */
	@Override
	public boolean per100g() {
		return true;
	}
	
}
