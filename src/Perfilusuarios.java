
import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;


/**
 *
 * @author villa
 */
public class Perfilusuarios extends javax.swing.JPanel {

    
    private String name,use,fec,estado="Seguir";
    private char ge;
    private int age,contar=0;
    private RandomAccessFile siguiendo,seguidores,tweets;
    
    LoginTwitter login=new LoginTwitter();
    Foto foto=new Foto(login);
    UsersTwit users=new UsersTwit();
     private ArrayList<String[]> twits;
    Buscarusuarios buscar=new Buscarusuarios(users);
    LogicaTwitter logica= new LogicaTwitter();
    public Perfilusuarios(String nombre,char genero,int edad,String userseleccionado,String fecha) {
        initComponents();
        this.name=nombre;
        this.ge=genero;
        this.age=edad;
        this.use=userseleccionado;
        this.fec=fecha;
       
        lbuserlog.setText(users.getUserlog());
        lbname.setText(name);
        lbfecha.setText("Se unio el "+fec);
        lbusuariob.setText("@"+use);
        lbgenero.setText(String.valueOf("Genero: "+ge));
        lbedad.setText(age+" años");
        
        try{
            tweets = new RandomAccessFile("Usertwit/" + use + "/twits.twc", "rw");
            subirtweets(use);
            lbsiguiendo.setText(buscar.getsiguiendonames()+" Siguiendo");
            lbseguidores.setText(buscar.getseguidores()+" Seguidores");
            System.out.println("Texto boton en perfil: "+buscar.textoboton(userseleccionado));
            ImageIcon icono = foto.seticon(use, foto.getRutaImagen(), null,160,160);
        if(icono==null){
        lbfoto.setIcon(icono);
        }else{
            lbfoto.setIcon(users.cargarFotoPerfil(use,145,145));
        }
        if(buscar.textoboton(userseleccionado)){
            contar++;
          btseguir.setText("Siguiendo");
        }else{
          btseguir.setText("Seguir");
        }
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("no lee los archivos");
        
        }
        
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbedad = new javax.swing.JLabel();
        lbuserlog = new javax.swing.JLabel();
        lbfoto = new javax.swing.JLabel();
        lbname2 = new javax.swing.JLabel();
        lbseguidores = new javax.swing.JLabel();
        lbname = new javax.swing.JLabel();
        lbsiguiendo = new javax.swing.JLabel();
        btseguir = new javax.swing.JButton();
        lbusuariob = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        scrolltweets = new javax.swing.JScrollPane();
        paneltweets = new javax.swing.JPanel();
        lbfecha = new javax.swing.JLabel();
        lbgenero = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbedad.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbedad.setForeground(new java.awt.Color(102, 102, 102));
        lbedad.setText("Edad");
        jPanel1.add(lbedad, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 160, 30));

        lbuserlog.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lbuserlog.setText("Userlog");
        jPanel1.add(lbuserlog, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        lbfoto.setText("Foto");
        jPanel1.add(lbfoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 150, 150));

        lbname2.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lbname2.setText("Tweets");
        jPanel1.add(lbname2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 180, 30));

        lbseguidores.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbseguidores.setText("0 Seguidores");
        jPanel1.add(lbseguidores, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 130, 30));

        lbname.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbname.setText("Nombre");
        jPanel1.add(lbname, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 160, 30));

        lbsiguiendo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbsiguiendo.setText("0 Siguiendo");
        jPanel1.add(lbsiguiendo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 80, 30));

        btseguir.setBackground(new java.awt.Color(153, 204, 255));
        btseguir.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btseguir.setText("Seguir");
        btseguir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btseguirActionPerformed(evt);
            }
        });
        jPanel1.add(btseguir, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 240, 130, 40));

        lbusuariob.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lbusuariob.setText("Usuario");
        jPanel1.add(lbusuariob, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 180, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 680, 10));

        scrolltweets.setBorder(null);
        scrolltweets.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        paneltweets.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout paneltweetsLayout = new javax.swing.GroupLayout(paneltweets);
        paneltweets.setLayout(paneltweetsLayout);
        paneltweetsLayout.setHorizontalGroup(
            paneltweetsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );
        paneltweetsLayout.setVerticalGroup(
            paneltweetsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );

        scrolltweets.setViewportView(paneltweets);

        jPanel1.add(scrolltweets, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 680, 530));

        lbfecha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbfecha.setForeground(new java.awt.Color(102, 102, 102));
        lbfecha.setText("Fecha en que se unio");
        jPanel1.add(lbfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 160, 30));

        lbgenero.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbgenero.setForeground(new java.awt.Color(102, 102, 102));
        lbgenero.setText("genero");
        jPanel1.add(lbgenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 160, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btseguirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btseguirActionPerformed
        contar++;
        
        try{
            if(contar==1){
            estado="Siguiendo";
             btseguir.setText("Siguiendo");
            buscar.guardarsiguiendo(use,estado);
            lbseguidores.setText(buscar.getseguidores()+" Seguidores");
            }else if(contar==2){
            int opcion=JOptionPane.showInternalConfirmDialog(null, "Esta seguro que desea dejar de seguir\n a este usuario?");
            if (opcion == JOptionPane.YES_OPTION) {
            contar=0;
            estado ="Seguir";
            btseguir.setText("Seguir");
            buscar.dejarDeSeguir(users.getUserlog(), use);
            lbseguidores.setText(buscar.getseguidores()+" Seguidores");
        } else if (opcion == JOptionPane.NO_OPTION || opcion == JOptionPane.CANCEL_OPTION || opcion == JOptionPane.CLOSED_OPTION) {
            contar=1;
        } 
        }
        
        }catch(IOException e){
            
        }
    }//GEN-LAST:event_btseguirActionPerformed

    private void subirtweets(String user) throws IOException{
     paneltweets.removeAll();
    paneltweets.setLayout(new BoxLayout(paneltweets, BoxLayout.Y_AXIS));
    
    twits = buscar.cargarTwits(user);

    if (!twits.isEmpty()) {
        // Iterar en orden inverso para agregar los nuevos tweets al principio
        for (int i = twits.size() - 1; i >= 0; i--) {
            String[] tweet = twits.get(i);
            String usuario = tweet[0];
            String texto = tweet[1];
            String fecha = tweet[2];

            long tiempoEnMilisegundos = Long.parseLong(fecha);
            Date fechadate = new Date(tiempoEnMilisegundos);
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            String fechaFormateada = formatoFecha.format(fechadate);
            System.out.println("subir tweets: user:"+user+" usuario: "+usuario);
            if(user.equals(usuario)){
            Tweets twee = new Tweets(usuario, texto, fechaFormateada);
            paneltweets.add(twee);
            }
            
        }

        paneltweets.revalidate();
        paneltweets.repaint();
        scrolltweets.revalidate();
        scrolltweets.repaint();

        // Mover la barra de desplazamiento al final
        JScrollBar barra = scrolltweets.getVerticalScrollBar();
        barra.setValue(barra.getMaximum());
    }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btseguir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbedad;
    private javax.swing.JLabel lbfecha;
    private javax.swing.JLabel lbfoto;
    private javax.swing.JLabel lbgenero;
    private javax.swing.JLabel lbname;
    private javax.swing.JLabel lbname2;
    private javax.swing.JLabel lbseguidores;
    private javax.swing.JLabel lbsiguiendo;
    private javax.swing.JLabel lbuserlog;
    private javax.swing.JLabel lbusuariob;
    private javax.swing.JPanel paneltweets;
    private javax.swing.JScrollPane scrolltweets;
    // End of variables declaration//GEN-END:variables
}
