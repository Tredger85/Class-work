var alphabet = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
        'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
        't', 'u', 'v', 'w', 'x', 'y', 'z'];
var guessed = [];
var fourfive = ["five","quilt","zoom","seven","jazz"];
var sixseven = ["flower","towers","younger","coquet", "jigsaw"];
var eightplus = ["exercise","boulevard", "supercalifragilisticexpialidocious","yourself","javascript"];
var secritWord;
var showWord = [];
var guessedCounter = 0;

function newgame(selection){
    showWord = [];
    secritWord = selection[Math.floor(Math.random()*5)];
    for (let i = 0; i<secritWord.length; i++){
        showWord.push('_');
    }
    guessedCounter = 8;
    document.getElementById("output1").innerHTML = "Welcome to Hangmen!";
    document.getElementById("output2").innerHTML = "The selected word is "+secritWord.length+" letters long." ;
}

function current(){
    document.getElementById("output4").innerHTML = showWord;
    document.getElementById("output5").innerHTML = "You have not guessed:";
    document.getElementById("output6").innerHTML = alphabet;
    document.getElementById("output7").innerHTML = "You have "+guessedCounter+ " guesses left.";
}

function letterGuess(){
    if(guessedCounter>0){
        var letter = document.form.guess.value;
        document.getElementById("guess").innerHTML = "";
        if (letter.length>1){
            document.getElementById("output3").innerHTML = "You can only enter one letter at a time";
        } else if(alphabet.indexOf(letter)<0 && guessed.indexOf(letter)<0){
            document.getElementById("output3").innerHTML = "You did not guess a letter, try again";
        } else if(alphabet.indexOf(letter)<0){
            document.getElementById("output3").innerHTML = "You have already guessed that letter, try again";
        } else if(secritWord.indexOf(letter)<0){
            guessedCounter--;
            if (guessedCounter===0){
                document.getElementById("output3").innerHTML = "Sorry, you ran out of guesses. The word was "+secritWord;
            } else {
                guessed.push(letter);
                alphabet.splice(alphabet.indexOf(letter),1,'_');
                document.getElementById("output3").innerHTML = "That letter is not in the hidden word.";
            }       
        } else {
            var letterlocation = secritWord.indexOf(letter);
            showWord.splice(letterlocation,1,letter);
            while (secritWord.indexOf(letter, letterlocation+1)>0){
                letterlocation = secritWord.indexOf(letter, letterlocation+1);
                showWord.splice(letterlocation,1,letter);
            }
            guessed.push(letter);
            alphabet.splice(alphabet.indexOf(letter),1,'_');
        }
        current();
        if(showWord.indexOf('_')<0){
            document.getElementById("output3").innerHTML = "Congratulations, YOU WON!!"
            document.getElementById("output4").innerHTML = showWord;
            document.getElementById("output5").innerHTML = "";
            document.getElementById("output6").innerHTML = "";
            document.getElementById("output7").innerHTML = "";
        }
    }else{
        document.getElementById("output3").innerHTML = "Sorry, you ran out of guesses. The word was "+secritWord;
    }
}
