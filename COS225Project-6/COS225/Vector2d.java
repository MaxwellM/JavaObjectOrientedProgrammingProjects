
/**
 * A class that contains the individual methods to perform the necessary
 * mathematical functions to return coordinates between two locations
 */
public class Vector2d {

    private double x;
    private double y;

    /**
     * Initial Vector call
     */
    public Vector2d() {
    }

    /**
     * Vector2d method to set positions
     * @param x x location
     * @param y y location
     */
    public Vector2d(double x, double y) {
        set(x, y);
    }

    /**
     * Vector2d sets polar for a Turtle
     * @param a Heading
     * @param dist Distance
     */
    public Vector2d(Heading a, double dist) {
        setPolar(a, dist);
    }

    /**
     * Vector2d method to set positions, internally
     * @param v Vector2d
     */
    public Vector2d(Vector2d v) {
        set(v.x, v.y);
    }

    /**
     * Adds two vectors together and returns the resulting vector.
     */
    public static Vector2d add(Vector2d v1, Vector2d v2) {
        return new Vector2d(v1.x + v2.x, v1.y + v2.y);
    }

    /**
     * Subtracts one vector from the other.
     * Note: A good way of thinking of subtraction is:
     * B - A yields A ---> B
     */
    public static Vector2d subtract(Vector2d v1, Vector2d v2) {
        return new Vector2d(v1.x - v2.x, v1.y - v2.y);
    }

    public static Vector2d wrapAround(Vector2d v, Vector2d extents) {
        return new Vector2d(v.x - Math.floor(v.x / extents.x) * extents.x,
                v.y - Math.floor(v.y / extents.y) * extents.y);
    }

    /**
     * Adds a polar coordinate to a vector and returns the resulting position.
     */
    public static Vector2d add(Vector2d v, Heading a, double radius) {
        return add(v, new Vector2d(a, radius));
    }

    /**
     * Sets this.x and this.y positions, internally
     * @param x x position
     * @param y y position
     */
    private void set(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Sets the vector's value in terms of polar coordinates.
     */
    private void setPolar(Heading a, double dist) {
        set(dist * Math.cos(a.getRadiansNum()), dist * Math.sin(a.getRadiansNum()));
    }

    /**
     * Returns the x position
     * @return x position
     */
    public double getX() {
        return x;
    }

    /**
     * Returns the y position
     * @return y position
     */
    public double getY() {
        return y;
    }

    /**
     * Flips the value entered
     * @return Vector2d
     */
    public Vector2d negate() {
        return new Vector2d(-this.x, -this.y);
    }

    /**
     * Get the angle component of the vector as polar coordinates.
     * 0 degrees = positive Y
     */
    public Heading heading() {
        if (this.x > 0.0) {
            return new Heading(Heading.HeadingType.RADIANS, Math.asin(this.y / this.length()));
        } else if (this.x < 0.0) {
            return new Heading(Heading.HeadingType.RADIANS, -Math.asin(this.y / this.length()) + Math.PI);
        }

        return new Heading();
    }

    /**
     * Finds the squared distance between two vectors.
     */
    public static double squaredDistance(Vector2d v1, Vector2d v2) {
        return (add(v1, v2.negate()).squaredLength());
    }

    /**
     * Distance to travel
     * @param v1 Vector2d
     * @param v2 Vector2d
     * @return Squared distance between the two
     */
    public static double distance(Vector2d v1, Vector2d v2) {
        return Math.sqrt(Vector2d.squaredDistance(v1, v2));
    }

    /**
     * Normalize a vector to length of 1.
     * @ensures The returned vector will be of length 1.
     */
    public Vector2d normalize() {
        return Vector2d.scale(this, this.length());
    }

    /**
     * Scales a vector by a given magnitude.
     */
    public static Vector2d scale(Vector2d v, double scalar) {
        return new Vector2d(v.x * scalar, v.y * scalar);
    }

    /**
     * Get the length component of the vector as polar coordinates.
     * If possible, use squaredLength() instead.
     * This method requires finding the square root, which is slow.
     */
    public double length() {
        return Math.sqrt(this.squaredLength());
    }

    /**
     * Finds the squared length of the vector.
     */
    public double squaredLength() {
        return y * y + y * y;
    }

    /**
     * Puts it to a String
     * @return A String
     */
    public String toString() {
        return ("{" + x + "," + y + "}");
    }
}