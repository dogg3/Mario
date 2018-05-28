package game1.controller;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.Color;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author greg
 */


/**
 * An orange.
 */
public class Orange extends DynamicBody {
    private static final Shape shape = new CircleShape(0.5f);
    private static SoundClip orangeSound;
    private static final BodyImage image = new BodyImage("data/coin.png");
    private static SolidFixture fixture;
    public Orange(World world) {
        super(world, shape);
        fixture = new SolidFixture(this,shape);
        fixture.setFriction(1);
        fixture.setDensity(200);
        this.addImage(image);
        this.setBullet(true);
    }
    @Override
public void destroy()
{
 super.destroy();
 orangeSound.play();
}

 static {
        try {
           orangeSound = new SoundClip("data/sounds/collectPoint.wav");
         } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
           System.out.println(e);
         } 
 }
}
