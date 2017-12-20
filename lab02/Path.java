/** A class that represents a path via pursuit curves.
 *  @author You!
 */
public class Path {

    /** What to do, what to do... */
   public Point temp, nextPoint, currPoint;
   
   //constructor
   public Path(double x, double y) {
      nextPoint = new Point(x, y);
      currPoint = new Point();
   }

   double getCurrX(){
      return currPoint.getX();
   }

   double getCurrY(){
      return currPoint.getY();
   }

   double getNextX(){
      return nextPoint.getX();
   }

   double getNextY(){
      return nextPoint.getY();
   }
   
   Point getCurrentPoint(){
      return currPoint;
   }

   void setCurrentPoint(Point point){
      currPoint.setX(point.getX());
      currPoint.setY(point.getY());
   }

   void iterate(double dx, double dy){
      setCurrentPoint(nextPoint);
      nextPoint.setX(currPoint.getX() + dx);
      nextPoint.setY(dy + currPoint.getY());
      
   }
}
