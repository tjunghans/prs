/**
 * Created with IntelliJ IDEA.
 * User: tjunghans
 * Date: 30.10.2013
 * Time: 9:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class Player {
    protected String playerType = "human";

    public Player() {

    }

    public Player(String playerType) {
        this.playerType = playerType;
    }

    public String getPlayerType() {
        return this.playerType;
    }
}
