import java.awt.*;
import java.util.*;

/**
 * This class is our NEW Turtle class that has added features
 */

public class BumpingTurtle {

    public double size;                                     //How large the Turtle shows up on the JPanel - constant
    public double ticks;                                    //Used to keep the loop on a steady cycle
    public double speed;                                    //How fast each Turtle moves on the JPanel - varies, depends on how sick
    public int timesSick;                                   //Unused, variable to keep track of how many times a Turtle has been sick
    public int countDown;                                   //How long each Turtle stays sick, varies on how many times the Turtle bumps
    public boolean sick;                                    //Boolean to keep track if the Turtle is sick or not
    public Set<TurtleRecognizer> listeners;                 //Watches over the Turtles
    public java.util.List<TurtleDriver> decorators;         //Tied to each Turtle and houses the methods to draw each Turtle
    public Color color;                                     //Keeps track of what Color to draw each Turtle
    public Heading heading;                                 //Where the Turtle is pointing
    public Vector2d position;                               //Where the Turtle is on the JPanel


    /**
     * Default settings tied to each Turtle
     * NOT sick, size = 5, ticks = 0, speed = 20
     * countDown = 5, timesSick = 0, Color = white
     */
    public BumpingTurtle() {
        setHeading(new Heading());
        setPosition(new Vector2d(0.0, 0.0));
        sick = false;
        size = 5.0;
        ticks = 0.0;
        speed = 20.0;
        countDown = 5;
        timesSick = 0;
        color = Color.white;
    }

    /**
     * @param t Individual Turtle object
     * @return Boolean if a Turtle had collided with another Turtle
     */
    public boolean collision(BumpingTurtle t) {
        double d = Vector2d.subtract(t.position, this.position).squaredLength();
        double size = t.size + this.size;
        return d <= (size * size);
    }

    /**
     * @param tickController How frequently the Turtles "loop" (1 second)
     */
    public void move(double tickController) {
        ticks += tickController;
        if (ticks > 1.0) {
            this.tr(new Heading(Heading.HeadingType.DEGREES, Math.random() * 30.0));
            this.tl(new Heading(Heading.HeadingType.DEGREES, Math.random() * 30.0));
            ticks = 0.0;
        }
        this.fd(this.speed * tickController);
    }

    /**
     * Method to draw each Turtle
     * @param g Graphics
     */
    void draw(Graphics g) {
        if (decorators != null) {
            for (TurtleDriver d : decorators) {
                d.draw(g, this);
            }
        }
    }

    /**
     * Retrieves the heading of the turtle.
     */
    public Heading getHeading() {
        return this.heading;
    }

    /**
     * Retrieves the turtle's position within global world space.
     */
    public Vector2d getPosition() {
        return this.position;
    }


    /**
     * Returns the Size of each Turtle
     * @return Size of Turtle
     */
    public double getSize() {
        return this.size;
    }


    /**
     * Sets the Size each Turtle will use
     * @param s Size to set each Turtle
     */
    public void setSize(double s) {
        this.size = s;
    }

    /**
     * Sets the heading of the turtle.
     * This occurs after the actual change has taken place, so calls to
     * t.getHeading() will return the heading.
     */
    public void setHeading(Heading a) {
        assert a != null;
        Heading old = this.heading;
        this.heading = a;

        if (this.listeners != null) {
            for (TurtleRecognizer l : this.listeners) {
                l.bumpingTurtleHeading(this, old, a);
            }
        }
    }

    /**
     * Sets the position of the turtle.
     */
    public void setPosition(Vector2d p) {
        assert p != null;
        Vector2d old = this.position;
        this.position = p;

        if (this.listeners != null) {
            for (TurtleRecognizer l : this.listeners) {
                l.newBumpingTurtlePos(this, old, p);
            }
        }
    }


    /**
     * Adds a Listener to each Turtle
     * @param l The Turtle Interface
     */
    public void addListener(TurtleRecognizer l) {
        if (this.listeners == null) {
            this.listeners = new HashSet<TurtleRecognizer>();
        }

        this.listeners.add(l);
    }

