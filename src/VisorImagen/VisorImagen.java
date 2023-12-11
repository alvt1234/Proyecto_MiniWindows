package VisorImagen;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.InternalFrameAdapter;
import windows.Login;
import windows.crearUser;
import windows.os;

public class VisorImagen extends JInternalFrame {
    private List<String> imagePaths;
    private int currentIndex;
    private JLabel mainImageLabel;
    private JLabel previousImageLabel;
    private JLabel nextImageLabel;
    public String user=Login.username;
    crearUser u= new crearUser();

    public VisorImagen(String selectedImagePath) {
        imagePaths = new ArrayList<>();
        currentIndex = 0;
        this.setClosable(true);
        this.closable=true;
        addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                os.imagesisopen=false;
                
            }
        });

        setTitle("Visor de Imágenes");
        setSize(800, 600);
      
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(30, 30, 30)); // Fondo gris oscuro

        JLabel titleLabel = new JLabel("Visor de Imágenes", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(new Color(255, 255, 255)); // Color del título blanco
        add(titleLabel, BorderLayout.NORTH);

        mainImageLabel = new JLabel();
        previousImageLabel = new JLabel();
        nextImageLabel = new JLabel();

        updateImages();

        JButton prevButton = new JButton("Anterior");
        JButton nextButton = new JButton("Siguiente");

        JButton selectFolderButton = new JButton("Seleccionar Carpeta");
        selectFolderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccionarCarpeta();
            }
        });

        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                anteriorImagen();
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                siguienteImagen();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(selectFolderButton);

        JPanel imagePanel = new JPanel(new BorderLayout());
        imagePanel.setBackground(new Color(30, 30, 30)); // Fondo gris oscuro
        imagePanel.add(previousImageLabel, BorderLayout.WEST);
        imagePanel.add(mainImageLabel, BorderLayout.CENTER);
        imagePanel.add(nextImageLabel, BorderLayout.EAST);

        add(imagePanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        if(!selectedImagePath.isBlank()){
            mainImageLabel.setSize(780,480);
            int mainImageWidth = mainImageLabel.getWidth();
            int mainImageHeight = mainImageLabel.getHeight();
            ImageIcon currentIcon = new ImageIcon(selectedImagePath);
            ImageIcon newIcon= scaleImage(currentIcon, mainImageWidth, mainImageHeight);
            
            
            previousImageLabel.setIcon(null);
            nextImageLabel.setIcon(null);
            mainImageLabel.setIcon(newIcon);
         
        
        }
    }
 private static class CarpetaVaciaException extends RuntimeException {
        public CarpetaVaciaException(String message) {
            super(message);
        }
    }

    private void seleccionarCarpeta() {
         File file= u.searchDir(user,"Z/usuarios");
        String initialDirPath=file.getPath();
        JFileChooser chooser = new JFileChooser(initialDirPath);
        chooser.setDialogTitle("Seleccionar Carpeta de Imagenes");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            String folderPath = chooser.getSelectedFile().getAbsolutePath();
            imagePaths = loadImages(folderPath);

            if (imagePaths.isEmpty()) {
                throw new CarpetaVaciaException("La carpeta no contiene imágenes.");
            }

            currentIndex = 0;
            updateImages();
        }
    }

    private List<String> loadImages(String folderPath) {
        List<String> paths = new ArrayList<>();
        File folder = new File(folderPath);

        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && isImageFile(file.getName())) {
                        paths.add(file.getAbsolutePath());
                    }
                }
            }
        }

        return paths;
    }

    private boolean isImageFile(String fileName) {
        String[] allowedExtensions = {".jpg", ".jpeg", ".png", ".gif", ".bmp"};
        for (String extension : allowedExtensions) {
            if (fileName.toLowerCase().endsWith(extension)) {
                return true;
            }
        }
        return false;
    }

   private void updateImages() {
    if (!imagePaths.isEmpty() && currentIndex >= 0 && currentIndex < imagePaths.size()) {
        String currentImagePath = imagePaths.get(currentIndex);

        // Obtener las dimensiones del contenedor principal
        int mainImageWidth = mainImageLabel.getWidth();
        int mainImageHeight = mainImageLabel.getHeight();

        // Escalar la imagen principal proporcionalmente
        ImageIcon currentIcon = new ImageIcon(currentImagePath);
        mainImageLabel.setIcon(scaleImage(currentIcon, mainImageWidth, mainImageHeight));

        // Miniatura anterior
        int previousIndex = (currentIndex - 1 + imagePaths.size()) % imagePaths.size();
        ImageIcon previousIcon = new ImageIcon(imagePaths.get(previousIndex));
        previousImageLabel.setIcon(scaleImage(previousIcon, 100, 100));

        // Miniatura siguiente
        int nextIndex = (currentIndex + 1) % imagePaths.size();
        ImageIcon nextIcon = new ImageIcon(imagePaths.get(nextIndex));
        nextImageLabel.setIcon(scaleImage(nextIcon, 100, 100));
    } else {
        mainImageLabel.setIcon(null);
        previousImageLabel.setIcon(null);
        nextImageLabel.setIcon(null);
    }
}

    private void anteriorImagen() {
        if (!imagePaths.isEmpty()) {
            currentIndex = (currentIndex - 1 + imagePaths.size()) % imagePaths.size();
            updateImages();
        }
    }

    private void siguienteImagen() {
        if (!imagePaths.isEmpty()) {
            currentIndex = (currentIndex + 1) % imagePaths.size();
            updateImages();
        }
    }

    private ImageIcon scaleImage(ImageIcon icon, int width, int height) {
        if (width <= 0 || height <= 0) {
            // Evitar dimensiones no válidas
            return icon;
        }
        

        Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }
    
    

    
}