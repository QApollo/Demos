public class NEOBuilder {
    private String approachDate;
    private String estimatedDiameter;
    private double nominalDistance;
    private double minimalDistance;
    private double relativeVelocity;
    private int id;

    public NEOBuilder setApproachDate(String approachDate) {
        if(approachDate == null) {
            throw new IllegalArgumentException("");
        }

        this.approachDate = approachDate;

        return this;
    }

    public NEOBuilder setEstimatedDiameter(String estimatedDiameter) {
        if(estimatedDiameter == null) {
            throw new IllegalArgumentException("");
        }

        this.estimatedDiameter = estimatedDiameter;

        return this;
    }

    public NEOBuilder setNominalDistance(double nominalDistance) {
        this.nominalDistance = nominalDistance;

        return this;
    }

    public NEOBuilder setMinimalDistance(double minimalDistance) {
        this.minimalDistance = minimalDistance;

        return this;
    }

    public NEOBuilder setRelativeVelocity(double relativeVelocity) {
        this.relativeVelocity = relativeVelocity;

        return this;
    }

    public NEOBuilder setId(int id) {
        this.id = id;

        return this;
    }

    public NEO build() {
        return new NEO(id, approachDate, nominalDistance, minimalDistance, relativeVelocity, estimatedDiameter);
    }
}