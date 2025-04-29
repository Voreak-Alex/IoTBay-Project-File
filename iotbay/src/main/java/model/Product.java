package model;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Objects;

public class Product implements Serializable{
    private int productID;
    private String productName;
    private int stock;
    private double price;


    public Product() {
    }

    public Product(int productID, String productName, int stock, double price) {
        this.productID = productID;
        this.productName = productName;
        this.stock = stock;
        this.price = price;
    }

    public int getProductID() {
        return this.productID;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getStock() {
        return this.stock;
    }

    //checks if correct amount of stock is left (stock checked against x)
    public boolean has(int x) {
        return getStock() >= x;
    }
    
    //returns total cost of all items sold & updates stock
    public double sell(int amount) {
        setStock(getStock() - amount);
        return amount * getPrice();
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product productName(String productName) {
        setProductName(productName);
        return this;
    }

    public Product stock(int stock) {
        setStock(stock);
        return this;
    }

    public Product price(double price) {
        setPrice(price);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Product)) {
            return false;
        }
        Product product = (Product) o;
        return productID == product.productID && Objects.equals(productName, product.productName) && stock == product.stock && price == product.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productID, productName, stock, price);
    }

    @Override
    public String toString() {
        return "{" +
            " productID='" + getProductID() + "'" +
            ", productName='" + getProductName() + "'" +
            ", stock='" + getStock() + "'" +
            ", price='$" + getPrice() + formatted(getPrice()) + "'" +
            "}";
    }

    public String formatted(double price) {
        return new DecimalFormat("###,##0.00").format(price);
    }
}

