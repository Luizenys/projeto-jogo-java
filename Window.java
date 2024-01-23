
package jogo;
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;
public class Window extends Canvas{
    public Window(int lar,int alt,String titulo,Jogo jogo){
        JFrame frame = new JFrame(titulo);
        
        frame.setPreferredSize(new Dimension(lar,alt));
        frame.setMaximumSize(new Dimension(lar,alt));
        frame.setMinimumSize(new Dimension(lar,alt));
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //para thread na operacao do jogo
        frame.setResizable(false); //impede de redimensionar a janela
        frame.setLocationRelativeTo(null); //para a janela abrir no centro da tela
        frame.add(jogo); //adc a classe jogo para nossa frame
        frame.setVisible(true); //torna visivel
        jogo.inicia();
    }
}
