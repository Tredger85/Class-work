function reverse (word){
    var result = []
    var counter = 1;
    while(counter < word.length) {
        result.concat(word[word.length-counter]);
        counter++;
    }
    Console.info(result);
}

reverse("Hello");

var reverse = ["one", "two", "three", "four"];

reverse(reverse);
