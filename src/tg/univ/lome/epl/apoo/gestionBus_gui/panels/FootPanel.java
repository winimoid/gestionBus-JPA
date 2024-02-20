package tg.univ.lome.epl.apoo.gestionBus_gui.panels;

import javax.swing.*;
import java.awt.*;

public class FootPanel extends JPanel {

    private JLabel authorLabel = new JLabel("EPL - 2023");
    // Polices
    Font arialBold30 = new Font("ARIAL", Font.BOLD, 30);
    Font arialBold20 = new Font("ARIAL", Font.BOLD, 20);
    Font arialLight20 = new Font("ARIAL", Font.PLAIN, 20);
    Font arialItalic10 = new Font("ARIAL", Font.ITALIC, 10);

    public FootPanel() {

        super();
        setBackground(Color.LIGHT_GRAY);
        setPreferredSize(new Dimension(getWidth(), 50));
        authorLabel.setFont(arialItalic10);
        // authorLabel.setSize(new Dimension(300, 50));
        this.add(authorLabel);

        // GetLayout
        // FlowLayout myFlowLayout = (FlowLayout) this.getLayout();
        // myFlowLayout.setAlignment(FlowLayout.LEADING);
    }

    // Getter

    public JLabel getAuthorLabel() {
        return authorLabel;
    }
}
