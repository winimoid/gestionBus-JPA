package tg.univ.lome.epl.apoo.gestionBus_gui.view.details;

import javax.swing.*;
import java.awt.*;

public class AddConducteurDetail extends JPanel {

    private JPanel fieldsPanel = new JPanel();
    private JLabel lblTitre = new JLabel("Ajout d'un nouveau Conducteur");
    private JLabel lblNumeroPermis;
    private JTextField txtNumeroPermis;
    private JLabel lblNom;
    private JTextField txtNom;
    private JLabel lblPrenoms;
    private JTextField txtPrenoms;
    private JLabel lblAge;
    private JTextField txtAge;
    private JLabel lblNumeroTelephone;
    private JTextField txtNumeroTelephone;
    private JLabel lblAdresse;
    private JTextField txtAdresse;
    private JLabel lblSalaire;
    private JTextField txtSalaire;
    private JLabel lblExperience;
    private JTextField txtExperience;
    private JLabel lblDisponible;
    private JCheckBox chkDisponible;
    private JButton btnValider;

    public AddConducteurDetail() {
        fieldsPanel.setLayout(new GridLayout(10, 2, 10, 10));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        initComponents();
    }

    private void initComponents() {
        lblNumeroPermis = new JLabel("Numéro de permis :");
        txtNumeroPermis = new JTextField();
        lblNom = new JLabel("Nom :");
        txtNom = new JTextField();
        lblPrenoms = new JLabel("Prenoms :");
        txtPrenoms = new JTextField();
        lblAge = new JLabel("Age :");
        txtAge = new JTextField();
        lblNumeroTelephone = new JLabel("Numéro de Téléphone :");
        txtNumeroTelephone = new JTextField();
        lblAdresse = new JLabel("Adresse :");
        txtAdresse = new JTextField();
        lblDisponible = new JLabel("Disponible :");
        chkDisponible = new JCheckBox();
        lblSalaire = new JLabel("Salaire :");
        txtSalaire = new JTextField();
        lblExperience = new JLabel("Expérience :");
        txtExperience = new JTextField();
        btnValider = new JButton("Valider");

        fieldsPanel.add(lblNumeroPermis);
        fieldsPanel.add(txtNumeroPermis);
        fieldsPanel.add(lblNom);
        fieldsPanel.add(txtNom);
        fieldsPanel.add(lblPrenoms);
        fieldsPanel.add(txtPrenoms);
        fieldsPanel.add(lblAge);
        fieldsPanel.add(txtAge);
        fieldsPanel.add(lblNumeroTelephone);
        fieldsPanel.add(txtNumeroTelephone);
        fieldsPanel.add(lblAdresse);
        fieldsPanel.add(txtAdresse);
        fieldsPanel.add(lblSalaire);
        fieldsPanel.add(txtSalaire);
        fieldsPanel.add(lblExperience);
        fieldsPanel.add(txtExperience);
        fieldsPanel.add(lblDisponible);
        fieldsPanel.add(chkDisponible);
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
}
