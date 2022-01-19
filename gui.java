import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class gui { 

    /** 
     * Method to initialize the chat window 
     */
    public void initializeChatWindow() {

        JFrame frame = new JFrame("Basic Chat Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set a size for the frame 
        frame.setSize(600,600);

        // create a menu bar in my GUI
        JMenuBar menuBar = new JMenuBar();

        // create two options for the menu bar
        JMenu option1 = new JMenu("File");
        JMenu option2 = new JMenu("Help");

        // add the two options to the menubar instance
        menuBar.add(option1);
        menuBar.add(option2);

        // create two menu items for the first menu bar options
        JMenuItem option1_1 = new JMenuItem("Open new file");
        JMenuItem option1_2 = new JMenuItem("Save as");

        // add the two options to the menu option
        option1.add(option1_1);
        option1.add(option1_2);

        ///////

        // create a new panel for a chat box
        JPanel chat = new JPanel(); 

        // create a label 
        JLabel label = new JLabel("Enter Text");

        // create a text field -> 10 indicates the maximum number of letters
        JTextField textField = new JTextField(10); 

        // create a button for both send and reset 
        JButton send = new JButton("Send");

        // Add a window to put the words in the middle of the screen
        JTextArea textArea = new JTextArea();
        // make the window scroll automatically
        textArea.setAutoscrolls(true);
        // make it so that we can't edit the window directly 
        textArea.setEditable(false);

        // create margins for the text area
        textArea.setMargin(new Insets(7,7,7,7));
        
        // create a keyboard listener 
        textField.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent keyPressed)
            {
   
                // If the user presses enter and the textbox isn't empty, send the text from the textbox to the chat
                if(keyPressed.getKeyCode() == KeyEvent.VK_ENTER && textField.getText() != null) {
                    textArea.append("You: " + textField.getText() + "\n");
                    textField.setText("");
                }
            }
            
        });

        send.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent buttonClicked) {
                                
                // If the user clicks on the send button and the textbox isn't empty, send the text from the textbox to the chat
                if(textField.getText() != null) {
                    textArea.append("You: " + textField.getText() + "\n");
                    textField.setText("");
                }

            }
        });

        chat.add(label); 
        chat.add(textField);
        chat.add(send);

        // add the menu bar to the frame
        frame.getContentPane().add(BorderLayout.NORTH, menuBar);
        frame.getContentPane().add(BorderLayout.SOUTH, chat);
        frame.getContentPane().add(BorderLayout.CENTER, textArea);

        frame.setVisible(true);
     }

     public gui() { 
        initializeChatWindow();
     }


     public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run()
            {
                new gui();
                
            }
        });
    }


}