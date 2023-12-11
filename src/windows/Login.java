
package windows;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Random;
import javax.swing.DefaultListModel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class Login extends javax.swing.JFrame {
public static String background;
public DefaultListModel listmodel= new DefaultListModel();
public crearUser user= new crearUser();;
public static String username="Admin";
   int anchoPantalla,altoPantalla ;
    public Login() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        
        JMenuItem[] items= new JMenuItem[10];
       
        
        user.createUser("Admin", "admin123");
        if(user.userList()!=null){
            String list=user.userList();
        String [] elements= list.split("\n");
        for(int i=0;i<elements.length;i++){
            items[i]=new JMenuItem(elements[i]);
            final int n=i;
            items[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    jLabel5.setText(items[n].getText());
                    lbnombre.setText(items[n].getText());
                }
            });
            jPopupMenu1.add(items[i]);
        }
        }
        
       String[] background= new String[3];
        Random rand = new Random();
        background[0]="bg2";
        background[1]="bg2";
        background[2]="bg2";
        this.background=background[rand.nextInt(3)];
//        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/"+this.background+".jpg")));
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jLabel2 = new javax.swing.JLabel();
        txtcontra = new javax.swing.JPasswordField();
        lbnombre = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        checkmostrar = new javax.swing.JCheckBox();
        lbfoto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\villa\\Downloads\\Miniwindows-master\\Miniwindows-master\\src\\images\\usericon.png")); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 160, 210, 140));

        txtcontra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcontraKeyPressed(evt);
            }
        });
        getContentPane().add(txtcontra, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 330, 180, 30));

        lbnombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbnombre.setText("Admin");
        getContentPane().add(lbnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 290, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("Password:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 340, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Admin");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 140, -1));

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\villa\\Downloads\\Miniwindows-master\\Miniwindows-master\\src\\images\\user.png")); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 50));

        checkmostrar.setText("Mostrar");
        checkmostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkmostrarActionPerformed(evt);
            }
        });
        getContentPane().add(checkmostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 360, -1, -1));

        lbfoto.setIcon(new javax.swing.ImageIcon("C:\\Users\\villa\\Downloads\\Miniwindows-master\\Miniwindows-master\\src\\images\\bg2.jpg")); // NOI18N
        lbfoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbfotoMouseClicked(evt);
            }
        });
        getContentPane().add(lbfoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtcontraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcontraKeyPressed
        
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            try{
                String nombre=lbnombre.getText();
                user.setUserlog(nombre);
               String password= user.getuserPassword(nombre);
               String contra=new String(txtcontra.getPassword());
                System.out.println("password: "+password+" contra "+contra);
                if(password.equals(contra)){
                os OS= new os();
                OS.setVisible(true);
                dispose();}
           else JOptionPane.showMessageDialog(null, "Esta clave es incorrecta para este usuario");
            }catch(IOException e){
                e.printStackTrace();
            }
          
        }
    }//GEN-LAST:event_txtcontraKeyPressed

    private void lbfotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbfotoMouseClicked
        
    }//GEN-LAST:event_lbfotoMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        jPopupMenu1.show(evt.getComponent(),evt.getX() , evt.getY());
        jPopupMenu1.setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked

    private void checkmostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkmostrarActionPerformed
        if(checkmostrar.isSelected()){
            txtcontra.setEchoChar((char)0);
        }else
            txtcontra.setEchoChar('*');
    }//GEN-LAST:event_checkmostrarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkmostrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JLabel lbfoto;
    private javax.swing.JLabel lbnombre;
    private javax.swing.JPasswordField txtcontra;
    // End of variables declaration//GEN-END:variables
}
