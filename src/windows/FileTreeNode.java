/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package windows;

import java.io.File;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author ferna
 */
public class FileTreeNode extends DefaultMutableTreeNode{
    private final File file;
    public FileTreeNode(File file){
        super(file.getName());
            this.file = file;
    }
    
    @Override
        public boolean isLeaf() {
            return !file.isDirectory();
        }
 public int getChildCount() {
            if (isLeaf()) {
                return 0;
            } else {
                File[] children = file.listFiles();
                return (children != null) ? children.length : 0;
            }
        }
 
  @Override
        public DefaultMutableTreeNode getChildAt(int index) {
            if (!isLeaf()) {
                File[] children = file.listFiles();
                if (children != null && index >= 0 && index < children.length) {
                    return new FileTreeNode(children[index]);
                }
            }
            return null;
        }
    }
