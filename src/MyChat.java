import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MyChat extends JFrame {

    private final JTextArea messageOutput;
    private final JTextField messageInput;
    private final JTextField contacts;


    public MyChat() {
        setBounds(500, 500, 700, 600);
        setTitle("TEST_CHAT");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        messageOutput = new JTextArea();
        messageInput = new JTextField("Enter your message");
        messageOutput.setEditable(false);
        messageOutput.setLineWrap(true);

        messageOutput.setRows(10);
        messageOutput.setWrapStyleWord(true);

        contacts = new JTextField();

        JPanel bottomPanel = new JPanel(new BorderLayout());
        add(bottomPanel, BorderLayout.SOUTH);
        JButton sendMessage = new JButton("SEND");
        bottomPanel.add(sendMessage, BorderLayout.EAST);

        JScrollPane jScrollPane = new JScrollPane(messageOutput);
        add(jScrollPane, BorderLayout.CENTER);

        bottomPanel.add(messageInput, BorderLayout.CENTER);


        sendMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                if ((!messageInput.getText().trim().isEmpty())) ;
                messageOutput.append(String.format("> %s\n", messageInput.getText()));
                messageInput.setText(" ");
                messageInput.grabFocus();
            }
        });
        add(messageOutput);

        messageInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                while ((!messageInput.getText().trim().isEmpty())) {
                    messageOutput.append(String.format("> %s\n", messageInput.getText()));
                    messageInput.setText(" ");
                    messageInput.grabFocus();
                }
            }
        });
        add(messageOutput);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MyChat();
    }

}
