//Andrew Franko
//Function plays Rock paper scissors
//No parameter is passed through the function but input from a form is called in the function
//Output is both what the computer randomizes Rock paper scissors and the outcome of the game
function rps (){	
	var compThrow;
	//Randomizes a number 1-3, used for the rps options
	var rand = Math.floor(Math.random()*3+1);
	if (rand == 1) {
		compThrow = "ROCK";
	} else if (rand == 2) {
		compThrow = "PAPER";
	} else {
		compThrow = "SCISSORS";
	}	
	var userThrow=(document.form.userThrow.value).toUpperCase();
	//Test to make sure that the input is valid
	if (userThrow=="ROCK"||userThrow=="PAPER"||userThrow=="SCISSORS"){
        document.form.compThrow.value=compThrow;
        //Test for tie, 3 of 9 possible cases
		if(userThrow==compThrow){
            document.form.output.value="You and the computer chose " + userThrow +", the game is a draw";
		} else if ((userThrow=="ROCK"&&compThrow=="SCISSORS")||
					(userThrow=="PAPER"&&compThrow=="ROCK")||
					(userThrow=="SCISSORS"&&compThrow=="PAPER")){
            //Output for wins
            document.form.output.value= userThrow+" defeats "+compThrow+ ", YOU WIN!!!";
        //Else case covers all non-win and non-draw ie loss, 3 of 9 possible cases
        } else {
            //Output for losing the game
            document.form.output.value= compThrow + " defeats "+userThrow+", You Lose :(";
        }
	//Failure to enter rock, paper or scissors regardless of capitalization	
	} else {
		document.form.output.value="Invalid input";
	}
}
			