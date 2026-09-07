/*
 * Access modifiers: public, protected, (package-private/default), private
 *
 *  Modifier      Class  Package  Subclass  World
 *  public          Y       Y        Y        Y
 *  protected       Y       Y        Y        N
 *  (default)       Y       Y        N        N
 *  private         Y       N        N        N
 */
public class AccessModifiers {

    public int publicField = 1;        // accessible from anywhere
    protected int protectedField = 2;  // accessible in same package + subclasses
    int defaultField = 3;              // (package-private) accessible only within same package
    private int privateField = 4;      // accessible only within this class

    private void showFields() {
        // private method - can only be called from inside this class
        System.out.println(publicField + " " + protectedField + " " + defaultField + " " + privateField);
    }

    public static void main(String[] args) {
        AccessModifiers obj = new AccessModifiers();
        obj.showFields();

        System.out.println("public: " + obj.publicField);
        System.out.println("protected (ok, same class/package): " + obj.protectedField);
        System.out.println("default (ok, same package): " + obj.defaultField);
        // System.out.println(obj.privateField); // would NOT compile outside this class
    }
}
