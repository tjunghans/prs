import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created with IntelliJ IDEA.
 * User: tjunghans
 * Date: 29.10.2013
 * Time: 10:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class ShapeTest {
    @Test
    public void testShape() throws Exception {
        Shape rock = new Shape("rock");

        assertTrue(rock.getShapeType().equals("rock"));
    }
}
