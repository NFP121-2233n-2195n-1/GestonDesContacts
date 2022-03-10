package Views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.util.Observer;
import java.util.Observable;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.util.Map;
import java.util.LinkedHashMap;

/**
 * Write a description of class UpdateContactUpdate here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class UpdateContactView extends JPanel implements Observer
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
    
    private Models.ContactModel model;
    
    private JButton saveButton,cancelButton;
    
    
    /**
     * Constructor for objects of class UpdateContactsView
     */
    public UpdateContactView(Models.ContactModel model)
    {
        this.model = model;
        title = new JLabel(" Update Contact");
        
        leftPanel = new JPanel();
        seperatorPanel = new JPanel();
        rightPanel = new JPanel();
        bottomContainerPanel = new JPanel();
        groupsPanel = new JPanel();
        credentialsPanel = new JPanel();
        tablePanel = new JPanel();
        middleRightPanel = new JPanel();
        buttonsPanel = new JPanel();
        
        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");
        
        firstNameLabel = new JLabel("First Name");
        lastNameLabel = new JLabel("Last Name");
        cityLabel = new JLabel("City");
        firstNameText = new JTextField();
        lastNameText = new JTextField();
        cityText = new JTextField();
        
        titleGroup = new JLabel("Contact Groups");
        
        tableTitle = new JLabel("Phone numbers");
        tableHeader = new String[]{"Region Code", "Phone Number"};
        tableModel = new DefaultTableModel(tableHeader, 4){
            @Override
            public boolean isCellEditable(int row, int column) {
               //all cells false
               return true;
            };
        };
        
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
        
        initialiseInterface();
        
        fillData();
        
        /*A completer ajouter les groups*/
    }
    
    public void fillData(){
        firstNameText.setText(this.model.getFirstName());
        lastNameText.setText(this.model.getLastName());
        cityText.setText(this.model.getCity());
        
        //set phone numbers in table model
        LinkedHashMap<Integer,Models.PhoneNumber> phoneNumbers = this.model.getPhoneNumbers();
        if(phoneNumbers!=null){
            
            this.tableModel = new DefaultTableModel(tableHeader, 0){
                @Override
                public boolean isCellEditable(int row, int column) {
                   //all cells false
                   return true;
                };
            };
            
            for(Map.Entry<Integer,Models.PhoneNumber> entry: phoneNumbers.entrySet()){
                Models.PhoneNumber pn = entry.getValue();
                this.tableModel.addRow(new Object[] {pn.getRegionCode(), pn.getPhoneNumber()});
            }
        }
        table.setModel(tableModel);
        table.revalidate();
        /*A completer set groups */
    }
    
    public void initialiseInterface(){}
    
    
    
    //add function to get groups
    
    public JTextField getFirstNameTextField(){return this.firstNameText;}
    public JTextField getLastNameTextField(){return this.lastNameText;}
    public JTextField getCityTextField(){return this.cityText;}
    public JTable getTable(){return this.table;}
    public DefaultTableModel getTableModel(){return this.tableModel;}
    public JButton getSaveButton(){return this.saveButton;}
    public JButton getCancelButton(){return this.cancelButton;}
    
    public void update(Observable o, Object arg){
        this.revalidate();
        this.repaint();
    }
}
