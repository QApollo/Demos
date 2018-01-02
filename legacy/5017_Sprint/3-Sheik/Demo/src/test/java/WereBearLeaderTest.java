import org.junit.Assert;
import org.junit.Test;

public class WereBearLeaderTest {
    // Prepare
    WereBearLeader obj = new WereBearLeader();

    @Test
    public void wereBearLeaderNameTest() {
        // Prepare

        // Execute
        String actual = obj.name;

        // Assert
        String expected = "WereBearLeader";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void wereBearLeaderHitpointsTest() {
        // Prepare

        // Execute
        int actual = obj.hitpoints;

        // Assert
        int expected = 50;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void wereBearLeaderAttackTest() {
        // Prepare

        // Execute
        int actual = obj.attack;

        // Assert
        int expected = 20;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void wereBearLeaderDefenceTest() {
        // Prepare

        // Execute
        int actual = obj.defence;

        // Assert
        int expected = 10;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void wereBearLeaderAbilityTest() {
        // Prepare

        // Execute
        String actual = obj.ability;

        // Assert
        String expected = "Crush";
        Assert.assertEquals(expected, actual);
    }
}
