//package ToDoList;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//
//public class MainFrame extends JFrame {
//
//    private String userInputTask;
//
//    public String getUserInputTask() {
//        return userInputTask;
//    }
//
//    // All Components
//    JLabel titleLabel;
//    JPanel taskContainerPanel;
//    JPanel taskListPanel;
//    JLabel taskList;
//    JButton editButton;
//    ImageIcon editIcon;
//    ImageIcon deleteIcon;
//    ImageIcon isCompleteIcon;
//    JLabel completeCheckMarkPanel;
//    JButton deleteButton;
//    JPanel addNewTaskPanel;
//    ImageIcon addNewTaskIcon;
//    JLabel addNewTask;
//    JTextField taskInput;
//    JButton completedTasks;
//    JButton viewAllTasks;
//
//    Task loadTasks;
//
//    // All Colors
//    Color framebackgroundColor = new Color(0x302E2E);
//    Color textcolor = new Color(0xE1E1E1);
//    Color buttonColor = new Color(0xFF3E3E40);
//    Color taskListColor = new Color(0xFF3E3E40);
//
//
//    public MainFrame(){
//
//
//        //Update the Colors JoptionPane
//        UIManager.put("OptionPane.background",framebackgroundColor);
//        UIManager.put("Panel.background", framebackgroundColor);
//        UIManager.put("OptionPane.messageForeground", textcolor);
//        UIManager.put("Button.background", buttonColor);
//        UIManager.put("Button.foreground", textcolor);
//        UIManager.put("Button.focus", new Color(0, 0, 0, 0));
//
//        // Title
//        titleLabel = new JLabel("Your Last Five added Task",SwingConstants.CENTER);
//        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
//        titleLabel.setBounds(0,5,600,50);
//        titleLabel.setForeground(textcolor);
//
//
//        taskContainerPanel = new JPanel();
//        taskContainerPanel.setLayout(new GridLayout(5,0,0,10));
//        taskContainerPanel.setBounds(22,60,540,270);
//        taskContainerPanel.setBackground(framebackgroundColor);
//
//        loadTaskMethod();
//
//        addNewTaskIcon = new ImageIcon("add.png");
//        addNewTask = new JLabel();
//        addNewTask.setIcon(addNewTaskIcon);
//        addNewTask.setBounds(15,4,40,40);
//
//        taskInput = new JTextField("Add New Task");
//        taskInput.setFont(new Font("Segoe UI", Font.BOLD,14));
//        taskInput.setForeground(textcolor);
//        taskInput.setBounds(50, 5,480,40);
//        taskInput.setBackground(null);
//        taskInput.setBorder(BorderFactory.createEmptyBorder());
//        taskInput.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                userInputTask = taskInput.getText();
//                taskInput.setText("");
//                Task writeAndLoad = new Task(loadTasks);
//                writeAndLoad.writeTaskAndLoad(userInputTask,MainFrame.this);
//
//
//            }
//        });
//
//        addNewTaskPanel = new JPanel();
//        addNewTaskPanel.setBackground(new Color(0xFF606060, true));
//        addNewTaskPanel.setBounds(22,350,540,50);
//        addNewTaskPanel.setLayout(null);
//        addNewTaskPanel.add(addNewTask);
//        addNewTaskPanel.add(taskInput);
//
//        // Completed Tasks and View All Task Buttons
//        completedTasks = new JButton("Completed Tasks");
//        completedTasks.setBounds(22,410,265,55);
//        completedTasks.setBackground(buttonColor);
//        completedTasks.setForeground(textcolor);
//        completedTasks.setFont(new Font("Segoe UI", Font.BOLD, 18));
//        completedTasks.setBorder(BorderFactory.createEmptyBorder());
//        completedTasks.setFocusPainted(false);
//        completedTasks.addActionListener(e -> {
//            new ViewTaskFrame(loadTasks,"completedTasks");
//        });
//
//        viewAllTasks = new JButton("View All Tasks");
//        viewAllTasks.setBounds(297,410,265,55);
//        viewAllTasks.setBackground(buttonColor);
//        viewAllTasks.setForeground(textcolor);
//        viewAllTasks.setFont(new Font("Segoe UI", Font.BOLD, 18));
//        viewAllTasks.setBorder(BorderFactory.createEmptyBorder());
//        viewAllTasks.setFocusPainted(false);
//        viewAllTasks.addActionListener(e -> {
//            new ViewTaskFrame(loadTasks,"viewAllTasks");
//        });
//
////        ImageIcon frameBG = new ImageIcon("FrameBackground.jpg");
////        JLabel BGImage = new JLabel(frameBG);
////        BGImage.setLayout(null);
////        BGImage.setSize(600,540);
//
//
//
//
//
//        //Main Frame
//        ImageIcon frameIcon = new ImageIcon("frameIcon.png");
//        setTitle("Al-Rafah ToDoList");
//        setIconImage(frameIcon.getImage());
//
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setBounds(700,300,600,540);
//        this.setLayout(null);
////        this.setContentPane(BGImage);
//        this.getContentPane().setBackground(framebackgroundColor);
//        this.setResizable(false);
//
//
//
//        this.add(titleLabel);
//        this.add(taskContainerPanel);
//        this.add(addNewTaskPanel);
//        this.add(completedTasks);
//        this.add(viewAllTasks);
//        setVisible(true);
//
//    }
//
//    // Method to Create Task GUI Dynamically
//    private void addTaskToPanel(int taskNumber, String taskText, boolean isCompleted){
//
//        taskList = new JLabel("Task: "+ taskNumber+" " + taskText);
//        taskList.setFont(new Font("Segoe UI", Font.BOLD, 14));
//        taskList.setBounds(15,0,418,50);
//        taskList.setForeground(textcolor);
//
//
//        editIcon = new ImageIcon("edit.png");
//        editButton = new JButton();
//        editButton.setBackground(taskListColor);
//        editButton.setForeground(textcolor);
//        editButton.setBounds(435,4,20,40);
//        editButton.setIcon(editIcon);
//        editButton.setBorder(BorderFactory.createEmptyBorder());
//        editButton.setFocusPainted(false);
//
//
//        editButton.setActionCommand(String.valueOf(taskNumber));
//        editButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int selectedTaskNumber = Integer.parseInt(e.getActionCommand());
//                editTask(selectedTaskNumber);
//            }
//        });
//
//        deleteIcon = new ImageIcon("delete.png");
//        deleteButton = new JButton();
//        deleteButton.setBackground(taskListColor);
//        deleteButton.setForeground(textcolor);
//        deleteButton.setBounds(470,4,20,40);
//        deleteButton.setIcon(deleteIcon);
//        deleteButton.setBorder(BorderFactory.createEmptyBorder());
//        deleteButton.setFocusPainted(false);
//
//
//        deleteButton.setActionCommand(String.valueOf(taskNumber));
//        deleteButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int selectedTaskNumber = Integer.parseInt(e.getActionCommand());
//
//                deleteTask(selectedTaskNumber);
//            }
//        });
//
//        JPopupMenu popupMenu = new JPopupMenu();
//        popupMenu.setBackground(framebackgroundColor);
//        popupMenu.setBorder(BorderFactory.createEtchedBorder());
//        popupMenu.setPreferredSize(new Dimension(140,40));
//
//
//        JMenuItem markedASComplete = new JMenuItem("Marked as Complete");
//
//        markedASComplete.setBackground(framebackgroundColor);
//        markedASComplete.setBorder(BorderFactory.createEmptyBorder());
//        markedASComplete.setFont(new Font("Segoe UI", Font.PLAIN, 14));
//        markedASComplete.setForeground(textcolor);
//
//        markedASComplete.setActionCommand(String.valueOf(taskNumber));
//        markedASComplete.addActionListener(e -> {
//            int selectedTaskNumber = Integer.parseInt(e.getActionCommand());
//            markedASCompleteMethod(selectedTaskNumber);
//
//        });
//        popupMenu.add(markedASComplete);
//
//        taskListPanel = new JPanel();
//        taskListPanel.setBackground(taskListColor);
//        taskListPanel.setBounds(22,0,300,50);
//        taskListPanel.setLayout(null);
//        taskListPanel.add(taskList);
//        taskListPanel.add(editButton);
//        taskListPanel.add(deleteButton);
//
//        taskListPanel.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e);
//                if (SwingUtilities.isRightMouseButton(e)) {
//                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
//                }
//            }
//        });
//
//
//        if (isCompleted){
//            taskList.setForeground(new Color(0x9E9E9E));
//            isCompleteIcon = new ImageIcon("isComplete.png");
//            completeCheckMarkPanel = new JLabel(isCompleteIcon);
//            completeCheckMarkPanel.setBounds(507,4,20,40);
//            taskListPanel.add(completeCheckMarkPanel);
//            editButton.setEnabled(false);
//            popupMenu.setPreferredSize(new Dimension(0,0));
//
//
//
//        }
//        taskContainerPanel.add(taskListPanel);
//
//    }
//
//    private void loadTaskMethod(){
//        loadTasks= new Task();
//        loadTasks.readAndLoadTasks();
//
//        if ((loadTasks.getSerialNO().size())>5) {
//
//            int startLoop = (loadTasks.getSerialNO().size()) - 5;
//            for (int i = startLoop; i < loadTasks.getSerialNO().size(); i++) {
//                addTaskToPanel(loadTasks.getSerialNO().get(i), loadTasks.getTaskText().get(i), loadTasks.getIsComplete().get(i));
//            }
//        }
//        else{
//            for (int i = 0; i < loadTasks.getSerialNO().size(); i++) {
//                addTaskToPanel(loadTasks.getSerialNO().get(i), loadTasks.getTaskText().get(i), loadTasks.getIsComplete().get(i));
//            }
//        }
//
//    }
//
//    public void updateTaskPanel(){
//        taskContainerPanel.removeAll();
//
//        loadTaskMethod();
//        taskContainerPanel.revalidate();
//        taskContainerPanel.repaint();
//    }
//
//    private void editTask(int selectedTaskNumber){
//
//        String newTaskText = JOptionPane.showInputDialog(this, "Edit Task:"+selectedTaskNumber, "Edit Task", JOptionPane.PLAIN_MESSAGE);
//
//        if (newTaskText != null && !newTaskText.trim().isEmpty()) {
//            for (int i = 0; i < loadTasks.getSerialNO().size(); i++) {
//                if (loadTasks.getSerialNO().get(i) == selectedTaskNumber) {
//                    loadTasks.getTaskText().set(i, newTaskText);
//                    break;
//                }
//            }
//
//            // Save changes
//            loadTasks.updateTaskFile();
//            updateTaskPanel();
//        }
//    }
//
//    private void deleteTask(int selectedTaskNumber){
//        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this task?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
//
//        if (confirm == JOptionPane.YES_OPTION) {
//            for (int i = 0; i < loadTasks.getSerialNO().size(); i++) {
//                if (loadTasks.getSerialNO().get(i) == selectedTaskNumber) {
//                    loadTasks.getSerialNO().remove(i);
//                    loadTasks.getTaskText().remove(i);
//                    loadTasks.getIsComplete().remove(i);
//                    break;
//                }
//            }
//
//            // Save changes
//            loadTasks.updateTaskFile();
//            updateTaskPanel();
//        }
//    }
//
//    private void markedASCompleteMethod(int selectedTaskNumber){
//
//        for (int i = 0; i < loadTasks.getSerialNO().size(); i++) {
//            if (loadTasks.getSerialNO().get(i) == selectedTaskNumber) {
//                loadTasks.getIsComplete().set(i,true);
//                break;
//            }
//        }
//        // Save changes
//        loadTasks.updateTaskFile();
//        updateTaskPanel();
//
//    }
//
//
//}
//
//
//
//







