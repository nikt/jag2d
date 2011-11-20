package garjust.jag2d.core;

import garjust.jag2d.geometry.Point;
import garjust.jag2d.geometry.Polygon;
import garjust.jag2d.geometry.Vector;
//
import java.awt.Graphics2D;

/**
 *
 * @author Justin Garbutt
 */
public class PolygonEntity extends Polygon implements Entity {

    public Point position;
    public Vector velocity;
    public float rotation_velocity;

    public PolygonEntity(final Polygon polygon, final Point position) {
        super(polygon);
        this.position = position;
        this.velocity = new Vector(Vector.ZERO);
        this.rotation_velocity = 0;
    }

    public PolygonEntity(final Polygon polygon, final Point position, final Vector velocity, final float velocity_rotation) {
        super(polygon);
        this.position = position;
        this.velocity = velocity;
        this.rotation_velocity = velocity_rotation;
    }

    public PolygonEntity(final PolygonEntity entity) {
        super(entity);
        this.position = entity.position;
        this.velocity = entity.velocity;
        this.rotation_velocity = entity.rotation_velocity;
    }
    
    public Point position() {
        return new Point(position);
    }
    
    public Vector velocity() {
        return new Vector(velocity);
    }
    
    public float rotation_velocity() {
        return rotation_velocity;
    }

    @Override
    public PolygonEntity translate(final float x, final float y) {
        super.translate(x, y);
        position.translate(x, y);
        return this;
    }

    @Override
    public void draw(Graphics2D graphics) {
        super.draw(graphics);
        position.draw(graphics);
        velocity.draw(graphics, java.awt.Color.CYAN, position);
    }

    public void update(final float delta) {
        translate(velocity.x() * (delta / 1000), velocity.y() * (delta / 1000));
        if(rotation_velocity != 0) {
            rotate(rotation_velocity * (delta / 1000), position);
        }
    }

    public boolean collide(final Entity entity) {
        return false;
    }
}
