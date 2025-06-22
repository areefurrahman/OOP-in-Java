//L1F23BSSE0389

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class HMSMainGUI extends JFrame {
    private HMSHotel hotel;

    public HMSMainGUI(HMSHotel hotel) {
        this.hotel = hotel;

        setTitle("Hotel Management Dashboard");
        setSize(500, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        Color backgroundColor = new Color(220, 230, 240);
        Color foregroundColor = Color.BLACK;
        Color buttonColor = new Color(70, 130, 180);

        getContentPane().setBackground(backgroundColor);

        JLabel titleLabel = new JLabel("HOTEL MANAGEMENT", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(foregroundColor);
        titleLabel.setBounds(100, 20, 300, 40);
        add(titleLabel);

        int buttonWidth = 180, buttonHeight = 40;
        int xOffset = 50, yOffset = 80, ySpacing = 60;

        JButton addEmployeeButton = createRoundedButton("Add Employee", xOffset, yOffset, buttonWidth, buttonHeight, e ->
                new HMSAddEmployeeFrame(hotel)
        );
        add(addEmployeeButton);

        JButton viewEmployeesButton = createRoundedButton("View Employees", xOffset + buttonWidth + 20, yOffset, buttonWidth, buttonHeight, e ->
                new HMSViewEmployeesFrame(hotel)
        );
        add(viewEmployeesButton);

        JButton calculateSalaryButton = createRoundedButton("Calculate Salary", xOffset, yOffset + ySpacing, buttonWidth, buttonHeight, e ->
                new HMSCalculateSalaryFrame(hotel)
        );
        add(calculateSalaryButton);

        JButton viewRevenueButton = createRoundedButton("View Revenue", xOffset + buttonWidth + 20, yOffset + ySpacing, buttonWidth, buttonHeight, e -> {
            double revenue = hotel.generateRevenue();
            JOptionPane.showMessageDialog(this, "Total Revenue: $" + revenue);
        });
        add(viewRevenueButton);

        JButton logoutButton = createRoundedButton("Logout", 175, yOffset + 2 * ySpacing, 150, buttonHeight, e -> System.exit(0));
        add(logoutButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JButton createRoundedButton(String text, int x, int y, int width, int height, ActionListener listener) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20); // Rounded corners with radius 20
                g2.setColor(getForeground());
                g2.drawString(getText(), getWidth() / 2 - g2.getFontMetrics().stringWidth(getText()) / 2, getHeight() / 2 + 5);
                g2.dispose();
            }
        };
        button.setBounds(x, y, width, height);
        button.setBackground(new Color(70, 130, 180));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.addActionListener(listener);
        return button;
    }

    public static void main(String[] args) {
        new HMSMainGUI(new HMSHotel("Pak Hotel", "Lahore"));
    }
}

