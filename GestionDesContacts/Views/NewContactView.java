package Views;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.util.Observer;
import java.util.Observable;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Dimension;


/**
 * Write a description of class NewContactView here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NewContactView extends JPanel implements Observer
{
    private JLabel title;
    private JPanel leftPanel, seperatorPanel, rightPanel, middleRightPanel;
    private JPanel tablePanel, buttonsPanel;
    private JPanel groupsPanel, credentialsPanel, bottomContainerPanel;
    
    private JLabel firstNameLabel, lastNameLabel, cityLabel;
    private JTextField firstNameText, lastNameText, cityText;
    
    private JLabel tableTitle;
    private DefaultTableModel tableModel;
    private JTable table;
    private JScrollPane scrollPane;
    private TableColumn columnRegionCode, columnPhoneNumber;
    private String[] tableHeader;
    
    private JLabel titleGroup;
    private JButton saveButton, cancelButton;
    
    public NewContactView(){
        title = new JLabel(" New Contact");
        
        leftPanel = new JPanel();
        seperatorPanel = new JPanel();
        rightPanel = new JPanel();
        bottomContainerPanel = new JPanel();
        groupsPanel = new JPanel();
        credentialsPanel = new JPanel();
        tablePanel = new JPanel();
        buttonsPanel = new JPanel();
        middleRightPanel = new JPanel();
        
        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");
        
        firstNameLabel = new JLabel("First Name");
        lastNameLabel = new JLabel("Last Name");
        cityLabel = new JLabel("City");
        firstNameText = new JTextField();
        lastNameText = new JTextField();
        cityText = new JTextField();
        
        titleGroup = new JLabel("Add the contact to Groups");
        
        tableTitle = new JLabel("Phone numbers");
        tableHeader = new String[]{"Region Code", "Phone Number"};
        tableModel = new DefaultTableModel(tableHeader, 4);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        
        this.setLayout(new BorderLayout());
        this.add(title, BorderLayout.NORTH);
        this.add(bottomContainerPanel, BorderLayout.CENTER);
        
        bottomContainerPanel.setLayout(new GridLayout(1,3));
        bottomContainerPanel.add(leftPanel);
        bottomContainerPanel.add(seperatorPanel);
        bottomContainerPanel.add(rightPanel);
        
        seperatorPanel.setSize(new Dimension(this.getHeight(), 100));
        seperatorPanel.setBackground(Data.Globals.getDarkBlueColor());
        title.setFont(Data.Globals.getBigFont());
        
        rightPanel.setLayout(new BorderLayout());
        rightPanel.add(credentialsPanel, BorderLayout.NORTH);
        rightPanel.add(middleRightPanel, BorderLayout.CENTER);
        rightPanel.add(buttonsPanel, BorderLayout.SOUTH);
        
        credentialsPanel.setLayout(new GridLayout(3,2));
        
        credentialsPanel.add(firstNameLabel);
        credentialsPanel.add(firstNameText);
        credentialsPanel.add(lastNameLabel);
        credentialsPanel.add(lastNameText);
        credentialsPanel.add(cityLabel);
        credentialsPanel.add(cityText);
        
        middleRightPanel.setLayout(new GridLayout(2,1));
        middleRightPanel.add(tablePanel);
        middleRightPanel.add(groupsPanel);
        
        tablePanel.setLayout(new BorderLayout());
        tablePanel.add(tableTitle, BorderLayout.NORTH);
        tablePanel.add(scrollPane, BorderLayout.CENTER);
        
        groupsPanel.setLayout(new BorderLayout());
        groupsPanel.add(titleGroup, BorderLayout.NORTH);
        
        buttonsPanel.setLayout(new GridLayout(1,2));
        buttonsPanel.add(saveButton);
        buttonsPanel.add(cancelButton);
    }
    
    public void update(Observable o, Object arg){
        this.revalidate();
        this.repaint();
    }
    
    public JTextField getFirstNameTextField(){return this.firstNameText;}
    public JTextField getLastNameTextField(){return this.lastNameText;}
    public JTextField getCityTextField(){return this.cityText;}
    public JTable getTable(){return this.table;}
    public JButton getSaveButton(){return this.saveButton;}
    public JButton getCancelButton(){return this.cancelButton;}
}
