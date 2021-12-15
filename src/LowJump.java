/**
 * This class represents the low jump behavior.
 */
public class LowJump implements JumpBehavior {
    /**
     * This is the value of the jump height.
     */
    private float jumpHeight;

    /**
     * LowJump Constructor
     */
    public LowJump(){
        jumpHeight = 11.0f;
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
        return "low jump";
    }

}
