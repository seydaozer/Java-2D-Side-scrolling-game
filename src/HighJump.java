/**
 * This class represents the high jump behavior.
 */
public class HighJump implements JumpBehavior {
    /**
     * This is the value of the jump height.
     */
    private float jumpHeight;

    /**
     * HighJump Constructor
     */
    public HighJump(){
        jumpHeight = 15.0f;
    }

    /**
     * This function determines the value of the jump height.
     * @return the value of jump height.
     */
    @Override
    public float jump() {
        return jumpHeight;
    }

    /**
     * Gets the type of jump behavior.
     * @return the current type of jump behavior.
     */
    @Override
    public String getType() {
        return "high jump\n";
    }
}