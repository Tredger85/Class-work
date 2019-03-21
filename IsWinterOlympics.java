public class IsWinterOlympics {
static boolean isWinterOlympicYear(int year){
if (year<=1923){ //Year came before the first election
    throw new IllegalArgumentException("Prior to modern Winder Olympics");
}
if(year==1940||year==1944){ //Canceled
    throw new IllegalArgumentException("Cancelled due to WW2");
}
if(year>=2030){//No planning has yet happened, the 2026 host city will be announced in 2019 
    throw new IllegalArgumentException("Year is beyond planned Winter Olympics");
    }
if (year %4==0&&year<=1992){ //Winter Olympic years
    return true;
}else if (year>1992&&(year+2)%4==0){//Could have done one long test but it would be easier to read a test before the shift and after
    return true;
}else{
    return false; //This was not a winter Olympics year
    }
}
   public static void main (String[] args) {
      System.out.println(isWinterOlympicYear(1924));
      System.out.println(isWinterOlympicYear(1925));
      System.out.println(isWinterOlympicYear(1994));
      System.out.println(isWinterOlympicYear(1996));
            System.out.println(isWinterOlympicYear(1940));

      
   }
}