class HMSAddEmployeeFrame extends JFrame {
    public HMSAddEmployeeFrame(HMSHotel hotel) {
        setTitle("Add New Employee");
        setSize(400, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Color bgColor = new Color(220, 230, 240);
        Color fgColor = Color.BLACK;
        Color btnColor = new Color(70, 130, 180);

        getContentPane().setBackground(bgColor);

        JTextField nameField = new JTextField();
        JTextField ageField = new JTextField();
        JTextField salaryField = new JTextField();
        JTextField extraField = new JTextField();

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 50, 120, 25);
        nameLabel.setForeground(fgColor);
        nameField.setBounds(180, 50, 160, 25);

        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setBounds(50, 90, 120, 25);
        ageLabel.setForeground(fgColor);
        ageField.setBounds(180, 90, 160, 25);

        JLabel salaryLabel = new JLabel("Base Salary:");
        salaryLabel.setBounds(50, 130, 120, 25);
        salaryLabel.setForeground(fgColor);
        salaryField.setBounds(180, 130, 160, 25);

        JLabel positionLabel = new JLabel("Position:");
        positionLabel.setBounds(50, 170, 120, 25);
        positionLabel.setForeground(fgColor);

        String[] positions = { "Manager", "HousekeepingStaff", "Chef", "SeniorManager" };
        JComboBox<String> positionComboBox = new JComboBox<>(positions);
        positionComboBox.setBounds(180, 170, 160, 25);
        positionComboBox.setBackground(btnColor);
        positionComboBox.setForeground(Color.WHITE);

        JLabel extraLabel = new JLabel("Additional Info:");
        extraLabel.setBounds(50, 210, 120, 25);
        extraLabel.setForeground(fgColor);
        extraField.setBounds(180, 210, 160, 25);

        positionComboBox.addActionListener(e -> {
            String role = (String) positionComboBox.getSelectedItem();
            if (role.equals("Manager") || role.equals("SeniorManager")) extraLabel.setText("Bonus:");
            else if (role.equals("HousekeepingStaff")) extraLabel.setText("Hours:");
            else if (role.equals("Chef")) extraLabel.setText("Specialization:");
        });

        JButton addButton = new JButton("Add Employee");
        addButton.setBounds(100, 310, 200, 30);
        addButton.setBackground(btnColor);
        addButton.setForeground(Color.WHITE);
        addButton.addActionListener(e -> {
            try {
                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                double baseSalary = Double.parseDouble(salaryField.getText());
                String role = (String) positionComboBox.getSelectedItem();
                HMSEmployee emp = null;

                switch (role) {
                    case "Manager":
                        emp = new HMSManager(name, age, baseSalary, Double.parseDouble(extraField.getText()));
                        break;
                    case "HousekeepingStaff":
                        emp = new HMSHousekeepingStaff(name, age, baseSalary, Integer.parseInt(extraField.getText()), 15);
                        break;
                    case "Chef":
                        emp = new HMSChef(name, age, baseSalary, extraField.getText(), 2000);
                        break;
                    case "SeniorManager":
                        emp = new HMSSeniorManager(name, age, baseSalary, Double.parseDouble(extraField.getText()), 5000);
                        break;
                }

                hotel.addEmployee(emp);
                JOptionPane.showMessageDialog(null, "Employee Added!");
                nameField.setText(""); ageField.setText(""); salaryField.setText(""); extraField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        add(nameLabel); add(nameField); add(ageLabel); add(ageField);
        add(salaryLabel); add(salaryField); add(positionLabel); add(positionComboBox);
        add(extraLabel); add(extraField); add(addButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}

class HMSCalculateSalaryFrame extends JFrame {
    public HMSCalculateSalaryFrame(HMSHotel hotel) {
        setTitle("Calculate Salary");
        setSize(400, 250);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(220, 230, 240));

        JTextField nameField = new JTextField();
        JLabel nameLabel = new JLabel("Employee Name:");
        nameLabel.setBounds(50, 50, 120, 25);
        nameField.setBounds(180, 50, 180, 25);

        JTextArea resultArea = new JTextArea();
        resultArea.setBounds(50, 150, 300, 40);
        resultArea.setEditable(false);
        resultArea.setBackground(new Color(220, 230, 240));

        JButton calcBtn = new JButton("Calculate");
        calcBtn.setBounds(100, 100, 200, 30);
        calcBtn.setBackground(new Color(70, 130, 180));
        calcBtn.setForeground(Color.WHITE);
        calcBtn.addActionListener(e -> {
            String name = nameField.getText();
            boolean found = false;
            for (HMSEmployee emp : hotel.getEmployeeList()) {
                if (emp.getName().equalsIgnoreCase(name)) {
                    resultArea.setText("Salary: $" + emp.calculateSalary());
                    found = true;
                    break;
                }
            }
            if (!found) resultArea.setText("Employee not found!");
        });

        add(nameLabel); add(nameField); add(calcBtn); add(resultArea);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

class HMSViewEmployeesFrame extends JFrame {
    public HMSViewEmployeesFrame(HMSHotel hotel) {
        setTitle("Employees");
        setSize(600, 400);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] columns = { "Name", "Age", "Base Salary", "Final Salary" };
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);
        table.setBackground(new Color(220, 230, 240));

        for (HMSEmployee e : hotel.getEmployeeList()) {
            model.addRow(new Object[]{e.getName(), e.age, e.baseSalary, e.calculateSalary()});
        }

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JButton closeBtn = new JButton("Close");
        closeBtn.addActionListener(e -> dispose());
        JPanel panel = new JPanel();
        panel.add(closeBtn);
        add(panel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}

abstract class HMSEmployee {
    protected String name;
    protected int age;
    protected double baseSalary;

    public HMSEmployee(String name, int age, double baseSalary) {
        this.name = name;
        this.age = age;
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();

    public String getName() { return name; }
}

class HMSManager extends HMSEmployee {
    private double bonus;
    public HMSManager(String name, int age, double baseSalary, double bonus) {
        super(name, age, baseSalary);
        this.bonus = bonus;
    }
    @Override public double calculateSalary() { return baseSalary + bonus; }
}

class HMSHousekeepingStaff extends HMSEmployee {
    private int hoursWorked;
    private double hourlyRate;
    public HMSHousekeepingStaff(String name, int age, double baseSalary, int hours, double rate) {
        super(name, age, baseSalary);
        this.hoursWorked = hours;
        this.hourlyRate = rate;
    }
    @Override public double calculateSalary() { return baseSalary + (hoursWorked * hourlyRate); }
}

class HMSChef extends HMSEmployee {
    private String specialization;
    private double performanceBonus;
    public HMSChef(String name, int age, double baseSalary, String spec, double bonus) {
        super(name, age, baseSalary);
        this.specialization = spec;
        this.performanceBonus = bonus;
    }
    @Override public double calculateSalary() { return baseSalary + performanceBonus; }
}

class HMSSeniorManager extends HMSManager {
    private double decisionBonus;
    public HMSSeniorManager(String name, int age, double baseSalary, double bonus, double decisionBonus) {
        super(name, age, baseSalary, bonus);
        this.decisionBonus = decisionBonus;
    }
    @Override public double calculateSalary() { return super.calculateSalary() + decisionBonus; }
}

interface HMSRevenue { double generateRevenue(); }

class HMSHotel implements HMSRevenue {
    private String hotelName, location;
    private ArrayList<HMSEmployee> employeeList = new ArrayList<>();

    public HMSHotel(String name, String loc) { this.hotelName = name; this.location = loc; }

    public void addEmployee(HMSEmployee emp) {
        for (HMSEmployee e : employeeList)
            if (e.getName().equalsIgnoreCase(emp.getName())) {
                JOptionPane.showMessageDialog(null, "Employee exists!");
                return;
            }
        employeeList.add(emp);
    }

    public ArrayList<HMSEmployee> getEmployeeList() { return employeeList; }

    @Override public double generateRevenue() { return employeeList.size() * 5000; }
}