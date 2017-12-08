import org.junit.Assert;
import org.junit.Test;

public class WereWolfFollowerTest {
    // Prepare
    WereWolfFollower obj = new WereWolfFollower();

    @Test
    public void WereWolfFollowerNameTest() {
        // Prepare

        // Execute
        String actual = obj.name;

        // Assert
        String expected = "WereWolfFollower";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void WereWolfFollowerHitpointsTest() {
        // Prepare

        // Execute
        int actual = obj.hitpoints;

        // Assert
        int expected = 15;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void WereWolfFollowerAttackTest() {
        // Prepare

        // Execute
        int actual = obj.attack;

        // Assert
        int expected = 5;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void WereWolfFollowerDefenceTest() {
        // Prepare

        // Execute
        int actual = obj.defence;

        // Assert
        int expected = 5;
        Assert.assertEquals(expected, actual);
    }
}
