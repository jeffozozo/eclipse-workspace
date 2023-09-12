import java.awt.*;

/**
 * DataModel
 * <p/>
 * $Id: DataModel $ 2014 adg <BR/>
 * $Created: 2/25/14 at 6:04 PM $
 *
 * @author Andrew G.
 */
public class DataModel {
    public boolean running = false;
    public double speed = 0.0;
    public double fuelSpent = 0.0;
    public Point altitude = new Point();
    public long time = 0L;
    public String difficulty = "";
    public String planetName = "";

    public void reset() {
        running = false;
        speed = 0.0;
        fuelSpent = 0.0;
        altitude = new Point();
        time = 0L;
        difficulty = "";
        planetName = "";
    }
}
