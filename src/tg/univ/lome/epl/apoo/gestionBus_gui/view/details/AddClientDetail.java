package tg.univ.lome.epl.apoo.gestionBus_gui.view.details;

import javax.swing.*;
import java.awt.*;

public class AddClientDetail extends JPanel {

    private JPanel fieldsPanel = new JPanel();
    private JLabel lblTitre = new JLabel("Ajout d'un nouveau Client");
    private JLabel lblNom;
    private JTextField txtNom;
    private JLabel lblPrenoms;
    private JTextField txtPrenoms;
    private JLabel lblTelephone;
    private JTextField txtTelephone;
    private JLabel lblDepart;
    private JComboBox<String> cmbDepart;
    private JLabel lblArivee;
    private JComboBox<String> cmbArrivee;
    private JLabel lblAdresse;
    private JTextField txtAdresse;
    private JButton btnValider;

    public AddClientDetail() {
        fieldsPanel.setLayout(new GridLayout(7, 2, 10, 10));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        initComponents();
    }

    private void initComponents() {
        lblNom = new JLabel("Nom du Client :");
        txtNom = new JTextField();
        lblPrenoms = new JLabel("Prénoms du Client :");
        txtPrenoms = new JTextField();
        lblTelephone = new JLabel("Téléphone :");
        txtTelephone = new JTextField();
        lblDepart = new JLabel("Arrêt de départ :");
        cmbDepart = new JComboBox<>();
        lblArivee = new JLabel("Arrêt d'arrivé:");
        cmbArrivee = new JComboBox<>();
        lblAdresse = new JLabel("Adresse du Client :");
        txtAdresse = new JTextField();
        btnValider = new JButton("Valider");

        fieldsPanel.add(lblNom);
        fieldsPanel.add(txtNom);
        fieldsPanel.add(lblPrenoms);
        fieldsPanel.add(txtPrenoms);
        fieldsPanel.add(lblTelephone);
        fieldsPanel.add(txtTelephone);
        fieldsPanel.add(lblDepart);
        fieldsPanel.add(cmbDepart);
        fieldsPanel.add(lblArivee);
        fieldsPanel.add(cmbArrivee);
        fieldsPanel.add(lblAdresse);
        fieldsPanel.add(txtAdresse);
        fieldsPanel.add(btnValider);

        // Configurations
        Font arialBold15 = new Font("ARIAL", Font.BOLD, 15);
        setBackground(new Color(93, 173, 226));
        setPreferredSize(new Dimension(getWidth(), 300));
        lblTitre.setForeground(Color.WHITE);
        lblTitre.setFont(arialBold15);

        // Ajout des 2 elements à aligner verticalement
        this.add(lblTitre);
        this.add(fieldsPanel);
    }
}
