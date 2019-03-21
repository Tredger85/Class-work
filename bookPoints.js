//Andrew Franko
//Declare the function
function bookPoints(){
	//Test to see if a negative number was entered, preventing a negative from hitting the default
	if(parseInt(document.form.points.value)<0){
		//Error message for a negative number
		document.form.output.value=("Enter a positive number");
	//If entered number is not negative
	} else {
		//Setting up a switch statement based on the inport value
		switch(parseInt(document.form.points.value)) {
			//First case, no books bought
			case 0:
				//Output points for no books
				document.form.output.value=0;
				//Exiting the case
				break;
			//Second case, one book bought
			case 1:
				//Output points for one book
				document.form.output.value=5;
				//Exiting the case
				break;
			//Third case, two books bought
			case 2:
				//Output points for two books
				document.form.output.value=15;
				//Exiting the case
				break;
			//Fourth case, three books bought
			case 3:
				//Output points for three books
				document.form.output.value=30;
				//Exiting the case
				break;
			//All cases that are greater than 3 books(negative numbers were discarded)
			default:
				document.form.output.value=60;
				//Exiting the case, knowing that the break isn't required but is good form
				break;
		}
	}
}