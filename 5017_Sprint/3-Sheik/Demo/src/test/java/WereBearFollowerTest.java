import org.junit.Assert;
import org.junit.Test;

public class WereBearFollowerTest {
    // Prepare
    WereBearFollower obj = new WereBearFollower();

    @Test
    public void wereBearFollowerNameTest() {
        // Prepare

        // Execute
        String actual = obj.name;

        // Assert
        String expected = "WereBearFollower";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void wereBearFollowerHitpointsTest() {
        // Prepare

        // Execute
        int actual = obj.hitpoints;

        // Assert
        int expected = 30;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void wereBearFollowerAttackTest() {
        // Prepare

        // Execute
        int actual = obj.attack;

        // Assert
        int expected = 10;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void wereBearFollowerDefenceTest() {
        // Prepare

        // Execute
        int actual = obj.defence;

        // Assert
        int expected = 5;
        Assert.assertEquals(expected, actual);
    }
}
