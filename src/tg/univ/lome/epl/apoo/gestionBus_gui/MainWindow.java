package tg.univ.lome.epl.apoo.gestionBus_gui;

import tg.univ.lome.epl.apoo.gestionBus_gui.panels.FirstPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    JPanel panelContent = new JPanel(new BorderLayout());
    FirstPanel firstPanel = new FirstPanel();
    public MainWindow() {

        this.setLayout(new BorderLayout());

        panelContent.add(firstPanel);

        // Charge l'icône à partir du fichier
        ImageIcon appIcon = new ImageIcon("src/tg/univ/lome/epl/apoo/gestionbus_gui/images/icons/appIcon.png");
        //ImageIcon appIconResized = IconResizer.resizeIcon(appIcon, 35, 40);

        // Définit l'icône de l'application
        this.setIconImage(appIcon.getImage());

        // Définit le titre de l'application
        this.setTitle("M  - Transports");

        try {
            // Définition du thème Nimbus Look and Feel
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

            System.out.println("NimbusLookAndFeel configuré avec succès !");

            // Création et affichage de ta fenêtre principale
            SwingUtilities.invokeLater(() -> {
                this.add(panelContent, BorderLayout.CENTER);
                this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                this.setVisible(true);
                this.setSize(new Dimension(1200, 700));
                pack();
                this.setLocationRelativeTo(null);
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Fermer quand on clique sur quitter
        firstPanel.getMenuPanel().getQuitterButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainWindow.this.dispose();
            }
        });
    }

    // Getters / Setters

    public JPanel getPanelContent() {
        return panelContent;
    }

    public FirstPanel getFirstPanel() {
        return firstPanel;
    }
}
