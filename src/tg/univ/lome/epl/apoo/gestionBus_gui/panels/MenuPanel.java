package tg.univ.lome.epl.apoo.gestionBus_gui.panels;

import tg.univ.lome.epl.apoo.gestionBus_gui.IconResizer;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    // Boutons
    JButton busButton = new JButton ("Bus");
    JButton voyageButton = new JButton ("Voyage");
    JButton itineraireButton = new JButton ("Itinéraires");
    JButton conducteurButton = new JButton ("Conducteurs");
    JButton clientsButton = new JButton ("Clients");
    JButton caisseButton = new JButton ("Caisse");
    JButton horaireButton = new JButton ("Horaires");
    JButton quitterButton = new JButton ("Quitter");

    // Labels
    JLabel menuLabel = new JLabel("Menu Principal");

    // Polices
    Font arialBold30 = new Font("Comic Sans MS", Font.BOLD, 30);
    Font arialBold20 = new Font("Cambria Math", Font.BOLD, 20);
    Font arialLight20 = new Font("ARIAL", Font.PLAIN, 20);
    Font arialItalic20 = new Font("ARIAL", Font.ITALIC, 20);

    // Panels des boutons
    JPanel busButtonPanel = new JPanel();
    JPanel voyageButtonPanel = new JPanel();
    JPanel itineraireButtonPanel = new JPanel();
    JPanel conducteurButtonPanel = new JPanel();
    JPanel clientsButtonPanel = new JPanel();
    JPanel caisseButtonPanel = new JPanel();
    JPanel horairesButtonPanel = new JPanel();
    JPanel quitterButtonPanel = new JPanel();

    // Création du curseur "main"
    Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);

    // Couleurs
    Color grisVert = new Color(194, 210, 204);
    Color rougePale = new Color(230, 121, 121);


    // Constructeur
    public MenuPanel() {

        super();
        this.setBackground(new Color(119, 144, 135));
        this.setPreferredSize(new Dimension(220,540));
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setOpaque(true);

        // Setfonts
        menuLabel.setFont(arialBold30);
        menuLabel.setForeground(Color.WHITE);

        busButton.setFont(arialBold20);
        voyageButton.setFont(arialBold20);
        itineraireButton.setFont(arialBold20);
        conducteurButton.setFont(arialBold20);
        clientsButton.setFont(arialBold20);
        caisseButton.setFont(arialBold20);
        horaireButton.setFont(arialBold20);

        quitterButton.setFont(arialBold20);
        quitterButton.setBackground(rougePale);

        // SetCursor
        busButton.setCursor(handCursor);
        voyageButton.setCursor(handCursor);
        itineraireButton.setCursor(handCursor);
        conducteurButton.setCursor(handCursor);
        clientsButton.setCursor(handCursor);
        caisseButton.setCursor(handCursor);
        horaireButton.setCursor(handCursor);
        quitterButton.setCursor(handCursor);

        // SetSize
        menuLabel.setPreferredSize(new Dimension(220,50));
        busButton.setPreferredSize(new Dimension(160, 45));
        voyageButton.setPreferredSize(new Dimension(160, 45));
        itineraireButton.setPreferredSize(new Dimension(160, 45));
        conducteurButton.setPreferredSize(new Dimension(160, 45));
        clientsButton.setPreferredSize(new Dimension(160, 45));
        caisseButton.setPreferredSize(new Dimension(160, 45));
        horaireButton.setPreferredSize(new Dimension(160, 45));
        quitterButton.setPreferredSize(new Dimension(160, 45));

        // BackgroundColor
        busButtonPanel.setBackground(grisVert);
        voyageButtonPanel.setBackground(grisVert);
        itineraireButtonPanel.setBackground(grisVert);
        caisseButtonPanel.setBackground(grisVert);
        conducteurButtonPanel.setBackground(grisVert);
        clientsButtonPanel.setBackground(grisVert);
        horairesButtonPanel.setBackground(grisVert);
        quitterButtonPanel.setBackground(grisVert);

        // ImageIcons
        ImageIcon busIcon = new ImageIcon("src/tg/univ/lome/epl/apoo/gestionbus_gui/images/icons/bus.png");
        ImageIcon voyageIcon = new ImageIcon("src/tg/univ/lome/epl/apoo/gestionbus_gui/images/icons/voyage.png");
        ImageIcon itineraireIcon = new ImageIcon("src/tg/univ/lome/epl/apoo/gestionbus_gui/images/icons/itineraire.png");
        ImageIcon caisseIcon = new ImageIcon("src/tg/univ/lome/epl/apoo/gestionbus_gui/images/icons/caisse.png");
        ImageIcon conducteurIcon = new ImageIcon("src/tg/univ/lome/epl/apoo/gestionbus_gui/images/icons/conducteur.png");
        ImageIcon clientsIcon = new ImageIcon("src/tg/univ/lome/epl/apoo/gestionbus_gui/images/icons/clients.png");
        ImageIcon horairesIcon = new ImageIcon("src/tg/univ/lome/epl/apoo/gestionbus_gui/images/icons/horaire.png");
        ImageIcon quitterIcon = new ImageIcon("src/tg/univ/lome/epl/apoo/gestionbus_gui/images/icons/quitter.png");


        ImageIcon busIconResized = IconResizer.resizeIcon(busIcon, 35, 40);
        ImageIcon voyageIconResized = IconResizer.resizeIcon(voyageIcon, 35, 40);
        ImageIcon itineraireIconResized = IconResizer.resizeIcon(itineraireIcon, 35, 40);
        ImageIcon caisseIconResized = IconResizer.resizeIcon(caisseIcon, 35, 40);
        ImageIcon conducteurIconResized = IconResizer.resizeIcon(conducteurIcon, 35, 40);
        ImageIcon clientsIconResized = IconResizer.resizeIcon(clientsIcon, 35, 40);
        ImageIcon horairesIconResized = IconResizer.resizeIcon(horairesIcon, 35, 40);
        ImageIcon quitterIconResized = IconResizer.resizeIcon(quitterIcon, 35, 40);

        // Labels d'icones
        JLabel busIconLabel =new JLabel(busIconResized);
        JLabel voyageIconLabel =new JLabel(voyageIconResized);
        JLabel itineraireIconLabel =new JLabel(itineraireIconResized);
        JLabel caisseIconLabel =new JLabel(caisseIconResized);
        JLabel conducteurIconLabel =new JLabel(conducteurIconResized);
        JLabel clientsIconLabel =new JLabel(clientsIconResized);
        JLabel horairesIconLabel =new JLabel(horairesIconResized);
        JLabel quitterIconLabel =new JLabel(quitterIconResized);

        // Ajout des icones à leurs panels
        busButtonPanel.add(busIconLabel);
        voyageButtonPanel.add(voyageIconLabel);
        itineraireButtonPanel.add(itineraireIconLabel);
        caisseButtonPanel.add(caisseIconLabel);
        conducteurButtonPanel.add(conducteurIconLabel);
        clientsButtonPanel.add(clientsIconLabel);
        horairesButtonPanel.add(horairesIconLabel);
        quitterButtonPanel.add(quitterIconLabel);

        // Ajout des boutons à leurs panels
        busButtonPanel.add(busButton);
        voyageButtonPanel.add(voyageButton);
        itineraireButtonPanel.add(itineraireButton);
        caisseButtonPanel.add(caisseButton);
        conducteurButtonPanel.add(conducteurButton);
        clientsButtonPanel.add(clientsButton);
        horairesButtonPanel.add(horaireButton);
        quitterButtonPanel.add(quitterButton);

        // GetLayout
        FlowLayout myFlowLayout = (FlowLayout) this.getLayout();
        myFlowLayout.setAlignment(FlowLayout.LEADING);

        // Ajout des petits panels au panel general
        this.add(menuLabel);
        this.add(busButtonPanel);
        this.add(voyageButtonPanel);
        this.add(itineraireButtonPanel);
        this.add(caisseButtonPanel);
        this.add(conducteurButtonPanel);
        this.add(clientsButtonPanel);
        this.add(horairesButtonPanel);
        this.add(quitterButtonPanel);
    }

    // Getters

    public JButton getBusButton() {
        return busButton;
    }

    public JButton getVoyageButton() {
        return voyageButton;
    }

    public JButton getItineraireButton() {
        return itineraireButton;
    }

    public JButton getConducteurButton() {
        return conducteurButton;
    }

    public JButton getClientsButton() {
        return clientsButton;
    }

    public JButton getCaisseButton() {
        return caisseButton;
    }

    public JButton getHoraireButton() {
        return horaireButton;
    }

    public JButton getQuitterButton() {
        return quitterButton;
    }
}
