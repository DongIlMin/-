package dongil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class FalsePanel extends JFrame{
	private ImageIcon img = new ImageIcon("Images/over.jpg");
	JLabel jl = new JLabel("GAME OVER");
	JButton p[] = {
			new JButton("New Game"),
			new JButton("EXIT")
			};
	public FalsePanel() {
		Container c = getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        JPanel background = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(img.getImage(), 0, 0, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        
        jl.setBounds(300,270,300,50);
        jl.setFont(new Font("Arial", Font.BOLD, 30));
        c.add(jl);
        
		for(int i=0; i<2; i++) {
			p[i].setBorderPainted(false);
			p[i].setContentAreaFilled(false);
			p[i].setOpaque(false);
			p[i].setForeground(Color.black);
			p[i].setBounds(500, 360+i*50, 250, 40);
			p[i].setFont(new Font("Arial", Font.BOLD, 30));
			p[i].addActionListener(new MenuActionListener());
			c.add(p[i]);
		}
        c.add(background);
		setSize(800,600);
		setVisible(true);

	}
	
	class MenuActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			if(btn.getText().equals("New Game")) {
				setVisible(false);
				new game();
				
			}
			else if(btn.getText().equals("EXIT")) {
				int result = JOptionPane.showConfirmDialog(btn, "Do you really wanna quit?", "Quit", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION) System.exit(0);
			}
			
		}
	}
}
class Panel1 extends JFrame{
	private ImageIcon img = new ImageIcon("images/backrea.jpg");
	JLabel jl[] = {
			new JLabel("REA"),
			new JLabel(".. Can you help me?")
	};
	JButton jb[] = {
			new JButton("Sure! What happend?"),
			new JButton("No.. Sorry")
	};
	public Panel1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
        JPanel background = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(img.getImage(), 0, 0, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        jl[0].setBounds(30,450,100,50);
        jl[1].setBounds(30,500,400,40);
		for(int i=0; i<2; i++) {
			jl[i].setForeground(Color.magenta);
			jl[i].setFont(new Font("Arial Black", Font.BOLD, 30));
			jb[i].setFont(new Font("Arial Black", Font.BOLD, 20));
			jb[i].setBounds(430,450+i*50,300,50);
			jb[i].setForeground(Color.black);
			jb[i].setBorderPainted(false);
			jb[i].setContentAreaFilled(false);
			jb[i].setOpaque(false);
			jb[i].addActionListener(new MenuActionListener());
			c.add(jl[i]);
			c.add(jb[i]);
		}
		c.add(background);
		setSize(800,600);
		setVisible(true);
	}
	class MenuActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			if(btn.getText().equals("Sure! What happend?")) {
				setVisible(false);
				new Panel2();
				
			}
			else if(btn.getText().equals("No.. Sorry")) {
				setVisible(false);
				new FalsePanel();
			}
			
		}
	}
}

class Panel2 extends JFrame{
	private ImageIcon img = new ImageIcon("images/rea2.gif");
	JLabel jl[] = {
			new JLabel("REA"),
			new JLabel("First, Draw my Face")
	};
	JButton jb[] = {
			new JButton("OK.. Wait!"),
			new JButton("No.. Sorry")
	};
	public Panel2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
        JPanel background = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(img.getImage(), 0, 0, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        jl[0].setBounds(30,450,100,50);
        jl[1].setBounds(30,500,400,40);
		for(int i=0; i<2; i++) {
			jl[i].setForeground(Color.magenta);
			jl[i].setFont(new Font("Arial Black", Font.BOLD, 30));
			jb[i].setFont(new Font("Arial Black", Font.BOLD, 20));
			jb[i].setBounds(430,450+i*50,300,50);
			jb[i].setForeground(Color.yellow);
			jb[i].setBorderPainted(false);
			jb[i].setContentAreaFilled(false);
			jb[i].setOpaque(false);
			jb[i].addActionListener(new MenuActionListener());
			c.add(jl[i]);
			c.add(jb[i]);
		}
		c.add(background);
		setSize(800,600);
		setVisible(true);
	}
	class MenuActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			if(btn.getText().equals("OK.. Wait!")) {
				setVisible(false);
				new Drawing();
			}
			else if(btn.getText().equals("No.. Sorry")) {
				setVisible(false);
				new FalsePanel();
			}
			
		}
	}
}

