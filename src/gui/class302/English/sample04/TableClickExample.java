package gui.class302.English.sample04;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

//github

public class TableClickExample extends JFrame{
	  private JTable dataTable;
	  
	    public TableClickExample() {
	        setTitle("Table Click Example");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setSize(400, 300);

	        // テーブルデータの初期化
	        String[] columns = {"Column 1", "Column 2", "Column 3"};
	        Object[][] data = {
	                {"Row 1 - Value 1", "Row 1 - Value 2", "Row 1 - Value 3"},
	                {"Row 2 - Value 1", "Row 2 - Value 2", "Row 2 - Value 3"},
	                {"Row 3 - Value 1", "Row 3 - Value 2", "Row 3 - Value 3"}
	        };

	        // テーブルモデルの初期化
	        DefaultTableModel defaultTableModel = new DefaultTableModel(data, columns) {
	            @Override
	            public boolean isCellEditable(int row, int column) {
	                // 特定の列のセルを編集不可にする
	                return column != 1;
	            }
	        };
	        
	        
	        
	        // データテーブルの初期化
	        dataTable = new JTable(defaultTableModel);
	        dataTable.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                int row = dataTable.getSelectedRow();
	                int column = dataTable.getSelectedColumn();

	                // クリックされたセルが特定の列（例：2列目）である場合に処理を実行
	                if (column == 1) {
	                    Object value = dataTable.getValueAt(row, column);
	                    JOptionPane.showMessageDialog(TableClickExample.this, "Value: " + value);
	                }
	            }
	        });

	        // カラム幅の調整
	        adjustColumnWidth();

	        // テーブルをスクロール可能にする
	        JScrollPane scrollPane = new JScrollPane(dataTable);

	        // レイアウトの設定
	        setLayout(new BorderLayout());
	        add(scrollPane, BorderLayout.CENTER);
	    }

	    private void adjustColumnWidth() {
	        TableColumn column = null;
	        for (int i = 0; i < dataTable.getColumnCount(); i++) {
	            column = dataTable.getColumnModel().getColumn(i);
	            if (i == 1) {
	                // 特定の列（例：2列目）の幅を縮小し、空白を表示
	                column.setPreferredWidth(10);
	                column.setMinWidth(10);
	                column.setMaxWidth(10);
	            } else {
	                // 他の列の幅を調整
	                column.setPreferredWidth(100);
	            }
	        }
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> {
	            TableClickExample example = new TableClickExample();
	            example.setVisible(true);
	        });
	    }
	}
