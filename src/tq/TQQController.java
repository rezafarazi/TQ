/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tq;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import com.jfoenix.controls.*;

/**
 * FXML Controller class
 *
 * @author rezafta
 */
public class TQQController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    
    
    
    
    
    
    //اشیاء داخل صفحه
    @FXML
    private JFXRadioButton jvbr4;

    @FXML
    private JFXRadioButton jvbr1;

    @FXML
    private JFXTextField jvb1;

    @FXML
    private JFXRadioButton jvbr2;

    @FXML
    private JFXRadioButton jvbr3;

    @FXML
    private JFXTextField jvb3;

    @FXML
    private JFXTextField quest;

    @FXML
    private JFXTextField jvb2;

    @FXML
    private JFXTextField jvb4;
    
    
    
    
    
    
    
    
    
    
    
    
    //برای بستن فرم ورود سوالات جدید
    @FXML
    void ClsInsert(ActionEvent event) throws IOException 
    {
        Parent p=FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene s=new Scene(p);
        Stage st=(Stage)((Node)event.getSource()).getScene().getWindow();
        st.setScene(s);
        st.show();
        
    }
    
    
    
    
    
    //کلیک روی دکمه بعدی
    @FXML
    void nxt_btn_click(ActionEvent event)
    {
        
        String jvbb="0";
        
        if(jvbr1.isSelected()||jvbr2.isSelected()||jvbr3.isSelected()||jvbr4.isSelected())
        {
        if(jvbr1.isSelected())
            jvbb="1";
        if(jvbr2.isSelected())
            jvbb="2";
        if(jvbr3.isSelected())
            jvbb="3";
        if(jvbr4.isSelected())
            jvbb="4";
        
        
        databaseclassTQ l=new databaseclassTQ();
        l.Insert_value_to_database(quest.getText().toString(), jvb1.getText().toString(), jvb2.getText().toString(), jvb3.getText().toString(), jvb4.getText().toString(), jvbb);
        clearallcontrolsvalue();
        }
        
    }
    
    
    
    
    //برای خالی کردن مقادیر داخل صفحه
    public void clearallcontrolsvalue()
    {
        
        JFXTextField []tex={quest,jvb1,jvb2,jvb3,jvb4};
        for(int a=0;a<tex.length;a++)
        {
            tex[a].setText("");
        }
        
        
        
        jvbr1.setSelected(false);
        jvbr2.setSelected(false);
        jvbr3.setSelected(false);
        jvbr4.setSelected(false);
        
        
        
    }
    
    
    
    
    //کلیک روی دکمه پایان
    @FXML
    void end_btn_click(ActionEvent event) throws Exception
    {
    String jvbb="0";
        
        if(jvbr1.isSelected()||jvbr2.isSelected()||jvbr3.isSelected()||jvbr4.isSelected())
        {
        if(jvbr1.isSelected())
            jvbb="1";
        if(jvbr2.isSelected())
            jvbb="2";
        if(jvbr3.isSelected())
            jvbb="3";
        if(jvbr4.isSelected())
            jvbb="4";
        
        
        databaseclassTQ l=new databaseclassTQ();
        l.Insert_value_to_database(quest.getText().toString(), jvb1.getText().toString(), jvb2.getText().toString(), jvb3.getText().toString(), jvb4.getText().toString(), jvbb);
        clearallcontrolsvalue();
        
        Parent p=FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene s=new Scene(p);
        Stage st=(Stage)((Node)event.getSource()).getScene().getWindow();
        st.setScene(s);
        st.show();
        }
     
    }

    
    
    
    
}
