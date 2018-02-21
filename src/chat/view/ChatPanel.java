package chat.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import chat.controller.ChatbotController;
import java.awt.Font;

public class ChatPanel extends JPanel
{
	private ChatbotController appController;
	private JButton chatButton;
	private JTextField inputField;
	private JTextArea chatArea;
	private SpringLayout baseLayout;
	private JLabel infoLabel;
	private JScrollPane chatScrollPane;
	private JButton loadButton;
	private JButton saveButton;
	private JButton searchButton;
	private JButton tweetButton;

	public ChatPanel(ChatbotController appController)
	{
		
		super();
		this.appController = appController;
		// Initialize GUI data members
		searchButton = new JButton("Search", new ImageIcon(getClass().getResource("/chat/view/images/Search.png")));
		searchButton.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		saveButton = new JButton("Save", new ImageIcon(getClass().getResource("/chat/view/images/Chat.png")));
		loadButton = new JButton("Load", new ImageIcon(getClass().getResource("/chat/view/images/Load.png")));
		loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		chatButton = new JButton("Chat", new ImageIcon(getClass().getResource("/chat/view/images/Chat.png")));
		tweetButton = new JButton("Tweet", new ImageIcon(getClass().getResource("/chat/view/images/Twitter.png")));
		chatArea = new JTextArea(10, 25);
		inputField = new JTextField(20);
		chatScrollPane = new JScrollPane();
		baseLayout = new SpringLayout();
		baseLayout.putConstraint(SpringLayout.SOUTH, loadButton, -70, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, searchButton, -147, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, saveButton, -147, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, tweetButton, 25, SpringLayout.EAST, loadButton);
		baseLayout.putConstraint(SpringLayout.EAST, tweetButton, -13, SpringLayout.WEST, chatButton);
		baseLayout.putConstraint(SpringLayout.NORTH, chatButton, 37, SpringLayout.SOUTH, chatScrollPane);
		baseLayout.putConstraint(SpringLayout.WEST, chatButton, 13, SpringLayout.EAST, searchButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatButton, -49, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatButton, 0, SpringLayout.EAST, chatScrollPane);
		baseLayout.putConstraint(SpringLayout.EAST, searchButton, -130, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, searchButton, 20, SpringLayout.EAST, saveButton);
		baseLayout.putConstraint(SpringLayout.NORTH, saveButton, 0, SpringLayout.NORTH, searchButton);
		baseLayout.putConstraint(SpringLayout.NORTH, loadButton, 0, SpringLayout.NORTH, tweetButton);
		baseLayout.putConstraint(SpringLayout.NORTH, tweetButton, 10, SpringLayout.SOUTH, searchButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, tweetButton, -92, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, loadButton, -242, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, saveButton, 266, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, loadButton, 266, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, saveButton, -242, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, searchButton, 59, SpringLayout.SOUTH, chatScrollPane);
		baseLayout.putConstraint(SpringLayout.WEST, inputField, 33, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, inputField, -273, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, inputField, 23, SpringLayout.SOUTH, chatScrollPane);
		infoLabel = new JLabel("Type to chat with the chatbot");

		setupScrollPane();
		setupPanel();
		setupLayout();
		setupListeners();

	}

	/**
	 * this is where you setup all your stuff like buttons and windows etc..
	 */
	private void setupPanel()
	{
		this.setMinimumSize(new Dimension(800, 600));
		this.setBackground(Color.CYAN);
		this.setLayout(baseLayout);
		this.add(loadButton);
		this.add(searchButton);
		this.add(tweetButton);
		this.add(saveButton);
		this.add(chatButton);
		this.add(inputField);
		this.add(chatScrollPane);
		this.add(infoLabel);
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
	}

	/**
	 * this is where all the stuff you put in above this is locatoin on the frame
	 */
	private void setupScrollPane()
	{
		chatScrollPane.setViewportView(chatArea);
		chatScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	}
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, chatScrollPane, 20, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatScrollPane, 25, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatScrollPane, -25, SpringLayout.EAST, this);
		baseLayout = new SpringLayout();
		baseLayout.putConstraint(SpringLayout.WEST, infoLabel, 0, SpringLayout.WEST, inputField);
		baseLayout.putConstraint(SpringLayout.SOUTH, infoLabel, -6, SpringLayout.NORTH, inputField);

	}

	/**
	 * this allows the things to have actions
	 */
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userText = inputField.getText();
				String displayText = appController.interactWithChatbot(userText);
				chatArea.append(displayText);
				inputField.setText("");
						 
			}
		});
			
		
		tweetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				appController.tweet(inputField.getText());
			}
			
		});
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
		loadButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
		searchButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
		
	}
	
}
