package Views;
import javax.swing.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Dimension;


/**
 * Write a description of class UpdateGroupView here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class UpdateGroupView extends JPanel implements Observer
{
    private JLabel title;
    
    private JPanel buttonsPanel;
    private JPanel leftPanel, rightPanel, credentialsPanel;
    private JPanel seperatorPanel, bottomContainerPanel;
    
    private JButton saveGroup;
    private JButton cancelGroup;
    
    private JLabel groupNameLabel, groupDescriptionLabel;
    private JTextField groupNameText, groupDescriptionText;
    
    private JTable contactsTable;
    private DefaultTableModel contactsTableModel;
    private JScrollPane contactsScrollPane;
    private TableColumn columnContactName;
    private TableColumn columnCity;
    private TableColumn columnAddToGroup;
    private String[] tableHeaderContacts;
    
    private Models.GroupModel model;
    
    public UpdateGroupView(Models.GroupModel model){
        this.model = model;
        
        bottomContainerPanel = new JPanel();
        leftPanel = new JPanel();
        seperatorPanel = new JPanel(); 
        buttonsPanel = new JPanel();
        rightPanel = new JPanel();
        credentialsPanel = new JPanel();
        
        title = new JLabel(" Update Group");
        
        tableHeaderContacts = new String[]{"ID","Contact Name", "City", "Add to group"};
        
        contactsTableModel = new DefaultTableModel(tableHeaderContacts, 0);
        contactsTable = new JTable(contactsTableModel);
        contactsScrollPane = new JScrollPane(contactsTable);
        
        saveGroup = new JButton("Save Group");
        cancelGroup = new JButton("Cancel");
        
        groupNameLabel = new JLabel("Group Name");
        groupDescriptionLabel = new JLabel("Description");
        groupNameText = new JTextField();
        groupDescriptionText = new JTextField();
        
        this.setLayout(new BorderLayout());
        this.add(title, BorderLayout.NORTH);
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
        rightPanel.add(contactsScrollPane, BorderLayout.CENTER);
        rightPanel.add(buttonsPanel, BorderLayout.SOUTH);
        
        credentialsPanel.setLayout(new GridLayout(2,2));
        credentialsPanel.add(groupNameLabel);
        credentialsPanel.add(groupNameText);
        credentialsPanel.add(groupDescriptionLabel);
        credentialsPanel.add(groupDescriptionText);
        
        buttonsPanel.setLayout(new GridLayout(1,2));
        buttonsPanel.add(saveGroup);
        buttonsPanel.add(cancelGroup);
        
        initialiseInterface();
        fillData();
    }
    
    public JButton getSaveGroupButton(){return this.saveGroup;}
    public JButton getCancelGroupButton(){return this.cancelGroup;}
    
    public JTextField getGroupNameTextField(){return this.groupNameText;}
    public JTextField getGroupDescriptionTextField(){return this.groupDescriptionText;}
    
    public JTable getContactsTable(){return this.contactsTable;}
    public DefaultTableModel getContactsTableModel(){return this.contactsTableModel;}
    
    public void initialiseInterface(){}
    
    public void fillData(){
        groupNameText.setText(model.getGroupName());
        groupDescriptionText.setText(model.getGroupDescription());
        setContactsInTable();
    }
    
    public void setContactsInTable(){
        contactsTableModel = new DefaultTableModel(tableHeaderContacts,0){
            public boolean isCellEditable(int row, int col){
                switch(col){
                    case 0:
                    case 1:
                    case 2:
                        return false;
                    default: 
                        return true;
                }
            }
            
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Integer.class;
                    case 1:
                    case 2:
                        return String.class;
                    default:
                        return Boolean.class;
                }
            };
        };

        //get all contacts
        LinkedHashMap<Integer,Models.ContactModel> contacts = Data.Globals.getInstance().getContacts();
        
        //get contacts ids in the chosen group
        ArrayList<Integer> list = model.getContactIDs();
        
        for(Map.Entry<Integer,Models.ContactModel> entry: contacts.entrySet()){
            Models.ContactModel contact = entry.getValue();
            boolean isContactInGroup = list.contains(contact.getContactID())==true;
            this.contactsTableModel.addRow(new Object[] {contact.getContactID(),contact.getFirstName()+" "+contact.getLastName(),contact.getCity(),isContactInGroup});
        }
        
        contactsTable.setModel(contactsTableModel);
        contactsTable.revalidate();

        //making IDs hidden
        contactsTable.getColumnModel().getColumn(0).setMinWidth(0);
        contactsTable.getColumnModel().getColumn(0).setMaxWidth(0);
        contactsTable.getColumnModel().getColumn(0).setWidth(0);

    }
    
    public void update(Observable o, Object arg){
        setContactsInTable();
        this.revalidate();
        this.repaint();
    }
}
