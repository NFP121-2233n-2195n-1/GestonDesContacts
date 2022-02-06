package Views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Color;
import java.util.Observer;
import java.util.Observable;
import javax.swing.DefaultListModel;
import java.util.Map;
import java.util.Iterator;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

/**
 * Write a description of class ContactsView here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ContactsView extends JPanel implements Observer
{
    private JLabel title;
    private JPanel leftPanel, seperatorPanel, rightPanel, buttonsPanel, bottomContainerPanel, searchPanel;
    
    private JButton searchButton;
    private JTextField searchInput;
    
    private JButton sortByFirstName, sortByLastName, sortByCity;
    private JButton addNewContact;
    
    private JButton viewContact, updateContact, deleteContact;
    
    private JList<Models.ContactModel> contactsList;
    private DefaultListModel contactsListModel;
    
    private Map<Integer, Models.ContactModel> filteredContacts;
    
    public ContactsView(){
        //init variables
        title = new JLabel(" Contacts");
        
        leftPanel = new JPanel();
        seperatorPanel = new JPanel();
        rightPanel = new JPanel();
        bottomContainerPanel = new JPanel();
        searchPanel = new JPanel();
        buttonsPanel = new JPanel();
        
        searchButton = new JButton("search");
        searchInput = new JTextField(10);
        
        sortByFirstName = new JButton("sort by first name");
        sortByLastName = new JButton("sort by last name");
        sortByCity = new JButton("sort by city");
        
        addNewContact = new JButton("add new contact");
        
        viewContact = new JButton("View");
        updateContact = new JButton("Update");
        deleteContact = new JButton("Delete");
        
        contactsList = new JList();
        contactsListModel = new DefaultListModel();
        contactsList.setModel(contactsListModel);

        //layout
        this.setLayout(new BorderLayout());
        this.add(title, BorderLayout.NORTH);
        this.add(bottomContainerPanel, BorderLayout.CENTER);
        
        bottomContainerPanel.setLayout(new GridLayout(1,3));
        bottomContainerPanel.add(leftPanel);
        bottomContainerPanel.add(seperatorPanel);
        bottomContainerPanel.add(rightPanel);
        
        leftPanel.setLayout(new GridLayout(4,1));
        leftPanel.setPreferredSize(new Dimension(200,400));
        leftPanel.add(sortByFirstName);
        leftPanel.add(sortByLastName);
        leftPanel.add(sortByCity);
        leftPanel.add(addNewContact);
        
        seperatorPanel.setSize(new Dimension(this.getHeight(), 100));
        seperatorPanel.setBackground(Data.Globals.getDarkBlueColor());
        title.setFont(Data.Globals.getBigFont());
        
        searchPanel.setLayout(new GridLayout(2,1));
        searchPanel.add(searchInput);
        searchPanel.add(searchButton);
        rightPanel.setLayout(new BorderLayout());
        rightPanel.add(searchPanel,BorderLayout.NORTH);
        rightPanel.add(contactsList,BorderLayout.CENTER);
        rightPanel.add(buttonsPanel,BorderLayout.SOUTH);
        
        buttonsPanel.setLayout(new GridLayout(1,3));
        buttonsPanel.add(viewContact);
        buttonsPanel.add(updateContact);
        buttonsPanel.add(deleteContact);
        
        setDataInList(null);
    }
    
    public JButton getSearchButton(){return this.searchButton;}
    
    public void setDataInList(Map<Integer, Models.ContactModel> filteredContacts){
        if(filteredContacts  == null) filteredContacts = Data.Globals.getInstance().getContacts();
        this.filteredContacts = filteredContacts;
        contactsListModel= new DefaultListModel();
        Iterator it = filteredContacts.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Integer,Models.ContactModel> pair = (Map.Entry<Integer,Models.ContactModel>) it.next();
            contactsListModel.addElement(pair.getValue());
        }
        
        contactsList.setModel(contactsListModel);
        contactsList.revalidate();
    }   
    
    public void addSearchActionListener(ActionListener a){
        this.searchButton.addActionListener(a);
    }
    
    public void update(Observable o, Object arg){
        setDataInList(null);
        this.revalidate();
        this.repaint();
    }
}
