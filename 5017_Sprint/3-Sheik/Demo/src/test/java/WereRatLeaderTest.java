import org.junit.Assert;
import org.junit.Test;

public class WereRatLeaderTest {
    // Prepare
    WereRatLeader obj = new WereRatLeader();

    @Test
    public void WereRatLeaderNameTest() {
        // Prepare

        // Execute
        String actual = obj.name;

        // Assert
        String expected = "WereRatLeader";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void WereRatLeaderHitpointsTest() {
        // Prepare

        // Execute
        int actual = obj.hitpoints;

        // Assert
        int expected = 15;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void WereRatLeaderAttackTest() {
        // Prepare

        // Execute
        int actual = obj.attack;

        // Assert
        int expected = 5;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void WereRatLeaderDefenceTest() {
        // Prepare

        // Execute
        int actual = obj.defence;

        // Assert
        int expected = 5;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void WereRatLeaderAbilityTest() {
        // Prepare

        // Execute
        String actual = obj.ability;

        // Assert
        String expected = "Poison";
        Assert.assertEquals(expected, actual);
    }
}
