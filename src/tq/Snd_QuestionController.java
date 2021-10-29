/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tq;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import com.jfoenix.controls.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import com.jfoenix.controls.*;
import javafx.scene.control.Label;


/**
 * FXML Controller class
 *
 * @author rezafta
 */
public class Snd_QuestionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        
        
        Select_questions_to_clinte_function();
        try{
        snd();
        }catch(Exception e)
        {
            
        }
    }    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @FXML
    private Label snd_text_View;
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    ///////کلیک روی دکمه بستن فرم صفحه
    @FXML
    void onClick_cls_btn_snd_frm(ActionEvent event)throws Exception
    {
        
             readmessage.close();
             WriteMessage.close();
             sock.close();
             soc.close();
            Parent p=FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene s=new Scene(p);
            Stage st=(Stage)((Node)event.getSource()).getScene().getWindow();
            st.setScene(s);
            st.initStyle(StageStyle.UNDECORATED);
            st.show();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //همه رکود ها
    String [][]db_rec;
    
    
    databaseclassTQ db;
    
    
    
    
    
    
    
    
    
    //////////////تابع اراسل متن از بانک اطلاعاتی به دستگاه ها
    /////ذخیره همه رکورد ها داخل یک بانک اطلاعاتی
    public void Select_questions_to_clinte_function()
    {
        db=new databaseclassTQ();
        
        int count=db.cnt();
        
        
        String s="";
        
        db_rec=new String[count][6];
        
        
        for(int a=0;a<count;a++)
        {
            s=db.fnd_record_vlaue(a);
            //javax.swing.JOptionPane.showMessageDialog(null, s);
            
            String []rec=s.split("-");
            
            for(int i=0;i<6;i++)
            {
                db_rec[a][i]=rec[i];
            }
            
            
        }
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    ServerSocket soc;
    
    Socket sock;
    
    DataInputStream readmessage;
    
    DataOutputStream WriteMessage;
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    String all_q_jvbs_jvb="";
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void snd() throws Exception
    {
        
        new Thread(new Runnable() {
            @Override
            public void run(){
                
                try
                {
                    soc=new ServerSocket(8085);
                    System.out.println("Connecting");
                    snd_text_View.setText("در حال انتظار برای متصل شدن دستگاه ها");
                    int connecting=0;
                    while(true){
                    sock=soc.accept();
                    
                    readmessage=new DataInputStream(sock.getInputStream());
                    WriteMessage=new DataOutputStream(sock.getOutputStream());
                    
                    
                    snd_text_View.setText("تعداد کاربر متصل   :   "+connecting);
                    
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            
                            try
                            {
                                for(int a=0;a<db.cnt();a++)
                                {
                                    for(int c=0;c<6;c++)
                                    {
                                        all_q_jvbs_jvb+=db_rec[a][c].toString()+"-";
                                    }
                                }
                                
                                WriteMessage.writeUTF(all_q_jvbs_jvb);
                                
                                
                                String reseve=readmessage.readUTF();
                                
                                
                                javax.swing.JOptionPane.showMessageDialog(null, reseve+"\n"+"دریافت شد");
                                
                                
                                Nettolist.natayej+=reseve+"-";
                                
                                
                                
                            }
                            catch(Exception e)
                            {
                                javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
                            }
                            
                            
                        }
                    }).start();
                    }
                    
                    
                }
                catch(Exception e)
                {
                    javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
                }
                
            }
        }).start();
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @FXML
    void show_about_by_net(ActionEvent event)
    {
        
        try
        {
            readmessage.close();
            WriteMessage.close();
            sock.close();
            soc.close();
            Parent p=FXMLLoader.load(getClass().getResource("Report.fxml"));
            Scene s=new Scene(p);
            Stage st=(Stage)((Node)event.getSource()).getScene().getWindow();
            st.setScene(s);
            st.initStyle(StageStyle.UNDECORATED);
            st.show();
            
        }
        catch(Exception e)
        {
            //javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
    
    
}
