/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to Docs this template
 */
package windows;

import windows.FileOrganizer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import static windows.crearUser.searchDir;

/**
 *
 * @author ferna
 */
public class Docs extends javax.swing.JInternalFrame {
DefaultMutableTreeNode root=root = new DefaultMutableTreeNode(new FileTreeNode(new File("Z")));
DefaultTreeModel treeModel = new DefaultTreeModel(root);
crearUser files= new crearUser();
String path="";
FileTableModel fileTableModel= new FileTableModel(path);
JTable fileTable= new JTable(fileTableModel);
FileOrganizer ordenar;
public String username=Login.username;
String selectedFile;
String rootpath,copiedfilepath, selectedfileToCopy;
boolean copiedFile;
    
    public Docs() {
        initComponents();
        
        JMenuItem open= new JMenuItem("Open File");      
        JMenuItem item= new JMenuItem("Rename");
        JMenuItem item1= new JMenuItem("Copy");
        JMenuItem item2= new JMenuItem("Paste");
        JMenuItem item3= new JMenuItem("Delete");
        JMenuItem item4= new JMenuItem("File");
        JMenuItem item5= new JMenuItem("Directory");
        jPopupMenu2.add(item4);
        jPopupMenu2.add(item5);
        jPopupMenu1.add(item);
        jPopupMenu1.add(item1);
        jPopupMenu1.add(item2);
        jPopupMenu1.add(item3);
        jPopupMenu1.add(open);
        
        open.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                     File file= new File(path+"/"+selectedFile);
                     String fileExtension=getFileExtension(file);
                     switch(fileExtension){
                         case"txt":
                             
                             word w= new word(file.getPath());
                             
                             JDesktopPane bg= os.jDesktopPane1;
                             w.setVisible(true);
                             bg.add(w);
                             dispose();
                             
                             break;
                         case"jpg":
                             
                             break;
                         case"mp3":
                             
                             break;
                         
                     }
                        }
                     
                
            });
        
        item.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(path.equals("Z/usuarios")){
                     JOptionPane.showMessageDialog(null, "El nombre de la carpeta de usuarios solo se puede cambiar en la opcion edit user");
                    }
                else{File oldfile= searchDir(selectedFile,path);
                   String newName= JOptionPane.showInputDialog(fileTable, "Nuevo nombre para el archivo: ");
                    File newFile= new File(oldfile.getParentFile().getPath(),newName);
                    System.out.println(oldfile.renameTo(newFile));
                    String option= jComboBox1.getSelectedItem().toString();
                    updateData(option);
                    if(newFile.isDirectory()){
                        DefaultMutableTreeNode nodetoChange =findNodeByName(root,oldfile.getName());
                    
                        if (nodetoChange != null) {
            // Update the user object (filename) of the node
            nodetoChange.setUserObject(newName);

            // Notify the tree model that the node has changed
            ((DefaultTreeModel) jTree1.getModel()).nodeChanged(nodetoChange);
        }}
                    
                }
                }});
        item1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                     copiedFile=true;
                     copiedfilepath=path+"/"+selectedFile;
                     selectedfileToCopy=selectedFile;
                     System.out.println("Path archivo copiado: "+copiedfilepath);
                }
            });
        item2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(copiedFile){
                        Path sourcepath= Paths.get(copiedfilepath);
                        Path destinationpath= Paths.get(path);
                        try{
                            Files.copy(sourcepath, destinationpath.resolve(sourcepath.getFileName()), StandardCopyOption.REPLACE_EXISTING);
                            copiedFile=false;
                            System.out.println("File copied successfully!");
                            updateData(jComboBox1.getSelectedItem().toString());
                        }catch(IOException r){
                            r.printStackTrace();
                            System.err.println("Error");
                        }
                }
                }
                
            });
      item3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                     //Crear File
                     File file= new File(path+"/"+selectedFile);
                     
                     System.out.println(file.delete());
                     updateData(jComboBox1.getSelectedItem().toString());
                        }
                     
                
            });
      item4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                     //Crear File
                     String filename=JOptionPane.showInputDialog("Nombre del File: ");
                     File file= new File(path+"/"+filename);
                     if(!file.exists()){
                        try{ file.createNewFile();
                        updateData(jComboBox1.getSelectedItem().toString());
                        }catch(IOException r){
                            r.printStackTrace();
                            System.out.println("Error al crear el archivo");
                        }
                     }
                }
            });
       item5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                     //Crear Directory
                     String filename=JOptionPane.showInputDialog("Nombre del Folder: ");
                     File file= new File(path+"/"+filename);
                     if(!file.exists()){
                         file.mkdir();
                         updateData(jComboBox1.getSelectedItem().toString());
                         updateTreeData(rootpath);
                        
                     }
                }
            });
        
        fileTable.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e)) { // Right mouse button clicked
            int selectedRow = fileTable.rowAtPoint(e.getPoint());
            int selectedColumn = fileTable.columnAtPoint(e.getPoint());
            System.out.println("se hizo click");
            if (selectedRow != -1) {
                // Get data from the selected row
                 selectedFile = (String) fileTable.getValueAt(selectedRow, 0);
                System.out.println(selectedFile);

                // Show the popup menu at the mouse coordinates
                jPopupMenu1.show(fileTable, e.getX(), e.getY());
                
                jPopupMenu1.setVisible(true);
                
            }
        }
    }
});
         showFile(new File("Z"),root);
           if(files.getUserlog().equals("Admin")){
                rootpath="Z/usuarios";
       } 
            else  rootpath="Z/usuarios/"+files.getUserlog();
            
            
            updateTreeData(rootpath);
       
     /*   showFile(new File("Z"),root);
            if (files.getUserlog().equals("Admin")) {
        rootpath = "Z";
       } else {
        rootpath = "Z/usuarios/" + files.getUserlog();
       }
    updateTreeData(rootpath);
    updateData("Nombre");
        */

   }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree(treeModel);
        jScrollPane2 = new javax.swing.JScrollPane(fileTable);
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(153, 153, 153));
        jScrollPane1.setForeground(new java.awt.Color(102, 102, 102));

        jTree1.setBackground(new java.awt.Color(102, 102, 102));
        jTree1.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTree1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jTree1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 100, 330));
        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 410, 310));

        jComboBox1.setBackground(new java.awt.Color(51, 51, 51));
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Fecha", "Tamaño", "Tipo" }));
        jComboBox1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jComboBox1.setDoubleBuffered(true);
        jComboBox1.setFocusable(false);
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 14, -1, -1));

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("New File");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
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
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 18, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTree1ValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTree1ValueChanged
          // Get the selected node
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) jTree1.getLastSelectedPathComponent();
        
       if(selectedNode!=null){
        String filepath= jTree1.getSelectionPath().toString().replace("[", "").replace(", ", "/").replace("]", "");
       if(username.equals("Admin"))
        path="Z/"+filepath;
       else path="Z/usuarios/"+filepath;
      
        updateData("Nombre");
        
        System.out.println(path);}
       else System.out.println("No node selected");
    }//GEN-LAST:event_jTree1ValueChanged

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
     String option= jComboBox1.getSelectedItem().toString();
     updateData(option);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
        
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
       jPopupMenu2.show(evt.getComponent(),evt.getX() , evt.getY());
        jPopupMenu2.setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked
