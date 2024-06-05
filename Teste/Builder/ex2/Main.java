package Builder.ex2;

public class Main {
    public static void main(String[] args) {
        NutritionFacts cola = new Builder(248, 8)
                                        .calories(100)
                                        .fat(1)
                                        .protein(0)
                                        .hidrates(10)
                                        .build();
        System.out.println(cola.toString());
        NutritionFacts fanta = new Builder(278, 10)
                                        .calories(97)
                                        .fat(0)
                                        .protein(10)
                                        .hidrates(12)
                                        .build();
        System.out.println(fanta.toString());

    }
}
