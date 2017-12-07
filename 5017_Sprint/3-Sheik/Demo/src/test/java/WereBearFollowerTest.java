import org.junit.Assert;
import org.junit.Test;

public class WereBearFollowerTest {

    // Prepare
    WereBearFollower wbf = new WereBearFollower();

    @Test
    public void wereBearFollowerNameTest() {
        // Prepare

        // Execute
        String actual = wbf.name;

        // Assert
        String expected = "WereBearFollower";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void wereBearFollowerHitpointsTest() {
        // Prepare

        // Execute
        int actual = wbf.hitpoints;

        // Assert
        int expected = 30;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void wereBearFollowerAttackTest() {
        // Prepare

        // Execute
        int actual = wbf.attack;

        // Assert
        int expected = 10;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void wereBearFollowerDefenceTest() {
        // Prepare

        // Execute
        int actual = wbf.defence;

        // Assert
        int expected = 5;
        Assert.assertEquals(expected, actual);
    }
}
