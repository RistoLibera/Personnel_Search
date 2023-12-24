package personnel.form;
/*
 * Search to see result
 *
 */
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import personnel.connection.ConnectionManager;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.*;

public class SearchResult extends JFrame{
    private JLabel lb_name;
    private JTextField tf_name;
    private static String PersonnelTable = "PERSONNEL_INFO";
    private ResultSet rs;
    
    public SearchResult() {
        setLayout(new GridBagLayout());
        // Top result area
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
        table.setFont(new Font("Times New Roman", Font.BOLD, 18));
        table.setRowHeight(30);
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setFont(new Font("Arial", Font.PLAIN, 20));
        // Bottom input area
        lb_name = new JLabel("Name");
        lb_name.setFont(new Font("Arial", Font.PLAIN, 20));
        tf_name = new JTextField(30);
        tf_name.setFont(new Font("Arial", Font.PLAIN, 15));
        // panel_title for responsive layout
        JPanel panel_search = new JPanel();
        panel_search.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panel_search.setBackground(Color.GRAY);
        // Add to frame
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 3;
        c.gridheight = 2;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        add(new JScrollPane(table), c);
        panel_search.add(lb_name);
        panel_search.add(tf_name);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 3;
        c.gridheight = 1;
        c.weightx = 1.0;
        c.weighty = 0.0;
        c.anchor = GridBagConstraints.LAST_LINE_START;
        add(panel_search, c);
        // Initial settings
        setSize(1000, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Get result by input
        tf_name.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) 
            {
                tableModel.setRowCount(0);
                rs = GetResult(tf_name.getText());
                UpdateTable(rs, tableModel);
            }
            public void insertUpdate(DocumentEvent e) 
            {
                tableModel.setRowCount(0);
                rs = GetResult(tf_name.getText());
                UpdateTable(rs, tableModel);
            }
    
            public void removeUpdate(DocumentEvent e) 
            {
                tableModel.setRowCount(0);
                rs = GetResult(tf_name.getText());
                UpdateTable(rs, tableModel);
            }
        });
    }

    private ResultSet GetResult(String input) {
        ResultSet rs = null;

        try {
            Connection con = ConnectionManager.getConnection();
            // Check table existence
            if (!ConnectionManager.IsTableExist(con, PersonnelTable)) {
                JOptionPane.showMessageDialog(null, "Personnel table does not exist!");
            }
            // Get resultset
            rs = ConnectionManager.getALLInfo(con, PersonnelTable, input);
            if (rs.isBeforeFirst()) {
                return rs;
            } else {
                JOptionPane.showMessageDialog(null, "No personnel info!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    private void UpdateTable(ResultSet rs, DefaultTableModel tm) {
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            int cols = rsmd.getColumnCount();
            // Set table header
            String[] colNames = new String[cols - 1];
            for( int i = 0; i < (cols - 1); i++) {
                colNames[i] = rsmd.getColumnName(i + 2);
            }
            tm.setColumnIdentifiers(colNames);
            // Set table row
            while(rs.next()) {
                Object[] info = new Object[cols - 1];
                for (int i = 1; i < cols; i++) {
                    info[i - 1] = rs.getObject(i + 1);
                }
                tm.addRow(info);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
