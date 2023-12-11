//import javax.swing.*;
//import java.awt.*;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//public class ChatServerGUI extends JFrame {
//    private final JLabel connectedUsersLabel;
//    private final JTextArea connectionInfoArea;
//    private final ChatServer server;
//    private final int port;
//
//    public ChatServerGUI() {
//
//        // Ввод порта для сервера
//        port = Integer.parseInt(JOptionPane.showInputDialog(this, "Введите порт для сервера:"));
//
//        // Создаем сервер
//        server = new ChatServer(this, port);
//        server.startServer(port);  // Запускаем сервер сразу после создания
//
//        // Окно
//        setTitle("Chat Server");
//        setSize(600, 400);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        // Счетчик подключенных пользователей
//        connectedUsersLabel = new JLabel("Количество пользователей: 0");
//
//        // Область для информации о подключениях
//        connectionInfoArea = new JTextArea();
//        connectionInfoArea.setEditable(false);
//
//        // Скролл-панель для области информации
//        JScrollPane scrollPane = new JScrollPane(connectionInfoArea);
//        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//
//        // Панель для размещения счетчика и области информации
//        JPanel infoPanel = new JPanel(new BorderLayout());
//        infoPanel.add(connectedUsersLabel, BorderLayout.WEST);
//        infoPanel.add(scrollPane, BorderLayout.CENTER);
//
//        // Добавляем панель в окно
//        add(infoPanel);
//
//    }
//
//    public void startServer() {
//        server.startServer(port);
//    }
//
//    public void updateConnectedUsers(int count) {
//        SwingUtilities.invokeLater(() -> {
//            connectedUsersLabel.setText("Количество пользователей: " + count);
//        });
//    }
//
//    public void appendConnectionInfo(String info) {
//        SwingUtilities.invokeLater(() -> {
//            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//            String formattedDate = sdf.format(new Date());
//
//            connectionInfoArea.append(formattedDate + " " + info + "\n");
//            connectionInfoArea.setCaretPosition(connectionInfoArea.getDocument().getLength());
//        });
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            ChatServerGUI chatServerGUI = new ChatServerGUI();
//            chatServerGUI.startServer();
//            chatServerGUI.setVisible(true);
//        });
//    }
//}
