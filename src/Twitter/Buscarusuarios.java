package Twitter;



import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;



/**
 *
 * @author villa
 */
public class Buscarusuarios {
 private UsersTwit users;
 private static String seguidos="Seguir",nombreselected;
 private RandomAccessFile siguiendo,seguidores,cantseguidores,cantsiguiendo,follows,tweets;
 //constructor
    public Buscarusuarios(UsersTwit users) {
        this.users = users;
        try{
        siguiendo=new RandomAccessFile("Usertwit/" + users.getUserlog() + "/following.twc", "rw");
        if(nombreselected!=null){
        cantseguidores=new RandomAccessFile("Usertwit/"+nombreselected+"/cantseguidores.xd", "rw");
        cantsiguiendo=new RandomAccessFile("Usertwit/"+users.getUserlog()+"/cantsiguiendo.xd", "rw");
        follows=new RandomAccessFile("Usertwit/"+nombreselected+"/cantsiguiendo.xd", "rw");
        seguidores=new RandomAccessFile("Usertwit/" + nombreselected + "/followers.twc", "rw");
        initCodeseguidores();
        initCodeseguiendo();
        initCodeseguiendonames();
        cargartwitseg();
        }
        }catch(IOException e){
                System.out.println("No se guardo seguidores");    
        }
    }
 
    //Buscar los usuarios que contienen letra
 public ArrayList<String> buscarUsuarios(String textoBusqueda) throws IOException {
    ArrayList<String> resultados = new ArrayList<>();

    try (RandomAccessFile registro = new RandomAccessFile("Usertwit/user.twc", "rw")) {
        while (registro.getFilePointer() < registro.length()) {
            registro.readUTF();
            registro.readChar();
            String usuario = registro.readUTF();
            registro.readUTF(); 
            registro.readInt();
            registro.readUTF();
            registro.readBoolean();

            if (usuario.contains(textoBusqueda)) {
                resultados.add(usuario);
            }
        }
    }

    return resultados;
}
 //funcion para contar los seguidores 
    private void initCodeseguidores() throws IOException {
        if (cantseguidores.length() == 0) {
            cantseguidores.writeInt(0);
        }
    }
    private int getCodeseguidores() throws IOException {
    
        cantseguidores.seek(0);
        int code = cantseguidores.readInt();//1
        cantseguidores.seek(0);
        cantseguidores.writeInt(code + 1);
        return code;
    }
    //contar los siguiendo
    private void initCodeseguiendo() throws IOException {
        if (cantsiguiendo.length() == 0) {
            cantsiguiendo.writeInt(0);
        }
    }
    private int getCodesiguiendo() throws IOException {
     
        cantsiguiendo.seek(0);
        int code = cantsiguiendo.readInt();//1
        cantsiguiendo.seek(0);
        cantsiguiendo.writeInt(code + 1);
        return code;
    }
    //siguiendo demas
     private void initCodeseguiendonames() throws IOException {
        if (follows.length() == 0) {
            follows.writeInt(0);
        }
    }
    private int getCodesiguiendonames() throws IOException {
     
        follows.seek(0);
        int code = follows.readInt();//1
        follows.seek(0);
        follows.writeInt(code + 1);
        return code;
    }
    public void writesiguiendonames(String name)throws IOException{
        if(name.equals(nombreselected)){
            int cant=getCodesiguiendonames();
            System.out.println("cant en write: "+cant);
            cantsiguiendo.writeInt(cant);
        }
    }
    public int getsiguiendonames() throws IOException{
         follows.seek(0);
         while(follows.getFilePointer()<follows.length()){
         int cantSiguiendo= follows.readInt();
         return cantSiguiendo;
        }  
        
        return 0; 
    }
    
