package garjust.jag2d.geometry;

/**
 *
 * @author jagarbut
 */
public interface WriteOnlyRectangle {

    public int x(final int x);

    public int y(final int y);
    
    public int w(final int w);

    public int h(final int h);

    public Rectangle set(final int x, final int y, final int w, final int h);
}
