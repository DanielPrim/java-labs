import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RaceGame extends JFrame {
    private JButton[] buttons;
    private boolean raceInProgress;

    public RaceGame() {
        setTitle("Гонки кнопок");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        buttons = new JButton[4];
        raceInProgress = false;

        initButtons();
    }

    private void initButtons() {
        setLayout(new BorderLayout());

        JPanel racesPanel = new JPanel();
        racesPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;  // Добавленная строка для выравнивания по левому краю
        gbc.insets = new Insets(5, 5, 5, 5);

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("Кнопка " + (i + 1));
            racesPanel.add(buttons[i], gbc);
        }

        add(racesPanel, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton startButton = new JButton("Старт гонки");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startRace();
            }
        });
        controlPanel.add(startButton);

        JButton restartButton = new JButton("Рестарт гонки");
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restartRace();
            }
        });
        controlPanel.add(restartButton);

        JButton stopButton = new JButton("Остановить гонку");
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopRace();
            }
        });
        controlPanel.add(stopButton);

        JButton exitButton = new JButton("Выход");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        controlPanel.add(exitButton);

        add(controlPanel, BorderLayout.SOUTH);
    }

    private void startRace() {
        if (!raceInProgress) {
            raceInProgress = true;
            for (JButton button : buttons) {
                new Thread(new Race(button)).start();
            }
        }
    }

    private void stopRace() {
        if (raceInProgress) {
            raceInProgress = false;
        }
    }

    private void restartRace() {
        stopRace();
        for (JButton button : buttons) {
            button.setLocation(0, button.getY());
            // Цвет меняется только при нажатии на кнопку "Рестарт"
        }
    }

    private Color generateRandomColor() {
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);
        return new Color(r, g, b);
    }

    private class Race implements Runnable {
        private JButton button;

        public Race(JButton button) {
            this.button = button;
            // Цвет устанавливается при создании потока
            button.setBackground(generateRandomColor());
        }

        @Override
        public void run() {
            while (raceInProgress && button.getLocation().x + button.getWidth() < getWidth()) {
                button.setLocation(button.getLocation().x + (int) (Math.random() * 10), button.getLocation().y);
                try {
                    Thread.sleep((long) (Math.random() * 100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (raceInProgress) {
                raceInProgress = false;
                button.setBackground(Color.GREEN);
                JOptionPane.showMessageDialog(null, "Победитель: " + button.getText(), "Гонки завершены", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
