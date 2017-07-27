import org.junit.Test;

import static org.junit.Assert.*;

public class NEOManagerTest {
	private NEOManager neoManager = NEOManager.getInstance();

    @Test
    public void testCreateNEONull() {
        Object result = neoManager.createNeo(null);

        assertEquals(null, result);
    }

    @Test
    public void testCreateNEO() {
        NEO result = neoManager.createNeo("3609693");

        NEO testNeo = new NEOBuilder()
                .setId(3609693)
                .setApproachDate("")
                .setEstimatedDiameter("")
                .build();

        assertEquals(testNeo, result);
    }
}