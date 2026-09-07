/*
 * Variables and scope
 * ---------------------
 * - Instance variables: one copy per object, declared at class level (no 'static').
 * - Static (class) variables: one copy shared across all instances.
 * - Local variables: declared inside a method/block, only exist during that call, must be initialized before use.
 * - Block scope: variables declared inside {} are only visible inside that block.
 */
public class VariablesScope {

    static int staticCounter = 0;       // class-level, shared by all instances
    int instanceId;                     // instance-level, one per object

    VariablesScope() {
        staticCounter++;                // shared counter increments for every object created
        instanceId = staticCounter;     // each object gets its own id
    }

    void demoLocalScope() {
        int localVar = 100;             // local to this method
        System.out.println("Inside method, localVar = " + localVar);
        {
            int blockVar = 5;           // local to this inner block only
            System.out.println("Inside block, blockVar = " + blockVar);
        }
        // System.out.println(blockVar); // ERROR: blockVar not visible here
    }

    public static void main(String[] args) {
        VariablesScope obj1 = new VariablesScope();
        VariablesScope obj2 = new VariablesScope();

        System.out.println("obj1.instanceId=" + obj1.instanceId);
        System.out.println("obj2.instanceId=" + obj2.instanceId);
        System.out.println("staticCounter (shared)=" + staticCounter);

        obj1.demoLocalScope();

        for (int i = 0; i < 3; i++) {   // 'i' is scoped to the for loop
            int loopLocal = i * 2;      // recreated each iteration
            System.out.println("i=" + i + " loopLocal=" + loopLocal);
        }
        // System.out.println(i); // ERROR: i is out of scope here
    }
}
