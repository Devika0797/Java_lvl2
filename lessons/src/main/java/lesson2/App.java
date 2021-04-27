package lesson2;

public class App {

    public static void main(String[] args) {
//        Month[] months = new Month[]{Month.JAN, Month.FEB, Month.MAR, Month.APR, Month.MAY};
        for (Month month : Month.values()) {
            System.out.println(month.ordinal() + " " + month + " " + month.getFullName() + " " + month.getNumber() + " "+ month.isSpring());
        }

        Month month = Month.JAN;
        Month month1 = Month.JAN;


        // время года
        switch (month){
            case JAN:
            case FEB: {
                System.out.println("Winter");
                break;
            }
            case MAR:
            case APR:
            case MAY: {
                System.out.println("Spring");
                break;
            }
        }
    }
}
