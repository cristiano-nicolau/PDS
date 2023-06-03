package lab09.ex2;

public abstract class chef {
    int min=1;
    int max=20;

    protected chef sucessor = null;

    public void chef (request r) {
        if (sucessor != null) {
            sucessor.chef(r);
        }
    }

    protected int rand() {
        return min + (int) (Math.random() * ((max - min) + 1));    
    }

    public boolean canMake(request r, String type) {
        return (r != null) && (r.getType() == type);
    }

    public chef setSucessor(chef sucessor) {
        this.sucessor = sucessor;
        return this;
    }
}

class Sushi extends chef {
    @Override
    public void chef(request r) {
        System.out.print("SushiChef: ");
        if (canMake(r, "sushi")) {
            System.out.println("Starting to cook sushi " + r.getName() + ".Out in " + rand() + " minutes!");
        } else {
            System.out.println("I can't cook that.");
            super.chef(r);
        }
    }
}

class Pasta extends chef {
    @Override
    public void chef(request r) {
        System.out.print("PastaChef: ");
        if (canMake(r, "pasta")) {
            System.out.println("Starting to cook pasta " + r.getName() + ".Out in " + rand() + " minutes!");
        } else {
            System.out.println("I can't cook that.");
            super.chef(r);
        }
    }
}

class Pizza extends chef {
    @Override
    public void chef(request r) {
        System.out.print("PizzaChef: ");
        if (canMake(r, "pizza")) {
            System.out.println("Starting to cook pizza " + r.getName() + ".Out in " + rand() + " minutes!");
        } else {
            System.out.println("I can't cook that.");
            super.chef(r);
        }
    }
}

class Burguer extends chef {
    @Override
    public void chef(request r) {
        System.out.print("BurguerChef: ");
        if (canMake(r, "burger")) {
            System.out.println("Starting to cook burger " + r.getName() + ".Out in " + rand() + " minutes!");
        } else {
            System.out.println("I can't cook that.");
            super.chef(r);
        }
    }
}


class Dessert extends chef {
    @Override
    public void chef(request r) {
        System.out.print("DessertChef: ");
        if (canMake(r, "dessert")) {
            System.out.println("Starting to cook dessert " + r.getName() + ".Out in " + rand() + " minutes!");
        } else {
            System.out.println("I can't cook that.");
            super.chef(r);
        }
    }
}