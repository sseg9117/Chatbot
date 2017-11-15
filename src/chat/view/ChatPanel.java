package chat.view;

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
	private JTextField inputField;
	private JTextArea chatArea;
	private SpringLayout baseLayout;
	
	public ChatPanel(ChatbotController appController)
	{
		super();
		this.appController = appController;
		//Initialize GUI data members
		chatButton = new JButton("Chat Button");
		chatArea = new JTextArea(10, 25);
		inputField = new JTextField(25);
		baseLayout = new SpringLayout();	
		
		
		
		setupPanel();
		setupLayout();
		setupListeners();
		
	}

	private void setupPanel()
	{
		this.add(chatButton);
		this.setLayout(baseLayout);
	}
	
	private void setupLayout()
	{
		return;
	}
	
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				return;
			}
		});
	}
}
