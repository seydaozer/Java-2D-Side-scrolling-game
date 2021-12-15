/**
 * This interface represents the jump behavior of the game player.
 * It is a low jump or high jump.
 */
public interface JumpBehavior {
    /**
     * This function determines the value of the jump height.
     * @return the value of jump height.
     */
    float jump();

    /**
     * Gets the type of jump behavior.
     * @return the current type of jump behavior.
     */
    String getType();
}
