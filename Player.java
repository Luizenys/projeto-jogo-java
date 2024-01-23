
package jogo;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Player extends GameObject {

    public Player(int x, int y, ID id) {
        super(x, y, id);
        /*Random r1 = new Random();
        Random r2 = new Random();
        velX = 4;
        velY = r2.nextInt(4)+1;*/
    }

    @Override
    public void tick() {
        x += velX;
        if(id==ID.player){
            if(!(y>(Jogo.ALTURA-150)&&velY==0)){
                if(y<20&&velY<0){
                    y=y;
                }else{
                    y += velY+7;
                }
            }
        }
        if(id==ID.player2){
            if(!(y>(Jogo.ALTURA-100)&&velY==0)){
                if(y<20&&velY<0){
                    y=y;
                }else{
                    y += velY+5;
                }
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        if (id==ID.player) g.fillOval(x, y, 70, 100);
        else if (id==ID.player2) g.fillOval(x, y, 35, 50);
        
    }
    
}
