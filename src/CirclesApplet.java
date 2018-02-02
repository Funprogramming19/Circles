import java.util.List;

import processing.core.PApplet;

public class CirclesApplet extends PApplet
{
    public static PApplet p;
    private List<Circle> circleList;
    private CircleController controller;

    public static void main(String[] args)
    {
        PApplet.main("CirclesApplet", args);
    }

    @Override
    public void settings()
    {
        size(800, 800);
    }

    @Override
    public void setup()
    {
        p = this;
        background(255);
        controller = new CircleController();
        circleList = controller.getCircleList();
        noStroke();
    }

    @Override
    public void draw()
    {
        background(255);
        for (Circle circle : circleList)
        {
            fill(circle.getColor());
            ellipse(
                    circle.getPosition().x,
                    circle.getPosition().y,
                    circle.getSize(),
                    circle.getSize()
            );
        }
        controller.update();
    }

    @Override
    public void mousePressed()
    {
        controller.changeState();
    }
}
