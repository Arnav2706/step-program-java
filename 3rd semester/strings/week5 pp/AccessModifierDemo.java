

public class AccessModifierDemo {

    // Fields with different access levels
    private int privateField;
             String defaultField;     
    protected double protectedField;
    public boolean publicField;

    // Constructor to initialize fields
    public AccessModifierDemo(int p, String d, double pr, boolean pub) {
        this.privateField = p;
        this.defaultField = d;
        this.protectedField = pr;
        this.publicField = pub;
    }

    // Methods with different access levels
    private void privateMethod() {
        System.out.println("Private method called");
    }

    void defaultMethod() {
        System.out.println("Default method called");
    }

    protected void protectedMethod() {
        System.out.println("Protected method called");
    }

    public void publicMethod() {
        System.out.println("Public method called");
    }

    // Method to test access from inside the class
    public void testInternalAccess() {
        System.out.println("== Inside same class ==");
        System.out.println("Private field: " + privateField);
        System.out.println("Default field: " + defaultField);
        System.out.println("Protected field: " + protectedField);
        System.out.println("Public field: " + publicField);

        privateMethod();
        defaultMethod();
        protectedMethod();
        publicMethod();
    }

    public static void main(String[] args) {
        AccessModifierDemo obj = new AccessModifierDemo(10, "Hello", 99.9, true);

        // Direct access from same class → ALL work
        System.out.println(obj.privateField);  
        System.out.println(obj.defaultField);  
        System.out.println(obj.protectedField); 
        System.out.println(obj.publicField);    

        obj.privateMethod();    
        obj.defaultMethod();    
        obj.protectedMethod();  
        obj.publicMethod();     

  
        obj.testInternalAccess();
    }
}
