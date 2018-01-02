import java.util.*;

public final class NEOManager {

    private final static NEOManager instance = new NEOManager();

    private final String fieldIdentifier = "fields";

    private String resourceName = "NEO";
    private ResourceBundle neoResource;

    private List<NEO> neos = new ArrayList<>();
    private List<String> fields;

    private NEOManager() {
        try {
            neoResource = ResourceBundle.getBundle(resourceName);
            processFieldSpecs();
            processNEOs(fetchNEOKeys());
        } catch (Exception e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }

    public static NEOManager getInstance() {
        return instance;
    }

    private void processFieldSpecs() {
        String strRepresentation = neoResource.getString(fieldIdentifier);

        this.fields = Arrays.asList(strRepresentation.split(","));
    }

    public List<String> fetchNEOKeys() {
        List<String> desiredProperties = Collections.list(neoResource.getKeys());
        desiredProperties.remove(fieldIdentifier);

        return desiredProperties;
    }

    private void processNEOs(List<String> propertyKeys) {
        propertyKeys.stream()
                .forEach(neoKey -> neos.add(createNeo(neoKey)));
    }

    public NEO createNeo(String neoKey) {
        if (neoKey == null) return null;

        NEO newNeo = null;
        String neoProperties = neoResource.getString(neoKey);
        List<String> neoFields = Arrays.asList(neoProperties.split(","));

        try {
            newNeo = new NEOBuilder()
                    .setId(Integer.valueOf(neoKey))
                    .setApproachDate(neoFields.get(0))
                    .setNominalDistance(Double.valueOf(neoFields.get(1)))
                    .setMinimalDistance(Double.valueOf(neoFields.get(2)))
                    .setRelativeVelocity(Double.valueOf(neoFields.get(3)))
                    .setEstimatedDiameter(neoFields.get(4))
                    .build();
        } catch (Exception e) {
            System.out.println("Caught: " + e.getMessage());
        }

        return newNeo;
    }

    public String getFields() {
        StringBuilder output = new StringBuilder();

        this.fields.stream()
                .limit(1)
                .forEach(field -> output.append(field));

        this.fields.stream()
                .skip(1)
                .forEach(field -> output.append(String.format("%30s", field)));

        return output.toString();
    }

    @Override
    public String toString() {
        StringBuilder strRepresentation = new StringBuilder();

        strRepresentation.append(this.getFields() + "\n");

        this.neos.stream()
                .forEach(neo -> strRepresentation.append(neo + "\n"));

        return strRepresentation.toString();
    }
}