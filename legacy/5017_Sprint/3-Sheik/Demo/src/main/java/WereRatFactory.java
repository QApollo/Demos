public class WereRatFactory implements LycanthropeFactory {

    private static WereRatFactory instance;

    private WereRatFactory() {}

    static synchronized WereRatFactory getInstance() {
        if (instance == null) {
            instance = new WereRatFactory();
        }
        return instance;
    }

    public Leader createLeader() {
        return new WereRatLeader();
    }

    public Follower createFollower() {
        return new WereRatFollower();
    }

}
