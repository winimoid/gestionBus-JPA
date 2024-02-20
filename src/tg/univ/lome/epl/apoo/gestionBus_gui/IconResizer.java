package tg.univ.lome.epl.apoo.gestionBus_gui;

import javax.swing.*;
import java.awt.*;

public class IconResizer {

    public static ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
}
