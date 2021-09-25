/*--------------------------------------------------------------------------
GWU - CS1112 Data Structures and Algorithms - Spring 2021

Use cases for both the array-list and linked-list based shopping carts.  
You can run this program once all the unit tests pass and to see some 
typical interactions with the shopping cart.

authors: James Taylor 
--------------------------------------------------------------------------*/
public class UseCases {
    private static Product[] products;

    public static void main(String[] args) {

        products = InventoryHelper.getProducts();

        System.out.println("Running use cases with ArrayList");
        usecase1(new ArrayList());
        System.out.println();
        usecase2(new ArrayList());
        System.out.println();
        usecase3(new ArrayList());
        System.out.println();
        usecase4(new ArrayList());

        System.out.println();
        System.out.println();

        System.out.println("Running use cases with LinkedList");
        usecase1(new LinkedList());
        System.out.println();
        usecase2(new LinkedList());
        System.out.println();
        usecase3(new LinkedList());
        System.out.println();
        usecase4(new LinkedList());
    }

    // A person puts one item into the cart and the does a checkout
    public static void usecase1(ShoppingCart cart) {
        System.out.println("*Use Case 1: Add one item to the cart and checkout");

        cart.add(products[4]);

        // List should contain 1 item
        System.out.println(cart);

        // Checkout should have the same value as the item listed above 
        System.out.println("checkout:" + cart.checkout());

        // List should be empty
        System.out.println(cart);
    }

    // A person puts multiple items into the cart and then does a checkout
    public static void usecase2(ShoppingCart cart) {
        System.out.println("*Use Case 2: Add multiple items to the cart and checkout");

        cart.add(products[1]);
        cart.add(products[3]);

        // List should contain 2 items
        System.out.println(cart);

        // Checkout should have the total value of all items listed above 
        System.out.println("checkout:" + cart.checkout());

        // List should be empty
        System.out.println(cart);
    }

    // A person puts an item into the cart, removes that item, and then does
    // a checkout
    public static void usecase3(ShoppingCart cart) {
        System.out.println("*Use Case 3: Add an item to the cart then remove that item.");

        cart.add(products[6]);

        // List should contain 1 item
        System.out.println(cart);

        cart.remove(products[6]);

        // List should be empty
        System.out.println(cart);

        // Checkout should have a total of 0.0
        System.out.println("checkout:" + cart.checkout());

        // List should be empty
        System.out.println(cart);
    }

    // A person adds a few items to the cart, then searches through the cart
    // to confirm an item was added, and then searches through the cart to
    // discover an item was not added.
    public static void usecase4(ShoppingCart cart) {
        System.out.println("*Use Case 4: Search through the cart for a specific item");

        cart.add(products[7]);
        cart.add(products[8]);
        cart.add(products[9]);

        // List should contain 3 items
        System.out.println(cart);

        // Product at index 8 should be found in the cart
        if(cart.contains(products[8])) {
            System.out.println("Found " + products[8] + " in the cart");
        }

        // Product at index 0 should not be found in the cart
        if(!cart.contains(products[0])) {
            System.out.println("Forgot to put " + products[0] + " in the cart");
        }
    }
}
