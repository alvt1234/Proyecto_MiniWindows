
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Foto extends javax.swing.JFrame {

    byte[] image;
    static String imagepath = "",rutaImagen;
    ImageIcon myimage;
    UsersTwit usertwit=new UsersTwit();
    private LoginTwitter login;
    //private LogicaTwitter logica = new LogicaTwitter();

    CrearCuenta cuenta=new CrearCuenta(login);
    public Foto(LoginTwitter login) {

        initComponents();
        this.setLocationRelativeTo(null);
        this.login = login;
    }
       public ImageIcon seticon(String user, String m, byte[] image, int width, int height) {
    if (m != null) {
        myimage = new ImageIcon(m);
    } else {
        myimage = new ImageIcon(getClass().getResource("/imagentwitter/usuario.jpg"));
    }
    
    Image img = myimage.getImage();
    img = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    ImageIcon scaledIcon = new ImageIcon(img);

    return scaledIcon;
}

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbimage = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btomitir = new javax.swing.JButton();
        btagregar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbimage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagentwitter/usuario.jpg"))); // NOI18N
        jPanel2.add(lbimage, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 30)); // NOI18N
        jLabel2.setText("Agregar foto");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, 52));

        btomitir.setBackground(new java.awt.Color(0, 153, 255));
        btomitir.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        btomitir.setForeground(new java.awt.Color(255, 255, 255));
        btomitir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btomitir.setBorderPainted(false);
        btomitir.setContentAreaFilled(false);
        btomitir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btomitirActionPerformed(evt);
            }
        });
        jPanel2.add(btomitir, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 390, 120, 30));

        btagregar.setBackground(new java.awt.Color(0, 153, 255));
        btagregar.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        btagregar.setForeground(new java.awt.Color(255, 255, 255));
        btagregar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btagregar.setBorderPainted(false);
        btagregar.setContentAreaFilled(false);
        btagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btagregarActionPerformed(evt);
            }
        });
        jPanel2.add(btagregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 100, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagentwitter/Agregar.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btomitirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btomitirActionPerformed
        MenuTwitter menu = new MenuTwitter();
        menu.setVisible(true);
        login.dispose();
        dispose();
    }//GEN-LAST:event_btomitirActionPerformed

    private void btagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btagregarActionPerformed
         try {
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.dir")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("All Pic", "png", "jpg", "jpeg", "gif");
        file.addChoosableFileFilter(filter);
        int a = file.showSaveDialog(null);

        if (a == JFileChooser.APPROVE_OPTION) {
            File f = file.getSelectedFile();
            rutaImagen = f.getAbsolutePath();

            // Obtener la instancia de UsuarioTwitter (asegúrate de haber inicializado usertwit correctamente)

            // Guardar la foto de perfil
            usertwit.guardarFotoPerfil(rutaImagen);

            // Mostrar la imagen en el JLabel
            lbimage.setIcon(seticon(usertwit.getUserlog(),rutaImagen, null,250,250));
        }
    } catch (IOException e) {
        System.out.println("Error al cargar la imagen");
    }
    }//GEN-LAST:event_btagregarActionPerformed

    public String getRutaImagen() {
        return rutaImagen;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btagregar;
    private javax.swing.JButton btomitir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbimage;
    // End of variables declaration//GEN-END:variables
}
