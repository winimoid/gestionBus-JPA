package tg.univ.lome.epl.apoo.gestionBus_gui.panels;

import tg.univ.lome.epl.apoo.gestionBus_gui.view.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstPanel extends JPanel {

    private JPanel mainPanel = new JPanel();
    private HeadPanel headPanel = new HeadPanel();
    private FootPanel footPanel = new FootPanel();
    private MenuPanel menuPanel = new MenuPanel();

    // Constructeur
    public FirstPanel() {

        // Layout
        setLayout(new BorderLayout());

        // Panel de droite
        mainPanel.setBackground(Color.WHITE);
        CardLayout myCardLayout = new CardLayout();
        mainPanel.setLayout(myCardLayout);
        mainPanel.setPreferredSize(new Dimension(800, 500));

        // Panels pour chaque opération
        JPanel busPanel = new JPanel();
        busPanel.setBackground(Color.WHITE);
        busPanel.setPreferredSize(new Dimension(790, 490));
        //busPanel.add(new JLabel("Opérations Bus"));
        BusView busView = new BusView();
        busPanel.add(busView);

        JPanel voyagePanel = new JPanel();
        voyagePanel.setBackground(Color.WHITE);
        voyagePanel.add(new JLabel("Opérations Voyage"));

        JPanel itinerairesPanel = new JPanel();
        itinerairesPanel.setBackground(Color.WHITE);
        //itinerairesPanel.add(new JLabel("Opérations Itinéraires"));
        ItineraireView itineraireView = new ItineraireView();
        itinerairesPanel.add(itineraireView);

        JPanel conducteursPanel = new JPanel();
        conducteursPanel.setBackground(Color.WHITE);
        // conducteursPanel.add(new JLabel("Opérations Conducteurs"));
        ConducteurView conducteurView = new ConducteurView();
        conducteursPanel.add(conducteurView);

        JPanel clientsPanel = new JPanel();
        clientsPanel.setBackground(Color.WHITE);
        //clientsPanel.add(new JLabel("Opérations Clients"));
        ClientView clientView = new ClientView();
        clientsPanel.add(clientView);

        JPanel caissePanel = new JPanel();
        caissePanel.setBackground(Color.WHITE);
        caissePanel.add(new JLabel("Opérations Caisse"));

        JPanel horairePanel = new JPanel();
        horairePanel.setBackground(Color.WHITE);
        //horairePanel.add(new JLabel("Opérations Horaire"));
        HoraireView horaireView = new HoraireView();
        horairePanel.add(horaireView);

        // Confection du cardLayout
        mainPanel.add(busPanel, "BUS");
        mainPanel.add(voyagePanel, "VOYAGE");
        mainPanel.add(itinerairesPanel, "ITINERAIRES");
        mainPanel.add(conducteursPanel, "CONDUCTEURS");
        mainPanel.add(clientsPanel, "CLIENTS");
        mainPanel.add(caissePanel, "CAISSE");
        mainPanel.add(horairePanel, "HORAIRE");

        // Ajouter les panels à la frame
        add(headPanel, BorderLayout.NORTH);
        add(footPanel, BorderLayout.SOUTH);
        add(menuPanel, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);

        // ActionListener pour les boutons
        menuPanel.getBusButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                myCardLayout.show(mainPanel, "BUS");
            }
        });

        menuPanel.getVoyageButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                myCardLayout.show(mainPanel, "VOYAGE");
            }
        });

        menuPanel.getItineraireButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                myCardLayout.show(mainPanel, "ITINERAIRES");
            }
        });

        menuPanel.getConducteurButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                myCardLayout.show(mainPanel, "CONDUCTEURS");
            }
        });

        menuPanel.getClientsButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                myCardLayout.show(mainPanel, "CLIENTS");
            }
        });

        menuPanel.getCaisseButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                myCardLayout.show(mainPanel, "CAISSE");
            }
        });

        menuPanel.getHoraireButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                myCardLayout.show(mainPanel, "HORAIRE");
            }
        });

    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public HeadPanel getHeadPanel() {
        return headPanel;
    }

    public FootPanel getFootPanel() {
        return footPanel;
    }

    public MenuPanel getMenuPanel() {
        return menuPanel;
    }
}
