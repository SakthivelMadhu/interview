
public class smallestAngle {
    public static void main(String[] args){
        int hour = 0;
        int min = 1;

        double angle = findSmallestAngle(hour , min);
        System.out.println("The smallest angle between the hour and mintue hand is " + angle + " degrees");
    }
    public static double findSmallestAngle(int hour , int min){

        double hourAngle =(hour % 12) * 360.0 / 12 + (min * 360.0 /(12 * 60));
        double minAngle =  min * 360.0 / 60;

        double angleDiff = Math.abs(hourAngle - minAngle);

        return Math.min(   angleDiff , 360 - angleDiff );
    }
}
