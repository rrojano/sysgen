package mx.uv.sysgen.Logica.martin;


import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JPanel;
import javax.swing.Scrollable;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GON
 */
class ScrollablePanel extends JPanel implements Scrollable
{
    public Dimension getPreferredSize()
    {
        return getPreferredScrollableViewportSize();
    }

    public Dimension getPreferredScrollableViewportSize()
    {
        if( getParent() == null )
            return getSize();
        Dimension d = getParent().getSize();
        int c = (int)Math.floor((d.width - getInsets().left - getInsets().right) / 50.0);
        if( c == 0 )
            return d;
        int r = 20 / c;
        if( r * c < 20 )
            ++r;
        return new Dimension(c * 50, r * 50);
    }

    public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction)
    {
        return 50;
    }

    public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction)
    {
        return 10;
    }

    public boolean getScrollableTracksViewportHeight()
    {
        return false;
    }

    public boolean getScrollableTracksViewportWidth()
    {
        return getParent() != null ? getParent().getSize().width > getPreferredSize().width : true;
    }
}