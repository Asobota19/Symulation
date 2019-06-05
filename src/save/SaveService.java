package save;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaveService {

    public static void createFile(SaveDataObject dataObject, boolean isPlLanguage, JFileChooser chooser) {
        String currentDate = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        new File("results").mkdirs();

        try (FileWriter file = new FileWriter(chooser.getSelectedFile().getPath() + currentDate + "_result.txt")) {
            file.write("Visual Impariment: " + dataObject.getVisualImpairment() + "\n");
            file.write("Amethropy type: " + dataObject.getAmethropyType() + "\n");
            file.write("Length: " + dataObject.getLength() + "\n");
            file.write("Save date: " + dataObject.getDate() + "\n");
        } catch (Exception e) {
            System.out.println("Error during write to file: " + e.getMessage());
        }
    }


}
