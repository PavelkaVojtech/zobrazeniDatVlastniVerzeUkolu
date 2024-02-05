import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame{
    private JTextArea textArea1;
    private JCheckBox zakoupenoCheckBox;
    private JRadioButton neoblibeneRadioButton;
    private JRadioButton oblibeneRadioButton;
    private JRadioButton nejviceOblibeneRadioButton;
    private JButton predchoziButton;
    private JButton ulozitButton;
    private JButton dalsiButton;
    private JPanel panelMain;
    private int indexAktualniDeskovky = 0;
    private EvidenceDeskovek evidenceDeskovek = new EvidenceDeskovek();

    public GUI(){
        initComponents();
        ukazDeskovku(indexAktualniDeskovky);
        dalsiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (indexAktualniDeskovky < evidenceDeskovek.getSeznamDeskovek().size() - 1){
                    indexAktualniDeskovky++;
                }
                ukazDeskovku(indexAktualniDeskovky);
            }
        });
        predchoziButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (indexAktualniDeskovky > 0){
                    indexAktualniDeskovky--;
                }
                ukazDeskovku(indexAktualniDeskovky);
            }
        });
        ulozitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nazevNoveDeskovky = textArea1.getText();
                boolean koupeno = zakoupenoCheckBox.isSelected();
                int oblibenost = 1;
                if (neoblibeneRadioButton.isSelected()){
                    oblibenost = 1;
                }
                if (oblibeneRadioButton.isSelected()){
                    oblibenost = 2;
                }
                if (nejviceOblibeneRadioButton.isSelected()){
                    oblibenost = 3;
                }
                evidenceDeskovek.getSeznamDeskovek().add(new Deskovka(nazevNoveDeskovky, koupeno, oblibenost));
            }
        });
    }

    private void initComponents() {
        setContentPane(panelMain);
        setTitle("Deskovky");
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    private void ukazDeskovku(int indexAktualniDeskovky){
        Deskovka aktualniDeskovka = evidenceDeskovek.getDeskovka(indexAktualniDeskovky);
        textArea1.setText(aktualniDeskovka.getNazevDeskovky());
        zakoupenoCheckBox.setSelected(aktualniDeskovka.isKoupeno());
        int oblibenost;
        if (aktualniDeskovka.getOblibenost() == 1){
            neoblibeneRadioButton.setSelected(true);
        }
        else if (aktualniDeskovka.getOblibenost() == 2){
            oblibeneRadioButton.setSelected(true);
        }
        else if (aktualniDeskovka.getOblibenost() == 3){
            nejviceOblibeneRadioButton.setSelected(true);
        }
    }
}
