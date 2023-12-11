
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JLabel;


/**
 *
 * @author villa
 */
public class fotoperfil extends JLabel{
    private int tamaño;
    public fotoperfil(int tamaño,int x,int y,int width,int height){
        this.tamaño=tamaño;
        setOpaque(false);
        setBounds(x, y, width, height);
    }
    public void bordes(Graphics g){
         Graphics2D g2 = (Graphics2D) g.create();

        // Crea una forma redondeada para los bordes de la etiqueta
        RoundRectangle2D.Float shape = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), tamaño, tamaño);

        g2.setClip(shape);  
        super.paintComponent(g);  

        g2.dispose();
    }
    @Override
    public boolean contains(int x, int y) {
        // Verifica si el punto (x, y) está contenido dentro de la forma redondeada
        RoundRectangle2D.Float shape = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), tamaño, tamaño);
        return shape.contains(x, y);
    }
}
