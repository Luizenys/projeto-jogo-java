
package jogo;

import java.awt.Color;
import java.awt.Graphics;

public class Inimigo extends GameObject {

    public Inimigo(int x, int y, ID id) {
        super(x, y, id);
    }

    @Override
    public void tick() {
        x+=-5;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, 40, 40);
    }
    
}
