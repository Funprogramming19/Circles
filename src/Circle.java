import processing.core.PApplet;
import processing.core.PVector;

public class Circle
{
    private PVector position;
    private PVector destination;

    private int color;
    private int destinationColor;

    private float size;
    private float destinationSize;

    private float speed;

    public Circle(PVector position, int color, float speed)
    {
        this.position = position;
        this.color = color;
        this.speed = speed;
    }

    public Circle(StateBundle stateBundle)
    {
        this.position = new PVector(stateBundle.x, stateBundle.y);
        this.color = stateBundle.color;
        this.speed = stateBundle.speed;
        this.size = stateBundle.size;
        this.destination = new PVector();
        setDestination(stateBundle);
    }

    public void setDestination(StateBundle stateBundle)
    {
        this.destination.x=stateBundle.x;
        this.destination.y=stateBundle.y;
        this.destinationColor = stateBundle.color;
        this.speed = stateBundle.speed;
        this.destinationSize = stateBundle.size;
    }

    public void update()
    {
        position.x = PApplet.lerp(position.x, destination.x, speed);
        position.y = PApplet.lerp(position.y, destination.y, speed);

        size = PApplet.lerp(size, destinationSize, speed);

        color = CirclesApplet.p.lerpColor(color, destinationColor, speed);
    }

    //region Getters and Setters

    public float getSize()
    {
        return size;
    }

    public void setSize(float size)
    {
        this.size = size;
    }

    public float getDestinationSize()
    {
        return destinationSize;
    }

    public void setDestinationSize(float destinationSize)
    {
        this.destinationSize = destinationSize;
    }

    public void setDestination(PVector destination)
    {
        this.destination = destination;
    }

    public void setDestinationColor(int destinationColor)
    {
        this.destinationColor = destinationColor;
    }

    public void setSpeed(float speed)
    {
        this.speed = speed;
    }

    public PVector getPosition()
    {
        return position;
    }

    public void setPosition(PVector position)
    {
        this.position = position;
    }

    public int getColor()
    {
        return color;
    }

    public void setColor(int color)
    {
        this.color = color;
    }

    //endregion

    public static final class StateBundle
    {
        float x;
        float y;
        int color;
        float speed;
        float size;
    }
}
