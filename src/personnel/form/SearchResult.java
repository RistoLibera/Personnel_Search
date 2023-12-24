package personnel.form;
/*
 * Search to see result
 *
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class SearchResult extends JFrame{
    private JLabel lb_name;
    private JTextField tf_name;

    public SearchResult() {
        setLayout(new GridBagLayout());
        // Left input area
        lb_name = new JLabel("Name");
        lb_name.setFont(new Font("Arial", Font.PLAIN, 20));
        tf_name = new JTextField(30);
        tf_name.setFont(new Font("Arial", Font.PLAIN, 15));
        // panel_title for responsive layout
        JPanel panel_search = new JPanel();
        panel_search.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panel_search.setBackground(Color.GRAY);
        // Right result area
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
        table.setFont(new Font("Times New Roman", Font.BOLD, 25));
        table.setRowHeight(30);
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setFont(new Font("Arial", Font.PLAIN, 30));
        // Add columns
        tableModel.setColumnIdentifiers(new Object[] { "CSS", "HTML5", "JavaScript" });
        tableModel.insertRow(0, new Object[] { "HTML5", "test" });
        tableModel.insertRow(0, new Object[] { "JavaScript" });
        tableModel.insertRow(0, new Object[] { "jQuery" });
        tableModel.insertRow(0, new Object[] { "AngularJS" });
        tableModel.insertRow(0, new Object[] { "JavaScript" });
        tableModel.insertRow(0, new Object[] { "jQuery" });
        tableModel.insertRow(0, new Object[] { "AngularJS" });        
        tableModel.insertRow(0, new Object[] { "JavaScript" });
        tableModel.insertRow(0, new Object[] { "jQuery" });
        tableModel.insertRow(0, new Object[] { "AngularJS" });
        tableModel.insertRow(0, new Object[] { "HTML5", "test" });
        tableModel.insertRow(0, new Object[] { "JavaScript" });
        tableModel.insertRow(0, new Object[] { "jQuery" });
        tableModel.insertRow(0, new Object[] { "AngularJS" });
        tableModel.insertRow(0, new Object[] { "JavaScript" });
        tableModel.insertRow(0, new Object[] { "jQuery" });
        tableModel.insertRow(0, new Object[] { "AngularJS" });        
        tableModel.insertRow(0, new Object[] { "JavaScript" });
        tableModel.insertRow(0, new Object[] { "jQuery" });
        tableModel.insertRow(0, new Object[] { "AngularJS" });
        tableModel.insertRow(tableModel.getRowCount(), new Object[] { "ExpressJS" });

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
        setSize(800, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
