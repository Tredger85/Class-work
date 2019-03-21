//Andrew Franko
class BankAccount{
	constructor(id, initialBalance) {
		this.id = id;
        this.balance = initialBalance;
    }
    depositAmount(toDeposit){
        if(toDeposit<0){
            return "Invalid amount.  Amount must be positive.  Please try again" ;
        } else {
            this.balance +=toDeposit;
            return "Your current balance is "+this.balance;
        }
    }
    withDraw(withDrawn){
        if(withDrawn<0){
            return "Invalid amount.  Amount must be positive.  Please try again" ;
        } else if(withDrawn>this.balance){
            return"Insufficient fund!!!";
        }else {
            this.balance -=withDrawn;
            return "Withdraw is complete, and your current balance is "+this.balance;
        }
    }
}

class Bank{
	constructor(name, accounts) {
		this.name = name;
        this.accounts = accounts;
    }

    addAccount(accountName){
        this.accounts.push(accountName);
    }

    removeAccount(accountName){
        for(let i = 0; i<this.accounts.length; i++){
            if (this.accounts[i]===accountName){
                delete this.accounts[i];
            }
        }
    }
}

var account1 = new BankAccount(1, 500);

var account2 = new BankAccount(2, 1000);

var account3 = new BankAccount(3, 5000);

 

console.log(account1.withDraw(600));

console.log(account2.withDraw(600));

accounts = [account1, account2, account3]

 

bank = new Bank("mybank", [])

//use the for-loop to iterate the accounts array add each bank account to the bank object using addAccount method.

for(let a = 0; a<accounts.length; a++){
    bank.addAccount(accounts[a]);
}

bank.removeAccount("account1");

console.log(bank);