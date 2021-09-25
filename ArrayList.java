/*--------------------------------------------------------------------------
GWU - CS1112 Data Structures and Algorithms - Spring 2021

This is the implementation layer for an array based shopping cart.  It 
implements the interface prescribed by the ShoppingCart class.

This class could be more generalized; however, it is specialized to make
the Shopping Cart application a little easier to implement for new students

authors: Lindsey Cicero 
--------------------------------------------------------------------------*/
public class ArrayList implements ShoppingCart {
    // For an array-based list, the array itself
    private CartItem[] data;
    // The counter to track the number of elements in the list
    private int count;

    // Parameterless Constructor
    public ArrayList() {
        count = 0;
        data = new CartItem[2];
    }
   
    /// Adds a product to the cart
    /// @param product the product to add to the cart
    public void add(Product product) {
        boolean space = false;
	int firstOpen = 0;
	//checks if there is open space and if so at what index
	for(int i=0; i<data.length; i++){
		if(data[i]==null){
			space=true;
			firstOpen=i;
			break;
		}
	}
	//if there is space creates new object at the first open space
	if(space==true){
		data[firstOpen]= new CartItem(product);
		//increase item count
		count++;
	}
	//if not then alllocate new array with doubling
	//then add the new object
	else{
		CartItem[] temp = new CartItem[data.length*2];
		for(int i=0; i<data.length; i++){
			temp[i]=data[i];
		}
		firstOpen=data.length;
		data = temp;
		data[firstOpen] = new CartItem(product);
		//increase item count
		count++;
	}


    }

    /// Remove the first product in the cart shortening the list by one and
    /// returning the product that was removed
    /// @return the product that was removed if the cart was not empty;
    ///         otherwise, null
    public Product remove() {
	//checks that there is something to remove at the front of the list
	if(data[0]==null){
		return null;
	}
        CartItem removal = data[0];
	CartItem[] temp = new CartItem[data.length];
	//fills a temproary array that moves all of the items up one
	for(int i=1; i<data.length; i++){
		temp[i-1]=data[i];
	}
	//have data point to the array that has the first item removed
	data=temp;
	//decrease the item count and return the item removed
	count--;
        return removal.getProduct();
    }

    /// Remove a specified product from the cart shortening the list by one
    /// and returning the product that was removed
    /// @param product the product to search for and remove from the cart
    /// @return the product that was removed if the cart was not empty;
    ///         otherwise, null
    public Product remove(Product product) {
	    int location = -1;
	    //find the location of the product being removed
	    for(int i=0; i<data.length;i++){
		    if((data[i]!=null)&&(data[i].getProduct()==product)){
			    location=i;
		    }
	    }
	    //return null if the array doesn't contain the product passed
	    if(location==-1){
		    return null;
	    }
	    //fill a temp array with the items from data that aren't being removed
	    else{
	   	 CartItem[] temp =new CartItem[data.length];
		 for(int i=0; i<data.length;i++){
			 if(i!=location){
				 temp[i]=data[i];
			 }
			 //skip the item being removed 
			 else if((i==location)&&(data.length<(i+1))){
				 temp[i]=data[i+1];
			 }
		 }
		 //have data point to the array that has the desired item removed 
		 data=temp;
		 //decrease the item count
		 count--;
	    }
	    //return the product removed
	return product;	    
	    
    }
    
    /// Removes all products from the cart and resets it to an empty state
    public void clear() {
	//set the array and count back to the default
        count=0;
	//array size shrinks back to original
	data = new CartItem[2];
    }
    
    /// Checks the cart to see if it contains no products.  
    /// @return true if the cart contains no products; otherwise, false 
    public boolean isEmpty() {
	//check that the array is not empty
		if(data[0]==null){
			return true;
		}
		else{
			return false;
		}
    }
    
    /// Returns the number of products stored in the cart
    /// @return the number of products stored in the cart
    public int count() {
	//reutrn the global item count
        return count;
    }
    
    /// Returns a product in the list based on its index.  The index must 
    /// be less than the count of the the cart and if not a null is returned
    /// @param i the index of the product to get in the cart where i must
    ///          be in the range [0,count-1]
    /// @return the product stored at index i, or null if i is invalid
    public Product get(int i) {
	//if the index is to big or to small for the array length return null
        if((data.length<i)||(i<0)){
        return null;
	}
	//return the product if it isnt null otherwise return null
	else if(data[i]!=null){
		return data[i].getProduct();
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
        boolean contains = false;
	//loop through and check for passed product
	for(int i=0; i<data.length;i++){
		if((data[i]!=null)&&(data[i].getProduct()==product)){
			//if product is in the array set contains to true
			contains=true;
		}
	}
	//return contain boolean value
        return contains;
    }

    /// Returns a truth value indicating whether the cart's structural 
    /// integrity remains valid.  If the integrity is no longer valid,
    /// then the cart should be invalidated and usage should not be trusted
    /// @return true if the cart integrity is valid; otherwise, false
    public boolean isIntegrityValid() {
        if(count < 0) {
            return false;
        }
        if(data == null) {
            return false;
        }
        if(count > data.length) {
            return false;
        }
        for(int i = 0; i < count; i++) {
            if(data[i] == null) {
                return false;
            }
        }

        return true;
    }

    /// Returns a string that contains information about the list and the 
    /// contents of the list.  This is mostly useful for visual debugging 
    /// @return a string containing information about the contents of the 
    ///         cart
    public String toString() {
        String s = "";
        s = "ArrayList::allocated=" + data.length;
        s += ", count=" + count(); 
        s += ", isEmpty=" + isEmpty(); 
        s += ", ["; 
        for(int i = 0; i < count; i++) {
            if(i > 0) {
                s += ", ";
            }
            s += data[i].getProduct().getName();
            s += "@$";
            s += data[i].getProduct().getPrice();
        }
        s += "]";
        return s;
    }

    /// Returns the sum total price of all products in the cart and then 
    /// clears the cart of all products
    /// @return the sum total price of all products in the cart
    public double checkout() {
        double total = 0.0;

        for(int i = 0; i < count; i++) {
            total += data[i].getProduct().getPrice();
        }
        clear();
        return total;
    }

    //--------------------------------------------------------------------
    // Utilities
    //--------------------------------------------------------------------

}
