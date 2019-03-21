function sumArray(array){
	var total = 0;
	for(var i = 0; i<array.length; i++){
		total+=array[i];
	}
	return total;
}

function average(array){
	return sumArray(array)/array.length;
}

function fillArray(){
	var numbers = new Array();
	var more = true;
	for(var i=0; more; i++){
		numbers[i] = parseInt(prompt("Enter a positive or negative number");
		more = confirm("Enter another number?");
	}
	return numbers;
}

function findHighest(array){
	var high = array[0];
	for (var i=0; i<array.length; i++){
		if (array[i]>high){
			high=array[i];
		}
	}
	return high;
}

function findLow(array){
	var low = array[0];
	for (var i=0; i<array.length; i++){
		if (array[i]<low){
			low=array[i];
		}
	}
	return low;
}

function copyArray(array){
	var array_copy = new Array();
	for(var i =0; i<array.length; i++){
		array_copy[i]=array[i];
	}
	return array_copy;
}