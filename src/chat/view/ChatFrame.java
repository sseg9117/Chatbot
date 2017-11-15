package chat.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SpringLayout;

import chat.controller.ChatbotController;

public class ChatFrame extends JFrame
{
	
	private ChatbotController appController;
//	private ChatPanel appPanel;

	
	public ChatFrame(ChatbotController appController)
	{
		super();
//		appPanel = new ChatPanel(appController);
		
		
		setupFrame();
	}

	private void setupFrame()
	{
		this.setSize(500,500);
		this.setTitle("Chatbot 2017");
//		this.setContentPane(appPanel);
		this.setResizable(false);
		this.setVisible(true);
	}	

}

