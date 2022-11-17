package extension;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class OpenBillPdf {
    public static void openFile(String fileName) throws IllegalArgumentException, IOException{
        String path = "C:\\Users\\ADMIN\\Desktop\\SQL BTL JAVA\\" + fileName + ".pdf";
        File file = new File(path);
        Desktop.getDesktop().open(file);
    }
}
