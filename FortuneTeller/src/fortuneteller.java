import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class fortuneteller extends JFrame {
    private JLabel titleLabel;
    private JTextArea fortuneTextArea;
    private JButton readFortuneButton;
    private JButton quitButton;
    private JScrollPane scrollPane; 
    private List<String> fortunes;
    private int lastDisplayedFortuneIndex = -1;

    public fortuneteller() {
        fortunes = new ArrayList<>();
        fortunes.add("You will find great success in the near future.");
        fortunes.add("A pleasant surprise is waiting for you.");
        fortunes.add("Your hard work will pay off soon.");
        fortunes.add("Good news will come your way.");
        fortunes.add("Don't worry, be happy.");
        fortunes.add("A thrilling adventure is on the horizon.");
        fortunes.add("You will make new friends in unexpected places.");
        fortunes.add("You'll achieve your goals with determination.");
        fortunes.add("A big opportunity is coming your way.");
        fortunes.add("An exciting journey is in your future.");
        fortunes.add("Love is in the air.");
        fortunes.add("Your creative talents will shine.");
        fortunes.add("Run.");


        setTitle("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(1500, 600);

        createComponents();
        addComponents();
        setupListeners();
    }

    private void createComponents() {
        titleLabel = new JLabel("Fortune Teller", new ImageIcon("C:\\Users\\tadpo\\IdeaProjects\\FortuneTeller\\src\\image.jpg"), JLabel.CENTER);
        titleLabel.setVerticalTextPosition(JLabel.BOTTOM);
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.PLAIN, 36));


        fortuneTextArea = new JTextArea(10, 40);
        fortuneTextArea.setFont(new Font("SansSerif", Font.PLAIN, 16));
        fortuneTextArea.setWrapStyleWord(true);
        fortuneTextArea.setLineWrap(true);
        fortuneTextArea.setEditable(false);

        scrollPane = new JScrollPane(fortuneTextArea);

        readFortuneButton = new JButton("Read My Fortune!");
        readFortuneButton.setFont(new Font("SansSerif", Font.PLAIN, 16));

        quitButton = new JButton("Quit");
        quitButton.setFont(new Font("SansSerif", Font.PLAIN, 16));

    }

    private void addComponents() {
        JPanel topPanel = new JPanel();
        topPanel.add(titleLabel);
        add(topPanel, BorderLayout.NORTH);

        JPanel middlePanel = new JPanel();
        middlePanel.add(scrollPane);
        add(middlePanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(readFortuneButton);
        bottomPanel.add(quitButton);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void setupListeners() {
        readFortuneButton.addActionListener((ActionEvent e) -> {
            displayRandomFortune();
        });

        quitButton.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
    }

    private void displayRandomFortune() {
        int randomIndex;
        do {
            randomIndex = new Random().nextInt(fortunes.size());
        } while (randomIndex == lastDisplayedFortuneIndex);

        String fortune = fortunes.get(randomIndex);
        fortuneTextArea.append(fortune + "\n");
        lastDisplayedFortuneIndex = randomIndex;
    }

    public static void main(String[] args) {
        fortuneteller frame = new fortuneteller();
        frame.setLocationRelativeTo(null);


        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenDimensions = toolkit.getScreenSize();
        int width = (int) (screenDimensions.getWidth() * 0.75);
        frame.setSize(new Dimension(width, frame.getHeight()));

        frame.setVisible(true);
    }
}
