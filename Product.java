public class Product {

    private final String name;
    private final double price;

    //add extra variable fields for extension here

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    //checks to see if two products are equal
    public boolean equals(Product other) {
        return (name.equals(other.name)) && price == (other.price);
    }

    public int compareTo(Product other) {
        if( name.equals(other.name) && price == other.price ) {
            return 0;
        }
        int result = name.compareTo(other.name);
        if( result != 0 ) {
            return result;
        }
        if( other.price < price ) {
            return 1;
        }
        return -1;
    }

    public String toString() {
        String s = new String(name);
        s += "::" + price;
        return s;
    }

    //add extra functions for extension here
}
