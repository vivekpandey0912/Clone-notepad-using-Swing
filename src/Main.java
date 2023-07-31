import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.io.*;
import javax.servlet.*;

public class Main extends JFrame implements ActionListener {

    JMenuBar menuBar = new JMenuBar();
    JMenu file = new JMenu("File");
    JMenu edit = new JMenu("Edit");
    JMenu help = new JMenu("Help");



    JMenuItem newFile = new JMenuItem("New");
    JMenuItem open = new JMenuItem("Open");
    JMenuItem save = new JMenuItem("Save");
    JMenuItem print = new JMenuItem("Print");
    JMenuItem exit = new JMenuItem("Exit");


    JMenuItem cut = new JMenuItem("Cut");
    JMenuItem copy = new JMenuItem("Copy");
    JMenuItem paste = new JMenuItem("Paste");
    JMenuItem selectAll = new JMenuItem("Select All");
    JMenuItem about = new JMenuItem("About");

    JTextArea jTextArea = new JTextArea();



    Main()
    {
        setTitle("Notepad Application");
        setBounds(100,100,800,600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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





        jTextArea.setFont(new Font(Font.SANS_SERIF,Font.BOLD,17));
        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jScrollPane.setBorder(BorderFactory.createEmptyBorder());
        add(jScrollPane);
        jTextArea.setLineWrap(true);
        jTextArea.setWrapStyleWord(true);



        newFile.addActionListener(this);
        open.addActionListener(this);
        save.addActionListener(this);
        print.addActionListener(this);
        exit.addActionListener(this);
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);
        about.addActionListener(this);


    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equalsIgnoreCase("New"))
        {
            jTextArea.setText(null);

        } else if (e.getActionCommand().equalsIgnoreCase("Open")) {

            JFileChooser jFileChooser = new JFileChooser();
            FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("Only Text File","txt");
            jFileChooser.setAcceptAllFileFilterUsed(false);
            jFileChooser.addChoosableFileFilter(fileNameExtensionFilter);
            int action = jFileChooser.showOpenDialog(null);

            if(action!=JFileChooser.APPROVE_OPTION)
            {
                return;
            }else
            {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(jFileChooser.getSelectedFile()));
                    jTextArea.read(reader,null);
                } catch (IOException ex) {
                    ex.getMessage();
                }
            }








        } else if (e.getActionCommand().equalsIgnoreCase("Save")) {

            JFileChooser jFileChooser = new JFileChooser();
            FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("Only Text File","text");
            jFileChooser.setAcceptAllFileFilterUsed(false);
            jFileChooser.addChoosableFileFilter(fileNameExtensionFilter);
            int action = jFileChooser.showSaveDialog(null);
            if(action != JFileChooser.APPROVE_OPTION)
            {
                return;
            }else {
                String fileName = jFileChooser.getSelectedFile().getAbsolutePath().toString();
                if(!fileName.contains(".txt"))
                    fileName = fileName+".txt";
                try {
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
                    jTextArea.write(bufferedWriter);
                } catch (IOException ex) {
                    ex.getMessage();
                }


            }


        } else if (e.getActionCommand().equalsIgnoreCase("Print")) {

            try {
                jTextArea.print();
            } catch (PrinterException ex) {
                throw new RuntimeException(ex);
            }


        } else if (e.getActionCommand().equalsIgnoreCase("Exit")) {

            System.exit(0);

        } else if (e.getActionCommand().equalsIgnoreCase("Cut")) {

            jTextArea.cut();

        }else if (e.getActionCommand().equalsIgnoreCase("Copy")) {


            jTextArea.copy();
        }
        else if (e.getActionCommand().equalsIgnoreCase("Paste")) {

            jTextArea.paste();
        }
        else if (e.getActionCommand().equalsIgnoreCase("Select All")) {

            jTextArea.selectAll();

        }
        else if (e.getActionCommand().equalsIgnoreCase("About")) {

            new About().setVisible(true);
        }

        newFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,KeyEvent.CTRL_DOWN_MASK));
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,KeyEvent.CTRL_DOWN_MASK));
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_DOWN_MASK));
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,KeyEvent.CTRL_DOWN_MASK));
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,KeyEvent.CTRL_DOWN_MASK));
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,KeyEvent.CTRL_DOWN_MASK));
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,KeyEvent.CTRL_DOWN_MASK));
        selectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,KeyEvent.CTRL_DOWN_MASK));
        about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J,KeyEvent.CTRL_DOWN_MASK));
        about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,KeyEvent.CTRL_DOWN_MASK));


    }


    public static void main(String[] args) {
        new Main().setVisible(true);



    }

}