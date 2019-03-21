/* Andrew Franko
function to validate the 'credit card' number based on given values
While typically for security reasons, not giving away too much, I would not have included the messages in 
the paranethasis and just returned an error.  I thought of refactoring it to do all of the processing
up front and then doing just one switch statement but was happy enough with the current functions readablity*/
//Over all function
function validateCreditCard(){
	//Taking in the input value
	var card = document.form.card.value;
	/*Nothing else needs to be done to the input to determine Length, last number even or 
	correct placement of dashes. This saves time and space by avoiding all of the created arrays*/
	if (card.length != 19){
		document.getElementById("output").innerHTML = "Error: invalid length(The total length is not correct, dashes must be included )";
	}else if (card[18]%2 != 0){
		document.getElementById("output").innerHTML = "Error: invalid number(The last number must be even)";
	}else if (card[4] != "-" || card[9] != "-" || card[14] != "-"){
		document.getElementById("output").innerHTML = "Error: invalid formating(The dashes are incorrectly entered)";
	}else{
		//Removing the dashes from the input and putting the substrings back together
		var cardSplit = card.split("-");
		var cardNumber = cardSplit.join("");
		//Test to see if there are any non-number characters
		if (parseInt(cardNumber) != cardNumber){
			document.getElementById("output").innerHTML = "Error: unexpected characters(The Card number only has numbers)";
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
				document.getElementById("output").innerHTML = "Error: invalid number(The total is not enough)";
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
					document.getElementById("output").innerHTML = "Error: invalid number(All the same number)";
				//To get here all of the tests must have passed and there for the number is valid by our standard
				} else {
					document.getElementById("output").innerHTML = "Valid";
				}
			}
		}
	}
}