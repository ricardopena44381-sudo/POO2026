public class Product {
    private String name;
    private double price;
    private int stock;

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price > 0 ? price : 1; 
        this.stock = Math.max(stock, 0);
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }

    public boolean updateName(String newName) {
        if (newName != null && !newName.trim().isEmpty()) {
            this.name = newName;
            return true;
        }
        return false;
    }

    public boolean updatePrice(double newPrice) {
        if (newPrice > 0) {
            this.price = newPrice;
            return true;
        }
        return false;
    }

    public boolean updateStock(int newStock) {
        if (newStock >= 0) {
            this.stock = newStock;
            return true;
        }
        return false;
    }
}