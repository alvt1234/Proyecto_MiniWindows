package windows;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

class FileTableModel extends AbstractTableModel {
    private List<File> files;
    private String[] columnNames = {"File Name", "Size", "Last Modified","File Type"};

    public FileTableModel(String directoryPath) {
        files = new ArrayList<>();
        loadFiles(directoryPath);
        
    }

    private void loadFiles(String directoryPath) {
        File directory = new File(directoryPath);
        if (directory.isDirectory()) {
            files = List.of(directory.listFiles());
            fireTableDataChanged();
        }
    }
    public void setFiles(List<File> files) {
        this.files = files;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return files.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        File file = files.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return file.getName();
            case 1:
                return file.length();
            case 2:
                return file.lastModified();
            case 3:
                return getFileExtension(file.getName());
            default:
                return null;
        }
    }
    private static String getFileExtension(String fileName) {
        int lastDotIndex = fileName.lastIndexOf('.');
        if (lastDotIndex > 0) {
            return fileName.substring(lastDotIndex + 1);
        } else {
            return ""; // No extension found
        }
    }
    
    
     
}



