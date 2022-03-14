package Views;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.util.Observer;
import java.util.Observable;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.util.LinkedHashMap;
import java.util.Map;

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
    private JPanel tablePanel, buttonsPanel, tableTitlePanel;
    private JPanel groupsPanel, credentialsPanel, bottomContainerPanel;
    
    private JLabel firstNameLabel, lastNameLabel, cityLabel;
    private JTextField firstNameText, lastNameText, cityText;
    
    private JLabel tableTitle;
    private DefaultTableModel tableModel, groupsTableModel;
    private JTable table, groupsTable;
    private JScrollPane scrollPane, groupsScrollPane;
    private String[] tableHeader;
    
    private JLabel titleGroup;
    private JButton saveButton, cancelButton, addPhoneNumberButton;
    
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
        tableTitlePanel = new JPanel();
        
        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");
        addPhoneNumberButton = new JButton("Add");
        
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
        
        groupsTableModel = new DefaultTableModel();
        groupsTable = new JTable(groupsTableModel);
        groupsScrollPane = new JScrollPane(groupsTable);
        
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
        tablePanel.add(tableTitlePanel, BorderLayout.NORTH);
        tablePanel.add(scrollPane, BorderLayout.CENTER);
        
        tableTitlePanel.setLayout(new GridLayout(1,2));
        tableTitlePanel.add(tableTitle);
        tableTitlePanel.add(addPhoneNumberButton);
        
        groupsPanel.setLayout(new BorderLayout());
        groupsPanel.add(titleGroup, BorderLayout.NORTH);
        groupsPanel.add(groupsScrollPane, BorderLayout.CENTER);
        
        buttonsPanel.setLayout(new GridLayout(1,2));
        buttonsPanel.add(saveButton);
        buttonsPanel.add(cancelButton);
        
        fillData();
    }
    
    public void update(Observable o, Object arg){
        this.revalidate();
        this.repaint();
    }
    
    public void fillData(){
        fillGroup();
    }
    
    public void fillGroup(){
        groupsTableModel = new DefaultTableModel(new String[]{"","",""},0){
            public boolean isCellEditable(int row, int col){
                switch(col){
                    case 1:
                        return true;
                    default: 
                        return false;
                }
            }
            
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Integer.class;
                    case 1:
                        return Boolean.class;
                    default:
                        return String.class;
                }
            };
        };
        
        
        LinkedHashMap<Integer,Models.GroupModel> groups = Data.Globals.getInstance().getGroups();
        for(Map.Entry<Integer,Models.GroupModel> entry: groups.entrySet()){
            Models.GroupModel group = entry.getValue();
            //groupID || isContactInGroup? || groupName
            this.groupsTableModel.addRow(new Object[] {group.getGroupID(),false,group.getGroupName()});
        }
        
        groupsTable.setModel(groupsTableModel);
        groupsTable.revalidate();
        
        
        //removing border of table
        groupsTable.setShowGrid(false);
    
        //making IDs hidden
        groupsTable.getColumnModel().getColumn(0).setMinWidth(0);
        groupsTable.getColumnModel().getColumn(0).setMaxWidth(0);
        groupsTable.getColumnModel().getColumn(0).setWidth(0);
        
    }
    
    public void clearInputs(){
        this.firstNameText.setText("");
        this.lastNameText.setText("");
        this.cityText.setText("");
        
        //reset phone number table
        this.tableModel = new DefaultTableModel(tableHeader, 4);
        table.setModel(tableModel);
        table.revalidate();

        //this will reset values to false
        fillGroup();
    }
    
    public JButton getAddPhoneNumberButton(){return this.addPhoneNumberButton;}
    
    public JTextField getFirstNameTextField(){return this.firstNameText;}
    public JTextField getLastNameTextField(){return this.lastNameText;}
    public JTextField getCityTextField(){return this.cityText;}
    
    public JTable getTable(){return this.table;}
    public DefaultTableModel getTableModel(){return this.tableModel;}
    public JTable getGroupsTable(){return this.groupsTable;}
    public DefaultTableModel getGroupsTableModel(){return this.groupsTableModel;}
    
    public JButton getSaveButton(){return this.saveButton;}
    public JButton getCancelButton(){return this.cancelButton;}
}
