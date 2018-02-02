import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;

public class CircleController
{
    private List<Circle> circleList;
    private final int number = 50;

    public CircleController()
    {
        circleList = new ArrayList<>(number);

        for (int i = 0; i < number; i++)
        {
            circleList.add(new Circle(newState()));
        }
    }

    public void changeState()
    {
        for (Circle circle : circleList)
            circle.setDestination(newState());
    }

    private Circle.StateBundle newState()
    {
        PApplet p = CirclesApplet.p;
        Circle.StateBundle stateBundle = new Circle.StateBundle();
        stateBundle.x = p.random(p.width);
        stateBundle.y = p.random(p.height);
        stateBundle.color = p.color(p.random(255), p.random(255), p.random(255));
        stateBundle.speed = p.random(0.1f);
        stateBundle.size = p.random(25, 50);

        return stateBundle;
    }

    public void update()
    {
        for (Circle circle : circleList)
            circle.update();
    }

    public List<Circle> getCircleList()
    {
        return circleList;
    }

}
