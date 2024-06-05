package Builder.ex2;

public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private int calories;
    private int fat;
    private int carbohydrates;
    private int protein;

    public NutritionFacts(int serving_size, int serving){
        this.servingSize = serving_size;
        this.servings = serving;
    }

    

    public void setCalories(int calories) {
        this.calories = calories;
    }



    public void setFat(int fat) {
        this.fat = fat;
    }



    public void setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
    }



    public void setProtein(int protein) {
        this.protein = protein;
    }



    public int getServingSize() {
        return servingSize;
    }

    public int getServings() {
        return servings;
    }

    public int getCalories() {
        return calories;
    }

    public int getFat() {
        return fat;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public int getProtein() {
        return protein;
    }



    @Override
    public String toString() {
        return "NutritionFacts [servingSize=" + servingSize + ", servings=" + servings + ", calories=" + calories
                + ", fat=" + fat + ", carbohydrates=" + carbohydrates + ", protein=" + protein + "]";
    }

    
    
}
