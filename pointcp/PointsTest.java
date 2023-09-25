import design1.PointCP;
import design2.PointCP2;
import design3.PointCP3;
import design5.PointCP2Sub;
import design5.PointCP3Sub;
import design5.PointCP5;

/**
 * Used to store all points used in
 * PointCPTest.java
 */
public class PointsTest {
    char firstType;   // Stores the original type of the points
    PointCP point1;   // Stores either polar or cartesian coords
    PointCP2 point2;  // Stores polar coords only
    PointCP3 point3;  // Stores cartesian coords only
    PointCP5 point5;  // Abstract class with sub classes for polar and cartesian coords

    public PointsTest(String args[]) {
      firstType = String.valueOf(args[0]).toUpperCase().charAt(0);
      double value1 = Double.valueOf(args[1]).doubleValue();
      double value2 = Double.valueOf(args[2]).doubleValue();

      point1 = new PointCP(firstType, value1, value2);
      
      if (firstType == 'P') {
        point2 = new PointCP2(value1, value2);
        point3 = new PointCP3(point1.getX(), point1.getY());
        point5 = new PointCP2Sub(value1, value2);
      } 
      else {
        point2 = new PointCP2(point1.getRho(), point1.getTheta());
        point3 = new PointCP3(value1, value2);
        point5 = new PointCP3Sub(value1, value2);
      }
    }

    public void testStorage() {
        System.out.println("\nYou entered:\n" + point1.toString());
        point1.convertStorageToCartesian();
        System.out.println("After asking to store as Cartesian:\n" + point1.toString());
        point1.convertStorageToPolar();
        System.out.println("After asking to store as Polar:\n" + point1.toString());

        System.out.println("\nYou entered:\n" + 
            ((this.firstType == 'P') ? point2.toString() : "Cartesian coordinates so they were converted to polar"));
        System.out.println("Computed Cartesian:\n(" + point2.getX() + "," + point2.getY() + ")");
        System.out.println("Stored Polar:\n" + point2.toString());

        System.out.println("\nYou entered:\n" + 
            ((this.firstType == 'C') ? point3.toString() : "Polar coordinates so they were converted to cartesian"));
        System.out.println("Computed Polar:\n(" + point3.getRho() + "," + point3.getTheta() + ")");
        System.out.println("Stored Cartesian:\n" + point3.toString());

        System.out.println("\nYou entered:\n" + point5.toString());
        point5.convertStorageToCartesian();
        System.out.println("After asking to store as Cartesian:\n" + point5.toString());
        point5.convertStorageToPolar();
        System.out.println("After asking to store as Polar:\n" + point5.toString());
    }
}
