package com.gdm.hermanas.util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.Objects;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Deibidson Mesquita
 */
public class ColorColumnRenderer extends DefaultTableCellRenderer {

    private static final long serialVersionUID = 1L;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (table.getValueAt(row, 3) != null && table.getValueAt(row, 4) != null) {
           
            Integer estoqueInicial = Integer.parseInt(table.getValueAt(row, 3).toString());
            Integer estoqueAtual = Integer.parseInt(table.getValueAt(row, 4).toString());

            if (value != null) {
                if (Objects.equals(estoqueInicial, estoqueAtual)) {
                    c.setFont(new Font("Tahoma", 1, 11));
                    c.setForeground(new Color(192, 23, 73));
                } else {
                    c.setForeground(table.getForeground());
                }

            }
        }

        return c;
    }

}
