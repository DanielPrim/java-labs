//import java.io.*;
//import java.net.*;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//public class ChatServer {
//    private List<ClientHandler> clients = new ArrayList<>();
//    private ChatServerGUI gui;
//
//    public ChatServer(ChatServerGUI gui, int port) {
//        this.gui = gui;
//    }
//
//    public void startServer(int port) {
//        try {
//            ServerSocket serverSocket = new ServerSocket(port);
//            gui.appendConnectionInfo("Сервер запущен на порту " + port + "...");
//
//            while (true) {
//                Socket clientSocket = serverSocket.accept();
//                ClientHandler clientHandler = new ClientHandler(clientSocket);
//                clients.add(clientHandler);
//                new Thread(clientHandler).start();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public synchronized void broadcast(String message) {
//        for (ClientHandler client : clients) {
//            client.sendMessage(message);
//        }
//    }
//
//    public synchronized void removeClient(ClientHandler client) {
//        clients.remove(client);
//        updateConnectedUsers();
//    }
//
//    private void updateConnectedUsers() {
//        gui.updateConnectedUsers(clients.size());
//    }
//
//    private class ClientHandler implements Runnable {
//        private Socket clientSocket;
//        private BufferedReader reader;
//        private BufferedWriter writer;
//        private String nickname;
//
//        public ClientHandler(Socket socket) {
//            this.clientSocket = socket;
//            try {
//                reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//                writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
//                nickname = reader.readLine();
//                broadcast(nickname + " присоединился к чату.");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        public void run() {
//            String message;
//            try {
//                while ((message = reader.readLine()) != null) {
//                    broadcast(nickname + ": " + message);
//                }
//            } catch (IOException e) {
//                // Клиент отключился
//            } finally {
//                try {
//                    broadcast(nickname + " покинул чат.");
//                    removeClient(this);
//                    clientSocket.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//        public void sendMessage(String message) {
//            try {
//                writer.write(message + "\n");
//                writer.flush();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    private List<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) {
        new ChatServer().startServer();
    }

    public void startServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(54321);
            System.out.println("Сервер запущен...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clients.add(clientHandler);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void broadcast(String message) {
        for (ClientHandler client : clients) {
            client.sendMessage(message);
        }
    }

    public synchronized void removeClient(ClientHandler client) {
        clients.remove(client);
    }

    private class ClientHandler implements Runnable {
        private Socket clientSocket;
        private BufferedReader reader;
        private BufferedWriter writer;
        private String nickname;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
            try {
                reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                nickname = reader.readLine();
                broadcast(nickname + " присоединился к чату.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            try {
                System.out.println("Новый клиент подключен: " + clientSocket.getInetAddress() + ":" + clientSocket.getPort() + " (" + nickname + ")");
                broadcast(nickname + " присоединился к чату.");
                String message;
                while ((message = reader.readLine()) != null) {
                    broadcast(nickname + ": " + message);
                }
            } catch (IOException e) {
                // Клиент отключился
            } finally {
                try {
                    broadcast(nickname + " покинул чат.");
                    removeClient(this);
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public void sendMessage(String message) {
            try {
                writer.write(message + "\n");
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