    //Guardar a las personas que sigo
    public void guardarsiguiendo(String user,String texto)throws IOException{
        
        //siguiendo   
           siguiendo.seek(siguiendo.length());
           int cantsiguiendos=getCodesiguiendo();
           siguiendo.writeInt(cantsiguiendos);
           siguiendo.writeUTF(user);
           siguiendo.writeUTF(texto);
       //seguidores otra persona 
           seguidores.seek(seguidores.length());
           int cantseguidore=getCodeseguidores();
           seguidores.writeInt(cantseguidore);
           seguidores.writeUTF(users.getUserlog());
    }
    //obtener el numero de seguidos(NO FUNCIONA)
    public int getsiguiendo() throws IOException{
    cantsiguiendo.seek(0);
    while(cantsiguiendo.getFilePointer()<cantsiguiendo.length()){
    int cantSiguiendo= cantsiguiendo.readInt();
     return cantSiguiendo;
    }
    return 0;
    }
    //numero de seguidores
    public int getseguidores()throws IOException{
        System.out.println("entra al get seguidores");
        cantseguidores.seek(0);
        while(cantseguidores.getFilePointer()<cantseguidores.length()){
         int cantseguidore= cantseguidores.readInt();
            System.out.println("cantseguidores: "+cantseguidore);
             return cantseguidore;
        }
        return 0;
    }
    //Para que se guarde el texto del boton (aveces funciona)
   public boolean textoboton(String nombr) throws IOException {
    siguiendo.seek(0);

    while (siguiendo.getFilePointer() < siguiendo.length()) {
        siguiendo.readInt();
        String name = siguiendo.readUTF();
        String text = siguiendo.readUTF();
        if (nombr.equals(name) && text.equals("Siguiendo")) {
            return true;
        }

        System.out.println("name: "+name+ " nombre "+ nombr +"text: "+text);
        
    }
    
    return false;
}

