/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tq;

import java.sql.*;



public class databaseclassTQ 
{
    
    
    
    private String URL="jdbc:sqlite:db.db";
    
    public void Insert_value_to_database(String question,String jvb1,String jvb2,String jvb3,String jvb4,String jvb)
    {
        try
        {
            Connection con=DriverManager.getConnection(URL);
            Statement st=con.createStatement();
            st.execute("Insert into tbl1 VALUES('"+question+"','"+jvb1+"','"+jvb2+"','"+jvb3+"','"+jvb4+"','"+jvb+"');");
            st.close();
            con.close();
            
        }catch(Exception e)
        {
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    
    
    
    public void Delte_all_records_on_database()
    {
        try
        {
            Connection con=DriverManager.getConnection(URL);
            Statement st=con.createStatement();
            st.execute("DELETE FROM tbl1");
            st.close();
            con.close();
            
        }catch(Exception e)
        {
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    
    
    public String fnd_record_vlaue(int val)
    {
        try {
            
         int count=0;
         
         String q,jvb1,jvb2,jvb3,jvb4,jvb;
         
         q=jvb1=jvb2=jvb3=jvb4=jvb="";
         
         Connection con=DriverManager.getConnection("jdbc:sqlite:db.db");
       

        Statement st = con.createStatement();

        ResultSet result = st.executeQuery("SELECT * FROM tbl1");

        while (result.next()) {
            
            if(count==val)
            {
                q=result.getString("q");
                jvb1=result.getString("jvb1");
                jvb2=result.getString("jvb2");
                jvb3=result.getString("jvb3");
                jvb4=result.getString("jvb4");
                jvb=result.getString("jvb");
            }
        count++;
        }

        result.close();

        st.close();
        
        return q+"-"+jvb1+"-"+jvb2+"-"+jvb3+"-"+jvb4+"-"+jvb;

    }
    catch ( SQLException e){
        System.out.print(e);
    }
    
        return null;
        
    }
   
    
    
    
    
     public int cnt()
    {
        try {
            
         
            int count=0;
            
         Connection con=DriverManager.getConnection("jdbc:sqlite:db.db");
       

        Statement st = con.createStatement();

        ResultSet result = st.executeQuery("SELECT * FROM tbl1");

        while (result.next()) {
            count++;
        }

        result.close();

        st.close();
        
        return count;

    }
    catch ( SQLException e){
        System.out.print(e);
    }
    
        return 0;
        
    }
   
    
    
    
    
    
    
    
    
}
