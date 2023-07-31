import javax.swing.*;
import java.awt.*;
import java.util.jar.JarFile;

public class About extends JFrame {

    About()
    {
         setBounds(100,100,500,400);
         setTitle("About Notepad");
         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         setLayout(null);

         JLabel textLabel = new JLabel("<html>Welcome the Notepad:<br> In the notepad you can add task add " +
                 " <br>tasks you can edit tasks and you can select and copy task:" +
                 "  Build By Vivek Pandey</html>");
         textLabel.setBounds(100,50,400,300);
         textLabel.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,16));
         add(textLabel);



    }

    public static void main(String[] args) {



        new About().setVisible(true);



    }




}
