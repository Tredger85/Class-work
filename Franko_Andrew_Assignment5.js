/*Andrew Franko
Here is the web form that was requested

<html>
	<head>
	<script src="validateCreditCard.js"></script>
		<title>Validate Credit Card</title>
	</head>
	<body>
		<form name="form" id="form" method="post">
			<label for="textBox">Enter your card number to validate,</br> Include dashes between every fourth number:</br>
			(xxxx-xxxx-xxxx-xxxx)</label></br>
			<input id="card" name="card" type="text" size="20" /><br/>
			<input id="button" type="button" id="button2" value="Validate" onclick="validateCreditCard()"/><br/>
			<p id="output"></p>
		</form>
	</body>
</html>

I had writen the validateCreditCard.js to tie to this but changed it after the request at the bottom to only submit one .js fileCreatedDate

/* All testing was completed through the web form.
function to validate the 'credit card' number based on given values
While typically for security reasons, not giving away too much, I would not have included the messages in 
the paranethasis and just returned an error.  I thought of refactoring it to do all of the processing
up front and then doing just one switch statement but was happy enough with the current functions readablity*/
//Over all function
function validateCreditCard(card){
	var error = "";
	var valid = false;
	function validation(){
		if (error == ""){
			return "{ valid: "+valid+", number: "+card+" }";
		} else {
			return "{ valid: "+valid+", number: "+card+", error: "+error+" }";
		}
	}
	/*Nothing else needs to be done to the input to determine Length, last number even or 
	correct placement of dashes. This saves time and space by avoiding all of the created arrays*/
	if (card.length != 19){
		error = "Error: invalid length(The total length is not correct, dashes must be included )";
		return validation();
	}else if (card[18]%2 != 0){
		error = "Error: invalid number(The last number must be even)";
		return validation();
	}else if (card[4] != "-" || card[9] != "-" || card[14] != "-"){
		error ="Error: invalid formating(The dashes are incorrectly entered)";
		return validation();
	}else{
		//Removing the dashes from the input and putting the substrings back together
		var cardSplit = card.split("-");
		var cardNumber = cardSplit.join("");
		//Test to see if there are any non-number characters
		if (parseInt(cardNumber) != cardNumber){
			error = "Error: unexpected characters(The Card number only has numbers)";
			return validation();
		} else {
			//Creating a running total and a new array to capture which numbers were used
			var cardTotal = 0;
			var numbersOnCard = [];
			numbersOnCard.length = 10;
			numbersOnCard.fill(0);
			//Steping through the card number with the dashes only once
			for(let i = 0; i<16; i++){
				cardTotal += parseInt(cardNumber[i]);
				numbersOnCard[parseInt(cardNumber[i])]++;
			}
			//Test if total of printed numbers is less than 16
			if (cardTotal<16){
				error = "Error: invalid number(The total is not enough)";
				return validation();
			} else {
				//Created a var to track how many different numbers were used
				var differentNumbers = 0;
				//Step through the array that holds the count of which numbers were used
				for(let j = 0; j<10; j++){
					if(parseInt(numbersOnCard[j])>0){
						differentNumbers++;
					}
				}
				//Test to see if the entered card number was just one number repeated
				if (differentNumbers ==1){
					error = "Error: invalid number(All the same number)";
					return validation();
				//To get here all of the tests must have passed and there for the number is valid by our standard
				} else {
					valid = true;
					return validation();
				}
			}
		}
	}
}


/*
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

/*My testing:

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
console.log(cart4.cashRegister()); */