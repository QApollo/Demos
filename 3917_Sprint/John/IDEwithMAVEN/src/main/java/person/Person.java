package person;

public class Person {
    private String name;
    private String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public boolean isHomeless() {
        return address == null || address.isEmpty();
    }
}
