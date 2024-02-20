package tg.univ.lome.epl.apoo.gestionBus_gui.view.details;

import javax.swing.*;
import java.awt.*;

public class AddItineraireDetail extends JPanel {

    private JPanel fieldsPanel = new JPanel();
    private JLabel lblTitre = new JLabel("Ajout d'un nouvel Itinéraire");
    private JLabel lblLigne;
    private JComboBox<String> cmbLigne;
    private JLabel lblPointDepart;
    private JComboBox<String> cmbPointDepart;
    private JLabel lblPointArrivee;
    private JComboBox<String> cmbPointArrivee;
    private JLabel lblDistance;
    private JTextField txtDistance;
    private JButton btnValider;

    // Ctor
    public AddItineraireDetail() {

        fieldsPanel.setLayout(new GridLayout(5, 2, 10, 10));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        initComponents();
    }

    private void initComponents() {
        lblLigne = new JLabel("Ligne :");
        cmbLigne = new JComboBox<>();
        lblPointDepart = new JLabel("Point de Départ :");
        cmbPointDepart = new JComboBox<>();
        lblPointArrivee = new JLabel("Point d'Arrivée :");
        cmbPointArrivee = new JComboBox<>();
        lblDistance = new JLabel("Distance Totale :");
        txtDistance = new JTextField();
        btnValider = new JButton("Valider");

        fieldsPanel.add(lblLigne);
        fieldsPanel.add(cmbLigne);
        fieldsPanel.add(lblPointDepart);
        fieldsPanel.add(cmbPointDepart);
        fieldsPanel.add(lblPointArrivee);
        fieldsPanel.add(cmbPointArrivee);
        fieldsPanel.add(lblDistance);
        fieldsPanel.add(txtDistance);
        fieldsPanel.add(btnValider);

        // Configurations
        Font arialBold15 = new Font("ARIAL", Font.BOLD, 15);
        setBackground(new Color(93, 173, 226));
        setPreferredSize(new Dimension(getWidth(), 200));
        lblTitre.setForeground(Color.WHITE);
        lblTitre.setFont(arialBold15);

        // Ajout des 2 elements à aligner verticalement
        this.add(lblTitre);
        this.add(fieldsPanel);
    }
}
