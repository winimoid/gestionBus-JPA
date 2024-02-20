package tg.univ.lome.epl.apoo.gestionBus_gui.view.details;

import tg.univ.lome.epl.apoo.gestionBus_gui.controller.BusController;
import tg.univ.lome.epl.apoo.gestionBus_gui.controller.ConducteurController;
import tg.univ.lome.epl.apoo.gestionBus_gui.controller.ItineraireController;
import tg.univ.lome.epl.apoo.gestionBus_jpa.entities.Bus;
import tg.univ.lome.epl.apoo.gestionBus_jpa.entities.Conducteur;
import tg.univ.lome.epl.apoo.gestionBus_jpa.entities.Itineraire;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBusDetail extends JPanel {

    private final JPanel fieldsPanel = new JPanel();
    private final JLabel lblTitre = new JLabel("Ajout d'un nouveau Bus");
    private JLabel lblNumero;
    private JTextField txtNumero;
    private JLabel lblModele;
    private JTextField txtModele;
    private JLabel lblCapacite;
    private JTextField txtCapacite;
    private JLabel lblAnnee;
    private JTextField txtAnnee;
    private JLabel lblKilometrage;
    private JTextField txtKilometrage;
    private JLabel lblStatut;
    private JTextField txtStatut;
    private JLabel lblDisponible;
    private JCheckBox chkDisponible;
    private JLabel lblConducteur;
    private JComboBox<String> cmbConducteur;
    private JLabel lblItineraire;
    private JComboBox<String> cmbItineraire;
    private JButton btnValider;

    public AddBusDetail() {
        fieldsPanel.setLayout(new GridLayout(10, 2, 10, 10));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        initComponents();

        // SetCmbModel
        ConducteurController conducteurController = new ConducteurController();
        ItineraireController itineraireController = new ItineraireController();

        cmbConducteur.setModel(setDefaultCondCmbModel(conducteurController.displayConducteur()));
        cmbItineraire.setModel(setDefaultItinCmbModel(itineraireController.displayItineraire()));

        // ActionListener
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //recuperation des entrées de la vue
                int numeroBus = Integer.parseInt(txtNumero.getText());
                String modeleBus = txtModele.getText();
                int capacite = Integer.parseInt(txtCapacite.getText());
                int anneeFabrication = Integer.parseInt(txtAnnee.getText());
                int kilometrage = Integer.parseInt(txtKilometrage.getText());
                String statut = txtStatut.getText();
                boolean dispo = chkDisponible.isSelected();

                // choisir le conducteur
                int indexConducteur = cmbConducteur.getSelectedIndex();
                ConducteurController conducteurController1 = new ConducteurController();
                Conducteur conducteur = mapIndexConducteur(indexConducteur, conducteurController1.displayConducteur());

                // Choisir l'itineraire
                int indexItineraire = cmbItineraire.getSelectedIndex();
                ItineraireController itineraireController1 = new ItineraireController();
                Itineraire itineraire = mapIndexItineraire(indexItineraire, itineraireController1.displayItineraire());

                BusController busController = new BusController();
                assert conducteur != null;
                busController.addBus(numeroBus,modeleBus, capacite, anneeFabrication, kilometrage, statut, dispo, conducteur, itineraire);

                System.out.println("Affichage de AddBus !");
            }
        });

        // Permet de valider lorsqu'on appuie sur la touche "entrée"
        //this.getRootPane().setDefaultButton(btnValider);
    }

    private void initComponents() {
        lblNumero = new JLabel("Numéro du bus:");
        txtNumero = new JTextField();
        lblModele = new JLabel("Modèle:");
        txtModele = new JTextField();
        lblCapacite = new JLabel("Capacité:");
        txtCapacite = new JTextField();
        lblAnnee = new JLabel("Année de fabrication:");
        txtAnnee = new JTextField();
        lblKilometrage = new JLabel("Kilométrage:");
        txtKilometrage = new JTextField();
        lblStatut = new JLabel("Statut:");
        txtStatut = new JTextField();
        lblDisponible = new JLabel("Disponible:");
        chkDisponible = new JCheckBox();
        lblConducteur = new JLabel("Conducteur:");
        cmbConducteur = new JComboBox<>();
        lblItineraire = new JLabel("Itinéraire:");
        cmbItineraire = new JComboBox<>();
        btnValider = new JButton("Valider");

        fieldsPanel.add(lblNumero);
        fieldsPanel.add(txtNumero);
        fieldsPanel.add(lblModele);
        fieldsPanel.add(txtModele);
        fieldsPanel.add(lblCapacite);
        fieldsPanel.add(txtCapacite);
        fieldsPanel.add(lblAnnee);
        fieldsPanel.add(txtAnnee);
        fieldsPanel.add(lblKilometrage);
        fieldsPanel.add(txtKilometrage);
        fieldsPanel.add(lblStatut);
        fieldsPanel.add(txtStatut);
        fieldsPanel.add(lblDisponible);
        fieldsPanel.add(chkDisponible);
        fieldsPanel.add(lblConducteur);
        fieldsPanel.add(cmbConducteur);
        fieldsPanel.add(lblItineraire);
        fieldsPanel.add(cmbItineraire);
        fieldsPanel.add(btnValider);

        // Configurations
        Font arialBold15 = new Font("ARIAL", Font.BOLD, 15);
        setBackground(new Color(93, 173, 226));
        setPreferredSize(new Dimension(getWidth(), 400));
        lblTitre.setForeground(Color.WHITE);
        lblTitre.setFont(arialBold15);

        // Ajout des 2 elements à aligner verticalement
        this.add(lblTitre);
        this.add(fieldsPanel);
    }

    // Modeles de combobox
    private DefaultComboBoxModel<String> setDefaultCondCmbModel(Conducteur[] tableau) {

        DefaultComboBoxModel<String> cmbModel = new DefaultComboBoxModel<>();
        cmbModel.addElement("Choisir un Conducteur");

        for (Conducteur conducteur : tableau) {

            cmbModel.addElement(conducteur.getNom() + " " + conducteur.getPrenom());
        }


        return cmbModel;
    }

    private DefaultComboBoxModel<String> setDefaultItinCmbModel(Itineraire[] tableau) {

        DefaultComboBoxModel<String> cmbModel = new DefaultComboBoxModel<>();
        cmbModel.addElement("Choisir un Itinéraire");

        for (Itineraire itineraire : tableau) {

            cmbModel.addElement("Ligne " + itineraire.getNumeroLigne());
        }


        return cmbModel;
    }

    // Recuperation de'index de conducteur
    private Conducteur mapIndexConducteur(int index, Conducteur[] tabConducteur) {

        for (int i=0; i<tabConducteur.length; i++) {

            if (index == i+1){
                System.out.println(tabConducteur[i]);
                return tabConducteur[i];
            }
        }

        return null;
    }

    // Recuperation de l'index itineraire
    private Itineraire mapIndexItineraire(int index, Itineraire[] tabItineraire) {

        for (int i=0; i<tabItineraire.length; i++) {

            if (index == i+1){
                System.out.println(tabItineraire[i]);
                return tabItineraire[i];
            }
        }

        return null;
    }

    // Getters

    public JTextField getTxtNumero() {
        return txtNumero;
    }

    public JTextField getTxtModele() {
        return txtModele;
    }

    public JTextField getTxtCapacite() {
        return txtCapacite;
    }

    public JTextField getTxtAnnee() {
        return txtAnnee;
    }

    public JTextField getTxtKilometrage() {
        return txtKilometrage;
    }

    public JTextField getTxtStatut() {
        return txtStatut;
    }

    public JCheckBox getChkDisponible() {
        return chkDisponible;
    }

    public JComboBox<String> getCmbConducteur() {
        return cmbConducteur;
    }

    public JComboBox<String> getCmbItineraire() {
        return cmbItineraire;
    }

    public JButton getBtnValider() {
        return btnValider;
    }
}
