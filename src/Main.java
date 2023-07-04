import javax.swing.*;

public class Main extends JFrame {

    JMenuBar menuBar = new JMenuBar();
    JMenu file = new JMenu("File");
    JMenu edit = new JMenu("Edit");
    JMenu help = new JMenu("Help");



    JMenuItem newFile = new JMenuItem("New");
    JMenuItem open = new JMenuItem("Exit");
    JMenuItem save = new JMenuItem("Save");
    JMenuItem print = new JMenuItem("Print");
    JMenuItem exit = new JMenuItem("Exit");


    JMenuItem cut = new JMenuItem("Cut");
    JMenuItem copy = new JMenuItem("copy");
    JMenuItem paste = new JMenuItem("paste");
    JMenuItem selectAll = new JMenuItem("Select All");
    JMenuItem about = new JMenuItem("About");


    Main()
    {
        setTitle("Notepad Application");
        setBounds(100,100,800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setJMenuBar(menuBar);
        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(help);

        file.add(newFile);
        file.add(open);
        file.add(save);
        file.add(print);
        file.add(exit);

        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        help.add(about);








    }


    public static void main(String[] args) {
        new Main().setVisible(true);



    }
}