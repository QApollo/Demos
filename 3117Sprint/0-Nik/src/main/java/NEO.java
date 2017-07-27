public class NEO {
	private String approachDate;
	private String estimatedDiameter;
	private double nominalDistance;
	private double minimalDistance;
	private double relativeVelocity;

	public final int id;

	public NEO (int id, String approachDate, double nominalDistance, double minimalDistance, double relativeVelocity,
				String estimatedDiameter) {
		this.id = id;

		this.setApproachDate(approachDate);
		this.setNominalDistance(nominalDistance);
		this.setMinimalDistance(minimalDistance);
		this.setRelativeVelocity(relativeVelocity);
		this.setEstimatedDiameter(estimatedDiameter);
	}

	public void setApproachDate(String approachDate) {
		if (approachDate == null) {
			throw new IllegalArgumentException("Invalid approachDate");
		}

		this.approachDate = approachDate;
	}

	public String getApproachDate() {
		return this.approachDate;
	}

	public void setNominalDistance(double nominalDistance) {
		this.nominalDistance = nominalDistance;
	}

	public double getNominalDistance() {
		return this.nominalDistance;
	}

	public void setMinimalDistance(double minimalDistance) {
		this.minimalDistance = minimalDistance;
	}

	public double getMinimalDistance() {
		return this.minimalDistance;
	}

	public void setRelativeVelocity(double relativeVelocity) {
		this.relativeVelocity = relativeVelocity;
	}

	public double getRelativeVelocity() {
		return this.relativeVelocity;
	}

	public void setEstimatedDiameter(String estimatedDiameter) {
		if (estimatedDiameter == null) {
			throw new IllegalArgumentException("Invalid esimatedDiameter");
		}

		this.estimatedDiameter = estimatedDiameter;
	}

	public String getEstimatedDiameter() {
		return this.estimatedDiameter;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof NEO)) return false;

		if(this == obj) return true;

		NEO otherNEO = (NEO) obj;

		return this.id == otherNEO.id;
	}

	@Override
	public int hashCode() {
		return this.id;
	}

	@Override
	public String toString() {
		StringBuilder strRepresentation = new StringBuilder();

		strRepresentation.append(this.id);
		strRepresentation.append(String.format("%25s", this.approachDate));
		strRepresentation.append(String.format("%30s", this.nominalDistance));
		strRepresentation.append(String.format("%30s", this.minimalDistance));
		strRepresentation.append(String.format("%30s", this.relativeVelocity));
		strRepresentation.append(String.format("%30s", this.estimatedDiameter));

		return strRepresentation.toString();
	}
}