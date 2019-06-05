package component;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RightPanelComponent extends JPanel {

    private Image eyeImage;
    private Image eyeImageUpper;
    private Image imagePoint;
    private Image imagePointBad;

    private JPanel panel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawSymulation(g);
            drawPointSymulation(g);
            drawEyeLineSymulation(g);
        }
    };
    private int width;
    private boolean isBad;
    private int upperSymulationX;

    public JPanel getPanel() {
        return panel;
    }

    public RightPanelComponent() {
        panel.setBackground(Color.white);
        panel.setSize(200, 200);
        panel.setLayout(new GridLayout(2, 1));
        upperSymulationX = 600;
        this.updateSymulation(0, false);

        try {
            eyeImage = ImageIO.read(getClass().getResourceAsStream("/image/eyeImage.png"));
            eyeImageUpper = ImageIO.read(getClass().getResourceAsStream("/image/eyeUpperLines.png"));
            imagePoint = ImageIO.read(getClass().getResourceAsStream("/image/imagePoint.png"));
            imagePointBad = ImageIO.read(getClass().getResourceAsStream("/image/imagePointBad.png"));
        } catch (Exception e) {
            System.out.println("IMAGE NOT FOUND");
        }
    }

    public void updateSymulation(int width, boolean isBad) {
        this.width = width;
        this.isBad = isBad;
        this.upperSymulationX = 550 + width;
        panel.repaint();
    }

    public void saveImageSymulation(JFileChooser chooser) {
        /*String currentDate = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        BufferedImage image = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();
        panel.paint(g);
        try {
            ImageIO.write(image, "png", new File("results/" + currentDate + "-image.png"));
        } catch (IOException ex) {
            System.out.println("write image failed: " + ex.getMessage());
        }*/

        BufferedImage image = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();
        panel.paint(g);

        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "PNG images", "png");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showSaveDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            File outputFile = new File(chooser.getSelectedFile().getAbsolutePath() + ".png");
            try {
                ImageIO.write(image, "png", outputFile);
            } catch (IOException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private void drawSymulation(Graphics g) {
        panel.repaint();
    }

    private void drawPointSymulation(Graphics g) {
        g.drawImage(eyeImage, 30, 500, null);
        if(!isBad) {
            g.drawImage(imagePoint, 780 - width * 7, 500, null);
        } else {
            g.drawImage(imagePointBad, 780 - width * 7, 500, null);
        }
    }

    private void drawEyeLineSymulation(Graphics g) {
        g.drawImage(eyeImageUpper,250, 150, null);
        g.setColor(Color.red);
        g.drawLine(487, 227, upperSymulationX, 262);
        g.drawLine(475, 262, upperSymulationX, 262);
        g.drawLine(490, 303, upperSymulationX, 262);
    }
}