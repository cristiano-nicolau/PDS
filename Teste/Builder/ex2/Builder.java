package Builder.ex2;

public class Builder {
    private NutritionFacts nut;

    public Builder(int serving_size, int serving){
        nut = new NutritionFacts(serving_size, serving);
    }

    public Builder calories(int i){
        this.nut.setCalories(i);
        return this;
    }

    public Builder protein(int i){
        this.nut.setProtein(i);;
        return this;
    }
    public Builder fat(int i){
        this.nut.setFat(i);
        return this;
    }
    public Builder hidrates(int i){
        this.nut.setCarbohydrates(i);
        return this;
    }

    public NutritionFacts build(){
        return nut;
    }
}
