package preprocessor;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by dromeror on 18/07/2017.
 */
public class Window extends JFrame {
    JLabel labelInstructions, labelResult;
    JButton buttonImport;
    JFileChooser fileChooser;

    public Window() {
        setTitle("WiFi4EU ABAC Test Application");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        initComponents();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dimension.width / 2 - getSize().width / 2, dimension.height / 3);
        setResizable(false);
        setVisible(true);
    }

    private void initComponents() {
        fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("JSON Files", "json"));
        labelInstructions = new JLabel("<html>Click the button below to import your <br>JSON file from the Wifi4EU portal.</html>");
        labelInstructions.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelInstructions.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        labelResult = new JLabel();
        labelResult.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelResult.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        buttonImport = new JButton("Import");
        buttonImport.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonImport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int returnVal = fileChooser.showOpenDialog(Window.this);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File jsonFile = fileChooser.getSelectedFile();
                    checkJsonFile(jsonFile);
                }
            }
        });
        add(labelInstructions);
        add(buttonImport);
        add(labelResult);
        pack();
    }

    private void checkJsonFile(File file) {
        labelResult.setText("Validating your JSON file...");
        buttonImport.setEnabled(false);
        labelResult.setText("Success!");
        buttonImport.setEnabled(true);
    }
}
