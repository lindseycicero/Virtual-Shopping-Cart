/*--------------------------------------------------------------------------
GWU - CS1112 Data Structures and Algorithms - Spring 2021

This class is a multi-purpose list element container for shopping carts as
it can act as an array element or a linked-list element 

It's chief purpose is to contain products and any other ancillary fields 
related to maintaining shopping cart data (like quantities or discounts)

Note that this class could be more generalized; however, it is specifically 
designed for the shopping cart application to make this problem a little 
easier.

authors: Aaron Coplan, James Taylor 
--------------------------------------------------------------------------*/
public class CartItem {

    // The product contained in this list item
    private final Product product;

    // The next field is only necessary for LinkedList based carts
    public CartItem next;
    //Any extra fields you need may go here

    // Parameterized constructor 
    // @param product an instance of a Product.
    public CartItem(Product product) {
        this.product = product;
        this.next = null;
    }

    // Accessor to return the product contained by this list item    
    public Product getProduct() {
        return product;
    }
}
