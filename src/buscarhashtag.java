
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JScrollBar;


/**
 *
 * @author villa
 */
public class buscarhashtag extends javax.swing.JPanel {

    UsersTwit users=new UsersTwit();
    Buscarusuarios buscar=new Buscarusuarios(users);
    LogicaTwitter logica=new LogicaTwitter();
    private ArrayList<String[]> twits;
    private static String hashtagselected;
    public buscarhashtag() {
        initComponents();
        scrollhash.setVisible(false);
       
        listahash.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                 try{
        hashtagselected= listahash.getSelectedValue();
        subirtweets();
        scrollhash.setVisible(false);
        lbhash.setText(hashtagselected);
        }catch(IOException ex){
           System.out.println("no se subieronlos tweets con ese hash");
        }
            }
        });
        
    }

    private void subirtweets() throws IOException {
        paneltweets.removeAll();
        paneltweets.setLayout(new BoxLayout(paneltweets, BoxLayout.Y_AXIS));

        ArrayList<String> usuarios = buscar.buscarUsers();
        for (String usuario : usuarios) {
            System.out.println("usuarios almacenados: "+usuario);
            twits = logica.cargarTwitsmencion(usuario, hashtagselected);
            System.out.println("pasa");
            System.out.println("twits: "+twits);
            if (twits != null && !twits.isEmpty()) {
                System.out.println("entra al if");
                // Iterar en orden inverso para agregar los nuevos tweets al principio
                for (int i = twits.size() - 1; i >= 0; i--) {
                    String[] tweet = twits.get(i);
                    String usuarioTweet = tweet[0];
                    String texto = tweet[1];
                    String fecha = tweet[2];
                    System.out.println("text: "+texto);
                    long tiempoEnMilisegundos = Long.parseLong(fecha);
                    Date fechadate = new Date(tiempoEnMilisegundos);
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                    String fechaFormateada = formatoFecha.format(fechadate);

                    Tweets twee = new Tweets(usuarioTweet, texto, fechaFormateada);
                    paneltweets.add(twee);
                }
            }
        }

        paneltweets.revalidate();
        paneltweets.repaint();
        scrollhash.revalidate();
        scrollhash.repaint();

        // Mover la barra de desplazamiento al final
        JScrollBar barra = scrollhash.getVerticalScrollBar();
        barra.setValue(barra.getMaximum());
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbname2 = new javax.swing.JLabel();
        txttexto = new javax.swing.JTextField();
        scrolltweets = new javax.swing.JScrollPane();
        paneltweets = new javax.swing.JPanel();
        scrollhash = new javax.swing.JScrollPane();
        listahash = new javax.swing.JList<>();
        lbhash = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbname2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbname2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagentwitter/lupa.png"))); // NOI18N
        lbname2.setText("Buscar #");
        jPanel1.add(lbname2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 110, 30));

        txttexto.setForeground(new java.awt.Color(153, 153, 153));
        txttexto.setText("Buscar");
        txttexto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txttextoMouseClicked(evt);
            }
        });
        txttexto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttextoKeyTyped(evt);
            }
        });
        jPanel1.add(txttexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 290, 40));

        scrolltweets.setBorder(null);
        scrolltweets.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrolltweets.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        paneltweets.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout paneltweetsLayout = new javax.swing.GroupLayout(paneltweets);
        paneltweets.setLayout(paneltweetsLayout);
        paneltweetsLayout.setHorizontalGroup(
            paneltweetsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        paneltweetsLayout.setVerticalGroup(
            paneltweetsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 718, Short.MAX_VALUE)
        );

        scrolltweets.setViewportView(paneltweets);

        jPanel1.add(scrolltweets, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 700, 680));

        listahash.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        listahash.setForeground(new java.awt.Color(102, 153, 255));
        scrollhash.setViewportView(listahash);

        jPanel1.add(scrollhash, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 290, 80));

        lbhash.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbhash.setForeground(new java.awt.Color(0, 153, 255));
        jPanel1.add(lbhash, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 100, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txttextoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttextoKeyTyped

        DefaultListModel<String> listModel = new DefaultListModel<>();
        listahash.setModel(listModel);
        scrollhash.setVisible(true);
        try{
        String datos=imprimirhashtags();
        if(!datos.isEmpty()){
            for (String linea : datos.split("\n")) {
                    listModel.addElement(linea);
                }
        }else
            listahash.clearSelection();
       
        }catch(IOException e){
            System.out.println("No se imprimen #");
        }
        
    }//GEN-LAST:event_txttextoKeyTyped

    private void txttextoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txttextoMouseClicked
   if(txttexto.getText().equals("Buscar")){
            txttexto.setText("");
            scrollhash.setVisible(true);
        }
       scrollhash.setVisible(true);
       if(txttexto.getText().isEmpty()){
           scrollhash.setVisible(false);
       }
    }//GEN-LAST:event_txttextoMouseClicked

     public String imprimirhashtags() throws IOException{
         String texto=txttexto.getText();
         ArrayList<String> hash=logica.leerHashtagsDesdeArchivo();
         StringBuilder resultBuilder = new StringBuilder();
         if(!hash.isEmpty()){
             for(String hashtags: hash){
                 if(hashtags.contains(texto))
                 resultBuilder.append(hashtags).append("\n");
             }
         }else
             return "No hay tweets con ese hashtag";
         
         return resultBuilder.toString();
     }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbhash;
    private javax.swing.JLabel lbname2;
    private javax.swing.JList<String> listahash;
    private javax.swing.JPanel paneltweets;
    private javax.swing.JScrollPane scrollhash;
    private javax.swing.JScrollPane scrolltweets;
    private javax.swing.JTextField txttexto;
    // End of variables declaration//GEN-END:variables
}
