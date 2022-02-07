package Views;
import javax.swing.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Dimension;

/**
 * Write a description of class NewGroupView here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NewGroupView extends JPanel implements Observer
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
    
    public NewGroupView(){
        bottomContainerPanel = new JPanel();
        leftPanel = new JPanel();
        seperatorPanel = new JPanel(); 
        buttonsPanel = new JPanel();
        rightPanel = new JPanel();
        credentialsPanel = new JPanel();
        
        title = new JLabel(" New Group");
        
        tableHeaderContacts = new String[]{"Contact Name", "City", "Add to group"};
        
        contactsTableModel = new DefaultTableModel(tableHeaderContacts, 12);
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
        buttonsPanel.add(saveGroup, cancelGroup);
    }    
    
    public void update(Observable o, Object arg){
        this.revalidate();
        this.repaint();
    }
}
