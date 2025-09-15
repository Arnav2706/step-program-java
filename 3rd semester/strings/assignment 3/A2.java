class Product {
    String productId;
    String productName;
    String category;
    double price;
    int stockQuantity;

    static int totalProducts = 0;
    static String[] categories = {"Electronics", "Grocery", "Fashion", "Books"};

    Product(String id, String name, double price, String cat, int stock) {
        this.productId = id;
        this.productName = name;
        this.price = price;
        this.category = cat;
        this.stockQuantity = stock;
        totalProducts++;
    }

    static Product findProductById(Product[] products, String productId) {
        for (Product p : products) {
            if (p != null && p.productId.equals(productId)) {
                return p;
            }
        }
        return null;
    }

    static Product[] getProductsByCategory(Product[] products, String category) {
        Product[] result = new Product[products.length];
        int k = 0;
        for (Product p : products) {
            if (p != null && p.category.equals(category)) {
                result[k++] = p;
            }
        }
        return result;
    }
}

class ShoppingCart {
    String cartId;
    String customerName;
    Product[] products;
    int[] quantities;
    double cartTotal;

    ShoppingCart(String id, String name, int capacity) {
        this.cartId = id;
        this.customerName = name;
        this.products = new Product[capacity];
        this.quantities = new int[capacity];
    }

    void addProduct(Product product, int quantity) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                if (product.stockQuantity >= quantity) {
                    products[i] = product;
                    quantities[i] = quantity;
                    product.stockQuantity -= quantity;
                }
                break;
            }
        }
    }

    void removeProduct(String productId) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null && products[i].productId.equals(productId)) {
                products[i].stockQuantity += quantities[i];
                products[i] = null;
                quantities[i] = 0;
                break;
            }
        }
    }

    double calculateTotal() {
        cartTotal = 0;
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                cartTotal += products[i].price * quantities[i];
            }
        }
        return cartTotal;
    }

    void displayCart() {
        System.out.println("\nCustomer: " + customerName + " | Cart ID: " + cartId);
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                System.out.println(products[i].productName + " x" + quantities[i] +
                                   " = " + (products[i].price * quantities[i]));
            }
        }
        System.out.println("Cart Total: " + calculateTotal());
    }

    void checkout() {
        System.out.println("Checkout Successful! Paid: " + calculateTotal());
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
            quantities[i] = 0;
        }
        cartTotal = 0;
    }
}

public class A2 {
    public static void main(String[] args) {
        Product[] catalog = new Product[10];

        catalog[0] = new Product("P1", "Phone", 5999, "Electronics", 10);
        catalog[1] = new Product("P2", "Laptop", 29999, "Electronics", 5);
        catalog[2] = new Product("P3", "Headphones", 999, "Electronics", 20);
        catalog[3] = new Product("P4", "Rice", 499, "Grocery", 50);
        catalog[4] = new Product("P5", "Shirt", 799, "Fashion", 15);
        catalog[5] = new Product("P6", "Shoes", 1299, "Fashion", 12);
        catalog[6] = new Product("P7", "Book A", 299, "Books", 30);
        catalog[7] = new Product("P8", "Book B", 399, "Books", 25);
        catalog[8] = new Product("P9", "Tea", 199, "Grocery", 40);
        catalog[9] = new Product("P10", "Watch", 1999, "Fashion", 8);

        ShoppingCart cart = new ShoppingCart("C101", "Arnav", 10);

        cart.addProduct(Product.findProductById(catalog, "P1"), 1);
        cart.addProduct(Product.findProductById(catalog, "P4"), 2);
        cart.addProduct(Product.findProductById(catalog, "P7"), 3);

        cart.displayCart();

        cart.removeProduct("P4");
        cart.displayCart();

        cart.checkout();

        Product[] onlyBooks = Product.getProductsByCategory(catalog, "Books");
        System.out.println("\nAvailable Books:");
        for (Product p : onlyBooks) {
            if (p != null) {
                System.out.println(p.productName + " - Rs." + p.price);
            }
        }

        System.out.println("\nTotal Products in Catalog: " + Product.totalProducts);
    }
}
