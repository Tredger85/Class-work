/*CSD 210 ExtraCredit
Andrew Franko 3/7/18
Create a class that holds fractions and
number of methods for basic math functions between fractions.
Also a method to reduce the fraction to lowest common denomiator.*/

public class RationalNumber {
        int nume=0;
        int denom=0;
        
    public RationalNumber(int numerator, int denominator){
        nume=numerator;
        denom=denominator;
        if(denom==0){
            throw new IllegalArgumentException();
        }
        reduce();
    }
    
    public RationalNumber(){
        nume=0;
        denom=1;
    }
    
    public int getDenominator(){
        return denom;
    }
    
    public int getNumerator(){
        return nume;
    }
    
    public String toString(){
        if(denom==1){
            return nume+" ";
        }
        return nume+"/"+denom;
    }
    
    public void reduce(){
        for(int i=nume; i>1; i--){
            if(nume%i==0&&denom%i==0){
                nume=nume/i;
                denom=denom/i;
            }
        }
        if(denom<0){
            nume*=-1;
            denom*=-1;
        }
    }
    
    public void addRationalNumber(RationalNumber other){
        nume=(nume*other.denom)+(other.nume*denom);
        denom*=other.denom;
        reduce();
    }
    
    public void subtractRationalNumber(RationalNumber other){
        nume=(nume*other.denom)-(other.nume*denom);
        denom*=other.denom;
        reduce();
    }
    
    public void multiplyRationalNumber(RationalNumber other){
        nume*=other.nume;
        denom*=other.denom;
        reduce();
    }
    
    public void devideRationalNumber(RationalNumber other){
        nume*=other.denom;
        denom*=other.nume;
        reduce();
    }

public static void main (String[] args){
    RationalNumber first=new RationalNumber();
    RationalNumber second=new RationalNumber(1,2);
    RationalNumber third=new RationalNumber(2,3);
    RationalNumber fourth=new RationalNumber(3,4);
    RationalNumber fith=new RationalNumber(4,5);
    second.addRationalNumber(fourth);
    System.out.println(second);
    second.devideRationalNumber(fith);
    System.out.println(second);
    third.multiplyRationalNumber(fourth);
    System.out.println(third);
    third.subtractRationalNumber(fith);
    System.out.println(third);
    second.subtractRationalNumber(third);
    System.out.println(second);
    RationalNumber zero=new RationalNumber(1,0);
    
}
}