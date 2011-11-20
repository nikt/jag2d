package garjust.jag2d.core;

import garjust.jag2d.geometry.Point;
import garjust.jag2d.geometry.Polygon;
import garjust.jag2d.geometry.Vector;

import java.awt.Graphics2D;

/**
 *
 * @author t_garbj
 */
public class FacedEntity extends PolygonEntity {

    public Vector facing;

    public FacedEntity(final Polygon polygon, final Point position) {
        super(polygon, position);
        this.facing = new Vector(0, 1);
    }

    public FacedEntity(final Polygon polygon, final Point position, final Vector velocity, final float velocity_rotation, final Vector facing) {
        super(polygon, position, velocity, velocity_rotation);
        this.facing = facing;
    }

    public FacedEntity(final FacedEntity entity) {
         super(entity);
         this.facing = entity.facing;
    }

    @Override
    public void draw(Graphics2D graphics) {
        super.draw(graphics);
        final Vector scaled = new Vector(facing);
        scaled.length(10).draw(graphics, java.awt.Color.GREEN, position);
    }

    @Override
    public void update(final float delta) {
        super.update(delta);
        if(rotation_velocity != 0) {
            facing.rotate(rotation_velocity * (delta / 1000));
        }
    }
}
