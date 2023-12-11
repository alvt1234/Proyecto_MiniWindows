
import java.io.IOException;
import javax.swing.ImageIcon;



/**
 *
 * @author villa
 */
public class Tweets extends javax.swing.JPanel {

    fotoperfil perfil=new fotoperfil(45,5,2,45,45);
    UsersTwit users=new UsersTwit();
    LoginTwitter login=new LoginTwitter();
    Foto foto=new Foto(login);
    private String text;
    public Tweets(String user,String texto,String fecha) {
        initComponents();
        this.text=texto;
        
        
       // ImageIcon fotoIcon = users.obtenerFotoPerfil(user);
      //  perfil.setIcon(fotoIcon);
        panelfondo.add(perfil);
        lbnombre.setText(user);
        areafondo.setText(text);
        lbfecha.setText(fecha);
        try{
        ImageIcon icono = foto.seticon(users.getUserlog(), foto.getRutaImagen(), null,45,45);
        if(icono==null){
        lbfoto.setIcon(icono);
        }if(user.equals(users.getUserlog())){
            lbfoto.setIcon(users.cargarFotoPerfil(users.getUserlog(),45,45));
        }else{
             lbfoto.setIcon(users.cargarFotoPerfil(user,45,45));
        }
        }catch(IOException e){
            System.out.println("No se pudo cargar la fot");
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelfondo = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        lbnombre = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areafondo = new javax.swing.JTextArea();
        lbfecha = new javax.swing.JLabel();
        lbfoto = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(684, 180));

        javax.swing.GroupLayout panelfondoLayout = new javax.swing.GroupLayout(panelfondo);
        panelfondo.setLayout(panelfondoLayout);
        panelfondoLayout.setHorizontalGroup(
            panelfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelfondoLayout.setVerticalGroup(
            panelfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));

        lbnombre.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbnombre.setText("NAME PERSON");

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        areafondo.setEditable(false);
        areafondo.setBackground(new java.awt.Color(255, 255, 255));
        areafondo.setColumns(20);
        areafondo.setLineWrap(true);
        areafondo.setRows(5);
        areafondo.setAutoscrolls(false);
        areafondo.setBorder(null);
        areafondo.setFocusable(false);
        areafondo.setMargin(new java.awt.Insets(10, 10, 10, 10));
        areafondo.setSelectionEnd(218);
        areafondo.setSelectionStart(218);
        jScrollPane1.setViewportView(areafondo);

        lbfecha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbfecha.setForeground(new java.awt.Color(0, 153, 255));
        lbfecha.setText("Fecha");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lbnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(lbfecha)))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areafondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbfecha;
    private javax.swing.JLabel lbfoto;
    private javax.swing.JLabel lbnombre;
    private javax.swing.JPanel panelfondo;
    // End of variables declaration//GEN-END:variables
}
