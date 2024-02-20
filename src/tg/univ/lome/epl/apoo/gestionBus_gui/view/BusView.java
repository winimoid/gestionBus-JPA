package tg.univ.lome.epl.apoo.gestionBus_gui.view;

import tg.univ.lome.epl.apoo.gestionBus_gui.IconResizer;
import tg.univ.lome.epl.apoo.gestionBus_gui.controller.BusController;
import tg.univ.lome.epl.apoo.gestionBus_gui.view.details.AddBusDetail;
import tg.univ.lome.epl.apoo.gestionBus_jpa.entities.Bus;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BusView extends JPanel {

    private JTable buses = new JTable();
    JPanel headerPanel = new JPanel();
    JLabel titleLabel = new JLabel("Opérations sur les bus");
    JPanel centerPanel = new JPanel();
    JPanel footerPanel = new JPanel();
    JPanel interPanel = new JPanel(new BorderLayout());
    JButton addButton = new JButton("Ajouter un bus");

    // Polices
    Font arialBold30 = new Font("ARIAL", Font.BOLD, 30);
    Font arialBold20 = new Font("ARIAL", Font.BOLD, 20);
    Font arialLight20 = new Font("ARIAL", Font.PLAIN, 20);
    Font arialItalic20 = new Font("ARIAL", Font.ITALIC, 20);

    // HandCursor pour les boutons
    Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);

    // Icones
    ImageIcon addIcon = new ImageIcon("src/tg/univ/lome/epl/apoo/gestionbus_gui/images/icons/ajouter.png");
    ImageIcon removeIcon = new ImageIcon("src/tg/univ/lome/epl/apoo/gestionbus_gui/images/icons/supprimer.png");
    ImageIcon editIcon = new ImageIcon("src/tg/univ/lome/epl/apoo/gestionbus_gui/images/icons/modifier.png");
    ImageIcon addIconResized = IconResizer.resizeIcon(addIcon, 20, 20);
    ImageIcon removeIconResized = IconResizer.resizeIcon(removeIcon, 20, 20);
    ImageIcon editIconResized = IconResizer.resizeIcon(editIcon, 20, 20);

    // Constructeur
    public BusView() {

        setLayout(new BorderLayout());

        // Panel header
        headerPanel.setBackground(Color.WHITE);

        titleLabel.setFont(arialBold20);
        headerPanel.add(titleLabel);

        // Panel center
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        // Exemple de liste de bus
        //String[] busList = {"Bus 1", "Bus 2", "Bus 3", "Bus 4", "Bus 5"};
        BusController busController = new BusController();
        Bus[] busList = busController.displayBus();
        buses.setModel(retourneModele(busList));

        /*for (String bus : busList) {
            JPanel busPanel = new JPanel(new BorderLayout());
            busPanel.setBackground(Color.WHITE);
            JLabel busLabel = new JLabel(bus);
            busPanel.add(busLabel, BorderLayout.CENTER);

            JButton modifyButton = new JButton("Modifier");
            modifyButton.setCursor(handCursor);
            modifyButton.setIcon(editIconResized);
            JButton deleteButton = new JButton("Supprimer");
            deleteButton.setCursor(handCursor);
            deleteButton.setIcon(removeIconResized);
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            buttonPanel.setBackground(Color.WHITE);
            buttonPanel.add(modifyButton);
            buttonPanel.add(deleteButton);
            busPanel.add(buttonPanel, BorderLayout.EAST);

            centerPanel.add(busPanel);
        }*/
        JPanel busPanel = new JPanel(new BorderLayout());
        busPanel.setBackground(Color.WHITE);
        busPanel.add(buses, BorderLayout.CENTER);
        centerPanel.add(busPanel);

        JScrollPane scrollPane = new JScrollPane(centerPanel);
        scrollPane.setPreferredSize(new Dimension(750, 450));

        // Panel footer
        footerPanel.setBackground(Color.WHITE);

        footerPanel.add(addButton);

        // Ajout des panels dans le mainPanel
        add(headerPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(footerPanel, BorderLayout.SOUTH);

        // ActionListener
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddBusDetail addBusDetail = new AddBusDetail();
                interPanel.add(addBusDetail);
                centerPanel.add(interPanel);

                System.out.println("Affichage de AddBus !");
            }
        });

        // SetCursor sur le bouton valider
        addButton.setCursor(handCursor);

        // Icone du bouton ajouter
        addButton.setIcon(addIconResized);

    }

    //Getters

    public JPanel getHeaderPanel() {
        return headerPanel;
    }

    public JPanel getCenterPanel() {
        return centerPanel;
    }

    public JPanel getFooterPanel() {
        return footerPanel;
    }

    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public JButton getAddButton() {
        return addButton;
    }

    // Fonction qui retourne le modèle du tableau
    public DefaultTableModel retourneModele(Bus[] tableau){
        final String[] colonnes = {"NUMÉRO", "MODELE", "CAPACITÉ", "ANNÉE-FABRICATION", "KILOMÉTRAGE", "STATUT", "CONDUCTEUR", "ITINÉRAIRE"};
        DefaultTableModel modele = new DefaultTableModel(colonnes, 0);

        for (Bus bus : tableau) {

            modele.addRow(
                    new Object[]{
                            bus.getNumeroBus(),
                            bus.getModele(),
                            bus.getCapacite(),
                            bus.getAnneeFabrication(),
                            bus.getKilometrage() + "Km",
                            bus.getStatut(),
                            bus.getConducteur().getNom() + " " + bus.getConducteur().getPrenom(),
                            "Ligne " + bus.getItineraire().getNumeroLigne()

                    }
            );
        }

        return modele;
    }
}
