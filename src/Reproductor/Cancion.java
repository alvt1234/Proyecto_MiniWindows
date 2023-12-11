/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reproductor;

/**
 *
 * @author danie
 */
public class Cancion {
    
    public class Song {
    private String nombreArtista;
    private String nombreCancion;
    private String nombreAlbum;
    private String duracion;
    private String imagenPath;
    
    public Song(String nombreArtista, String nombreCancion, String nombreAlbum, String duracion, String imagenPath) {
        this.nombreArtista = nombreArtista;
        this.nombreCancion = nombreCancion;
        this.nombreAlbum = nombreAlbum;
        this.duracion = duracion;
        this.imagenPath = imagenPath;
    }
    
}
}