class Drawing extends JFrame {

    private int prevX, prevY;
    private boolean drawing = false;
    private boolean erasing = false;

    public Drawing() {
        setTitle("Drawing App");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        Draw draw = new Draw();
        add(draw, BorderLayout.CENTER);

        JButton pencilButton = new JButton("Pencil");
        JButton eraseButton = new JButton("Erase");
        JButton nextButton = new JButton("Submit");

        pencilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                erasing = false;
            }
        });

        eraseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                erasing = true;
            }
        });
        nextButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new quiz1();
				
			}
        	
        });
        JPanel Jp = new JPanel();
        Jp.add(pencilButton);
        Jp.add(eraseButton);
        Jp.add(nextButton);

        add(Jp, BorderLayout.SOUTH);

        draw.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    prevX = e.getX();
                    prevY = e.getY();
                    drawing = true;
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                drawing = false;
            }
        });

        draw.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (drawing) {
                    int x = e.getX();
                    int y = e.getY();
                    if (erasing) {
                        draw.erase(x, y);
                    } else {
                        draw.drawPencilLine(prevX, prevY, x, y);
                    }
                    prevX = x;
                    prevY = y;
                }
            }
        });
    }
    private class Draw extends JPanel {
        private ImageIcon backgroundImage;

        public Draw() {
        	backgroundImage = new ImageIcon("images/drawrea.jpg");
        }

        private void drawPencilLine(int x1, int y1, int x2, int y2) {
            Graphics g = getGraphics();
            g.setColor(Color.BLACK);
            g.drawLine(x1, y1, x2, y2);
        }

        private void erase(int x, int y) {
            Graphics g = getGraphics();
            g.setColor(getBackground());
            g.fillRect(x - 5, y - 5, 15, 15);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage.getImage(), 0, 0, 400, getHeight(), this);
        }
    }
  }

class quiz1 extends JFrame{

    private JLabel quizLabel;
    private JTextField textLabel;
    ImageIcon img = new ImageIcon("images/sawako.jpg");
    
    public quiz1() {
        Container c = getContentPane();

        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel text = new JLabel("Wow..Thank You!");
        JLabel quizLabel = new JLabel("Q.What's my name?");
        textLabel = new JTextField("sawako");
        
        JButton SubmitButton = new JButton("submit");
        SubmitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textLabel.getText().equals("sawako")) {
					setVisible(false);
					new quiz2();
				}
				else {
					setVisible(false);
					new FalsePanel();
				}
			}
        	
        });
        JPanel background = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(img.getImage(), 0, 0, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };  
        c.add(quizLabel);
        c.add(textLabel);
        c.add(SubmitButton);
        c.add(text);
        text.setFont(new Font("Arial", Font.BOLD, 30));
        text.setForeground(Color.magenta);
        text.setBounds(300,290,300,30);
        SubmitButton.setBounds(300,400,300,50);
        SubmitButton.setBorderPainted(false);
        SubmitButton.setFont(new Font("Arial", Font.BOLD, 20));
        quizLabel.setFont(new Font("Italic", Font.BOLD, 25));
        quizLabel.setBounds(300, 300, 300, 100);
        textLabel.setBounds(300, 370, 300, 30);

        c.add(background);
        setSize(800,600);
        setVisible(true);
    }
}

class quiz2 extends JFrame{
	
