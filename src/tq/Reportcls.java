/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tq;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author rezafta
 */
public class Reportcls implements Initializable {

      @FXML
    private ListView<String> lst;

     
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       
        
        String res=Nettolist.natayej;
        
        String []decode=res.split("-");
        
        
        ObservableList<String> items =FXCollections.observableArrayList ();
        
        for(int a=0;a<decode.length;a++)
        {
            items.add(decode[a].toString());
        }
        
        
        lst.setItems(items);
        
        
       
        
        
        
    }    
    
    
    
    
    
    @FXML
    void close_window(ActionEvent event) throws Exception
    {
            Parent p=FXMLLoader.load(getClass().getResource("Snd_Question.fxml"));
            Scene s=new Scene(p);
            Stage st=(Stage)((Node)event.getSource()).getScene().getWindow();
            st.setScene(s);
            st.initStyle(StageStyle.UNDECORATED);
            st.show();

    }
    
    
    
}
