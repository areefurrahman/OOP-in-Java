package ToDoList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ViewTaskFrame extends JFrame {


    ViewTaskFrame(Task task, String selectButton) {

        Color framebackgroundColor = new Color(0x302E2E);
        Color textcolor = new Color(0xE1E1E1);
        Color buttonColor = new Color(0xFF3E3E40);

        // Title Label
        JLabel titleLabel = new JLabel("All Tasks List", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(textcolor);
        titleLabel.setBounds(150, 20, 300, 40);
        add(titleLabel);


        // Table to display orders
        String[] columnNames = {"Seriol NO", "Tasks", "Is Complete"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable taskTable = new JTable(tableModel);


        // Table properties
        taskTable.setBackground(framebackgroundColor);
        taskTable.setForeground(textcolor);
        taskTable.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        taskTable.setRowHeight(25);
        taskTable.getTableHeader().setBackground(framebackgroundColor);
        taskTable.getTableHeader().setForeground(textcolor);
        taskTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));



        JScrollPane scrollPane = new JScrollPane(taskTable);
        scrollPane.setBounds(50, 80, 500, 300);
        add(scrollPane);


//         Load data into the table
        ArrayList<String> tasksData = new ArrayList<>();
        if (selectButton.equals("viewAllTasks")) {
            tasksData = task.viewAllTasksLoad();
        } else {
            tasksData = task.viewAllCompletedTasksLoad();
        }
        for (String taskLine : tasksData) {
            String[] taskDetails = taskLine.split(",");
            tableModel.addRow(taskDetails);
        }

        // Close button
        JButton closeButton = new JButton("CLOSE");
        closeButton.setBounds(220, 400, 150, 50);
        closeButton.setBackground(buttonColor);
        closeButton.setBorder(BorderFactory.createEmptyBorder());
        closeButton.setForeground(textcolor);
        closeButton.setFocusPainted(false);
        closeButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        closeButton.addActionListener(e -> dispose());

        this.setTitle("All Tasks");
        this.setBounds(700, 300, 600, 540);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.getContentPane().setBackground(framebackgroundColor);
        this.add(closeButton);
        this.setVisible(true);

    }

}
