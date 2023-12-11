import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class ChatClientGUI extends JFrame {
    private Socket socket;
    private BufferedWriter writer;
    private BufferedReader reader;
    private String nickname;

    private JTextArea chatArea;
    private JTextField messageField;

    public ChatClientGUI() {
        // Окно
        setTitle("Chat Client");
        setSize(512, 1024);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Область чата
        chatArea = new JTextArea();
        chatArea.setEditable(false);

        // Скролл-панель для области чата
        JScrollPane scrollPane = new JScrollPane(chatArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        // Поле ввода и кнопка отправки сообщения
        messageField = new JTextField();
        JButton sendButton = new JButton("Отправить");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        // Панель для размещения поля ввода и кнопки
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(messageField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        // Панель для размещения области чата и панели ввода
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(inputPanel, BorderLayout.SOUTH);

        // Добавляем основную панель в окно
        add(mainPanel);

        // Ввод никнейма
        nickname = JOptionPane.showInputDialog(this, "Введите ваш никнейм:");

        // Инициализация сокета и потоков ввода/вывода
        try {
            socket = new Socket("localhost", 54321);
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Отправляем серверу никнейм при подключении
            writer.write(nickname + "\n");
            writer.flush();

            // Создаем отдельный поток для чтения сообщений от сервера
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        String message;
                        while ((message = reader.readLine()) != null) {
                            appendToChat(message);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage() {
        String message = messageField.getText();
        if (!message.isEmpty()) {
            try {
                writer.write(message + "\n");
                writer.flush();
                messageField.setText("");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void appendToChat(String message) {
        chatArea.append(message + "\n");
        chatArea.setCaretPosition(chatArea.getDocument().getLength());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ChatClientGUI().setVisible(true);
            }
        });
    }
}