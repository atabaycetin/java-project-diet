package diet;

public class rawMaterial implements NutritionalElement{

    private String name;
	private double calories, proteins, carbs, fat;

    public rawMaterial (String name, double calories, double proteins, double carbs, double fat) {
        this.name = name;
        this.calories = calories; this.proteins = proteins; this.carbs = carbs; this.fat = fat;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getCalories() {
        return calories;
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
        return true;
    }
}