package ToDoList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {

    private String userInputTask;

    // All Components
    JLabel titleLabel;
    JPanel taskContainerPanel;
    JScrollPane scrollPane; // Add JScrollPane
    JPanel taskListPanel;
    JLabel taskList;
    JButton editButton;
    ImageIcon editIcon;
    ImageIcon deleteIcon;
    ImageIcon isCompleteIcon;
    JLabel completeCheckMarkPanel;
    JButton deleteButton;
    JPanel addNewTaskPanel;
    ImageIcon addNewTaskIcon;
    JLabel addNewTask;
    JTextField taskInput;
    JButton completedTasks;
    JButton viewAllTasks;

    Task loadTasks;

    // All Colors
    Color framebackgroundColor = new Color(0x302E2E);
    Color textcolor = new Color(0xE1E1E1);
    Color buttonColor = new Color(0xFF3E3E40);
    Color taskListColor = new Color(0xFF3E3E40);

    public MainFrame() {

        // Update the Colors JoptionPane
        UIManager.put("OptionPane.background", framebackgroundColor);
        UIManager.put("Panel.background", framebackgroundColor);
        UIManager.put("OptionPane.messageForeground", textcolor);
        UIManager.put("Button.background", buttonColor);
        UIManager.put("Button.foreground", textcolor);
        UIManager.put("Button.focus", new Color(0, 0, 0, 0));

        // Title
        titleLabel = new JLabel("To Do List", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setBounds(0, 5, 600, 50);
        titleLabel.setForeground(textcolor);



        taskContainerPanel = new JPanel();
        taskContainerPanel.setBackground(framebackgroundColor);
        taskContainerPanel.setLayout(new GridLayout(0, 1, 0, 10));


        // Wrap taskContainerPanel in a JScrollPane
        scrollPane = new JScrollPane(taskContainerPanel);
        scrollPane.setBounds(22, 60, 540, 270); // Set bounds for the scroll pane
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setBackground(framebackgroundColor);
        verticalScrollBar.setPreferredSize(new Dimension(7, 0));
        verticalScrollBar.setUnitIncrement(16);// Set the increment for scrolling with the mouse wheel

        loadTaskMethod();

        addNewTaskIcon = new ImageIcon("add.png");
        addNewTask = new JLabel();
        addNewTask.setIcon(addNewTaskIcon);
        addNewTask.setBounds(15, 4, 40, 40);

        taskInput = new JTextField("Add New Task");
        taskInput.setFont(new Font("Segoe UI", Font.BOLD, 14));
        taskInput.setForeground(textcolor);
        taskInput.setBounds(50, 5, 480, 40);
        taskInput.setBackground(null);
        taskInput.setBorder(BorderFactory.createEmptyBorder());
        taskInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userInputTask = taskInput.getText();
                taskInput.setText("");
                Task writeAndLoad = new Task(loadTasks);
                writeAndLoad.writeTaskAndLoad(userInputTask, MainFrame.this);
            }
        });

        addNewTaskPanel = new JPanel();
        addNewTaskPanel.setBackground(new Color(0xFF606060, true));
        addNewTaskPanel.setBounds(22, 350, 540, 50);
        addNewTaskPanel.setLayout(null);
        addNewTaskPanel.add(addNewTask);
        addNewTaskPanel.add(taskInput);

        // Completed Tasks and View All Task Buttons
        completedTasks = new JButton("Completed Tasks");
        completedTasks.setBounds(22, 410, 265, 55);
        completedTasks.setBackground(buttonColor);
        completedTasks.setForeground(textcolor);
        completedTasks.setFont(new Font("Segoe UI", Font.BOLD, 18));
        completedTasks.setBorder(BorderFactory.createEmptyBorder());
        completedTasks.setFocusPainted(false);
        completedTasks.addActionListener(e -> {
            new ViewTaskFrame(loadTasks, "completedTasks");
        });

        viewAllTasks = new JButton("View All Tasks");
        viewAllTasks.setBounds(297, 410, 265, 55);
        viewAllTasks.setBackground(buttonColor);
        viewAllTasks.setForeground(textcolor);
        viewAllTasks.setFont(new Font("Segoe UI", Font.BOLD, 18));
        viewAllTasks.setBorder(BorderFactory.createEmptyBorder());
        viewAllTasks.setFocusPainted(false);
        viewAllTasks.addActionListener(e -> {
            new ViewTaskFrame(loadTasks, "viewAllTasks");
        });

        // Main Frame
        ImageIcon frameIcon = new ImageIcon("frameIcon.png");
        setTitle("Al-Rafah ToDoList");
        setIconImage(frameIcon.getImage());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(700, 300, 600, 540);
        this.setLayout(null);
        this.getContentPane().setBackground(framebackgroundColor);
        this.setResizable(false);

        this.add(titleLabel);
