//Andrew Franko
//Function plays Rock paper scissors
//No parameter is passed through the function but input from a form is called in the function
//Output is both what the computer randomizes Rock paper scissors and the outcome of the game
function rps (){
	//variable to hold a random rock paper scissors selection		
	var compThrow;
	//Randomizes a number 1-3, used for the rps options
	var rand = Math.floor(Math.random()*3+1);
	//Tests the random number
	if (rand == 1) {
		//Sets the computer selection to rock
		compThrow = "ROCK";
	//Tests the random number
	} else if (rand == 2) {
		//Sets the computer selection to paper
		compThrow = "PAPER";
	//If the first two tests fail, ie not 1 or 2 and there for 3 from the random number
	} else {
		//Sets the computer selection to scissors
		compThrow = "SCISSORS";
	}	
	//Pulls the user input from the HTML form and sets it to all caps for testing
	var userThrow=(document.form.userThrow.value).toUpperCase();
	//Test to make sure that the input is valid
	if (userThrow=="ROCK"||userThrow=="PAPER"||userThrow=="SCISSORS"){
		//Displays what the resault of random value for the computer
		document.form.compThrow.value=compThrow;
		//Test if the user and computer have the same value, 3 of 9 possible cases
		if(userThrow==compThrow){
			//Output for a tie/Draw
			document.form.output.value="Draw";
		//Tests for the user win cases, broken up into seperate lines for simple reading
		} else if ((userThrow=="ROCK"&&compThrow=="SCISSORS")||
					//second win case
					(userThrow=="PAPER"&&compThrow=="ROCK")||
					//third win case
					(userThrow=="SCISSORS"&&compThrow=="PAPER")){
						//Output for wins
						document.form.output.value="YOU WIN!!!";
					//Else case covers all non-win and non-draw ie loss, 3 of 9 possible cases
					} else {
						//Output for losing the game
						document.form.output.value="You Lose :(";
					}
	//Failure to enter rock, paper or scissors regardless of capitalization	
	} else {
		//Returns error message into the HTML form
		document.form.output.value="Invalid input";
	}
}
			