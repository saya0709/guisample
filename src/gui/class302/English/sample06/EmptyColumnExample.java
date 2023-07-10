package gui.class302.English.sample06;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class EmptyColumnExample extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private int targetColumnIndex = 2; // 空白にする対象の列のインデックス
    
    public EmptyColumnExample() {
        initializeTable();
        initializeUI();
    }
    
    private void initializeTable() {
        // テーブルモデルの作成
        tableModel = new DefaultTableModel(new Object[][]{
                {"A", "B", "C"},
                {"D", "E", "F"},
                {"G", "H", "I"}
        }, new Object[]{"Column 1", "Column 2", "Column 3"});
        
        // JTableの作成
        table = new JTable(tableModel);
        
        // カラムレンダラーの設定
        TableCellRenderer emptyCellRenderer = new EmptyCellRenderer();
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(targetColumnIndex).setCellRenderer(emptyCellRenderer);
    }
    
    private void initializeUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Empty Column Example");
        
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private class EmptyCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
        	
        	
            // 対象の列のセルを空白にする
            if (column == targetColumnIndex) {
                value = ""; // セルを空白にする
            }
            
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }
    
    public static void main(String[] args) {
        EmptyColumnExample example = new EmptyColumnExample();
    }
}