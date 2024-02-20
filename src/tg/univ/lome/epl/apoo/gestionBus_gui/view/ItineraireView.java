package tg.univ.lome.epl.apoo.gestionBus_gui.view;

import tg.univ.lome.epl.apoo.gestionBus_gui.IconResizer;
import tg.univ.lome.epl.apoo.gestionBus_gui.view.details.AddConducteurDetail;
import tg.univ.lome.epl.apoo.gestionBus_gui.view.details.AddItineraireDetail;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItineraireView extends JPanel {

    JPanel headerPanel = new JPanel();
    JLabel titleLabel = new JLabel("Opérations sur les Itinéraires");
    JPanel centerPanel = new JPanel();
    JPanel footerPanel = new JPanel();
    JPanel interPanel = new JPanel(new BorderLayout());
    JButton addButton = new JButton("Ajouter un Itinéraire");

    // Polices
    Font arialBold30 = new Font("ARIAL", Font.BOLD, 30);
    Font arialBold20 = new Font("ARIAL", Font.BOLD, 20);
    Font arialLight20 = new Font("ARIAL", Font.PLAIN, 20);
    Font arialItalic20 = new Font("ARIAL", Font.ITALIC, 20);

    // SetCursor
    Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);

    // Icones
    ImageIcon addIcon = new ImageIcon("src/tg/univ/lome/epl/apoo/gestionbus_gui/images/icons/ajouter.png");
    ImageIcon removeIcon = new ImageIcon("src/tg/univ/lome/epl/apoo/gestionbus_gui/images/icons/supprimer.png");
    ImageIcon editIcon = new ImageIcon("src/tg/univ/lome/epl/apoo/gestionbus_gui/images/icons/modifier.png");
    ImageIcon addIconResized = IconResizer.resizeIcon(addIcon, 20, 20);
    ImageIcon removeIconResized = IconResizer.resizeIcon(removeIcon, 20, 20);
    ImageIcon editIconResized = IconResizer.resizeIcon(editIcon, 20, 20);

    // Constructeur
    public ItineraireView() {

        setLayout(new BorderLayout());

        // Panel header
        headerPanel.setBackground(Color.WHITE);

        titleLabel.setFont(arialBold20);
        headerPanel.add(titleLabel);

        // Panel center
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        // Exemple de liste de bus
        String[] itinerairesList = {"Itinéraire 1", "Itinéraire 2", "Itinéraire 3", "Itinéraire 4", "Itinéraire 5"};

        for (String itineraire : itinerairesList) {
            JPanel itinerairePanel = new JPanel(new BorderLayout());
            itinerairePanel.setBackground(Color.WHITE);

            JLabel itineraireLabel = new JLabel(itineraire);
            itinerairePanel.add(itineraireLabel, BorderLayout.CENTER);

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
            itinerairePanel.add(buttonPanel, BorderLayout.EAST);

            centerPanel.add(itinerairePanel);
        }

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
                AddItineraireDetail addItineraireDetail = new AddItineraireDetail();
                interPanel.add(addItineraireDetail);
                centerPanel.add(interPanel);

                System.out.println("Affichage de AddItineraire !");
            }
        });

        // SetCursor sur le bouton valider
        addButton.setCursor(handCursor);

        // Icone du bouton ajouter
        addButton.setIcon(addIconResized);
    }

    // Getters

    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public JButton getAddButton() {
        return addButton;
    }
}
