/*Andrew Franko
Creating a shopping cart and returning the total.
Added returning of items in the cart and the bonus if taxable*/

//Top object to hold everything
function shoppingCart(){
	//Initializing global veriables
	this.items = [];
	this.totalPrice = 0;
	//Placing new items in the cart, chaging price if taxable
	this.add = function (name,price,taxable){
		//If empty do nothing, classic fence post issue
	  if(this.items.length!==0){
	    this.items += ", ";
	  }
		this.items += name;
		//Relying on taxable being a boolean for simplifying code
		if (taxable){
			this.totalPrice += (1.1*parseFloat(price));
		} else {
			this.totalPrice += parseFloat(price);
		}
	}
	//Returns Items in the cart or if empty
	this.getItemsInCart = function() {
	  if (this.items.length === 0 ){
	    return "Cart is empty";
	  }
		return this.items;
	}
	//Returns the running total
	this.cashRegister = function() {
		//Rounding to standard dollars and cents
        return "Your total is: $" + this.totalPrice.toFixed(2);
	}
}


var cart1 = new shoppingCart();
var cart2 = new shoppingCart();
var cart3 = new shoppingCart();
var cart4 = new shoppingCart();

cart2.add("Frozen Pees", 5.99,false);
cart2.add("Carrots", 2.99,false);

cart3.add("Red Wine", 14.99,false);
cart3.add("Ritz Crackers", 3.99,false);
cart3.add("Assorted Cheeses", 9.99,false);
cart3.add("Holiday Cheese Knife", 12.99,true);

cart4.add("Sheets", 25.99,true);
cart4.add("Towle", 9.99,true);
cart4.add("Plunger", 5.99,true);
cart4.add("Plunger", 5.99,true);

console.log(cart1.getItemsInCart());
console.log(cart1.cashRegister());

console.log(cart2.getItemsInCart());
console.log(cart2.cashRegister());

console.log(cart3.getItemsInCart());
console.log(cart3.cashRegister());

console.log(cart4.getItemsInCart());
console.log(cart4.cashRegister());