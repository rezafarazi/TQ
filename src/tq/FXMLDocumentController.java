/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tq;

import java.awt.Dialog;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.StageStyle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.web.WebEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import com.jfoenix.controls.*;
import javafx.animation.FadeTransition;
import javafx.util.Duration;

/**
 *
 * @author rezafta
 */
public class FXMLDocumentController implements Initializable {
    
    
    
    @FXML
    private Label txt_lbl;

    @FXML
    private JFXButton no_btn;

    @FXML
    private JFXButton yes_btn;

    @FXML
    private JFXButton newq_btn;
    
    @FXML
    private JFXButton snd_btn_Main_frm;

    
    
    
    //طرح سوالات جدید
    @FXML
    private void newquestions(ActionEvent event) throws Exception 
    {
        
        txt_lbl.setVisible(true);
        yes_btn.setVisible(true);
        no_btn.setVisible(true);
        newq_btn.setVisible(false);
        snd_btn_Main_frm.setVisible(false);

        
        
    }
    
    
    
    //کلیک روی دکمه یس
    @FXML
    void yes_btn_onclick(ActionEvent event) throws Exception
    {
        txt_lbl.setVisible(false);
        yes_btn.setVisible(false);
        no_btn.setVisible(false);
        newq_btn.setVisible(true);
        snd_btn_Main_frm.setVisible(true);

        
        databaseclassTQ db=new databaseclassTQ();
        db.Delte_all_records_on_database();
        
        Parent p=FXMLLoader.load(getClass().getResource("TQQ.fxml"));
        Scene s=new Scene(p);
        Stage st=(Stage)((Node)event.getSource()).getScene().getWindow();
        st.setScene(s);
        st.initStyle(StageStyle.UNDECORATED);
        st.show();
        
        
    }

    
    //کلیک روی دکمه نو
    @FXML
    void no_btn_onclick(ActionEvent event) throws Exception{

        txt_lbl.setVisible(false);
        yes_btn.setVisible(false);
        no_btn.setVisible(false);
        newq_btn.setVisible(true);
        snd_btn_Main_frm.setVisible(true);
        
        Parent p=FXMLLoader.load(getClass().getResource("TQQ.fxml"));
        Scene s=new Scene(p);
        Stage st=(Stage)((Node)event.getSource()).getScene().getWindow();
        st.setScene(s);
        st.initStyle(StageStyle.UNDECORATED);
        st.show();
    }
    
    
    
    
    
    //خروج از برنامه
    @FXML
    void Ext(ActionEvent event) {
        
        System.exit(0);
        
    }
    
    
    
    
    
    
    
    
    
    
    ///////////کلیک روی دکمه ارسال سوالات
    @FXML
    void onclick_snd_btn(ActionEvent event)throws Exception
    {
        
        Parent p=FXMLLoader.load(getClass().getResource("Snd_Question.fxml"));
        Scene s=new Scene(p);
        Stage st=(Stage)((Node)event.getSource()).getScene().getWindow();
        st.setScene(s);
        st.initStyle(StageStyle.UNDECORATED);
        st.show();

    }
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       
        
    }    
    
}
