package chat.view;

import javax.swing.JFrame;

import chat.controller.ChatbotController;

public class ChatFrame extends JFrame
{
	/**
	 * get access to other clases/packages
	 */
	private ChatbotController appController;
	private ChatPanel appPanel;

	public ChatFrame(ChatbotController appController)
	{
		super();
		this.appController = appController;
		appPanel = new ChatPanel(appController);		
		setupFrame();
	}
/**
 * sets the size of the popup frame when you start program.
 * and puts name on it.
 */
	private void setupFrame()
	{
		this.setSize(500,500);
		this.setTitle("Chatbot 2017");
		this.setContentPane(appPanel);
		this.setResizable(false);
		this.setVisible(true);
	}	

}

