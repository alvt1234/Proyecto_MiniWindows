package Twitter;


import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class UsersTwit {
    private RandomAccessFile registro;
    private static String userlog;
    public UsersTwit(){
    try{
    File file=new File("Usertwit");
    file.mkdirs();
    registro=new RandomAccessFile("Usertwit/user.twc","rw");
    }catch(IOException e){
        System.out.println("Erros");
    }
    }
 public boolean Existeuser(String user) throws IOException {
     
        while (registro.getFilePointer() < registro.length()) {
            registro.readUTF();
            registro.readChar();
            String usuario = registro.readUTF();
            registro.readUTF(); 
            registro.readInt();
            registro.readUTF();
            registro.readBoolean();
            //System.out.println("usuario "+usuario+" thisactivo "+activo);
            if (user.equals(usuario)) {
                return true;
            }
        }
    return false;
}

    private String carpetauser(String user){
        return"Usertwit/"+user;
    }
    private void carpetausers(String user) throws IOException{
       File file=new File(carpetauser(user));
        file.mkdirs();
        try{
            new File("Usertwit/" + user + "/following.twc").createNewFile();
            new File("Usertwit/" + user + "/followers.twc").createNewFile();
            new File("Usertwit/" + user + "/twits.twc").createNewFile();
            }catch(IOException e){
            System.out.println("No se pudo crear");
            } 
    }
     public void agguser(String nombre, char genero, String user, String contra, int edad,String fecha,boolean activa) throws IOException {
        if (!Existeuser(user)) {
                registro.seek(registro.length());
                registro.writeUTF(nombre);
                registro.writeChar(genero);
                registro.writeUTF(user);
                registro.writeUTF(contra);
                registro.writeInt(edad);
                registro.writeUTF(fecha);
                registro.writeBoolean(activa);
                carpetausers(user);
                System.out.println("agg user");
                userlog=user;
        }
    }
     
     public boolean iniciosesion(String user, String contra) throws IOException{
         while(registro.getFilePointer() < registro.length()){
            registro.readUTF();
            registro.readChar();
            String usuario=registro.readUTF();
            String password=registro.readUTF();
            registro.readInt();
            registro.readUTF();
            boolean activa=registro.readBoolean();
             System.out.println("usuario: "+usuario+"activa: "+activa);
            if(user.equals(usuario.trim()) && contra.equals(password.trim())){
                   userlog=user;
                   return true;
               
            } 
            
                 
         }
           JOptionPane.showMessageDialog(null, "Usuario inexistente");
         return false;
     }
  
 
    public String getUserlog() {
        return userlog;
    }
    public void desaccuenta() throws IOException {
    RandomAccessFile tempFile = new RandomAccessFile("Usertwit/user.twc", "rw");

    try {
        while (registro.getFilePointer() < registro.length()) {
            String nombre = registro.readUTF();
            char genero = registro.readChar();
            String usuario = registro.readUTF();
            String contra = registro.readUTF();
            int edad = registro.readInt();
            String fecha = registro.readUTF();
            boolean activa = registro.readBoolean();

            if (userlog.equals(usuario)) {
                tempFile.seek(tempFile.getFilePointer()-1); // Retroceder para sobrescribir el booleano activo
                tempFile.writeBoolean(false); // Desactivar la cuenta
              
                break;
            }

            tempFile.writeUTF(nombre);
            tempFile.writeChar(genero);
            tempFile.writeUTF(usuario);
            tempFile.writeUTF(contra);
            tempFile.writeInt(edad);
            tempFile.writeUTF(fecha);
            tempFile.writeBoolean(activa);
        }
    } finally {
        registro.close(); // Cerrar el archivo original
        tempFile.close(); // Cerrar el archivo temporal
    }
}
public void activarcuenta(String user) throws IOException {
    RandomAccessFile tempFile = new RandomAccessFile("Usertwit/user.twc", "rw");

    try {
        while (registro.getFilePointer() < registro.length()) {
            String nombre = registro.readUTF();
            char genero = registro.readChar();
            String usuario = registro.readUTF();
            String contra = registro.readUTF();
            int edad = registro.readInt();
            String fecha = registro.readUTF();
            boolean activa = registro.readBoolean();

            if (user.equals(usuario)) {
                tempFile.seek(tempFile.getFilePointer()-1); // Retroceder para sobrescribir el booleano activo
                tempFile.writeBoolean(true); // Activar la cuenta
                  JOptionPane.showMessageDialog(null, "Se reactivo su cuenta");
            }

            // Continuar escribiendo los demás datos
            tempFile.writeUTF(nombre);
            tempFile.writeChar(genero);
            tempFile.writeUTF(usuario);
            tempFile.writeUTF(contra);
            tempFile.writeInt(edad);
            tempFile.writeUTF(fecha);
            tempFile.writeBoolean(activa);
        }
    } finally {
        registro.close(); // Cerrar el archivo original
        tempFile.close(); // Cerrar el archivo temporal
    }
}

    public String[] obtenerUsuarios() throws IOException{
        ArrayList<String> usuarios = new ArrayList<>();
        registro.seek(0);

        while (registro.getFilePointer() < registro.length()){
            registro.readUTF(); 
            registro.readChar(); 
            String usuario = registro.readUTF(); 
            registro.readUTF(); 
            registro.readInt(); 
            registro.readUTF(); 
            registro.readBoolean(); 
            if(!usuario.equals(userlog))
            usuarios.add(usuario);
        }
        String[] usuariosArray = new String[usuarios.size()];
        usuariosArray = usuarios.toArray(usuariosArray);
        return usuariosArray;
    }

     public void guardarFotoPerfil(String rutaOrigen) throws IOException {
        String rutaDestino = "Usertwit/" + userlog + "/foto_perfil.png";
        
        Path origenPath = Path.of(rutaOrigen);
        Path destinoPath = Path.of(rutaDestino);

        Files.copy(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
    }
     public ImageIcon cargarFotoPerfil(String user,int ancho,int largo) throws IOException {
     String rutaArchivoFoto = "Usertwit/" + user + "/foto_perfil.png";
        Path pathArchivo = Path.of(rutaArchivoFoto);

        try {
            if (Files.exists(pathArchivo)) {
                BufferedImage img = ImageIO.read(pathArchivo.toFile());
                Image imgRedonda = redondearImagen(img);
                Image scaledImg = imgRedonda.getScaledInstance(ancho, largo, Image.SCALE_SMOOTH);
                return new ImageIcon(scaledImg);
            } else {
                return obtenerImagenPredeterminada(ancho, largo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
         return obtenerImagenPredeterminada(ancho, largo);
}
 private Image redondearImagen(Image img) {
    int ancho = img.getWidth(null);
    int alto = img.getHeight(null);

    if (ancho <= 0 || alto <= 0) {
        // Si las dimensiones son no válidas, devuelve la imagen original sin redondear
        return img;
    }

    int radio = Math.min(ancho, alto) / 2;
    BufferedImage imagenRedonda = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g = imagenRedonda.createGraphics();
    g.setClip(new Ellipse2D.Float(0, 0, ancho, alto));
    g.drawImage(img, 0, 0, null);
    g.dispose();

    return imagenRedonda;
}



   private ImageIcon obtenerImagenPredeterminada(int ancho, int largo) {
    ImageIcon image = new ImageIcon(getClass().getResource("/imagentwitter/usuario.jpg"));
    Image img = image.getImage();
    img = img.getScaledInstance(ancho, largo, Image.SCALE_SMOOTH);
    Image imgRedonda = redondearImagen(img);
    return new ImageIcon(imgRedonda);
}


     
}
