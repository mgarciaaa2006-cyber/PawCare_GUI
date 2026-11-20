import javax.swing.*;

public class SignUp {
    private JPanel mainPanel;
    private JTextField usernameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JPasswordField confirmField;
    private JButton signUpButton;

    public SignUp() {
        signUpButton.addActionListener(e -> handleSignUp());
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private void handleSignUp() {
        String username = usernameField.getText().trim();
        String email = emailField.getText().trim();
        String password = new String(passwordField.getPassword());
        String confirm = new String(confirmField.getPassword());

        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            show("Please fill in all fields.");
        } else if (!email.matches("^[\\w.+-]+@[\\w-]+\\.[\\w.]+$")) {
            show("Invalid email address.");
        } else if (password.length() < 8) {
            show("Password must be at least 8 characters.");
        } else if (!password.equals(confirm)) {
            show("Passwords do not match.");
        } else {
            show("Account created for " + username + "!");
        }
    }

    private void show(String message) {
        JOptionPane.showMessageDialog(mainPanel, message);
    }
}