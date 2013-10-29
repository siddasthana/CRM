/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

/**
 *
 * @author admin
 */
public class DirectorySearch {
    //Fields
    String Area, District, Service;

    public DirectorySearch() {
    Area = District = Service = "%";
    }
    
    public String getinfo(){
    /**
        String Query = "Select * From TableName where Area Like" + " '%" + Area + "%'  and" ;
        Query += " District Like" + " '%" + District + "%' And ";
        Query += "Service Like" + " '%" + Service + "%' ";
       */ 
        
        return "No Value Found";
    }
}
