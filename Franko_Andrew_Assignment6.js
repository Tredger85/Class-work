//Andrew Franko

//Problem 1, counting the number of vowels in a given string
function numVowels(s){
    //starts a running count of occurances
    var count = 0;
    //steps through input string
    for(let i = 0; i<s.length; i++){
        //tests if the current location is a vowel
        if (s[i]=='a'||s[i]=='e'||s[i]=='i'||s[i]=='o'||s[i]=='u'){
            //increments if true
            count++;
        }
    }
    console.log("Number of vowels: "+count);
}

//Problem 2, counting the number of times a string appears in a longer string
function numOfBob(s){
    //starts a running count of occurances
    var count = 0;
    //steps through input string, stops at the last place the 'bob' could start
    for(let i = 0; i<s.length-2; i++){
        //tests if the 'bob' starts at the current locatioin
        if (s[i]=='b'&&s[i+1]=='o'&&s[i+2]=='b'){
            //increments if true
            count++;
        }
    }
    console.log("Number of times bob occurs is: "+count);
}

var s = 'azcbobobegghakl';
numVowels(s);
numOfBob(s);