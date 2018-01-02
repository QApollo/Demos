import org.junit.Assert;
import org.junit.Test;

public class WereRatFollowerTest {
    // Prepare
    WereRatFollower obj = new WereRatFollower();

    @Test
    public void WereRatFollowerNameTest() {
        // Prepare

        // Execute
        String actual = obj.name;

        // Assert
        String expected = "WereRatFollower";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void WereRatFollowerHitpointsTest() {
        // Prepare

        // Execute
        int actual = obj.hitpoints;

        // Assert
        int expected = 10;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void WereRatFollowerAttackTest() {
        // Prepare

        // Execute
        int actual = obj.attack;

        // Assert
        int expected = 5;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void WereRatFollowerDefenceTest() {
        // Prepare

        // Execute
        int actual = obj.defence;

        // Assert
        int expected = 0;
        Assert.assertEquals(expected, actual);
    }
}
