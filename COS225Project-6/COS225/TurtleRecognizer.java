
/**
 * An interface that hides the method that is tasked with observing the individual Turtles
 */
public interface TurtleRecognizer {

    void bumpingTurtleBump(BumpingTurtle t1, BumpingTurtle t2);

    void newBumpingTurtlePos(BumpingTurtle t, Vector2d prevPos, Vector2d presPos);

    void bumpingTurtleHeading(BumpingTurtle t, Heading prevHeading, Heading presHeading);
}
