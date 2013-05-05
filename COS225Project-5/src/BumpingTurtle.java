/**
 * This class is our NEW Turtle class that has added features
 */
class BumpingTurtle extends Turtle {

    private double ticks;

    public BumpingTurtle() {
        ticks = 0.0;
    }

  /**
   *
   * @param t  Individual Turtle object
   * @return   Boolean if a Turtle had collided with another Turtle
   */
    public boolean collision(Turtle t) {
        double d = Vector2d.subtract(t.getPosition(), this.getPosition()).squaredLength();
        double size = t.getSize() + this.getSize();
        return d <= (size * size);
    }

  /**
   *
   * @param tickController How frequently the Turtles "loop" (1 second)
   */
    public void move(double tickController) {
        ticks += tickController;
        if (ticks > 1.0) {
            this.tr(new Heading(Heading.HeadingType.DEGREES, Math.random() * 30.0));
            this.tl(new Heading(Heading.HeadingType.DEGREES, Math.random() * 30.0));
            ticks = 0.0;
        }

        this.fd(this.getSpeed() * tickController);
    }

  /**
   * Moving a Turtle forward method
   * @param dist The distance to travel
   */
    public void fd(double dist) {
        this.setPosition(Vector2d.wrapAround(Vector2d.add(this.getPosition(), this.getHeading(), dist), new Vector2d(400.0, 400.0)));
    }

  /**
   * Turning a Turtle to the right
   * @param a Degrees
   */
    public void tr(Heading a) {
        this.setHeading(Heading.add(a, this.getHeading()));
    }

  /**
   * Turning a Turtle to the left
   * @param a Degrees
   */
    public void tl(Heading a) {
        tr(a.negate());
    }

  /**
   * How fast Turtles traverse the TurtleGrid
   * @return Their speed!
   */
    public double getSpeed()
    {
        return 5.0;
    }
}
