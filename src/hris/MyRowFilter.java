/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hris;

import javax.swing.RowFilter;

/**
 *
 * @author sagio
 */
public class MyRowFilter extends RowFilter {
    private String searchText;
    
    public MyRowFilter(String searchText) {
        this.searchText = searchText;
    }
    
    @Override
    public boolean include(Entry entry) {
        return entry.getStringValue(0).indexOf(searchText) >= 0;
    }
}
