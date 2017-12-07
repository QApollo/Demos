public class WereBearFactory implements LycanthropeFactory {

    private static WereBearFactory instance;

    private WereBearFactory() {}

    public static synchronized WereBearFactory getInstance() {
        if (instance == null) {
            instance = new WereBearFactory();
        }
        return instance;
    }

    public Leader createLeader() {
        return new WereBearLeader();
    }

    public Follower createFollower() { return new WereBearFollower(); }
}
