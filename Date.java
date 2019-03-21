public class Date {

	int year;
	int month;
	int day;
	
	public Date(int y, int m, int d){
		if(y>0){
			year = y;
			if(m>0 && m<=12){
				month = m;
				if(d<=monthLength() && d>0){
					day = d;
				}
			}
		}
		if(year == 0 || month == 0 || day == 0){
			throw new IllegalArgumentException();
		}
	}
	
	public int monthLength(){
		if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12){
			return 31;
		}else if(month==2){
			if(isLeapYear()){
				return 29;
			}else{
				return 28;
			}
		}else{
			return 30;
		}
	}
	
	public boolean isLeapYear(){
		return year%400==0 || (year%4==0 && year%100!=0);
	}
    
    public void addDays(int days){
        day+=days;
        while (day>monthLength()){
            day-=monthLength();
            month++;
            if(month==13){
                month=1;
                year++;
            }
        }
    }
    
    public void addWeeks(int weeks){
        addDays(weeks*7);
    }
    
    public int daysTo(Date other){
    	if(other.year < year || (other.year == year && other.month < month) || 
    			(other.year == year && other.month == month && other.day < day)){
    		throw new IllegalArgumentException();
    	}
    	int tYear = year;
    	int tMonth = month; 
    	int tDay = day;
    	int count = 0;
    	while(day != other.day || month != other.month || year != other.year ){
    		addDays(1);
    		count++;
    	}
    	year = tYear;
    	month = tMonth;
    	day = tDay;
    	return count;
    }
    
    public int getDay(){
    	return day;
    }
    
    public int getMonth(){
    	return month;
    }
    
    public int getYear(){
    	return year;
    }
    
    public String toString(){
    	if(month<10){
    		return year+"/0"+month+"/"+day;
    	}
    	return year+"/"+month+"/"+day;
    }
    public static void main (String[] args){
        Date first = new Date (1900, 2, 28);
        Date second = new Date (2000, 2, 29);
        System.out.println(first.daysTo(second));
        Date third = new Date (2000, 1,30);
        System.out.println(third.daysTo(second));
        first.addDays(55);
        System.out.println(first.getMonth());
        System.out.println(first.getDay());
        System.out.println(first);
        second.addWeeks(52);
        System.out.println(second);
        System.out.println(second.getYear());
}
}
