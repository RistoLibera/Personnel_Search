package personnel.form;
/*
 * Verify user and proceed to the search form
 *
 */
import javax.swing.*;
import personnel.connection.ConnectionManager;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class SearchForm extends JFrame{
    private JLabel lb_title;
    private JLabel lb_user;
    private JLabel lb_password;
    private JTextField tf_user;
    private JPasswordField tf_password;
    private JButton button_v;
    private static String AdminTable = "ADMIN_INFO";

    public SearchForm() {
        setLayout(new BorderLayout(20, 20));
        // panel_title for responsive layout
        JPanel panel_title = new JPanel();
        panel_title.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 30));
        JPanel panel_input = new JPanel();
        panel_input.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));
        JPanel panel_button = new JPanel();
        panel_button.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 40));
        // Title
        lb_title = new JLabel("Personnel Search");
        lb_title.setFont(new Font("Times New Roman", Font.BOLD, 50));
        // Username
        lb_user = new JLabel("Username");
        lb_user.setFont(new Font("Arial", Font.PLAIN, 25));
        tf_user = new JTextField(40);
        tf_user.setFont(new Font("Arial", Font.PLAIN, 20));
        // Password
        lb_password = new JLabel("Password");
        lb_password.setFont(new Font("Arial", Font.PLAIN, 25));
        tf_password = new JPasswordField(40);
        tf_password.setFont(new Font("Arial", Font.PLAIN, 20));
        // button
        button_v = new JButton("Verify");
        button_v.setFont(new Font("Arial", Font.PLAIN, 30));
        // // Can press Enter key to proceed
        getRootPane().setDefaultButton(button_v);
        // Add to frame
        panel_title.add(lb_title);
        panel_input.add(lb_user);
        panel_input.add(tf_user);
        panel_input.add(lb_password);
        panel_input.add(tf_password);
        panel_button.add(button_v);
        add(panel_title,BorderLayout.PAGE_START);
        add(panel_input,BorderLayout.CENTER);
        add(panel_button,BorderLayout.PAGE_END);
        // Initial settings
        setSize(1000, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Button action
        button_v.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    Connection con = ConnectionManager.getConnection();
                    // Check table existence
                    if (!ConnectionManager.IsTableExist(con, AdminTable)) {
                        JOptionPane.showMessageDialog(null, "Admin table does not exist!");
                        return;
                    }
                    // Check admin user existence
                    if (!ConnectionManager.getAdminInfo(con, AdminTable, tf_user.getText(), String.valueOf(tf_password.getPassword()))) {
                        JOptionPane.showMessageDialog(null, "Wrong username or password!");
                        return;
                    } else {
                        setVisible(false);
                        new SearchResult();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        try {
            SearchForm form = new SearchForm();
            form.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
