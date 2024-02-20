package tg.univ.lome.epl.apoo.gestionBus_gui.panels;

import javax.swing.*;
import java.awt.*;

public class HeadPanel extends JPanel {

    private JLabel titleLabel = new JLabel("Application de Gestion des Bus");

    // Polices
    Font arialBold30 = new Font("ARIAL", Font.BOLD, 30);
    Font arialBold20 = new Font("ARIAL", Font.BOLD, 20);
    Font arialLight20 = new Font("ARIAL", Font.PLAIN, 20);
    Font arialItalic20 = new Font("ARIAL", Font.ITALIC, 20);

    public HeadPanel() {

        setBackground(new Color(136, 145, 250));
        setPreferredSize(new Dimension(getWidth(), 50));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(arialBold30);
        add(titleLabel);
    }

    // Getter

    public JLabel getTitleLabel() {
        return titleLabel;
    }
}
