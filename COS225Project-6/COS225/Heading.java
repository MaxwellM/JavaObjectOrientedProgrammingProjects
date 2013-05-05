/**
 * Handles angles in radians or degreeNum.
 */

public class Heading {

    public enum HeadingType {

        DEGREES, RADIANS
    }

    /**
     * Degrees represented as a double
     */
    private double degreeNum;

    public Heading() {
        setDegreeNum(0.0);
    }

    /**
     * Conversion between Degrees and Radians
     * @param t Degrees or Radians
     * @param a Double of Degree/Radian number to set for a Turtle
     */
    public Heading(HeadingType t, double a) {
        if (t == HeadingType.DEGREES) {
            setDegreeNum(a);
        } else if (t == HeadingType.RADIANS) {
            setRadiansNum(a);
        }
    }

    /**
     * Adds two angles together and returns the new resulting heading.
     */
    public static Heading add(Heading a1, Heading a2) {
        return new Heading(HeadingType.DEGREES, a1.degreeNum + a2.degreeNum);
    }

    /**
     * Adds a scalar degree value to an angle, and returns the resulting angle.
     */
    public static Heading addDegrees(Heading a, double deg) {
        return new Heading(HeadingType.DEGREES, a.degreeNum + deg);
    }

    /**
     * Adds a scalar radian value to an angle, and returns the resulting angle.
     */
    public static Heading addRadians(Heading a, double rad) {
        return new Heading(HeadingType.RADIANS, a.getRadiansNum() + rad);
    }

    /**
     * Gets the heading in degreeNum.
     */
    public double getDegreeNum() {
        return degreeNum;
    }

    /**
     * Sets the heading in degreeNum. If greater than 360 degreeNum, this will wrapAround
     * the value to between 0 and 360.
     */
    private void setDegreeNum(double deg) {
        degreeNum = deg % 360.0;
    }

    /**
     * Gets the heading in radians.
     */
    public double getRadiansNum() {
        return degreeNum * (Math.PI / 180.0);
    }

    /**
     * Sets the heading in radians. This converts the heading to degreeNum and then
     * calls setDegreeNum.
     */
    private void setRadiansNum(double rad) {
        setDegreeNum(rad * (180.0 / Math.PI));
    }

    /**
     * Returns the heading equivalent to the heading, negative.
     */
    public Heading negate() {
        return new Heading(HeadingType.DEGREES, -this.degreeNum);
    }

    /**
     * Converts input to a String, informally
     * @return String
     */
    public String toString() {
        return (degreeNum + "d");
    }
}