//        this.add(taskContainerPanel);
        this.add(scrollPane); // Add scrollPane instead of taskContainerPanel
        this.add(addNewTaskPanel);
        this.add(completedTasks);
        this.add(viewAllTasks);
        setVisible(true);
    }

    // Method to Create Task GUI Dynamically
    private void addTaskToPanel(int taskNumber, String taskText, boolean isCompleted) {
        taskList = new JLabel("Task: " + taskNumber + " " + taskText);
        taskList.setFont(new Font("Segoe UI", Font.BOLD, 14));
        taskList.setBounds(15, 0, 418, 50);
        taskList.setForeground(textcolor);

        editIcon = new ImageIcon("edit.png");
        editButton = new JButton();
        editButton.setBackground(taskListColor);
        editButton.setForeground(textcolor);
        editButton.setBounds(435, 4, 20, 40);
        editButton.setIcon(editIcon);
        editButton.setBorder(BorderFactory.createEmptyBorder());
        editButton.setFocusPainted(false);

        editButton.setActionCommand(String.valueOf(taskNumber));
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedTaskNumber = Integer.parseInt(e.getActionCommand());
                editTask(selectedTaskNumber);
            }
        });

        deleteIcon = new ImageIcon("delete.png");
        deleteButton = new JButton();
        deleteButton.setBackground(taskListColor);
        deleteButton.setForeground(textcolor);
        deleteButton.setBounds(470, 4, 20, 40);
        deleteButton.setIcon(deleteIcon);
        deleteButton.setBorder(BorderFactory.createEmptyBorder());
        deleteButton.setFocusPainted(false);

        deleteButton.setActionCommand(String.valueOf(taskNumber));
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedTaskNumber = Integer.parseInt(e.getActionCommand());
                deleteTask(selectedTaskNumber);
            }
        });

        JPopupMenu popupMenu = new JPopupMenu();
        popupMenu.setBackground(framebackgroundColor);
        popupMenu.setBorder(BorderFactory.createEtchedBorder());
        popupMenu.setPreferredSize(new Dimension(140, 40));

        JMenuItem markedASComplete = new JMenuItem("Marked as Complete");
        markedASComplete.setBackground(framebackgroundColor);
        markedASComplete.setBorder(BorderFactory.createEmptyBorder());
        markedASComplete.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        markedASComplete.setForeground(textcolor);

        markedASComplete.setActionCommand(String.valueOf(taskNumber));
        markedASComplete.addActionListener(e -> {
            int selectedTaskNumber = Integer.parseInt(e.getActionCommand());
            markedASCompleteMethod(selectedTaskNumber);
        });
        popupMenu.add(markedASComplete);

        taskListPanel = new JPanel();
        taskListPanel.setBackground(taskListColor);
        taskListPanel.setPreferredSize(new Dimension(540,50));
        taskListPanel.setLayout(null);
        taskListPanel.add(taskList);
        taskListPanel.add(editButton);
        taskListPanel.add(deleteButton);

        taskListPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (SwingUtilities.isRightMouseButton(e)) {
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });

        if (isCompleted) {
            taskList.setForeground(new Color(0x9E9E9E));
            isCompleteIcon = new ImageIcon("isComplete.png");
            completeCheckMarkPanel = new JLabel(isCompleteIcon);
            completeCheckMarkPanel.setBounds(507, 4, 20, 40);
            taskListPanel.add(completeCheckMarkPanel);
            editButton.setEnabled(false);
            popupMenu.setPreferredSize(new Dimension(0, 0));
        }
        taskContainerPanel.add(taskListPanel);
    }

    private void loadTaskMethod() {
        loadTasks = new Task();
        loadTasks.readAndLoadTasks();

        for (int i = 0; i < loadTasks.getSerialNO().size(); i++) {
            addTaskToPanel(loadTasks.getSerialNO().get(i), loadTasks.getTaskText().get(i), loadTasks.getIsComplete().get(i));
        }
    }

    public void updateTaskPanel() {
        taskContainerPanel.removeAll();
        loadTaskMethod();
        taskContainerPanel.revalidate();
        taskContainerPanel.repaint();
    }

    private void editTask(int selectedTaskNumber) {
        String newTaskText = JOptionPane.showInputDialog(this, "Edit Task:" + selectedTaskNumber, "Edit Task", JOptionPane.PLAIN_MESSAGE);

        if (newTaskText != null && !newTaskText.trim().isEmpty()) {
            for (int i = 0; i < loadTasks.getSerialNO().size(); i++) {
                if (loadTasks.getSerialNO().get(i) == selectedTaskNumber) {
                    loadTasks.getTaskText().set(i, newTaskText);
                    break;
                }
            }

            // Save changes
            loadTasks.updateTaskFile();
            updateTaskPanel();
        }
    }

    private void deleteTask(int selectedTaskNumber) {
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this task?", "Confirm Delete", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            for (int i = 0; i < loadTasks.getSerialNO().size(); i++) {
                if (loadTasks.getSerialNO().get(i) == selectedTaskNumber) {
                    loadTasks.getSerialNO().remove(i);
                    loadTasks.getTaskText().remove(i);
                    loadTasks.getIsComplete().remove(i);
                    break;
                }
            }

            // Save changes
            loadTasks.updateTaskFile();
            updateTaskPanel();
        }
    }

    private void markedASCompleteMethod(int selectedTaskNumber) {
        for (int i = 0; i < loadTasks.getSerialNO().size(); i++) {
            if (loadTasks.getSerialNO().get(i) == selectedTaskNumber) {
                loadTasks.getIsComplete().set(i, true);
                break;
            }
        }
        // Save changes
        loadTasks.updateTaskFile();
        updateTaskPanel();
    }
}