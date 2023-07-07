package gui.class302.English.sample03;

import java.awt.BorderLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Main extends JFrame {
    private JComboBox<String> tableComboBox;
    private JTable dataTable;
    private JScrollPane scrollPane;

    public Main() {
        setTitle("Table Switch Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // テーブルデータの初期化
        String[] columns = {"Column 1", "Column 2"};
        String[][] data = {{"Row 1 - Value 1", "Row 1 - Value 2"}, {"Row 2 - Value 1", "Row 2 - Value 2"}};
        DefaultTableModel defaultTableModel = new DefaultTableModel(data, columns);

        // コンボボックスの初期化
        String[] tableNames = {"Table 1", "Table 2", "Table 3"};
        tableComboBox = new JComboBox<>(tableNames);
        tableComboBox.addActionListener(e -> {
            // 選択されたテーブル名に応じてカラムを変更
            String selectedTable = (String) tableComboBox.getSelectedItem();
            switch (selectedTable) {
                case "Table 1":
                    defaultTableModel.setColumnIdentifiers(new String[]{"Column 1", "Column 2"});
                    break;
                case "Table 2":
                    defaultTableModel.setColumnIdentifiers(new String[]{"Column 1", "Column 2", "Column 3"});
                    break;
                case "Table 3":
                    defaultTableModel.setColumnIdentifiers(new String[]{"Column 1", "Column 2", "Column 3", "Column 4"});
                    break;
                // 追加のテーブルに対しても同様に処理を追加
            }
        });

        // データテーブルの初期化
        dataTable = new JTable(defaultTableModel);
        scrollPane = new JScrollPane(dataTable);

        // レイアウトの設定
        setLayout(new BorderLayout());
        add(tableComboBox, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
            Main example = new Main();
            example.setVisible(true);
//        });
    }
}


