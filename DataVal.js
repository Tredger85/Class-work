//Andrew Franko
//I tested each if statement of each input.  No entry, below range, above range and incorrect 
//data type
function dataVal (){
    //Declare the veriables to use later and only set them after each entry is verified to meet requirements
    var verifiedName
    var verifiedNum1
    var verifiedNum2
    var verifiedNum3
    var verifiedNum4
    var verifiedNum5
    //Pulls the name from the form		
    var name=(document.form.name.value);
    /*This second test feels odd but the test is to see if we 
    can complete a mathimatical operation it is a number*/
    if(1+name>1){
        document.form.name.value="Please enter a name and not a number";
    } else if (name.length<2){
        document.form.name.value="Not enough characters to distinqish you";
    } else {
        verifiedName = name;
    }
    //Pulls the first number from the form
    var num1=(document.form.num1.value);
    if(num1.length==0){
        document.getElementById("num1output").innerHTML="Please enter a number";
    }else if(typeof num1 === 'number'){
        document.getElementById("num1output").innerHTML="Its a number";
    }else if (num1<1){
		document.getElementById("num1output").innerHTML="Enter a larger number";
	} else if (num1>100){
        document.getElementById("num1output").innerHTML="Enter a smaller number";
    } else if (Math.ceil(num1)!=num1){
        document.getElementById("num1output").innerHTML="Enter a whole number";
    } else {
        verifiedNum1 = num1;
    }
    //Pulls the second number from the form
    var num2=(document.form.num2.value);
	if(num2.length==0){
        document.getElementById("num2output").innerHTML="Please enter a number";
    }else if (num2<50){
		document.getElementById("num2output").innerHTML="Enter a larger number";
	} else if (num2>150){
        document.getElementById("num2output").innerHTML="Enter a smaller number";
    } else if (Math.ceil(num2)!=num2){
        document.getElementById("num2output").innerHTML="Enter a whole number";
    } else {
        verifiedNum2 = num2;
    }
    //Pulls the third number from the form
    var num3=(document.form.num3.value);
	if(num3.length==0){
        document.getElementById("num3output").innerHTML="Please enter a number";
    }else if (num3>=0){
        document.getElementById("num3output").innerHTML="Enter a negative number";
    } else {
        verifiedNum3 = num3;
    }
    //Pulls the fourth number from the form
    var num4=(document.form.num4.value);
    if(num4.length==0){
        document.getElementById("num4output").innerHTML="Please enter a number";
    }else{
        verifiedNum4 = num4;
    }
    //Pulls the fith number from the form
    var num5=(document.form.num5.value);
    if(num5.length==0){
        document.getElementById("num5output").innerHTML ="Please enter a number";
    }else{
        verifiedNum5 = num5;
    }
    //Determining and saving the highest(max) entered number
    var maxVal= Math.max(verifiedNum1,verifiedNum2,verifiedNum3,verifiedNum4,verifiedNum5);
    //Determining and saving the highest(max) entered number
    var minVal=Math.min(verifiedNum1,verifiedNum2,verifiedNum3,verifiedNum4,verifiedNum5);
    //Saving the sum of all the entered numbers
    var sum = verifiedNum1+verifiedNum2+verifiedNum3+verifiedNum4+verifiedNum5;
    document.getElementById("output").innerHTML = "Hello, "+verifiedName+".  You entered: "+verifiedNum1+", "+verifiedNum2+", "+verifiedNum3+", "+verifiedNum4+", "+verifiedNum5+".  The largest number entered was "+maxVal+".  The smallest number you entered was "+minVal+".  And the sum of all of the numbers was "+sum+".";
}
