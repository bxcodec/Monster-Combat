/*
 *     Name :  Iman Syahputra Situmorang
 *     NIM  :  11113064
 *     Date :  27/November/2014
 
 */

package Model;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Takiya
 */
public class TemplateMonsterTable  extends  DefaultTableModel{
    
    public  ArrayList <Monster>  colloumElement;
    
    private static final long serialVersionUID= 1L;
    public  TemplateMonsterTable (Object [] [] data, Object [] colloumname) 
    {
        super(data, colloumname);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return getValueAt(0,columnIndex).getClass(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public TemplateMonsterTable (ArrayList <Monster> template) 
    {
        this.colloumElement=template;
    }
    
    
}
