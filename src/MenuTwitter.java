
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MenuTwitter extends javax.swing.JFrame {
 
    private static String nombreSeleccionado;
    String image1,image2,lupan,lupaA,campana,campanaA,user,userA,mas,masA;
   LogicaTwitter logica=new LogicaTwitter();
   UsersTwit users=new UsersTwit();
   Buscarusuarios buscar= new Buscarusuarios(users);
    public MenuTwitter() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        Timeline time=new Timeline(logica);
        crearpaneles(time);
        image1= "src/imagentwitter/casa.png";
        image2= "src/imagentwitter/casa_azul.png";
        lupan ="src/imagentwitter/lupa.png";
        lupaA ="src/imagentwitter/lupa_azul.png";
        campana="src/imagentwitter/campana.png";
        campanaA="src/imagentwitter/campana_azul.png";
        user="src/imagentwitter/user.png";
        userA="src/imagentwitter/user_azul.png";
        mas="src/imagentwitter/mas.png";
        masA="src/imagentwitter/mas_azul.png";
        scrollLista.setVisible(false);
        listabuscar.addListSelectionListener(e -> {
            try{
            if (!e.getValueIsAdjusting()) {
                // Obtener el nombre seleccionado
                
                nombreSeleccionado = listabuscar.getSelectedValue();
                buscar.setNombreselected(nombreSeleccionado);
                if(nombreSeleccionado!=null){
                buscarparaelperfil(nombreSeleccionado);
                scrollLista.setVisible(false);
                }
            }
            }catch(IOException ex){
            System.out.println("");
        }
        });
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        bthogar = new javax.swing.JButton();
        btexplorar = new javax.swing.JButton();
        btnotificacion = new javax.swing.JButton();
        btuser = new javax.swing.JButton();
        btmas = new javax.swing.JButton();
        bttweet = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtbuscar = new javax.swing.JTextField();
        scrollLista = new javax.swing.JScrollPane();
        listabuscar = new javax.swing.JList<>();
        panelhome = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1606, 840));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagentwitter/LogoTwitter.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 12, 71, 57));

        bthogar.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        bthogar.setForeground(new java.awt.Color(0, 153, 255));
        bthogar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagentwitter/casa_azul.png"))); // NOI18N
        bthogar.setText(" HOGAR");
        bthogar.setBorderPainted(false);
        bthogar.setContentAreaFilled(false);
        bthogar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        bthogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthogarActionPerformed(evt);
            }
        });
        jPanel1.add(bthogar, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 81, -1, 40));

        btexplorar.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        btexplorar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagentwitter/lupa.png"))); // NOI18N
        btexplorar.setText(" EXPLORAR");
        btexplorar.setBorderPainted(false);
        btexplorar.setContentAreaFilled(false);
        btexplorar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btexplorar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btexplorarActionPerformed(evt);
            }
        });
        jPanel1.add(btexplorar, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 127, -1, 40));

        btnotificacion.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        btnotificacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagentwitter/campana.png"))); // NOI18N
        btnotificacion.setText(" INTERACCIONES");
        btnotificacion.setBorderPainted(false);
        btnotificacion.setContentAreaFilled(false);
        btnotificacion.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnotificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnotificacionActionPerformed(evt);
            }
        });
        jPanel1.add(btnotificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 173, -1, 40));

        btuser.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        btuser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagentwitter/user.png"))); // NOI18N
        btuser.setText(" PERFIL");
        btuser.setBorderPainted(false);
        btuser.setContentAreaFilled(false);
        btuser.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btuserActionPerformed(evt);
            }
        });
        jPanel1.add(btuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 225, -1, 40));

        btmas.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        btmas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagentwitter/mas.png"))); // NOI18N
        btmas.setText("  CERRAR SESION");
        btmas.setBorderPainted(false);
        btmas.setContentAreaFilled(false);
        btmas.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btmas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmasActionPerformed(evt);
            }
        });
        jPanel1.add(btmas, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 283, -1, 40));

        bttweet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagentwitter/Twit.png"))); // NOI18N
        bttweet.setBorderPainted(false);
        bttweet.setContentAreaFilled(false);
        bttweet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttweetActionPerformed(evt);
            }
        });
        jPanel1.add(bttweet, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 386, 174, 42));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 715, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtbuscar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtbuscar.setForeground(new java.awt.Color(51, 51, 51));
        txtbuscar.setText("Buscar");
        txtbuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtbuscarMouseClicked(evt);
            }
        });
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbuscarKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtbuscarKeyTyped(evt);
            }
        });
        jPanel2.add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 366, 40));

        listabuscar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        scrollLista.setViewportView(listabuscar);

        jPanel2.add(scrollLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 360, -1));

        panelhome.setBackground(new java.awt.Color(255, 255, 255));
        panelhome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelhome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelhome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bthogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthogarActionPerformed
        botonesblack();
       bthogar.setForeground(new Color(0, 153, 255));
       bthogar.setIcon(new ImageIcon(image2));
       Timeline time=new Timeline(logica);
        crearpaneles(time);
    }//GEN-LAST:event_bthogarActionPerformed

    private void btexplorarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btexplorarActionPerformed
        botonesblack();
        btexplorar.setForeground(new Color(0, 153, 255));
        btexplorar.setIcon(new ImageIcon(lupaA));
        buscarhashtag hash=new buscarhashtag();
        crearpaneles(hash);
    }//GEN-LAST:event_btexplorarActionPerformed

    private void btnotificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnotificacionActionPerformed
        botonesblack();
        btnotificacion.setForeground(new Color(0, 153, 255));
        btnotificacion.setIcon(new ImageIcon(campanaA));
        Interacciones intera=new Interacciones();
        crearpaneles(intera);
    }//GEN-LAST:event_btnotificacionActionPerformed

    private void btuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btuserActionPerformed
        botonesblack();
        btuser.setForeground(new Color(0, 153, 255));
        btuser.setIcon(new ImageIcon(userA));
        try(RandomAccessFile registro=new RandomAccessFile("Usertwit/user.twc","rw");){
         while(registro.getFilePointer() < registro.length()){
            String name=registro.readUTF();
            char genero=registro.readChar();
            String usuario=registro.readUTF();
            registro.readUTF();
            int edad=registro.readInt();
            String fecha=registro.readUTF();
            registro.readBoolean();
            
            if(usuario.equals(users.getUserlog())){
             Perfil perfil=new Perfil(this,name,genero,edad, fecha);
             crearpaneles(perfil);
            }
         }
        }catch(IOException e){
            
        }
       
    }//GEN-LAST:event_btuserActionPerformed

    private void btmasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmasActionPerformed
        botonesblack();
        btmas.setForeground(new Color(0, 153, 255));
        btmas.setIcon(new ImageIcon(masA));
        int opcion=JOptionPane.showInternalConfirmDialog(null, "Desea cerrar la sesion? ");
         if (opcion == JOptionPane.YES_OPTION) {
         LoginTwitter login=new LoginTwitter();
        login.setVisible(true);
        dispose();
        } else if (opcion == JOptionPane.NO_OPTION || opcion == JOptionPane.CANCEL_OPTION || opcion == JOptionPane.CLOSED_OPTION) {
             System.out.println("no cerro xd");
        } 
        
    }//GEN-LAST:event_btmasActionPerformed

    private void bttweetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttweetActionPerformed

    }//GEN-LAST:event_bttweetActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        LoginTwitter login=new LoginTwitter();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtbuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtbuscarMouseClicked
        if(txtbuscar.getText().equals("Buscar")){
            txtbuscar.setText("");
            scrollLista.setVisible(true);
        }
       scrollLista.setVisible(true);
       if(txtbuscar.getText().isEmpty()){
           scrollLista.setVisible(false);
       }
        
    }//GEN-LAST:event_txtbuscarMouseClicked

    private void txtbuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyPressed
       if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
           
       }
    }//GEN-LAST:event_txtbuscarKeyPressed

    private void txtbuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyTyped
       DefaultListModel<String> listModel = new DefaultListModel<>();
                listabuscar.setModel(listModel);
        scrollLista.setVisible(true);
        try {
            String resultado = imprimirdatos();
            if (!resultado.isEmpty()) {
                // Limpiar el modelo antes de agregar nuevos resultados
                
                // Dividir el resultado por líneas y agregar cada línea al modelo
                for (String linea : resultado.split("\n")) {
                    listModel.addElement(linea);
                }
            } else {
                listabuscar.clearSelection();
            }
        } catch (IOException e) {
            System.out.println("Error al imprimir los datos");
        }
    
    }//GEN-LAST:event_txtbuscarKeyTyped

   private String imprimirdatos() throws IOException {
    String texto = txtbuscar.getText();
    ArrayList<String> resultados = buscar.buscarUsuarios(texto);

    StringBuilder resultBuilder = new StringBuilder();

    if (!resultados.isEmpty()) {
        for (String usuario : resultados) {
            // Verificar si el usuario contiene la letra escrita
            if (!usuario.equalsIgnoreCase(users.getUserlog())&& usuario.toLowerCase().contains(texto.toLowerCase()) && !users.desac(usuario)) {
                resultBuilder.append(usuario).append("\n");
            }
        }
    }else
        return  "No se encontraron usuarios";

    return resultBuilder.toString();
}

    public boolean buscarparaelperfil(String user) throws IOException{
        System.out.println("entra al buscar");
        try (RandomAccessFile registro = new RandomAccessFile("Usertwit/user.twc", "rw")) {
        while (registro.getFilePointer() < registro.length()) {
            String nombre=registro.readUTF();
            char gene=registro.readChar();
            String usuario = registro.readUTF();
            registro.readUTF(); 
            int edad=registro.readInt();
            String date=registro.readUTF();
            registro.readBoolean();
            System.out.println("antes del if");
            if(user.equals(usuario) && !users.desac(user)){
                System.out.println("entra al if");
                System.out.println("nombre: "+nombre+" user "+user);
                Perfilusuarios perfil=new Perfilusuarios(nombre, gene, edad, usuario, date);
                crearpaneles(perfil);
                txtbuscar.setText("Buscar");
              return true;
            }
           
        }
    } 
        return false;
    }
     private void crearpaneles(JPanel pa){
        pa.setSize(684, 840);
        pa.setLocation(0, 0);
         panelhome.removeAll();
        panelhome.add(pa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0,0,-1,-1));
        panelhome.revalidate();
        panelhome.repaint(); 
     }
    private void botonesblack(){
       btmas.setIcon(new ImageIcon(mas));
       btuser.setIcon(new ImageIcon(user));
       bthogar.setIcon(new ImageIcon(image1));
       btexplorar.setIcon(new ImageIcon(lupan));
       btnotificacion.setIcon(new ImageIcon(campana));
       bthogar.setForeground(Color.black);
       btexplorar.setForeground(Color.black);
       btnotificacion.setForeground(Color.black);
       btuser.setForeground(Color.black);  
       btmas.setForeground(Color.black);  
    //    panelbuscar.setText("");
       txtbuscar.setText("Buscar");
       scrollLista.setVisible(false);
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btexplorar;
    private javax.swing.JButton bthogar;
    private javax.swing.JButton btmas;
    private javax.swing.JButton btnotificacion;
    private javax.swing.JButton bttweet;
    private javax.swing.JButton btuser;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JList<String> listabuscar;
    private javax.swing.JPanel panelhome;
    private javax.swing.JScrollPane scrollLista;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}
