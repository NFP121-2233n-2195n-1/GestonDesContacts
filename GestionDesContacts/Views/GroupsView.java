package Views;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.Observer;
import java.util.Observable;
import java.util.LinkedHashMap;
import java.util.Map;

public class GroupsView extends JPanel implements Observer{
    private JLabel tablesTitle,title;
    
    private JPanel buttonsPanel;
    private JPanel leftPanel, tablesPanel, rightPanel;
    private JPanel seperatorPanel, bottomContainerPanel, undoRedoPanel;
    
    private JButton addNewGroup, updateGroup, deleteGroup, undoDelete, redoDelete;
    private JButton sortByGroupName, sortByNbOfContacts;    
    
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
        
    
    private LinkedHashMap<Integer, Models.GroupModel> filteredGroups;
    
    public GroupsView(){
        bottomContainerPanel = new JPanel();
        leftPanel = new JPanel();
        seperatorPanel = new JPanel(); 
        buttonsPanel = new JPanel();
        tablesPanel = new JPanel();
        rightPanel = new JPanel();
        undoRedoPanel = new JPanel();
        
        title = new JLabel(" Groups");        
        tablesTitle = new JLabel(" List Of Groups");
          
        tableHeaderGroups = new String[]{"Group ID","Group Name", "Nb of contacts"};
        tableHeaderContacts = new String[]{"Contact Name", "Contact city"};
        
        groupsTableModel = new DefaultTableModel(tableHeaderGroups, 6){
            public boolean isCellEditable(int row, int col){
                switch(col){
                    default: 
                        return false;
                }
            }
        };
        
        groupsTable = new JTable(groupsTableModel);
        groupsScrollPane = new JScrollPane(groupsTable);
        
        contactsTableModel = new DefaultTableModel(tableHeaderContacts, 6){
            public boolean isCellEditable(int row, int col){
                switch(col){
                    default: 
                        return false;
                }
            }
        };
        contactsTable = new JTable(contactsTableModel);
        contactsScrollPane = new JScrollPane(contactsTable);

        addNewGroup = new JButton("Add New Group");
        updateGroup = new JButton("Update Group");
        deleteGroup = new JButton("Delete");
        undoDelete = new JButton("undo delete");
        redoDelete = new JButton("redo delete");
        sortByGroupName = new JButton("sort by group name");
        sortByNbOfContacts = new JButton("sort by number of contacts");
        
        this.setLayout(new BorderLayout());
        this.add(title, BorderLayout.NORTH);
        this.setLayout(new BorderLayout());
        this.add(title, BorderLayout.NORTH);
        this.add(bottomContainerPanel, BorderLayout.CENTER);
        
        bottomContainerPanel.setLayout(new GridLayout(1,3));
        bottomContainerPanel.add(leftPanel);
        bottomContainerPanel.add(seperatorPanel);
        bottomContainerPanel.add(rightPanel);
        
        leftPanel.setLayout(new GridLayout(4,1));
        leftPanel.add(undoRedoPanel);
        leftPanel.add(sortByGroupName);
        leftPanel.add(sortByNbOfContacts);
        leftPanel.add(addNewGroup);
        
        undoRedoPanel.setLayout(new GridLayout(1,2));
        undoRedoPanel.add(undoDelete);
        undoRedoPanel.add(redoDelete);
        
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
        
        fillData();
    }
    
    
    public void fillData(){
        fillGroupsTable();
    }
    
    public void fillGroupsTable(){
        groupsTableModel = new DefaultTableModel(tableHeaderGroups, 0){
            public boolean isCellEditable(int row, int col){
                switch(col){
                    default: 
                        return false;
                }
            }
            
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Integer.class;
                    default:
                        return String.class;
                }
            };
        };
        
        if(filteredGroups == null){
            filteredGroups = Data.Globals.getInstance().getGroups();
        }
        for(Map.Entry<Integer,Models.GroupModel> entry: filteredGroups.entrySet()){
            Models.GroupModel group = entry.getValue();
            this.groupsTableModel.addRow(new Object[] {group.getGroupID(),group.getGroupName(),group.getContactIDs().size()});
        }
        
        groupsTable.setModel(groupsTableModel);
        groupsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        groupsTable.revalidate();
    
        //making IDs hidden
        groupsTable.getColumnModel().getColumn(0).setMinWidth(0);
        groupsTable.getColumnModel().getColumn(0).setMaxWidth(0);
        groupsTable.getColumnModel().getColumn(0).setWidth(0);
        
    }
    
    
    public LinkedHashMap<Integer, Models.GroupModel> getFilteredGroupsMap(){
        return this.filteredGroups;
    }
    
    public void setFilteredGroupsMap(LinkedHashMap<Integer,Models.GroupModel> filteredGroups){
        if(filteredGroups == null) return;
        this.filteredGroups = filteredGroups;
        fillGroupsTable();
    }
    
    
    public JButton getUndoDeleteButton(){return this.undoDelete;}
    public JButton getRedoDeleteButton(){return this.redoDelete;}
    
    public JButton getSortByGroupNameButton(){return this.sortByGroupName;}
    public JButton getSortByNbOfContactsButton(){return this.sortByNbOfContacts;}
    
    public JTable getGroupsTable(){return this.groupsTable;}
    public JTable getContactsTable(){return this.contactsTable;}
    public String[] getTableHeaderContacts(){return this.tableHeaderContacts;}
    
    public JButton getAddNewGroupButton(){return this.addNewGroup;}
    public JButton getUpdateGroupButton(){return this.updateGroup;}
    public JButton getDeleteGroupButton(){return this.deleteGroup;}
    
    public void setContactsTableModel(DefaultTableModel contactsTableModel){
        this.contactsTableModel = contactsTableModel;
        contactsTable.setModel(contactsTableModel);
        contactsTable.revalidate();
    }
    
    public void update(Observable o, Object arg){
        fillGroupsTable();
        this.revalidate();
        this.repaint();
    }
}