    /**
     * Removes a Listener that is attached to each Turtle
     * @param l The Turtle Interface
     */
    public void delListener(TurtleRecognizer l) {
        if (this.listeners != null) {
            this.listeners.remove(l);
        }
    }

    /**
     * Adds a Decorator and is used to manage how each Turtle is drawn
     * @param l The Turtle drawing Interface
     */
    public void addDecorator(TurtleDriver l) {
        if (this.decorators == null) {
            this.decorators = new ArrayList<TurtleDriver>();
        }

        this.decorators.add(l);
    }

    /**
     * Del a Decorator attached to each Turtle
     * @param l The Turtle drawing Interface
     */
    public void delDecorator(TurtleDriver l) {
        if (this.decorators != null) {
            this.decorators.remove(l);
        }
    }

    /**
     * Tripped when a collision occurs between two Turtles
     * @param t the BumpingTurtle class
     */
    public void collidedWith(BumpingTurtle t) {
        if (this.listeners != null) {
            for (TurtleRecognizer l : this.listeners) {
                l.bumpingTurtleBump(this, t);
            }
        }
    }

    /**
     * Moving a Turtle forward method
     *
     * @param dist The distance to travel
     */
    public void fd(double dist) {
        this.setPosition(Vector2d.wrapAround(Vector2d.add(this.position, this.heading, dist), new Vector2d(400.0, 400.0)));
    }

    /**
     * Turning a Turtle to the right
     * @param a Degrees
     */
    public void tr(Heading a) {
        this.setHeading(Heading.add(a, this.heading));
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
    public double getSpeed() {
        return speed;
    }

    /**
     * Sets the beginning Color of Turtle
     * @return Color, white
     */
    public Color setBeginningColor() {
        color = Color.white;
        return color;
    }

    /**
     * Called from the Tick method in TurtleWorld that regulates what to do each loop for Sick Turtles
     */
    public void isSick() {
        if (sick && countDown > 0) {
            countDown--;
        }
        else {
            if (countDown <= 0){
                resetSick();
                resetSickColor();
                countDown = 5;
                speed = 20.0;
            }
        }
    }


    /**
     * Increments timesSick by 1
     */
    public void addNumTimesSick() {
        timesSick += 1;
    }

    /**
     * Calls how many times a Turtle has been Sick
     * @return timesSick
     */
    public int getTimesSick() {
        return timesSick;
    }

    /**
     * decrement timesSick by 1
     */
    public void delTimesSick() {
        timesSick -= 1;
    }

    /**
     * Resets timesSick to 0
     */
    public void resTimesSick() {
        timesSick = 0;
    }

    /**
     * Sets the Turtle values, color, countDown, and speed based upon prior values
     */
    public void setSickColor() {
        if ((color == Color.white) && (countDown>0)) {
            countDown += 250;
            speed -= 2.0;
            color = Color.yellow;
        } else if ((color == Color.yellow) && (countDown>0)){
            countDown += 500;
            speed -= 3.0;
            color = Color.pink;
        } else if ((color == Color.pink) && (countDown>0)) {
            countDown += 500;
            speed -= 4.0;
            color = Color.red;
        } else if ((color == Color.red) && (countDown>0)) {
            countDown += 500;
            speed -= 5.0;
            color = Color.black;
        } else if ((color == Color.black) && (countDown>0)){
            countDown += 100;
        }
    }

    /**
     * Returns what color the Turtle is
     * @return Color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Resets the color of the Turtle to white
     */
    public void resetSickColor() {
        color = Color.white;
    }

    /**
     * Sets the Turtle after a bump to Sick
     */
    public void setSick() {
        sick = true;
    }

    /**
     * Sets the Turtle to NOT Sick
     */
    public void resetSick() {
        sick = false;
    }

    /**
     * Returns the current state of Sick associated with the Turtle
     * @return Sick
     */
    public boolean getSick() {
        return this.sick;
    }

}