   //para disminuir los seguidores
     public void dejarDeSeguir(String usuario, String seguidor) {
        try {
            decrementarSeguidor("Usertwit/" + usuario + "/cantsiguiendo.xd");
            decrementarSeguidor("Usertwit/" + seguidor + "/cantseguidores.xd");
            eliminarEntrada("Usertwit/" + usuario + "/following.twc", seguidor);
            
            eliminarEntrada("Usertwit/" + seguidor + "/followers.twc", usuario);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     
    private void decrementarSeguidor(String filePath) throws IOException {
        try (RandomAccessFile file = new RandomAccessFile(filePath, "rw")) {
            // Verificar si hay al menos un seguidor
            if (file.length() > 0) {
                // Leer la cantidad actual de seguidores
                int cantidadSeguidores = file.readInt();

                // Verificar si la cantidad es mayor a cero antes de decrementar
                if (cantidadSeguidores > 0) {
                    cantidadSeguidores--;

                    // Regresar al inicio del archivo para sobrescribir la cantidad de seguidores
                    file.seek(0);
                    file.writeInt(cantidadSeguidores);
                }
            }
        }
    }
     private void eliminarEntrada(String filePath, String target) throws IOException {
        try (RandomAccessFile file = new RandomAccessFile(filePath, "rw")) {
            ArrayList<String> lines = new ArrayList<>();

            while (file.getFilePointer() < file.length()) {
                int codigo = file.readInt();
                String nombre = file.readUTF();
                String texto = "";
                
                // Solo en following.twc hay un campo de texto adicional
                if (filePath.contains("following.twc")) {
                    texto = file.readUTF();
                }

                if (target.equals(nombre)) {
                    continue;
                }

                lines.add(codigo + " " + nombre + " " + texto);
            }

            file.seek(0);
            file.setLength(0);

            for (String line : lines) {
                String[] parts = line.split(" ");
                file.writeInt(Integer.parseInt(parts[0]));
                file.writeUTF(parts[1]);

                // Solo en following.twc hay un campo de texto adicional
                if (filePath.contains("following.twc")) {
                    file.writeUTF(parts[2]);
                }
            }
        }
     }
        
    //leer el tweet de las personas
  public ArrayList<String[]> Twitspersonas(String user) throws IOException {
    ArrayList<String[]> mensajes = new ArrayList<>();
    tweets = new RandomAccessFile("Usertwit/" + user + "/twits.twc", "rw");
    tweets.seek(0);

    while (tweets.getFilePointer() < tweets.length()) {
        String[] temp = new String[3];
        temp[0] = tweets.readUTF(); // usuario
        temp[1] = tweets.readUTF(); // texto
        temp[2] = tweets.readLong() + "";
        
        if (temp[0].equals(user)) {
            mensajes.add(temp);
        }
    }

    return mensajes.isEmpty() ? null : mensajes;
}
  
//metodo para cargar los tweets
public ArrayList<String[]> cargarTwits(String user) throws IOException {
    ArrayList<String[]> twts = new ArrayList<>();

    // Carga los propios twits
    if (Twitspersonas(user) != null) {
        twts.addAll(Twitspersonas(user));
    }

    return twts;
}
     public ArrayList cargartwitseg() throws IOException{
         
         ArrayList<String> followers=new ArrayList<>();
         siguiendo.seek(0);
         while(siguiendo.getFilePointer()<siguiendo.length()){
             siguiendo.readInt();
             String names=siguiendo.readUTF();
             siguiendo.readUTF();
              followers.add(names);
              System.out.println("Seguidores en cargartitseg: "+followers);
         }
         return followers;
     }

    public String getSeguidos() {
        return seguidos;
    }

    public void setSeguidos(String seguidos) {
        Buscarusuarios.seguidos = seguidos;
    }

    public String getNombreselected() {
        return nombreselected;
    }

    public void setNombreselected(String nombreselected) {
        Buscarusuarios.nombreselected = nombreselected;
    }
    
 public ArrayList<String> buscarmenciones(String mencion)throws IOException{
     ArrayList<String> menciones=new ArrayList<>();
     try (RandomAccessFile registro = new RandomAccessFile("Usertwit/user.twc", "rw")) {
        while (registro.getFilePointer() < registro.length()) {
            registro.readUTF();
            registro.readChar();
            String usuario = registro.readUTF();
            registro.readUTF(); 
            registro.readInt();
            registro.readUTF();
            registro.readBoolean();

            System.out.println("antes del if de buscar");
            if (mencion.contains("@"+usuario)) {
                menciones.add("@"+usuario);
                System.out.println("menciones: "+menciones);
            }
        }
     }
     return menciones;
 }public ArrayList<String[]> Twitspersonasmencion(String user) throws IOException {
    ArrayList<String[]> mensajes = new ArrayList<>();
    tweets = new RandomAccessFile("Usertwit/" + user + "/twits.twc", "rw");
    tweets.seek(0);

    while (tweets.getFilePointer() < tweets.length()) {
        String[] temp = new String[3];
        temp[0] = tweets.readUTF(); // usuario
        temp[1] = tweets.readUTF(); // texto
        temp[2] = tweets.readLong() + "";

        if (temp[1].contains("@" + users.getUserlog())) {
            mensajes.add(temp);
        }
    }

    return mensajes.isEmpty() ? null : mensajes;
}

public ArrayList<String[]> cargarTwitsmencion(String user) throws IOException {
    ArrayList<String[]> twts = new ArrayList<>();

    if (Twitspersonasmencion(user) != null ) {
        twts.addAll(Twitspersonasmencion(user));
    }

    return twts;
}

public ArrayList<String> buscarUsers() throws IOException {
    ArrayList<String> users = new ArrayList<>();

    try (RandomAccessFile registro = new RandomAccessFile("Usertwit/user.twc", "rw")) {
        while (registro.getFilePointer() < registro.length()) {
            registro.readUTF();
            registro.readChar();
            String usuario = registro.readUTF();
            registro.readUTF(); 
            registro.readInt();
            registro.readUTF();
            registro.readBoolean();
            if(usuario!=null)
              users.add(usuario);
            
        }
    }

    return users;
}
 

}
