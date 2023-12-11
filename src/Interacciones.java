
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BoxLayout;
import javax.swing.JScrollBar;


/**
 *
 * @author villa
 */
public class Interacciones extends javax.swing.JPanel {

     private ArrayList<String[]> twits;
     UsersTwit users=new UsersTwit();
     Buscarusuarios buscar=new Buscarusuarios(users);
    public Interacciones() {
        initComponents();
        try{
            subirtweets();
        }catch(IOException e){
            System.out.println("no se puedieron encontrar las mencioned");
        }
    }
 private void subirtweets() throws IOException {
    panelmenciones.removeAll();
    panelmenciones.setLayout(new BoxLayout(panelmenciones, BoxLayout.Y_AXIS));

    ArrayList<String> usuarios = buscar.buscarUsers();

    for (String usuario : usuarios) {
        System.out.println("usuarios almacenados: " + usuario);
        twits = buscar.cargarTwitsmencion(usuario);

        if (twits != null && !twits.isEmpty()) {
            // Iterar en orden inverso para agregar los nuevos tweets al principio
            for (int i = twits.size() - 1; i >= 0; i--) {
                String[] tweet = twits.get(i);
                String usuarioTweet = tweet[0];
                String texto = tweet[1];
                String fecha = tweet[2];

                long tiempoEnMilisegundos = Long.parseLong(fecha);
                Date fechadate = new Date(tiempoEnMilisegundos);
                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                String fechaFormateada = formatoFecha.format(fechadate);

                Tweets twee = new Tweets(usuarioTweet, texto, fechaFormateada);
                panelmenciones.add(twee);// Agregar al principio del panel
            }
        }
    }

        panelmenciones.revalidate();
        panelmenciones.repaint();
        scrollmenciones.revalidate();
        scrollmenciones.repaint();

        // Mover la barra de desplazamiento al final
        JScrollBar barra = scrollmenciones.getVerticalScrollBar();
        barra.setValue(barra.getMaximum());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbname2 = new javax.swing.JLabel();
        lbname3 = new javax.swing.JLabel();
        scrollmenciones = new javax.swing.JScrollPane();
        panelmenciones = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(684, 840));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbname2.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lbname2.setText("Notificaciones");

        lbname3.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lbname3.setText("Menciones");

        scrollmenciones.setBorder(null);
        scrollmenciones.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panelmenciones.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelmencionesLayout = new javax.swing.GroupLayout(panelmenciones);
        panelmenciones.setLayout(panelmencionesLayout);
        panelmencionesLayout.setHorizontalGroup(
            panelmencionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 684, Short.MAX_VALUE)
        );
        panelmencionesLayout.setVerticalGroup(
            panelmencionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 730, Short.MAX_VALUE)
        );

        scrollmenciones.setViewportView(panelmenciones);

        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbname3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbname2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(scrollmenciones)
            .addComponent(jSeparator1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbname2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(lbname3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollmenciones, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbname2;
    private javax.swing.JLabel lbname3;
    private javax.swing.JPanel panelmenciones;
    private javax.swing.JScrollPane scrollmenciones;
    // End of variables declaration//GEN-END:variables
}
