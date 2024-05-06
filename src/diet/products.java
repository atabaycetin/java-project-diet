package diet;

public class products implements NutritionalElement{

    private String name;
	private double kiloCalories, proteins, carbs, fat;

    public products (String name, double kiloCalories, double proteins, double carbs, double fat) {
        this.name = name;
        this.kiloCalories = kiloCalories; this.proteins = proteins; this.carbs = carbs; this.fat = fat;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getCalories() {
        return kiloCalories;
    }

    @Override
    public double getProteins() {
        return proteins;
    }

    @Override
    public double getCarbs() {
        return carbs;
    }

    @Override
    public double getFat() {
        return fat;
    }

    @Override
    public boolean per100g() {
        return false;
    }

    
}
