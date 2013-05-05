/**
 * The TurtleTest class invokes the main program of the Turtle System.
 */
public class TurtleTest {

    private static long lasttick = System.nanoTime();

    public static void main(String[] args) {
    	TurtleWorld w = new TurtleWorld();
        long thistick = System.nanoTime();
        double timediff = (thistick - lasttick) / 1000000000.0;
        lasttick = thistick;
        for (int x = 0; x < 250; ++x) {
            Turtle t = new BumpingTurtle();
            t.setSize();
            t.setPosition(new Vector2d(Math.random() * 400, Math.random() * 400));
            t.setHeading(new Heading(Heading.HeadingType.DEGREES, Math.random() * 360));
            w.addTurtle(t);
        }
        while (true){
        	w.tick(timediff);
        }
    }
}