public class Pizza {
    private int basePrice;
    private boolean isVeg;
    private boolean extraCheese;
    private boolean extraToppings;
    private boolean takeaway;

    public Pizza(boolean isVeg) {
        this.isVeg = isVeg;
        this.basePrice = isVeg ? 300 : 400;
        this.extraCheese = false;
        this.extraToppings = false;
        this.takeaway = false;
    }

    public void addExtraCheese() {
        this.extraCheese = true;
    }

    public void addExtraToppings() {
        this.extraToppings = true;
    }

    public void selectTakeaway() {
        this.takeaway = true;
    }

    public int calculateTotal() {
        int total = this.basePrice;
        if (this.extraCheese) {
            total += 100;
        }
        if (this.extraToppings) {
            total += 100;
        }
        if (this.takeaway) {
            total += 20;
        }
        return total;
    }

    public String generateBill() {
        StringBuilder bill = new StringBuilder();
        bill.append("Base Price: ").append(this.basePrice).append(" rupees\n");
        if (this.extraCheese) {
            bill.append("Extra Cheese: 100 rupees\n");
        }
        if (this.extraToppings) {
            bill.append("Extra Toppings: 100 rupees\n");
        }
        if (this.takeaway) {
            bill.append("Takeaway Backpack: 20 rupees\n");
        }
        bill.append("Total: ").append(calculateTotal()).append(" rupees");
        return bill.toString();
    }
}
    public class DeluxePizza extends Pizza {
    public DeluxePizza(boolean isVeg) {
        super(isVeg);
        addExtraCheese();
        addExtraToppings();
    }
}
public class Main {
    public static void main(String[] args) {
        // Example usage of normal pizza
        Pizza normalPizza = new Pizza(true); // Vegetarian pizza
        normalPizza.addExtraCheese();
        normalPizza.selectTakeaway();
        System.out.println(normalPizza.generateBill());

        // Example usage of deluxe pizza
        DeluxePizza deluxePizza = new DeluxePizza(false); // Non-vegetarian deluxe pizza
        deluxePizza.selectTakeaway();
        System.out.println(deluxePizza.generateBill());
    }
}
