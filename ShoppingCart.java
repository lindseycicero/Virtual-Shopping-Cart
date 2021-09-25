/*--------------------------------------------------------------------------
GWU - CS1112 Data Structures and Algorithms - Spring 2021

This is the abstract list layer for the conceptual Shopping Cart.  There is
no implementation here and this definition simply defines how to interact 
with the cart via the interface.  The resultant behaviors are documented so
that it is clear how the cart should behave when the interface is used.

authors: Aaron Coplan, James Levy, James Taylor 
--------------------------------------------------------------------------*/

public interface ShoppingCart {

    /// Adds a product to the cart
    /// @param product the product to add to the cart
    public void add(Product product);

    /// Remove the first product in the cart shortening the list by one and
    /// returning the product that was removed
    /// @return the product that was removed if the cart was not empty;
    ///         otherwise, null
    public Product remove();

    /// Remove a specified product from the cart shortening the list by one
    /// and returning the product that was removed
    /// @param product the product to search for and remove from the cart
    /// @return the product that was removed if the cart was not empty;
    ///         otherwise, null
    public Product remove(Product product);
    
    /// Removes all products from the cart and resets it to an empty state
    public void clear(); 
    
    /// Checks the cart to see if it contains no products.  
    /// @return true if the cart contains no products; otherwise, false 
    public boolean isEmpty();
    
    /// Returns the number of products stored in the cart
    /// @return the number of products stored in the cart
    public int count(); 
    
    /// Returns a product in the list based on its index.  The index must 
    /// be less than the count of the the cart and if not a null is returned
    /// @param i the index of the product to get in the cart where i must
    ///          be in the range [0,count-1]
    /// @return the product stored at index i, or null if i is invalid
    public Product get(int i);
   
    /// Returns a truth value that indicates whether a reference to the 
    /// specified product currently exists in the cart
    /// @param product the product to search for
    /// @return true if a reference to the product exists in the cart;
    ///         otherwise, false
    public boolean contains(Product product);

    /// Returns a truth value indicating whether the cart's structural 
    /// integrity remains valid.  If the integrity is no longer valid,
    /// then the cart should be invalidated and usage should not be trusted
    /// @return true if the cart integrity is valid; otherwise, false
    public boolean isIntegrityValid();

    /// Returns a string that contains information about the list and the 
    /// contents of the list.  This is mostly useful for visual debugging 
    /// @return a string containing information about the contents of the 
    ///         cart
    public String toString();

    /// Returns the sum total price of all products in the cart and then 
    /// clears the cart of all products
    /// @return the sum total price of all products in the cart
    public double checkout();

}
