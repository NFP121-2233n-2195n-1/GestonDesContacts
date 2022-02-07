package Views;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.Observer;
import java.util.Observable;

public class GroupsView extends JPanel implements Observer{
    private JLabel tablesTitle,title;
    
    private JPanel buttonsPanel;
    private JPanel leftPanel, tablesPanel, rightPanel;
    private JPanel seperatorPanel, bottomContainerPanel;
    
    private JButton addNewGroup;
    private JButton updateGroup;
    private JButton deleteGroup;
        
    private DefaultTableModel groupsTableModel;
    private JTable groupsTable;
    private JScrollPane groupsScrollPane;
    private TableColumn columnNbOfContacts;
    private DefaultTableModel contactsTableModel;
    private String[] tableHeaderGroups;
    
    private JTable contactsTable;
    private JScrollPane contactsScrollPane;
    private TableColumn columnContactName;
    private TableColumn columnContactCity;
    private String[] tableHeaderContacts;
        
    public GroupsView(){
        bottomContainerPanel = new JPanel();
        leftPanel = new JPanel();
        seperatorPanel = new JPanel(); 
        buttonsPanel = new JPanel();
        tablesPanel = new JPanel();
        rightPanel = new JPanel();
        
        title = new JLabel(" Groups");        
        tablesTitle = new JLabel(" List Of Groups");
          
        tableHeaderGroups = new String[]{"Group Name", "Nb of contacts"};
        tableHeaderContacts = new String[]{"Contact Name", "Contact city"};
        
        groupsTableModel = new DefaultTableModel(tableHeaderGroups, 6);
        groupsTable = new JTable(groupsTableModel);
        groupsScrollPane = new JScrollPane(groupsTable);
        
        contactsTableModel = new DefaultTableModel(tableHeaderContacts, 6);
        contactsTable = new JTable(contactsTableModel);
        contactsScrollPane = new JScrollPane(contactsTable);

        addNewGroup = new JButton("Add New Group");
        updateGroup = new JButton("Update Group");
        deleteGroup = new JButton("Delete");
        
        this.setLayout(new BorderLayout());
        this.add(title, BorderLayout.NORTH);
        this.setLayout(new BorderLayout());
        this.add(title, BorderLayout.NORTH);
        this.add(bottomContainerPanel, BorderLayout.CENTER);
        
        bottomContainerPanel.setLayout(new GridLayout(1,3));
        bottomContainerPanel.add(leftPanel);
        bottomContainerPanel.add(seperatorPanel);
        bottomContainerPanel.add(rightPanel);
        
        leftPanel.setLayout(new GridLayout(1,1));
        leftPanel.add(addNewGroup);
        
        seperatorPanel.setSize(new Dimension(this.getHeight(), 100));
        seperatorPanel.setBackground(Data.Globals.getDarkBlueColor());
        title.setFont(Data.Globals.getBigFont());
        
        rightPanel.setLayout(new BorderLayout());
        rightPanel.add(tablesTitle, BorderLayout.NORTH);
        rightPanel.add(tablesPanel, BorderLayout.CENTER);
        rightPanel.add(buttonsPanel, BorderLayout.SOUTH);
        
        tablesPanel.setLayout(new GridLayout(2,1));
        tablesPanel.add(groupsScrollPane);
        tablesPanel.add(contactsScrollPane);
        
        buttonsPanel.setLayout(new GridLayout(1,2));
        buttonsPanel.add(updateGroup);
        buttonsPanel.add(deleteGroup);
    }
    
    public void update(Observable o, Object arg){
        this.revalidate();
        this.repaint();
    }
}