    private JLabel quizLabel;
    private JButton rea = new JButton("Rea");
    private JButton sawako = new JButton("Sawako");
    private ImageIcon img = new ImageIcon("images/quiz2.jpg");
	public quiz2() {
        Container c = getContentPane();

        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        quizLabel = new JLabel("who's your choice?");
        
        JPanel background = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(img.getImage(), 0, 0, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        c.add(quizLabel);
        c.add(rea);
        c.add(sawako);

        quizLabel.setBounds(250, 300, 400, 100);
        quizLabel.setFont(new Font("Italic", Font.BOLD, 30));
        quizLabel.setForeground(Color.PINK);
        rea.setBounds(200,400,100,50);
        sawako.setBounds(300,400,300,50);
        rea.addActionListener(new MyActionListener());
        sawako.addActionListener(new MyActionListener());
        rea.setFont(new Font("Arial", Font.BOLD, 30));
        sawako.setFont(new Font("Arial", Font.BOLD, 30));
        rea.setForeground(Color.magenta);
        sawako.setForeground(Color.blue);
		rea.setBorderPainted(false);
		sawako.setBorderPainted(false);
        c.setSize(800,600);
        c.add(background);
        setVisible(true);
	}
	
	class MyActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton j = (JButton)e.getSource();
			setVisible(false);
			if(j.getText().equals("Rea")) {
				setVisible(false);
				new finalPanel();
			}
			else {
				setVisible(false);
				new FalsePanel();
			}
		}
			
		}
		
}
class finalPanel extends JFrame{
	private ImageIcon img = new ImageIcon("images/final.jpg");
	private JLabel jf = new JLabel("You are my boyfriend from now on!");
	private JButton ReButton = new JButton("RE GAME");
	private JButton ExitButton = new JButton("Exit");
	public finalPanel() {
		Container c = getContentPane();
		
        JPanel background = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(img.getImage(), 0, 0, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        jf.setBounds(150,400,600,100);
        jf.setFont(new Font("Italic", Font.BOLD, 30));
        jf.setForeground(Color.magenta);
        ReButton.setBounds(230,500,200,50);
        ExitButton.setBounds(380,500,200,50);
        ReButton.setFont(new Font("Arail", Font.BOLD,25));
        ExitButton.setFont(new Font("Arail", Font.BOLD,25));
		ReButton.setBorderPainted(false);
		ExitButton.setBorderPainted(false);
        ReButton.addActionListener(new MyActionListener());
        ExitButton.addActionListener(new MyActionListener());
        c.add(ReButton);
        c.add(ExitButton);
        c.add(jf);
        c.add(background);
        
        setSize(800,600);
        setVisible(true);
	}
	class MyActionListener implements ActionListener {
	@Override
		public void actionPerformed(ActionEvent e) {
			JButton tmp = (JButton)e.getSource();
			if(tmp.getText().equals("RE GAME")) {
				setVisible(false);
				new game();
			}else {
				setVisible(false);
				int result = JOptionPane.showConfirmDialog(null, "Do you really wanna quit?", "Quit", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION) System.exit(0);
				
			}
		}
	}
}
	
public class game extends JFrame{
    Container c = getContentPane();
	JButton p[] = {
			new JButton("GAME START"), 
			new JButton("EXIT")};
	
    private ImageIcon img = new ImageIcon("images/back.jpg");
    
	public game() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        JPanel background = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(img.getImage(), 0, 0, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        
		for(int i=0; i<2; i++) {
			p[i].setBorderPainted(false);
			p[i].setContentAreaFilled(false);
			p[i].setOpaque(false);
			p[i].setForeground(Color.black);
			p[i].setBounds(500, 360+i*50, 250, 40);
			p[i].setFont(new Font("Arial", Font.BOLD, 30));
			p[i].addActionListener(new MenuActionListener());
			c.add(p[i]);
		}
        c.add(background);
		setSize(800,600);
		setVisible(true);

	}
	
	class MenuActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			if(btn.getText().equals("GAME START")) {
				setVisible(false);
				new Panel1();
				
			}
			else if(btn.getText().equals("EXIT")) {
				int result = JOptionPane.showConfirmDialog(null, "Do you really want to quit?", "Quit", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION) System.exit(0);
			}
			
		}
	}
	
	public static void main(String[] args) {
		new game();
	}
}