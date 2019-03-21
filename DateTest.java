
public class DateTest {
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