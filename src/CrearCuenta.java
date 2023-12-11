
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

//Logica
public class CrearCuenta extends javax.swing.JFrame {

    private RandomAccessFile usuarios;
    private String name,genero,user,contra,edadS;
    private int edad;
    private char generoselected;
    UsersTwit usertwit=new UsersTwit();
    Border bordeRojo = BorderFactory.createLineBorder(Color.RED);
    Color colorPersonalizado = new Color(0, 153, 255);
    Border bordePersonalizado = BorderFactory.createLineBorder(colorPersonalizado);
    private LoginTwitter login;
    public CrearCuenta(LoginTwitter login) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.login=login;
      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        lbnombre = new javax.swing.JLabel();
        lbcontra = new javax.swing.JLabel();
        txtuser = new javax.swing.JTextField();
        lbuser = new javax.swing.JLabel();
        txtcontra = new javax.swing.JPasswordField();
        lbgenero = new javax.swing.JLabel();
        cbgenero = new javax.swing.JComboBox<>();
        lbedad = new javax.swing.JLabel();
        txtedad = new javax.swing.JTextField();
        btsiguiente = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jButton1.setText("X");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 30)); // NOI18N
        jLabel1.setText("Crea tu cuenta");

        txtnombre.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        txtnombre.setToolTipText("");
        txtnombre.setAlignmentX(1.0F);
        txtnombre.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 153, 255), new java.awt.Color(51, 153, 255)));
        txtnombre.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        lbnombre.setForeground(new java.awt.Color(0, 153, 255));
        lbnombre.setText("Nombre Completo:");

        lbcontra.setForeground(new java.awt.Color(0, 153, 255));
        lbcontra.setText("Contraseña:");

        txtuser.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        txtuser.setToolTipText("");
        txtuser.setAlignmentX(1.0F);
        txtuser.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 153, 255), new java.awt.Color(51, 153, 255)));
        txtuser.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        lbuser.setForeground(new java.awt.Color(0, 153, 255));
        lbuser.setText("Username:");

        txtcontra.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 153, 255), new java.awt.Color(0, 153, 255)));

        lbgenero.setForeground(new java.awt.Color(0, 153, 255));
        lbgenero.setText("Genero:");

        cbgenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Opcion", "F", "M" }));
        cbgenero.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 153, 255), new java.awt.Color(0, 153, 255)));

        lbedad.setForeground(new java.awt.Color(0, 153, 255));
        lbedad.setText("Edad:");

        txtedad.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        txtedad.setToolTipText("");
        txtedad.setAlignmentX(1.0F);
        txtedad.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 153, 255), new java.awt.Color(51, 153, 255)));
        txtedad.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        btsiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagentwitter/botonsig.png"))); // NOI18N
        btsiguiente.setBorderPainted(false);
        btsiguiente.setContentAreaFilled(false);
        btsiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsiguienteActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel6.setText("¿Ya tienes cuenta? ");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 255));
        jLabel5.setText("Inicia sesion");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbgenero, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbgenero, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lbedad, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(196, 196, 196))
                        .addComponent(txtcontra, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbuser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtuser, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbcontra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtnombre, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbnombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtedad, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(303, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btsiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbnombre)
                .addGap(4, 4, 4)
                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbgenero)
                .addGap(1, 1, 1)
                .addComponent(cbgenero, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbuser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtuser, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbcontra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtcontra, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbedad)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btsiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtedad, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(66, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btsiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsiguienteActionPerformed
       if(txtnombre.getText().isEmpty() || txtuser.getText().isEmpty() || txtcontra.getText().isEmpty() || txtedad.getText().isEmpty() || cbgenero.getSelectedItem().equals("Opcion")){
        if(txtnombre.getText().isEmpty()){
            txtnombre.setBorder(bordeRojo);
            lbnombre.setForeground(Color.red);
        }if(txtuser.getText().isEmpty()){
            txtuser.setBorder(bordeRojo);
            lbuser.setForeground(Color.red);
        }if(txtcontra.getText().isEmpty()){
            txtcontra.setBorder(bordeRojo);
            lbcontra.setForeground(Color.red);
        }if(txtedad.getText().isEmpty()){
            txtedad.setBorder(bordeRojo);
            lbedad.setForeground(Color.red);
        }if(cbgenero.getSelectedItem()==null || cbgenero.getSelectedItem().equals("Opcion")){
            cbgenero.setBorder(bordeRojo);
            lbgenero.setForeground(Color.red);
        }
         JOptionPane.showMessageDialog(null, "llene todos los campos");
           cbgenero.setBorder(bordePersonalizado);
           lbgenero.setForeground(new Color(0, 153, 255));  
           txtnombre.setBorder(bordePersonalizado);
           lbnombre.setForeground(new Color(0, 153, 255));
           txtuser.setBorder(bordePersonalizado);
           lbuser.setForeground(new Color(0, 153, 255));  
           txtcontra.setBorder(bordePersonalizado);
           lbcontra.setForeground(new Color(0, 153, 255)); 
           txtedad.setBorder(bordePersonalizado);
           lbedad.setForeground(new Color(0, 153, 255)); 
       }else{
           try{
         name=txtnombre.getText();
         user=txtuser.getText();
         contra=new String(txtcontra.getPassword());
         genero = (String) cbgenero.getSelectedItem();
         edadS=txtedad.getText();
        edad=Integer.parseInt(edadS);
        generoselected = genero.charAt(0);
        Date fechaActual = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fechaEntrada = dateFormat.format(fechaActual);
        System.out.println("user"+user+" contra "+contra);
            
            if(!usertwit.Existeuser(user)){
                System.out.println("entra");
                usertwit.agguser(name, generoselected, user, contra, edad,fechaEntrada,true);
                 Foto foto=new Foto(login);
                 foto.setVisible(true);
                 this.setVisible(false);
            }else{
            txtuser.setBorder(bordeRojo);
            lbuser.setForeground(Color.red);
            JOptionPane.showMessageDialog(null, "Ya existe este usuario");
           txtuser.setBorder(bordePersonalizado);
           lbuser.setForeground(new Color(0, 153, 255)); 
        }
      
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Ingrese un numero en la edad");
            txtedad.setText("");
        }catch(IOException e){
             e.printStackTrace();
            System.out.println("Error x2");
        }
      }
    }//GEN-LAST:event_btsiguienteActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        IniciarSesion sesion=new IniciarSesion(login);
        sesion.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel5MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btsiguiente;
    private javax.swing.JComboBox<String> cbgenero;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbcontra;
    private javax.swing.JLabel lbedad;
    private javax.swing.JLabel lbgenero;
    private javax.swing.JLabel lbnombre;
    private javax.swing.JLabel lbuser;
    private javax.swing.JPasswordField txtcontra;
    private javax.swing.JTextField txtedad;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables
}