public  void showFile(File file,DefaultMutableTreeNode node){
        File fl= new File(file.getPath());
        if(fl.exists()&&fl.listFiles().length>0){
            File[] files=fl.listFiles();
            for(File f:files){
                DefaultMutableTreeNode hijo= new DefaultMutableTreeNode(new FileTreeNode(new File(f.getPath())));
                if(f.isDirectory()){
                   
                   
                   node.add(hijo);
                   showFile(f,hijo);
                }
               
            }
        }
    }
private void updateData(String filter) {
        // Simulate getting new data (you can replace this with actual data retrieval)
        File file= new File(path);
        ordenar= new FileOrganizer();
        try{
            switch(filter){
           case "Nombre":
               ordenar.organizeFilesByName(path);
               break;
           case "Fecha":
               ordenar.organizeFilesByDate(path);
               break;
           case "Tipo":
               ordenar.organizeFilesByType(path);
               break;
           case "Tamaño":
               ordenar.organizeFilesBySize(path);
               break;
       }
        }catch(IOException e ){
            e.printStackTrace();
        }
        List<File> newFiles = List.of(file.listFiles());

        // Update the model and fireTableDataChanged will notify the table to refresh
        fileTableModel.setFiles(newFiles);
    }
    private void updateTreeData(String rootpath) {
        // Simulate getting new data (you can replace this with actual data retrieval)
        DefaultMutableTreeNode newRoot= new DefaultMutableTreeNode(new FileTreeNode(new File(rootpath)));
        root=newRoot;
         treeModel.setRoot(root);

        // Update the model and reload the tree
        showFile(new File(rootpath),root);
        treeModel.reload();
    }
    private DefaultMutableTreeNode findNodeByName(DefaultMutableTreeNode root, String nodeName) {
        // Traverse the tree to find a node with the specified name
        for (int i = 0; i < root.getChildCount(); i++) {
            DefaultMutableTreeNode child = (DefaultMutableTreeNode) root.getChildAt(i);
            if (child.getUserObject().toString().equals(nodeName)) {
                return child;
            }

            // Recursively search in child nodes
            DefaultMutableTreeNode foundNode = findNodeByName(child, nodeName);
            if (foundNode != null) {
                return foundNode;
            }
        }

        return null; // Node not found
    }
    private static String getFileExtension(File file) {
        String fileName = file.getName();
        int lastDotIndex = fileName.lastIndexOf('.');

        if (lastDotIndex > 0 && lastDotIndex < fileName.length() - 1) {
            return fileName.substring(lastDotIndex + 1);
        } else {
            // No extension found or the dot is the last character in the file name
            return "";
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables
}
