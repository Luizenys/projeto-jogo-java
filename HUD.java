
package jogo;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
    public static int HP=150;
    
    public void tick(){
        if(HP<=0){
            HP=HP;
        }else{
            HP--;
        }
    }
    
    public void render(Graphics g){
        g.setColor(Color.gray);
        g.fillRoundRect(655, 465,160 , 40,30,30);
        g.setColor(Color.green);
        g.fillRoundRect(660, 470,HP , 30,30,30);
    }
}
