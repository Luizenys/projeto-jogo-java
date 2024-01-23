
package jogo;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Teclado extends KeyAdapter {
    private Administrador administrador;
    public Teclado(Administrador administrador){
        this.administrador  = administrador;
    }
    
    public void keyPressed(KeyEvent a){
        int key = a.getKeyCode();
        for(int i=0;i<administrador.object.size();i++){
            GameObject tempObject = administrador.object.get(i);
            if (tempObject.getId()==ID.player){
                if(key==KeyEvent.VK_UP) tempObject.setVelY(-13);
            }

            if (tempObject.getId()==ID.player2){
                if(key==KeyEvent.VK_W) tempObject.setVelY(-10);
                if(key==KeyEvent.VK_D) tempObject.setVelX(5);
                if(key==KeyEvent.VK_A) tempObject.setVelX(-5);
            }
        }
        if(key == KeyEvent.VK_ESCAPE) System.exit(1);
    }
    
    public void keyReleased(KeyEvent a){
        int key = a.getKeyCode();
        for(int i=0;i<administrador.object.size();i++){
            GameObject tempObject = administrador.object.get(i);
            if (tempObject.getId()==ID.player){
                if(key==KeyEvent.VK_UP) tempObject.setVelY(0);
            }

            if (tempObject.getId()==ID.player2){
                if(key==KeyEvent.VK_W) tempObject.setVelY(0);
                if(key==KeyEvent.VK_D) tempObject.setVelX(0);
                if(key==KeyEvent.VK_A) tempObject.setVelX(0);

            }
        }
    }
    
}
