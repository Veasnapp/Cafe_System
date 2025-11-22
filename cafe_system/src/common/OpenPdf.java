package common;

import java.awt.Desktop;
import java.io.File;
import javax.swing.JOptionPane;
import java.io.IOException;

public class OpenPdf {
    
    public static void openById(String id) {
        try {
            String filePath = System.getProperty("user.dir") + "/src/Transaction/" + id + ".pdf";
            File pdfFile = new File(filePath);
            if (pdfFile.exists()) {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(pdfFile);
                } else {
                    JOptionPane.showMessageDialog(null, "Desktop is not supported on your platform.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "File does not exist.");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error opening the document: " + e.getMessage());
        }
    }
}

