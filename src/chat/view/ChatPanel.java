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
	private JButton firstButton;
	private JTextField inputFeild;
	private JTextArea chatArea;
	private SpringLayout baseLayout;
	
	public ChatPanel(ChatbotController appController)
	{
		super();
		this.appController = appController;
		firstButton = new JButton("Button 1");
		baseLayout = new SpringLayout();	
		
		setupPanel();
		setupLayout();
		setupListeners();
		
	}

	private void setupPanel()
	{
		this.add(firstButton);
		this.setLayout(baseLayout);
	}
	
	private void setupLayout()
	{
		return;
	}
	
	private void setupListeners()
	{
		firstButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				return;
			}
		});
	}
}