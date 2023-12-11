
import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;


/**
 *
 * @author villa
 */
public class Timeline extends javax.swing.JPanel {

    private JList<String> listaSugerencias = new JList<>();
    LoginTwitter login=new LoginTwitter();
    Foto foto=new Foto(login);
    UsersTwit user=new UsersTwit();
    LogicaTwitter logica;
    Buscarusuarios buscar=new Buscarusuarios(user);
    private Set<String> tweetsSet = new HashSet<>();
    private ArrayList<String[]> twits;
    private JPopupMenu popupSugerencias;
    public Timeline(LogicaTwitter logica) {
        initComponents();
        popupSugerencias=new JPopupMenu();
//        popupSugerencias.add(new JScrollPane(listaSugerencias));
       try{
       this.logica=logica;
       this.twits=logica.cargarTwits();
       cargartwitssiguiendo();
       subirtweets();
       ImageIcon icono = foto.seticon(user.getUserlog(), foto.getRutaImagen(), null,50,50);
        if(icono==null){
        lbfoto.setIcon(icono);
        }else{
            lbfoto.setIcon(user.cargarFotoPerfil(user.getUserlog(),50,50));
        }
       }catch(IOException e){
           e.printStackTrace();
            System.out.println("error en cargar ");
        }
     
   
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txttexto = new javax.swing.JEditorPane();
        lbfoto = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        scrolltweets = new javax.swing.JScrollPane();
        paneltweets = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txttexto.setBorder(null);
        txttexto.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txttexto.setForeground(new java.awt.Color(102, 102, 102));
        txttexto.setToolTipText("");
        txttexto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txttexto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttextoKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txttexto);

        lbfoto.setText("Foto");

        jButton1.setBackground(new java.awt.Color(153, 204, 255));
        jButton1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jButton1.setText("Tweet");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("QUE ESTA PASANDO?");

