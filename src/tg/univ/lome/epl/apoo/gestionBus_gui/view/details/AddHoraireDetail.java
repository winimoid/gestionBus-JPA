package tg.univ.lome.epl.apoo.gestionBus_gui.view.details;

import javax.swing.*;
import java.awt.*;

public class AddHoraireDetail extends JPanel {

    private JPanel fieldsPanel = new JPanel();
    private JLabel lblTitre = new JLabel("Ajout d'un nouvel Horaire de Travail");
    private JLabel lblJourTravail;
    private JComboBox<String> cmbJourTravail;
    private JLabel lblHeureDebut;
    private JTextField txtHeureDebut;
    private JLabel lblMinuteDebut;
    private JTextField txtMinuteDebut;
    private JLabel lblHeureFin;
    private JTextField txtHeureFin;
    private JLabel lblMinuteFin;
    private JTextField txtMinuteFin;
    private JLabel lblConducteur;
    private JComboBox<String> cmbConducteur;
    private JButton btnValider;

    public AddHoraireDetail() {
        fieldsPanel.setLayout(new GridLayout(7, 2, 10, 10));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        initComponents();
    }

    private void initComponents() {
        lblJourTravail = new JLabel("Jour de Travail :");
        cmbJourTravail = new JComboBox<>();
        lblHeureDebut = new JLabel("Heure de Début :");
        txtHeureDebut = new JTextField();
        lblMinuteDebut = new JLabel("Minute de Début :");
        txtMinuteDebut = new JTextField();
        lblHeureFin = new JLabel("Heure de Fin :");
        txtHeureFin = new JTextField();
        lblMinuteFin = new JLabel("Minute de Fin :");
        txtMinuteFin = new JTextField();
        lblConducteur = new JLabel("Conducteur :");
        cmbConducteur = new JComboBox<>();
        btnValider = new JButton("Valider");

        fieldsPanel.add(lblJourTravail);
        fieldsPanel.add(cmbJourTravail);
        fieldsPanel.add(lblHeureDebut);
        fieldsPanel.add(txtHeureDebut);
        fieldsPanel.add(lblHeureFin);
        fieldsPanel.add(txtHeureFin);
        fieldsPanel.add(lblMinuteDebut);
        fieldsPanel.add(txtMinuteDebut);
        fieldsPanel.add(lblMinuteFin);
        fieldsPanel.add(txtMinuteFin);
        fieldsPanel.add(lblConducteur);
        fieldsPanel.add(cmbConducteur);
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
