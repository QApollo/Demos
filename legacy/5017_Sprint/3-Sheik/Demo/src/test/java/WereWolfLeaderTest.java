import org.junit.Assert;
import org.junit.Test;

public class WereWolfLeaderTest {
    // Prepare
    WereWolfLeader obj = new WereWolfLeader();

    @Test
    public void WereWolfLeaderNameTest() {
        // Prepare

        // Execute
        String actual = obj.name;

        // Assert
        String expected = "WereWolfLeader";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void WereWolfLeaderHitpointsTest() {
        // Prepare

        // Execute
        int actual = obj.hitpoints;

        // Assert
        int expected = 25;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void WereWolfLeaderAttackTest() {
        // Prepare

        // Execute
        int actual = obj.attack;

        // Assert
        int expected = 10;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void WereWolfLeaderDefenceTest() {
        // Prepare

        // Execute
        int actual = obj.defence;

        // Assert
        int expected = 5;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void WereWolfLeaderAbilityTest() {
        // Prepare

        // Execute
        String actual = obj.ability;

        // Assert
        String expected = "Howl";
        Assert.assertEquals(expected, actual);
    }
}
