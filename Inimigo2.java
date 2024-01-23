package jogo;

import java.awt.Color;
import java.awt.Graphics;

public class Inimigo2 extends GameObject {

    public Inimigo2(int x, int y, ID id) {
        super(x, y, id);
        velY=5;
        //velX=-3;
    }

    @Override
    public void tick() {
        x+=velX;
        y+=velY;
        
        if(y<=0||y>Jogo.ALTURA-80){
            velY *= -1;
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(x, y, 40, 40);
    }
    
}
