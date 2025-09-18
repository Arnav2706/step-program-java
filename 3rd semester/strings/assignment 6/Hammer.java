class Tool {
    private String name = "Generic Tool";
    protected String material = "Steel";
    public int weight = 5;

    public String getName() {
        return name;
    }
}

public class Hammer extends Tool {
    public void showAccess() {
        // System.out.println(name); ❌ private not accessible
        System.out.println("Material: " + material);   // ✅ protected accessible
        System.out.println("Weight: " + weight);       // ✅ public accessible
        System.out.println("Name (via getter): " + getName()); // ✅ via method
    }

    public static void main(String[] args) {
        Hammer h = new Hammer();
        h.showAccess();
    }
}
