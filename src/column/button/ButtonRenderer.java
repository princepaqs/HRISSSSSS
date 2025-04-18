/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package column.button;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.AbstractCellEditor;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;


/**
 *
 * @author sagio
 */
public class ButtonRenderer extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, ActionListener, MouseListener {
    private JTable table;
    private Action action;
    private int mnemonic;
    private Border originalBorder;
    private Border focusBorder;

    private JButton renderButton;
    private JButton updateButton;
    private Object editorValue;
    private boolean isButtonColumnEditor;
    
    public ButtonRenderer(JTable table, Action action, int column) {
        this.table = table;
        this.action = action;
        
        renderButton = new JButton();
        updateButton = new JButton();
        updateButton.setFocusPainted(false);
        updateButton.addActionListener(this);
        originalBorder = updateButton.getBorder();
        setFocusBorder( new LineBorder(Color.BLUE) );

        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(column).setCellRenderer( this );
        columnModel.getColumn(column).setCellEditor( this );
        table.addMouseListener( this );
    }
    
    public Border getFocusBorder() {
        return focusBorder;
    }
    
    public void setFocusBorder(Border focusBorder) {
        this.focusBorder = focusBorder;
        updateButton.setBorder( focusBorder );
    }
    
    public int getMnemonic() {
        return mnemonic;
    }
    
    public void setMnemonic(int mnemonic) {
        this.mnemonic = mnemonic;
        renderButton.setMnemonic(mnemonic);
        updateButton.setMnemonic(mnemonic);
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (value == null) {
            updateButton.setText( "" );
            updateButton.setIcon( null );
        }
        else if (value instanceof Icon) {
            updateButton.setText( "" );
            updateButton.setIcon( (Icon)value );
        }
        else {
            updateButton.setText( value.toString() );
            updateButton.setIcon( null );
        }

        this.editorValue = value;
        return updateButton;
    }
    
    @Override
    public Object getCellEditorValue() {
            return editorValue;
    }
    
//    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	if (isSelected) {
            renderButton.setForeground(table.getSelectionForeground());
            renderButton.setBackground(table.getSelectionBackground());
        } else {
            renderButton.setForeground(table.getForeground());
            renderButton.setBackground(UIManager.getColor("Button.background"));
        }

	if (hasFocus) {
            renderButton.setBorder( focusBorder );
        } else {
            renderButton.setBorder( originalBorder );
        }
        
        if (value == null) {
            renderButton.setText( "" );
            renderButton.setIcon( null );
        } else if (value instanceof Icon) {
            renderButton.setText( "" );
            renderButton.setIcon( (Icon)value );
        } else {
            renderButton.setText( value.toString() );
            renderButton.setIcon( null );
        }

        return renderButton;
    }
    
//    @Override
    public void actionPerformed(ActionEvent e) {
        int row = table.convertRowIndexToModel( table.getEditingRow() );
        fireEditingStopped();

        ActionEvent event = new ActionEvent(
                table,
                ActionEvent.ACTION_PERFORMED,
                "" + row);
        action.actionPerformed(event);
    }

//    @Override
    public void mousePressed(MouseEvent e) {
        if (table.isEditing() &&  table.getCellEditor() == this)
            isButtonColumnEditor = true;
    }

//    @Override
    public void mouseReleased(MouseEvent e) {
        if (isButtonColumnEditor &&  table.isEditing())
           table.getCellEditor().stopCellEditing();
        
        isButtonColumnEditor = false;
        
    }

    public void mouseClicked(MouseEvent e) {
        if(SwingUtilities.isLeftMouseButton(e)) {
            this.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
        }
    }
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
