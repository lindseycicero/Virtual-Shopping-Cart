/*--------------------------------------------------------------------------
GWU - CS1112 Data Structures and Algorithms - Spring 2021

This is the implementation layer for a linked list based shopping cart.  It 
implements the interface prescribed by the ShoppingCart class.

This class could be more generalized; however, it is specialized to make
the Shopping Cart application a little easier to implement for new students

authors: Lindsey Cicero 
--------------------------------------------------------------------------*/
public class LinkedList implements ShoppingCart {

    // For a linked-list based list, the head pointer
    private CartItem head;
    // The counter to track the number of elements in the list 
    private int count;

    // Parameterless Constructor
    public LinkedList() {
        count = 0;
        head = null;
    }

    /// Adds a product to the cart
    /// @param product the product to add to the cart
    public void add(Product product) {
	    //checks to see if there is anything in the list 
	    //and makes the item the head if not
	    if(head==null){
		    head=new CartItem(product);
	    }
	    //links the new item to the list if it isn't epmty
	    else{
		    CartItem another = new CartItem(product);
		    CartItem it=head;
		    CartItem prev = null;
		    //find the curent last element to link the new one to
		    while(it!=null){
				prev=it;
				it=it.next;
		    }
	            prev.next=another;
	    }
	//increase item count
	count++;	
    }

    /// Remove the first product in the cart shortening the list by one and
    /// returning the product that was removed
    /// @return the product that was removed if the cart was not empty;
    ///         otherwise, null
    public Product remove() {
	CartItem removal = head;
	//return null if list is empty
        if(head==null){
		return null;
	}
	//make the second item the new head to remove the first item
	else{
		head=head.next;
	}
	//decrease the item count
	count--;
	//return the product removed
        return removal.getProduct();
    }    

    /// Remove a specified product from the cart shortening the list by one
    /// and returning the product that was removed
    /// @param product the product to search for and remove from the cart
    /// @return the product that was removed if the cart was not empty;
    ///         otherwise, null
    public Product remove(Product product) {
	//return null is list is empty
        if(head==null){
		return null;
	}
	CartItem it = head;
	CartItem prev = null;
	//find the item before what is being removed
	while((it!= null)&&(it.getProduct()!=product)){
		prev = it;
		it=it.next;
	}
	//link the item from before the removal to the item after to remove the desired item
	if(it==head){
		head=it.next;
	}
	else{
		prev.next=it.next;
	}
	//decrease item count
	count--;
	//return the product removed
        return product;
    }

    /// Removes all products from the cart and resets it to an empty state
    public void clear() {
	//set the list and count back to the default values
        head=null;
	count=0;
    }
    
    /// Checks the cart to see if it contains no products.  
    /// @return true if the cart contains no products; otherwise, false 
    public boolean isEmpty() {
	//return true if the list is empty
        if(head==null){
		return true;
	}
	else{
        return false;
	}
    }
    
    /// Returns the number of products stored in the cart
    /// @return the number of products stored in the cart
    public int count() {
        //return the global count variable
        return count;
    }
    
    /// Returns a product in the list based on its index.  The index must 
    /// be less than the count of the the cart and if not a null is returned
    /// @param i the index of the product to get in the cart where i must
    ///          be in the range [0,count-1]
    /// @return the product stored at index i, or null if i is invalid
    public Product get(int i) {
        CartItem it= head;
	//return null if the index is invalid (negative)
	if(i<0){
		return null;
	}
	//find the product at the index passed through
	while((it!=null)&&(i>0)){
		i--;
		it=it.next;
	}
	//if i isn't 0 then the list doesn't have that many indexes return null
	if(i>0){
        return null;
	}
	//if it isnt null return it's product if it is null return null
	else if(it!=null){
		return it.getProduct();
	}
	else{
		return null;
	}
    }

    /// Returns a truth value that indicates whether a reference to the 
    /// specified product currently exists in the cart
    /// @param product the product to search for
    /// @return true if a reference to the product exists in the cart;
    ///         otherwise, false
    public boolean contains(Product product) {
	    CartItem it = head;
	    boolean present = false;
	    //loop through looking for the product sent in the parameter
	    while(it!=null){
		    if(it.getProduct()==product){
			    //present is true if the list contains the product
			    present=true;
		    }
		    it=it.next;
	    }
	//return the present variable 
        return present;
    }

    /// Returns a truth value indicating whether the cart's structural 
    /// integrity remains valid.  If the integrity is no longer valid,
    /// then the cart should be invalidated and usage should not be trusted
    /// @return true if the cart integrity is valid; otherwise, false
    public boolean isIntegrityValid() {
        if(count < 0) {
            System.out.println("1");
            return false;
        }
        if(count == 0 && head == null) {
            return true;
        }
        if(count == 1 && head != null && head.next == null) {
            return true;
        }

        int n = 1;
        CartItem it = head;
        while(it.next != null) {
            it = it.next;
            n++;
        }

        if(n != count) {
            System.out.println("2");
            return false;
        }

        return true;
    }

    /// Returns a string that contains information about the list and the 
    /// contents of the list.  This is mostly useful for visual debugging 
    /// @return a string containing information about the contents of the 
    ///         cart
    public String toString() {
        String s = "";
        s = "LinkedList::count=" + count(); 
        s += ", isEmpty=" + isEmpty(); 
        s += ", ["; 
        CartItem it = head;
        while(it != null) {
            if(it != head) {
                s += ", ";
            }
            s += it.getProduct().getName();
            s += "@$";
            s += it.getProduct().getPrice();
            it = it.next;
        }
        s += "]";

        return s; 
    }

    /// Returns the sum total price of all products in the cart and then 
    /// clears the cart of all products
    /// @return the sum total price of all products in the cart
    public double checkout() {
        double total = 0.0;

        CartItem it = head;
        while(it != null) {
            total += it.getProduct().getPrice();
            it = it.next;
        }
        clear();
        return total;
    }

    //--------------------------------------------------------------------
    // Utilities
    //--------------------------------------------------------------------

}
