//Andrew Franko
function remainingBalance(balance,annualInterestRate,monthlyPaymentRate){
    //Testing for input both valid(actually owing money) and in the format that is expected(decimals)
    if (annualInterestRate>1 || monthlyPaymentRate>1 || annualInterestRate<0 || monthlyPaymentRate<0){
        console.log("The Annual Interest Rate and Monthly Payment Rate must both be represented by a positive decimal");
    } else if(balance<0){
        console.log("The amount owed is represented by a positive number");
    } else {
        //Calculating Monthly Interest Rate
        var mir = annualInterestRate/12;
        //Creating a localized variable to be manipulated
        var balance = balance;
        //Stepping through each of the months
        for( let i= 0; i<12; i++){
            //Calculating minimum payment based on current balance and then reducing the current balance
            balance -=(balance*monthlyPaymentRate);
            balance +=mir*balance;
        }
        console.log("Remaining balance: "+Math.round(100*balance)/100);
    }
}

// Personal testing below
/* remainingBalance(-1000, .5, .5);
remainingBalance(1000, -.5, 5);
remainingBalance(1000, .5, -5);
remainingBalance(1000, .5, 5);
remainingBalance(1000, 5, .5);
remainingBalance(1000,.07,.05);
remainingBalance(1000,.12,.01); */