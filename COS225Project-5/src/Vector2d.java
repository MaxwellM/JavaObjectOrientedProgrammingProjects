/**
 * A class that contains the individual methods to perform the necessary
 * mathematical functions to return coordinates between two locations
 */
public class Vector2d {

    private double x;
    private double y;

    public Vector2d(double x, double y) {
        set(x, y);
    }

    private Vector2d(Heading a, double dist) {
        setPolar(a, dist);
    }

    private void set(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Sets the vector's value in terms of polar coordinates.
     */
    private void setPolar(Heading a, double dist) {
        set(dist * Math.cos(a.getRadians()), dist * Math.sin(a.getRadians()));
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Vector2d negate() {
        return new Vector2d(-this.getX(), -this.getY());
    }

    /**
     * Get the heading component of the vector as polar coordinates.
     */
    public Heading heading() {
        if (this.getX() > 0) {
            return new Heading(Heading.HeadingType.RADIANS, Math.asin(this.getY() / this.length()));
        } else if (this.getX() < 0) {
            return new Heading(Heading.HeadingType.RADIANS, -Math.asin(this.getY() / this.length()) + Math.PI);
        }

        return new Heading();
    }

  /**
     * Get the length component of the vector as polar coordinates.
     */
    public double length() {
        return Math.sqrt(this.squaredLength());
    }

   /**
     * Finds the squared length of the vector.
     */
    public double squaredLength() {
        return getX() * getX() + getY() * getY();
    }

   /**
     * Adds two vectors together and returns the resulting vector.
     */
    private static Vector2d add(Vector2d v1, Vector2d v2) {
        return new Vector2d(v1.x + v2.x, v1.y + v2.y);
    }

    /**
     * Subtracts one vector from the other.
     */
    public static Vector2d subtract(Vector2d v1, Vector2d v2) {
        return new Vector2d(v1.x - v2.x, v1.y - v2.y);
    }

    public static Vector2d wrapAround(Vector2d v, Vector2d extents) {
         return new Vector2d(v.getX() - Math.floor(v.getX() / extents.getX()) * extents.getX(),
                 v.getY() - Math.floor(v.getY() / extents.getY()) * extents.getY());
    }

   /**
     * Adds a polar coordinate to a vector and returns the resulting position.
     */
    public static Vector2d add(Vector2d v, Heading a, double radius) {
        return add(v, new Vector2d(a, radius));
    }

    public String toString() {
        return "{" + getX() + "," + getY() + "}";
    }
}
