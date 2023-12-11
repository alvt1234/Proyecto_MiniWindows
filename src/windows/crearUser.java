/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package windows;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author ferna
 */
public class crearUser {
   
    private static File ROOT_DIRECTORY;
    public RandomAccessFile r_users;
    private static String userlog;
    public crearUser() {
    try{    
    ROOT_DIRECTORY = new File("Z");
    ROOT_DIRECTORY.mkdir();
    r_users= new RandomAccessFile("Z/r_users.ur","rw");
    }catch(IOException e){
        e.printStackTrace();
    }

   
}

    public String getUserlog() {
        return userlog;
    }

    public void setUserlog(String userlog) {
        crearUser.userlog = userlog;
    }
   

public void createUser(String name,String password){
    
    String[] info= new String[3];
    info[0]="Mis Documentos";
    info[1]="Mis Imagenes";
    info[2]="Musica";
    
    
    if(checkUniqueUser(name,password)){
        try{
         r_users.seek(r_users.length());
         r_users.writeUTF(name);
         r_users.writeUTF(password);
     }catch(IOException e){
         e.printStackTrace();
     }
    for(int i=0;i<info.length;i++){
     File file= new File(ROOT_DIRECTORY.getPath()+"/usuarios/"+name+"/"+info[i]);
     if(!file.exists()){
        file.mkdirs();
     
     }}
    
    
    }
    
}
public boolean checkUniqueUser(String username, String password){
    if(searchDir(username,"Z/usuarios")==null){
       
       return true;
       }
    return false;
}
public String userList() {
    String userList = "";
    File usuariosDir = searchDir("usuarios", ROOT_DIRECTORY.getPath());

    if (usuariosDir != null && usuariosDir.exists()) {
        File[] users = usuariosDir.listFiles();
        if (users != null) {
            for (File user : users) {
                userList += user.getName() + "\n";
            }
        }
    }

    return userList;
}


public static File searchDir(String nombre, String path) {
        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    if (f.getName().equals(nombre)) {
                        return f;
                    } else if (f.isDirectory()) {
                        // Recursive call and return the result
                        File result = searchDir(nombre, f.getPath());
                        if (result != null) {
                            return result; // Return the result if found in the subdirectory
                        }
                    }
                }
            }
        }
        return null;
    }
public String getuserPassword(String user)throws IOException{
    try {
        r_users.seek(0);
        while (r_users.getFilePointer()<r_users.length()) {
            String username = r_users.readUTF();
            String password = r_users.readUTF();
            System.out.println(password);
            if (username.equals(user)) {
                System.out.println("entra al if");
                return password;
            }
        }
    } catch (EOFException e) {
        System.out.println("No ve la contra");
       
    }
     return null;
}
    
}
    
    
    

