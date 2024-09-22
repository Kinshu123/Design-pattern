// CoffeeDecoratorPattern.java
interface Coffee {
    double cost();
    String description();
}

class BasicCoffee implements Coffee {
    @Override
    public double cost() {
        return 5;
    }

    @Override
    public String description() {
        return "Plain Coffee";
    }
}

abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public double cost() {
        return coffee.cost();
    }

    @Override
    public String description() {
        return coffee.description();
    }
}

class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double cost() {
        return coffee.cost() + 2;
    }

    @Override
    public String description() {
        return coffee.description() + ", Milk";
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double cost() {
        return coffee.cost() + 1;
    }

    @Override
    public String description() {
        return coffee.description() + ", Sugar";
    }
}

public class CoffeeDecoratorPattern {
    public static void main(String[] args) {
        Coffee coffee = new BasicCoffee();
        System.out.println(coffee.description() + ": $" + coffee.cost());

        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.description() + ": $" + coffee.cost());

        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.description() + ": $" + coffee.cost());
    }
}
