//Full fill the call of isEvenCounter, 
//No parameter is input to this outer function
//Returns two print outs detailing how many evens and odds were generated this run

function isEvenCounter(){
	//Declaring the evens counter on the outside of the for loop to prevent localization
	var evens=0;
	//Using a for loop to generate 100 random numbers
	for(var i=0; i<100; i++){
		//Generating a random number 1-100, theoretically the program would work just as well by multiplying by 2
		var rand=Math.floor(1+Math.random()*100);
		//Calling the function and passing the random number through
		if(isEven(rand)){
			//Uses the if true from the function to increment evens
			evens++;
		}
	}
	//Print out the number of evens that were generated
	document.write("There was "+evens+" evens in this run</br>");
	//Print out the number of odds, knowing that we ran it 100 times total minus evens will get number of odds
	document.write("There was "+(100-evens)+" odds in this run");
}

//Determines if a number is even
//The parameter is expecting a whole number
//Returning a boolean
function isEven(num){
	//tests if the input parameter is even
	if(num%2==0){
		//sends back the boolean true to the calling function
		return true;
	}
}