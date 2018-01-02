public class Boat<T> {
    private T contents;

    public T unloadBoat() {
        return contents;
    }

    public void loadBoat(T contents) {
        this.contents = contents;
    }
}
