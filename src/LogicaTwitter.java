
import java.awt.Image;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

public class LogicaTwitter {

    UsersTwit user=new UsersTwit();
    ArrayList<String[]> cargartwits=new ArrayList<>();
    private RandomAccessFile tweets,fotoarchivo;
    private Image fotoperfil;
    public LogicaTwitter(){
        try {
            tweets = new RandomAccessFile("Usertwit/" + user.getUserlog() + "/twits.twc", "rw");
            fotoarchivo = new RandomAccessFile("Usertwit/user.twc", "rw");
          //  registro = new RandomAccessFile( "Usertwit/hashtags.txt","rw");
        } catch (IOException e) {
            System.out.println("NO SE ENCONTRO");
        }
    }
   
     public void guardarTwit(String txt) throws IOException {
        tweets.seek(tweets.length());
        Date fechaActual = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    // Formatear la fecha como una cadena
    String fechaString = dateFormat.format(fechaActual);
        try {
            // Convierte la cadena a un objeto Date
            Date fechaDate = dateFormat.parse(fechaString);

            // Obtiene el valor long de la fecha
            long valorLong = fechaDate.getTime();

            // Imprime el valor long
            System.out.println("Valor long de la fecha: " + valorLong);
            tweets.writeUTF(user.getUserlog());
            tweets.writeUTF(txt);
            tweets.writeLong(valorLong);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
   
    public ArrayList<String[]> misTwits() throws IOException {
        ArrayList<String[]> mensajes = new ArrayList<>();
        tweets.seek(0);

        while (tweets.getFilePointer() < tweets.length()) {
            String[] temp = new String[3];
            temp[0] = tweets.readUTF();
            temp[1] = tweets.readUTF();
            temp[2] = tweets.readLong() + "";
            mensajes.add(temp);
        }

        return mensajes;
    }
    public ArrayList<String[]> cargarTwits() throws IOException{
        ArrayList<String[]> twits = new ArrayList<>();

        // Carga los propios twits
        if (misTwits() != null) {
            twits.addAll(misTwits());
        }
       
        return twits;
    }

   public List<String> extraerHashtags(String texto) {
    List<String> hashtags = new ArrayList<>();
    
    if (texto != null) {
        String[] palabras = texto.split("\\s+"); 

        for (String palabra : palabras) {
            if (palabra.startsWith("#")) {
                hashtags.add(palabra); 
                System.out.println("extraerhash: "+hashtags);
            }
        }
    }

    return hashtags;
}

    public void guardarHashtagsEnArchivo(List<String> hashtags) throws IOException {
    List<String> existingHashtags = leerHashtagsDesdeArchivo();

    try (RandomAccessFile registro = new RandomAccessFile("Usertwit/hashtags.txt", "rw")) {
        // Buscar al final del archivo antes de escribir
        registro.seek(registro.length());

        // Agregar nuevos hashtags que no estén en la lista existente
        for (String hashtag : hashtags) {
            if (!existingHashtags.contains(hashtag)) {
                registro.writeUTF(hashtag);
                // Agregar el nuevo hashtag a la lista existente
                existingHashtags.add(hashtag);
            }
        }
    }
}

public ArrayList<String> leerHashtagsDesdeArchivo() throws IOException {
    ArrayList<String> existingHashtags = new ArrayList<>();

    try (RandomAccessFile registro = new RandomAccessFile("Usertwit/hashtags.txt", "rw")) {
        // Buscar al principio del archivo antes de leer
        registro.seek(0);

        while (registro.getFilePointer() < registro.length()) {
            existingHashtags.add(registro.readUTF());
        }
    }

    return existingHashtags;
}

    public ArrayList<String[]> Twitspersonahash(String user, String texto) throws IOException {
    ArrayList<String[]> mensajes = new ArrayList<>();
    HashSet<String> hashtags = new HashSet<>(extraerHashtags(texto));

    tweets = new RandomAccessFile("Usertwit/" + user + "/twits.twc", "rw");
    tweets.seek(0);

    while (tweets.getFilePointer() < tweets.length()) {
        String[] temp = new String[3];
        temp[0] = tweets.readUTF(); // usuario
        temp[1] = tweets.readUTF(); // texto
        temp[2] = tweets.readLong() + "";

        // Buscar hashtags en el texto del tweet
        boolean contieneHashtags = false;
        for (String hashtag : hashtags) {
            if (temp[1].contains(hashtag)) {
                contieneHashtags = true;
                break;
            }
        }

        if (contieneHashtags) {
            mensajes.add(temp);
        }
    }

    return mensajes.isEmpty() ? null : mensajes;
}

public ArrayList<String[]> cargarTwitsmencion(String user,String texto) throws IOException {
    ArrayList<String[]> twts = new ArrayList<>();

    if (Twitspersonahash(user,texto) != null && !this.user.desac(user)) {
        twts.addAll(Twitspersonahash(user,texto));
    }

    return twts;
}


}
