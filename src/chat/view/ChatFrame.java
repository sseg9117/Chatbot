package chat.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import chat.controller.ChatbotController;

public class ChatFrame extends JFrame
{
	
	private ChatbotController appController;
//	private ChatPanel appPanel;
	private JButton firstButton;
	public ChatFrame(ChatbotController appController)
	{
		super();
		this.setAppController(appController);
//		appPanel = new ChatPanel(appController);
		firstButton = new JButton("Button 1");
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setSize(500,500);
		this.setTitle("Chatbot 2017");
//		this.setContentPane(appPanel);
		this.setResizable(false);
		this.setVisible(true);
		
		setupPanel();
	}
	
	private void setupPanel()
	{
		this.add(firstButton);
	}

}

