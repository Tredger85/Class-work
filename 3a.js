class Vehicle {
	constructor(year, make, model) {
		this.year = year;
		this.make = make;
		this.model = model;
        this.speed = 0;
        this.totalDistance += this.speed;
	}
	accellerate() {
		this.speed += 5;
	}
	brake() {
		if (this.speed > 5)
			this.speed -= 5;
		else
			this.speed = 0;
	}
	getSpeed() {
		return this.speed;
    }
    getDistance(){
        return this.totalDistance;
    }
}

class Van extends Vehicle {
	constructor(year, make, model) {
		super(year,make,model);
		this.passengers = 8;
	}
	accellerate() {
		this.speed +=3;
	}
}

class SportsCar extends Vehicle {
	constructor(year, make, model) {
		super(year,make,model);
		this.passengers = 2;
	}
	accellerate() {
		this.speed +=10;
	}
}

var frogCar = new SportsCar(1962,Porshe, 911);
var lorry = new Van(2004, Mercedez-Benz, Sprinter);
var bug = new Vehicle(1978, Volkswagen, Beetle);

frogCar.accellerate();
lorry.accellerate();
bug.accellerate();

frogCar.accellerate();
lorry.accellerate();
bug.accellerate();

frogCar.accellerate();
lorry.accellerate();
bug.accellerate();

frogCar.brake();
lorry.brake();
bug.brake();

frogCar.brake();
lorry.brake();
bug.brake();

console.log(frogCar.getSpeed());
console.log(lorry.getSpeed());
console.log(bug.getSpeed());

console.log(frogCar.getDistance());
console.log(lorry.getDistance());
console.log(bug.getDistance());