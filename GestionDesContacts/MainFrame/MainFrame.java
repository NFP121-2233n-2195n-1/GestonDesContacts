package MainFrame;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Insets;

import javax.swing.*;
import java.awt.Color;

/**
 * Write a description of class MainFrame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MainFrame extends JFrame
{
    private JPanel currentPanel;
    
    private JMenuBar menuBar;
    private JMenu contacts, groups;
    private JMenuItem createContact, createGroup, listContacts, listGroups;
    
    private static MainFrame instance = new MainFrame();
    
    MainFrame(){
        
        menuBar = new JMenuBar();
        contacts = new JMenu("Contacts");
        groups = new JMenu("Groups");
        createContact = new JMenuItem("New");
        createGroup = new JMenuItem("New");
        listContacts = new JMenuItem("List Contacts");
        listGroups = new JMenuItem("List Groups");
        
        
        this.setJMenuBar(menuBar);
        menuBar.add(contacts);
        menuBar.add(groups);
        contacts.add(createContact);
        groups.add(createGroup);
        contacts.add(listContacts);
        groups.add(listGroups);
        
        if(currentPanel == null){currentPanel = new JPanel();}
        this.add(currentPanel);
        
        createContact.addActionListener(new Actions.ContactActions.OpenNewContact());
        listContacts.addActionListener(new Actions.ContactActions.OpenContacts());
    
        setCustomDesign();
        setMyFontToAllComponents();
        
        this.setVisible(true);
        this.pack();
        this.setSize(new Dimension(800,400));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void setCurrentPanel(JPanel currentPanel){
        this.getContentPane().removeAll();
        this.currentPanel = currentPanel;
        
        this.getContentPane().add(currentPanel);
        this.revalidate();
        this.pack();
        this.setSize(new Dimension(800,400));
        this.setVisible(true);
    }
    
    public JPanel getCurrentPanel(){return this.currentPanel;}
    
    public static MainFrame getInstance(){
        return instance;
    }
    
       
    public void setCustomDesign() {
        UIManager.put("Panel.background", Color.white);
        UIManager.put("Button.background",Data.Globals.getLightBlueColor());
        UIManager.put("Button.preferredsize",new Dimension(300,20));
        UIManager.put("Button.size", new Dimension(200,30) );
    }
    
    
    public void setMyFontToAllComponents() {
        UIManager.put("Label.font", Data.Globals.getFont());
        UIManager.put("TextField.font", Data.Globals.getFont());
        UIManager.put("TabbedPane.font", Data.Globals.getFont());
        UIManager.put("Button.font", Data.Globals.getFont());
        UIManager.put("TitledBorder.font", Data.Globals.getFont());
    }
}