package chat.view;

import javax.swing.JFrame;

import chat.controller.ChatbotController;

public class ChatFrame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * get access to other clases/packages
	 */
	private ChatbotController appController;
	private ChatPanel appPanel;

	public ChatFrame(ChatbotController appController)
	{
		super();
		this.setAppController(appController);
		appPanel = new ChatPanel(appController);		
		setupFrame();
	}
/**
 * sets the size of the popup frame when you start program.
 * and puts name on it.
 */
	private void setupFrame()
	{
		this.setSize(800,600);
		this.setTitle("Chatbot 2017");
		this.setContentPane(appPanel);
		this.setResizable(false);
		this.setVisible(true);
	}
public Object getBaseController()
{
	return null;
}
public ChatbotController getAppController()
{
	return appController;
}
public void setAppController(ChatbotController appController)
{
	this.appController = appController;
}

}

