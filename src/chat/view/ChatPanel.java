package chat.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import chat.controller.ChatbotController;

public class ChatPanel extends JPanel
{
	private ChatbotController appController;
	private JButton chatButton;
	private JButton checkerButton;
	private JTextField inputField;
	private JTextArea chatArea;
	private SpringLayout baseLayout;

	public ChatPanel(ChatbotController appController)
	{
		super();
		this.appController = appController;
		// Initialize GUI data members
		chatButton = new JButton("Chat");
		checkerButton = new JButton("Checker");
		chatArea = new JTextArea(10, 25);
		inputField = new JTextField(20);
		baseLayout = new SpringLayout();

		setupPanel();
		setupLayout();
		setupListeners();

	}

	/**
	 * this is where you setup all your stuff like buttons and windows etc..
	 */
	private void setupPanel()
	{
		this.setBackground(Color.CYAN);
		this.setLayout(baseLayout);
		this.add(chatButton);
		this.add(checkerButton);
		this.add(inputField);
		this.add(chatArea);
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
	}

	/**
	 * this is where all the stuff you put in above this is locatoin on the frame
	 */
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, inputField, 0, SpringLayout.NORTH, chatButton);
		baseLayout.putConstraint(SpringLayout.WEST, inputField, 0, SpringLayout.WEST, chatArea);
		baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 20, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatButton, -24, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatButton, 0, SpringLayout.EAST, chatArea);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 25, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatArea, -25, SpringLayout.EAST, this);
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
	}
}
