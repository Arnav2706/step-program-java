import java.time.LocalDateTime;
import java.util.*;

final class Product {
    private final String productId;
    private final String name;
    private final String category;
    private final String manufacturer;
    private final double basePrice;
    private final double weight;
    private final String[] features;
    private final Map<String, String> specifications;

    private Product(String productId, String name, String category, String manufacturer,
                    double basePrice, double weight, String[] features, Map<String, String> specs) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.manufacturer = manufacturer;
        this.basePrice = basePrice;
        this.weight = weight;
        this.features = features == null ? new String[0] : features.clone();
        this.specifications = specs == null ? Map.of() : new HashMap<>(specs);
    }

    public static Product createElectronics(String name, String manufacturer, double price, double weight) {
        return new Product(UUID.randomUUID().toString(), name, "Electronics", manufacturer, price, weight,
                new String[]{"warranty"}, Map.of("type", "electronic"));
    }

    public static Product createClothing(String name, String manufacturer, double price) {
        return new Product(UUID.randomUUID().toString(), name, "Clothing", manufacturer, price, 0.2,
                new String[]{"size"}, Map.of("material", "cotton"));
    }

    public static Product createBooks(String name, String manufacturer, double price) {
        return new Product(UUID.randomUUID().toString(), name, "Books", manufacturer, price, 0.5,
                new String[]{"pages"}, Map.of("genre", "education"));
    }

    public String getProductId() { return productId; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public String getManufacturer() { return manufacturer; }
    public double getBasePrice() { return basePrice; }
    public double getWeight() { return weight; }
    public String[] getFeatures() { return features.clone(); }
    public Map<String, String> getSpecifications() { return new HashMap<>(specifications); }

    public final double calculateTax(String region) {
        double rate = region.equalsIgnoreCase("IN") ? 0.18 : 0.1;
        return basePrice * rate;
    }

    @Override public String toString() { return name + "(" + productId + ")"; }
}

class Customer {
    private final String customerId;
    private final String email;
    private String name;
    private String phoneNumber;
    private String preferredLanguage;
    private final String accountCreationDate;

    public Customer(String customerId, String email, String name) {
        this.customerId = customerId;
        this.email = email;
        this.name = name;
        this.accountCreationDate = LocalDateTime.now().toString();
    }

    public String getCustomerId() { return customerId; }
    public String getEmail() { return email; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPublicProfile() { return "Customer: " + name; }
    int getCreditRating() { return 700; } // package-private
}

class ShoppingCart {
    private final String cartId;
    private final String customerId;
    private final List<CartItem> items = new ArrayList<>();
    private double totalAmount = 0;
    private int itemCount = 0;

    static class CartItem { Product product; int qty; CartItem(Product p, int q){product=p;qty=q;} }

    public ShoppingCart(String cartId, String customerId) {
        this.cartId = cartId;
        this.customerId = customerId;
    }

    public boolean addItem(Object productObj, int quantity) {
        if (!(productObj instanceof Product) || quantity <= 0) return false;
        Product p = (Product) productObj;
        items.add(new CartItem(p, quantity));
        itemCount += quantity;
        totalAmount += p.getBasePrice() * quantity;
        return true;
    }

    private double calculateDiscount() {
        return itemCount > 5 ? totalAmount * 0.05 : 0;
    }

    Map<String,Object> getCartSummary() { // package-private
        Map<String,Object> m = new HashMap<>();
        m.put("total", totalAmount - calculateDiscount());
        m.put("count", itemCount);
        return m;
    }
}

final class Order {
    private final String orderId;
    private final LocalDateTime orderTime;
    private final String customerId;
    private final double amount;

    public Order(String customerId, double amount) {
        this.orderId = UUID.randomUUID().toString();
        this.orderTime = LocalDateTime.now();
        this.customerId = customerId;
        this.amount = amount;
    }

    public String getOrderId() { return orderId; }
}

final class ECommerceSystem {
    private static final Map<String,Object> productCatalog = new HashMap<>();

    public static boolean processOrder(Object orderObj, Object customerObj) {
        if (!(orderObj instanceof Order) || !(customerObj instanceof Customer)) return false;
        // simplified processing
        return true;
    }

    public static void main(String[] args) {
        Product p1 = Product.createElectronics("Phone X", "Maker", 30000, 0.2);
        Product p2 = Product.createBooks("Java Guide", "Author", 799);
        productCatalog.put(p1.getProductId(), p1);
        productCatalog.put(p2.getProductId(), p2);

        Customer c = new Customer("C100","c@x.com","Alice");
        ShoppingCart cart = new ShoppingCart("Cart1", c.getCustomerId());
        cart.addItem(p1, 1);
        cart.addItem(p2, 2);

        System.out.println("Cart summary: " + cart.getCartSummary());
    }
}
