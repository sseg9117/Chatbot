package chat.view;

import chat.controller.ChatbotController;
import javax.swing.JFrame;

public class ChatFrame extends JFrame
{
	
	private ChatbotController appController;

	public ChatFrame(ChatbotController appController)
	{
		super();
		this.appController = appController;
	}
	
	private void setupFrame()
	{
		this.setVisible(true);
	}
}
