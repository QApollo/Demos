public class WereWolfFactory implements LycanthropeFactory {

    private static WereWolfFactory instance;

    private WereWolfFactory() {}

    public static synchronized WereWolfFactory getInstance() {
        if (instance == null) {
            instance = new WereWolfFactory();
        }
        return instance;
    }

    public Leader createLeader() {
        return new WereWolfLeader();
    }

    public Follower createFollower() { return new WereWolfFollower(); }
}
