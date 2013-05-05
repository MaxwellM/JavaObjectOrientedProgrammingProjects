/**
 * Handles angles in radians or degreeNum.
 */
public class Heading {

    private double degreeNum;

    public Heading() {
        setDegreeNum(0.0);
    }

    public Heading(HeadingType t, double a) {
        if (t == HeadingType.DEGREES) {
            setDegreeNum(a);
        } else if (t == HeadingType.RADIANS) {
            setRadians(a);
        }
    }

    /**
     * Adds two angles together and returns the new resulting heading.
     */
    public static Heading add(Heading a1, Heading a2) {
        return new Heading(HeadingType.DEGREES, a1.degreeNum + a2.degreeNum);
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
    public double getRadians() {
        return degreeNum * (Math.PI / 180.0);
    }

    /**
     * Sets the heading in radians. This converts the heading to degreeNum and then
     * calls setDegreeNum.
     */
    private void setRadians(double rad) {
        setDegreeNum(rad * (180.0 / Math.PI));
    }

    /**
     * Returns the heading equivalent to the heading, negative.
     */
    public Heading negate() {
        return new Heading(HeadingType.DEGREES, -this.degreeNum);
    }

    public String toString() {
        return degreeNum + "d";
    }

    public enum HeadingType {

        DEGREES, RADIANS
    }
}
