
var wrapper = () => (x,y) => x+y;

var sum = wrapper()(4,5);
console.log(sum);
