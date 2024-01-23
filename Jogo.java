
package jogo;

import java.awt.Canvas;
import java.awt.Color;
import static java.awt.Color.black;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.ImageIcon;

public class Jogo extends Canvas implements Runnable {
    public static final int LARGURA = 1040, ALTURA =540;
    private Thread thread;
    private boolean rodando = false;
    private Administrador administrador;
    private Random rand;
    private HUD hud;

    public Jogo(){
        administrador = new Administrador();  
        this.addKeyListener(new Teclado(administrador));
        new Window(LARGURA,ALTURA,"Egg game!",this);
        hud = new HUD();
        rand = new Random();
        /*for(int i=0; i<30;i++){
            administrador.addObject(new Player(0,rand.nextInt(ALTURA),ID.player));
        }*/
        administrador.addObject(new Player(50,50,ID.player));
        administrador.addObject(new Player(150,50,ID.player2));
        administrador.addObject(new Inimigo(LARGURA,100,ID.inimigo));
        administrador.addObject(new Inimigo2(400,0,ID.inimigo2));
        
    }
    
    public synchronized void inicia(){ //inicia nosso thread
        thread = new Thread(this); //iniciacializa a thread como uma nova thread
        thread.start(); //comeca a thread
        rodando = true;
    }
    
    public synchronized void para(){
        try{
            thread.join(); //para a thread
            rodando=false;
        }catch (Exception e){
            e.printStackTrace(); //gera um erro, dizendo o porque nao pode ser realizado o try
        }
    }
    
    public void run(){
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(rodando){
            long now = System.nanoTime();
            delta += (now - lastTime)/ns;
            lastTime = now;
            while(delta>=1){
                tick();
                delta--;
            }
            if(rodando){
                render();
            }
            frames++;
            if(System.currentTimeMillis()-timer>1000){
                timer += 1000;
                System.out.println("FPS: "+frames);
                frames = 0;
            }
        }
        para();
    }
    
    private void tick(){
        administrador.tick();
        hud.tick();
    }
    
    private void render(){
        BufferStrategy bs = this.getBufferStrategy(); 
        if(bs == null){
            this.createBufferStrategy(3);//cria 3 buffers
            return;
        }
        
        Graphics g = bs.getDrawGraphics();

        
        g.setColor(Color.pink);
        g.fillRect(0, 0, LARGURA, ALTURA);
        administrador.render(g);
        hud.render(g);
        g.dispose();
        bs.show();
        
    }

    public static void main(String[] args) {
        new Jogo();
    }
}