        scrolltweets.setBackground(new java.awt.Color(255, 255, 255));
        scrolltweets.setBorder(null);
        scrolltweets.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        paneltweets.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout paneltweetsLayout = new javax.swing.GroupLayout(paneltweets);
        paneltweets.setLayout(paneltweetsLayout);
        paneltweetsLayout.setHorizontalGroup(
            paneltweetsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 672, Short.MAX_VALUE)
        );
        paneltweetsLayout.setVerticalGroup(
            paneltweetsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 615, Short.MAX_VALUE)
        );

        scrolltweets.setViewportView(paneltweets);

        jSeparator3.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator3.setForeground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lbfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(422, 422, 422))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
                        .addComponent(jSeparator1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(scrolltweets, javax.swing.GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
            .addComponent(jSeparator3)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(lbfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(scrolltweets, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      String texto=txttexto.getText();
      if(texto.length()<=140){
      if(!txttexto.getText().isEmpty()){
        try{
        logica.guardarTwit(texto);
        buscar.buscarmenciones(texto);
        if(!txttexto.getText().isEmpty()){
        List<String> hashtags = logica.extraerHashtags(texto);
            logica.guardarHashtagsEnArchivo(hashtags);
        }
        txttexto.setText("");
        subirtweets();
        this.revalidate();
                this.repaint();
                JScrollBar barra = scrolltweets.getVerticalScrollBar();
                barra.setValue(barra.getMaximum());
        }catch(IOException e){
             System.out.println("No se puede");
         } 
      }else{
          JOptionPane.showMessageDialog(null, "Tweet vacio");
      }
      }else
          JOptionPane.showMessageDialog(null, "Mensaje muy largo");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txttextoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttextoKeyTyped
    char tecla = evt.getKeyChar();
    String texto = txttexto.getText() + tecla;

    
    try {
        if (tecla == '@') {
            mostrarVentanaSugerencias(texto);
            
            txttexto.setForeground(Color.blue);
        } else if (Character.isWhitespace(tecla)) {
            txttexto.setForeground(new Color(102, 102, 102));
            ocultarVentanaSugerencias();
        }
       
    } catch (IOException e) {
        System.out.println("no @");
    }

        
    }//GEN-LAST:event_txttextoKeyTyped

    private void mostrarVentanaSugerencias(String texto) throws IOException{
    String[] usuarios = user.obtenerUsuarios();
    ArrayList<String> sugerencias = obtenerSugerencias(texto);
    
    for (String usuario : usuarios) {
            sugerencias.add(usuario);   
    }
        
    listaSugerencias.setListData(sugerencias.toArray(new String[0]));
    
    popupSugerencias.removeAll();
   
    // Asociar el menú emergente al componente de texto
       for (String sugerencia : sugerencias){
           if(!user.desac(sugerencia)){
        System.out.println("datos"+sugerencias);
        JMenuItem menuItem = new JMenuItem(sugerencia);
        menuItem.setBackground(Color.WHITE);
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {           
               txttexto.setText(txttexto.getText() + menuItem.getText().toString());
            }
        });

        popupSugerencias.add(menuItem);
           }
    }
    popupSugerencias.setInvoker(txttexto);


    // Mostrar la ventana emergente cerca del '@' en el editor pane
    Point posicion = txttexto.getCaret().getMagicCaretPosition();
    if (posicion != null) {
        popupSugerencias.show(txttexto, posicion.x, posicion.y + 20); // Ajusta la posición vertical
        txttexto.requestFocusInWindow(); // Asegurar que el editor pane mantenga el foco
    }
}


private void ocultarVentanaSugerencias() {
    popupSugerencias.setVisible(false);
    txttexto.requestFocusInWindow(); // Asegurar que el editor pane mantenga el foco
}
//sugerencias
private ArrayList<String> obtenerSugerencias(String mencion) throws IOException {
      
        ArrayList<String> resultados = buscar.buscarUsuarios(mencion);
        
        
        ArrayList<String> sugerencias = new ArrayList<>();
        System.out.println("suge"+sugerencias);

        if (!resultados.isEmpty()) {
            for (String usuario : resultados) {
                // Verificar si el usuario contiene la letra escrita
                if (!usuario.equalsIgnoreCase(user.getUserlog()) && usuario.toLowerCase().contains(mencion.toLowerCase()) && !user.desac(usuario)) {
                 sugerencias.add(usuario);
                   
                }

            }
        }

        return sugerencias;
    }



private void subirtweets() throws IOException {
    paneltweets.removeAll();
    paneltweets.setLayout(new BoxLayout(paneltweets, BoxLayout.Y_AXIS));

    // Panel para los tweets del usuario logueado
    JPanel panelTweetsUsuario = new JPanel();
    panelTweetsUsuario.setLayout(new BoxLayout(panelTweetsUsuario, BoxLayout.Y_AXIS));

    twits = logica.cargarTwits();

    if (!twits.isEmpty()) {
        // Limpiar el conjunto de tweets antes de agregar nuevos
        tweetsSet.clear();

        // Iterar en orden inverso para agregar los nuevos tweets al principio
        for (int i = twits.size() - 1; i >= 0; i--) {
            String[] tweet = twits.get(i);
            String identificador = tweet[1] + tweet[2]; // Identificador único

            // Agregar tweet solo si no existe en el conjunto
            if (!tweetsSet.contains(identificador)) {
                tweetsSet.add(identificador);

                String usuario = tweet[0];
                String texto = tweet[1];
                String fecha = tweet[2];

                long tiempoEnMilisegundos = Long.parseLong(fecha);
                Date fechadate = new Date(tiempoEnMilisegundos);
                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                String fechaFormateada = formatoFecha.format(fechadate);

                Tweets twee = new Tweets(usuario, texto, fechaFormateada);
                panelTweetsUsuario.add(twee);
            }
        }
    }

    // Agregar panel de tweets del usuario logueado al panel general
    paneltweets.add(panelTweetsUsuario);

    // Cargar y agregar los tweets de los seguidores
    cargartwitssiguiendo();

    // Revalidar y repintar el panel general
    paneltweets.revalidate();
    paneltweets.repaint();
    scrolltweets.revalidate();
    scrolltweets.repaint();

    // Mover la barra de desplazamiento al final
    JScrollBar barra = scrolltweets.getVerticalScrollBar();
    barra.setValue(barra.getMaximum());
}

private void cargartwitssiguiendo() throws IOException {
    ArrayList<String> twitssiguiendo = buscar.cargartwitseg();

    for (String usuario : twitssiguiendo) {
        ArrayList<String[]> twitsUsuario = buscar.cargarTwits(usuario);

        if (twitsUsuario != null) {
            for (int i = twitsUsuario.size() - 1; i >= 0; i--) {
                String[] tweet = twitsUsuario.get(i);
                String identificador = tweet[1] + tweet[2]; // Identificador único

                // Agregar tweet solo si no existe en el conjunto
                if (!tweetsSet.contains(identificador)) {
                    tweetsSet.add(identificador);

                    String texto = tweet[1];
                    String fecha = tweet[2];

                    long tiempoEnMilisegundos = Long.parseLong(fecha);
                    Date fechadate = new Date(tiempoEnMilisegundos);
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                    String fechaFormateada = formatoFecha.format(fechadate);

                    Tweets twee = new Tweets(usuario, texto, fechaFormateada);
                    paneltweets.add(twee);
                }
            }
        }
    }
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lbfoto;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel paneltweets;
    private javax.swing.JScrollPane scrolltweets;
    private javax.swing.JEditorPane txttexto;
    // End of variables declaration//GEN-END:variables
}
