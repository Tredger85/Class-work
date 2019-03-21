function calculateSums(array){
    var counter = 0;
    var sumP = 0;
    var sumN = 0;
    while (counter<array.length){
        if(array[counter]<0){
            sumN += Math.abs(array[counter]);
        } else {
            sumP += array[counter];
        }
        counter++;
    }
    return "The array, ["+array+"], calculates as "+(sumP >= sumN);
}
function calculateSumsMain(){
    document.getElementById("output1").innerHTML =calculateSums([0]);
    document.getElementById("output2").innerHTML =calculateSums([1]);
    document.getElementById("output3").innerHTML =calculateSums([-1]);
    document.getElementById("output4").innerHTML =calculateSums([-1,1]);
    document.getElementById("output5").innerHTML =calculateSums([1,-1]);
    document.getElementById("output6").innerHTML =calculateSums([1,-2,3,-4,5,-6]);
    document.getElementById("output7").innerHTML =calculateSums([-1,2,-3,4,-5,6]);
}
/*var newArray=[1,-2,3,-4,5,-6];
var arrayTwo=[5,-7,-7,-7,9,15,1];

console.log(arraySum(newArray));
console.log(arraySum(arrayTwo));*/