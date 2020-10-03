/*
 * Created on 2004.4.1
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package v23.Slider;

/**
 * @author Ja
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
import java.awt.Point;
import java.awt.Rectangle;
import java.util.*;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;

public class SliderGame extends JFrame
{

	private class ButtonEvents extends MouseInputAdapter
	{

		private Rectangle dragSourceArea = null;
		private Rectangle dragTargetArea = null;
		private Rectangle panelArea = null;
		private Point cursorOffset = null;

		private boolean isClick;

		public void mousePressed(java.awt.event.MouseEvent e)
		{
			isClick = true;
			JButton b = (JButton) e.getSource();
			// check to see if the target button can be moved
			if (!solved && check(buttons.indexOf(b)))
			{
				// hide the target button
				b.setVisible(false);

				// Figure out the bounds of the areas where source
				// and target buttons are located
				int menuOffset = getJMenuBar().getHeight();
				dragSourceArea = b.getBounds();
				dragTargetArea = ((JButton) buttons.get(hiddenIndex)).getBounds();
				dragSourceArea.translate(0, menuOffset);
				dragTargetArea.translate(0, menuOffset);

				// setup the bounds of the panel to limit the locations on the drag
				// layer
				panelArea =
					new Rectangle(
						0,
						menuOffset,
						getJPanel().getWidth(),
						getJPanel().getHeight());

				// Setup and show the drag button on the upper layer
				getDragButton().setText(b.getText());
				getDragButton().setBounds(dragSourceArea);
				getDragButton().setVisible(true);

				// Offset when repositioning the drag button later
				cursorOffset = new Point(e.getX(), e.getY());
			}
		}

		public void mouseDragged(java.awt.event.MouseEvent e)
		{
			if (dragTargetArea != null)
			{
				// Since we're dragging, this is no longer considered a click
				isClick = false;

				// Draw the target feedback and position the drag button based
				// on the mouse's new location
				e.translatePoint(dragSourceArea.x, dragSourceArea.y);
				Point p = makeSafePoint(e.getX(), e.getY());
				paintTargetFeedback(p.x, p.y);
				getDragButton().setLocation(p.x - cursorOffset.x, p.y - cursorOffset.y);
			}
		}

		public void mouseReleased(java.awt.event.MouseEvent e)
		{
			if (dragTargetArea != null)
			{

				// Turn off the drag button and feedback
				getDragButton().setVisible(false);
				paintTargetFeedback(-1, -1);

				e.translatePoint(dragSourceArea.x, dragSourceArea.y);
				Point p = makeSafePoint(e.getX(), e.getY());

				JButton b = (JButton) e.getSource();
				if (isClick || dragTargetArea.contains(p.x, p.y))
				{
					// if we're considered a simple click, or the dragging ended
					// within the target area, perform the move.
					slide(buttons.indexOf(b));
				}
				else
				{
					// The drag finished outside the target, so just show the
					// hidden button and don't move anything. 
					b.setVisible(true);
				}
				dragTargetArea = null;
				dragSourceArea = null;
			}
		}

		/**
		 * Position the target feedback if necessary for
		 * the given cursor position
		 * 
		 * @param x cursor position x
		 * @param y cursor position y
		 */
		private void paintTargetFeedback(int x, int y)
		{
			if (dragSourceArea.contains(x, y))
			{
				// If the cursor is in the source area, move the feedback 
				// to the source area.
				getHighlightBorder().setBounds(dragSourceArea);
				getHighlightBorder().setVisible(true);
			}
			else if (dragTargetArea.contains(x, y))
			{
				// If the cursor is in the target area, move the feedback 
				// to the target area.
				getHighlightBorder().setBounds(dragTargetArea);
				getHighlightBorder().setVisible(true);
			}
			else
			{
				// Otherwise just hide the feedback
				getHighlightBorder().setVisible(false);
			}
		}

		/**
		 * Translate the given mouse cursor position into a
		 * point safely within the parent panel area.
		 * 
		 * @param cx cursor position x
		 * @param cy cursor position y
		 * @return a safe point
		 */
		private Point makeSafePoint(int cx, int cy)
		{
			Point op = new Point(cx, cy);
			Rectangle t =
				new Rectangle(
					cx - cursorOffset.x,
					cy - cursorOffset.y,
					cx - cursorOffset.x + dragSourceArea.width,
					cy - cursorOffset.y + dragSourceArea.height);

			// Check to see if the entire bounds is within
			// panel area
			if (panelArea.contains(t))
			{
				return op;
			}

			// if the drag top is above the panel top
			if (t.x < panelArea.x)
			{
				t.x = panelArea.x;
			}
			// if the drag bottom is below the panel bottom
			if (t.width > panelArea.x + panelArea.width)
			{
				t.x = panelArea.x + panelArea.width - dragSourceArea.width;
			}
			// if the drag left is before the panel left
			if (t.y < panelArea.y)
			{
				t.y = panelArea.y;
			}
			// if the drag right is after the panel right
			if (t.height > panelArea.y + panelArea.height)
			{
				t.y = panelArea.y + panelArea.height - dragSourceArea.height;
			}

			t.x += cursorOffset.x;
			t.y += cursorOffset.y;

			return t.getLocation();
		}
	}

	private ButtonEvents buttonEvents = new ButtonEvents();

	private javax.swing.JPanel jContentPane = null;
	private javax.swing.JPanel jPanel = null;
	private javax.swing.JLabel statusLabel = null;
	private javax.swing.JButton jButton1 = null;
	private javax.swing.JButton jButton2 = null;
	private javax.swing.JButton jButton3 = null;
	private javax.swing.JButton jButton4 = null;
	private javax.swing.JButton jButton5 = null;
	private javax.swing.JButton jButton6 = null;
	private javax.swing.JButton jButton7 = null;
	private javax.swing.JButton jButton8 = null;
	private javax.swing.JButton jButton9 = null;
	private javax.swing.JButton jButton10 = null;
	private javax.swing.JButton jButton11 = null;
	private javax.swing.JButton jButton12 = null;
	private javax.swing.JButton jButton13 = null;
	private javax.swing.JButton jButton14 = null;
	private javax.swing.JButton jButton15 = null;
	private javax.swing.JButton jButton16 = null;
	private javax.swing.JMenuBar jJMenuBar = null;
	private javax.swing.JMenu gameMenu = null;
	private javax.swing.JMenuItem jMenuItem = null;
	private javax.swing.JMenuItem jMenuItem1 = null;
	private javax.swing.JMenu jMenu = null;
	private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem = null;
	private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1 = null;
	private javax.swing.JButton dragButton = null;
	private javax.swing.JPanel highlightBorder = null;

	private ArrayList buttons;
	private ArrayList correct;
	private ArrayList current;

	private int hiddenIndex;

	private int moves = 0;
	private boolean solved;

	public static void main(String[] args)
	{
		new SliderGame().show();
	}

	/**
	 * This is the default constructor
	 */
	public SliderGame()
	{
		super();
		initialize();

	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize()
	{
		this.setSize(300, 325);
		this.setContentPane(getJContentPane());

		// Add the drag button and feedback square to the drag layer of the
		// frame's LayeredPane.
		this.getLayeredPane().add(getDragButton(), JLayeredPane.DRAG_LAYER);
		this.getLayeredPane().add(getHighlightBorder(), JLayeredPane.DRAG_LAYER);

		this.setJMenuBar(getJJMenuBar());
		this.setTitle("v19.Slider Game");
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

		// Set up the lists of buttons, correct orders and current order
		buttons = new ArrayList(Arrays.asList(getJPanel().getComponents()));
		correct = new ArrayList(16);
		for (int i = 1; i <= 16; i++)
		{
			correct.add(String.valueOf(i));
		}
		current = (ArrayList) correct.clone();
		shuffle();
	}

	/**
	 * Shuffle the numbers on the buttons 
	 */
	private void shuffle()
	{
		// Randomize the order
		Collections.shuffle(current);

		// Reset the stats
		moves = 0;
		solved = false;

		// Reset each of the buttons to reflect the randomized
		// order 
		for (int i = 0; i < buttons.size(); i++)
		{
			JButton b = (JButton) buttons.get(i);
			String value = (String) current.get(i);
			b.setText(value);
			b.setBackground(java.awt.Color.orange);
			if (value.equals("16"))
			{
				b.setVisible(false);
				hiddenIndex = i;
			}
			else
			{
				b.setVisible(true);
			}
		}

		// Reset the status line 
		getStatusLabel().setText("Number of moves: " + moves);
	}

	/**
	 * Check to see if the button at the given index can be moved
	 * @param index the button to check
	 * @return true if the button can move, false otherwise
	 */
	private boolean check(int index)
	{

		if (index < 0 || index > buttons.size() - 1)
			return false;

		boolean valid = false;
		// check up
		if (index > 3)
		{
			valid = (hiddenIndex == index - 4);
		}
		// check down
		if (valid == false && index <= 11)
		{
			valid = (hiddenIndex == index + 4);
		}
		// check right
		if (valid == false && (index % 4) != 3)
		{
			valid = (hiddenIndex == index + 1);
		}
		// check left
		if (valid == false && (index % 4) != 0)
		{
			valid = (hiddenIndex == index - 1);
		}
		return valid;
	}

	/**
	 * React to the pushing of the given button
	 * 
	 * @param index  The number of the button pushed
	 */
	private void slide(int index)
	{

		// Don't do anything if the puzzle is solved
		if (solved)
			return;

		// if not a valid click return
		if (!check(index))
		{
			return;
		}

		// swap positions
		current.set(index, current.set(hiddenIndex, current.get(index)));

		// swap strings
		JButton b = (JButton) buttons.get(index);
		b.setText((String) current.get(index));
		b.setVisible(false);
		b = (JButton) buttons.get(hiddenIndex);
		b.setText((String) current.get(hiddenIndex));
		b.setVisible(true);

		// update the position of the blanked spot
		hiddenIndex = index;

		// Increment the number of moves and update status
		moves++;
		getStatusLabel().setText("Number of moves: " + moves);

		// if you've won
		if (current.equals(correct))
		{
			solved = true;
			// Change the buttons colors to green
			Iterator itr = buttons.iterator();
			while (itr.hasNext())
			{
				((JButton) itr.next()).setBackground(java.awt.Color.green);
			}
		}
	}

	/**
	 * Update the Look and Feel of the game
	 * @param lnf fully qualified look and feel class name
	 */
	private void changeLnF(String lnf)
	{
		try
		{
			UIManager.setLookAndFeel(lnf);
			SwingUtilities.updateComponentTreeUI(this);
		}
		catch (Exception e)
		{
		}
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getJContentPane()
	{
		if (jContentPane == null)
		{
			jContentPane = new javax.swing.JPanel();
			jContentPane.setLayout(new java.awt.BorderLayout());
			jContentPane.add(getJPanel(), java.awt.BorderLayout.CENTER);
			jContentPane.add(getStatusLabel(), java.awt.BorderLayout.SOUTH);
		}
		return jContentPane;
	}
	/**
	 * This method initializes jButton1
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getJButton1()
	{
		if (jButton1 == null)
		{
			jButton1 = new javax.swing.JButton();
			jButton1.setText("1");
			jButton1.setBackground(java.awt.Color.orange);
			jButton1.addMouseListener(buttonEvents);
			jButton1.addMouseMotionListener(buttonEvents);
		}
		return jButton1;
	}
	/**
	 * This method initializes jButton2
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getJButton2()
	{
		if (jButton2 == null)
		{
			jButton2 = new javax.swing.JButton();
			jButton2.setText("2");
			jButton2.setBackground(java.awt.Color.orange);
			jButton2.addMouseListener(buttonEvents);
			jButton2.addMouseMotionListener(buttonEvents);
		}
		return jButton2;
	}
	/**
	 * This method initializes jButton3
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getJButton3()
	{
		if (jButton3 == null)
		{
			jButton3 = new javax.swing.JButton();
			jButton3.setText("3");
			jButton3.setBackground(java.awt.Color.orange);
			jButton3.addMouseListener(buttonEvents);
			jButton3.addMouseMotionListener(buttonEvents);
		}
		return jButton3;
	}
	/**
	 * This method initializes jButton4
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getJButton4()
	{
		if (jButton4 == null)
		{
			jButton4 = new javax.swing.JButton();
			jButton4.setText("4");
			jButton4.setBackground(java.awt.Color.orange);
			jButton4.addMouseListener(buttonEvents);
			jButton4.addMouseMotionListener(buttonEvents);
		}
		return jButton4;
	}
	/**
	 * This method initializes jButton5
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getJButton5()
	{
		if (jButton5 == null)
		{
			jButton5 = new javax.swing.JButton();
			jButton5.setText("5");
			jButton5.setBackground(java.awt.Color.orange);
			jButton5.addMouseListener(buttonEvents);
			jButton5.addMouseMotionListener(buttonEvents);
		}
		return jButton5;
	}
	/**
	 * This method initializes jButton6
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getJButton6()
	{
		if (jButton6 == null)
		{
			jButton6 = new javax.swing.JButton();
			jButton6.setText("6");
			jButton6.setBackground(java.awt.Color.orange);
			jButton6.addMouseListener(buttonEvents);
			jButton6.addMouseMotionListener(buttonEvents);
		}
		return jButton6;
	}
	/**
	 * This method initializes jButton7
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getJButton7()
	{
		if (jButton7 == null)
		{
			jButton7 = new javax.swing.JButton();
			jButton7.setText("7");
			jButton7.setBackground(java.awt.Color.orange);
			jButton7.addMouseListener(buttonEvents);
			jButton7.addMouseMotionListener(buttonEvents);
		}
		return jButton7;
	}
	/**
	 * This method initializes jButton8
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getJButton8()
	{
		if (jButton8 == null)
		{
			jButton8 = new javax.swing.JButton();
			jButton8.setText("8");
			jButton8.setBackground(java.awt.Color.orange);
			jButton8.addMouseListener(buttonEvents);
			jButton8.addMouseMotionListener(buttonEvents);
		}
		return jButton8;
	}
	/**
	 * This method initializes jButton9
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getJButton9()
	{
		if (jButton9 == null)
		{
			jButton9 = new javax.swing.JButton();
			jButton9.setText("9");
			jButton9.setBackground(java.awt.Color.orange);
			jButton9.addMouseListener(buttonEvents);
			jButton9.addMouseMotionListener(buttonEvents);
		}
		return jButton9;
	}
	/**
	 * This method initializes jButton10
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getJButton10()
	{
		if (jButton10 == null)
		{
			jButton10 = new javax.swing.JButton();
			jButton10.setText("10");
			jButton10.setBackground(java.awt.Color.orange);
			jButton10.addMouseListener(buttonEvents);
			jButton10.addMouseMotionListener(buttonEvents);
		}
		return jButton10;
	}
	/**
	 * This method initializes jButton11
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getJButton11()
	{
		if (jButton11 == null)
		{
			jButton11 = new javax.swing.JButton();
			jButton11.setText("11");
			jButton11.setBackground(java.awt.Color.orange);
			jButton11.addMouseListener(buttonEvents);
			jButton11.addMouseMotionListener(buttonEvents);
		}
		return jButton11;
	}
	/**
	 * This method initializes jButton12
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getJButton12()
	{
		if (jButton12 == null)
		{
			jButton12 = new javax.swing.JButton();
			jButton12.setText("12");
			jButton12.setBackground(java.awt.Color.orange);
			jButton12.addMouseListener(buttonEvents);
			jButton12.addMouseMotionListener(buttonEvents);
		}
		return jButton12;
	}
	/**
	 * This method initializes jButton13
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getJButton13()
	{
		if (jButton13 == null)
		{
			jButton13 = new javax.swing.JButton();
			jButton13.setText("13");
			jButton13.setBackground(java.awt.Color.orange);
			jButton13.addMouseListener(buttonEvents);
			jButton13.addMouseMotionListener(buttonEvents);
		}
		return jButton13;
	}
	/**
	 * This method initializes jButton14
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getJButton14()
	{
		if (jButton14 == null)
		{
			jButton14 = new javax.swing.JButton();
			jButton14.setText("14");
			jButton14.setBackground(java.awt.Color.orange);
			jButton14.addMouseListener(buttonEvents);
			jButton14.addMouseMotionListener(buttonEvents);
		}
		return jButton14;
	}
	/**
	 * This method initializes jButton15
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getJButton15()
	{
		if (jButton15 == null)
		{
			jButton15 = new javax.swing.JButton();
			jButton15.setText("15");
			jButton15.setBackground(java.awt.Color.orange);
			jButton15.addMouseListener(buttonEvents);
			jButton15.addMouseMotionListener(buttonEvents);
		}
		return jButton15;
	}
	/**
	 * This method initializes jButton16
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getJButton16()
	{
		if (jButton16 == null)
		{
			jButton16 = new javax.swing.JButton();
			jButton16.setVisible(false);
			jButton16.setText("16");
			jButton16.setBackground(java.awt.Color.orange);
			jButton16.addMouseListener(buttonEvents);
			jButton16.addMouseMotionListener(buttonEvents);
		}
		return jButton16;
	}
	/**
	 * This method initializes jJMenuBar
	 * 
	 * @return javax.swing.JMenuBar
	 */
	private javax.swing.JMenuBar getJJMenuBar()
	{
		if (jJMenuBar == null)
		{
			jJMenuBar = new javax.swing.JMenuBar();
			jJMenuBar.add(getGameMenu());
			jJMenuBar.add(getJMenu());
		}
		return jJMenuBar;
	}
	/**
	 * This method initializes gameMenu
	 * 
	 * @return javax.swing.JMenu
	 */
	private javax.swing.JMenu getGameMenu()
	{
		if (gameMenu == null)
		{
			gameMenu = new javax.swing.JMenu();
			gameMenu.add(getJMenuItem());
			gameMenu.add(getJMenuItem1());
			gameMenu.setText("Game");
			gameMenu.setMnemonic(java.awt.event.KeyEvent.VK_G);
		}
		return gameMenu;
	}
	/**
	 * This method initializes jMenuItem
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private javax.swing.JMenuItem getJMenuItem()
	{
		if (jMenuItem == null)
		{
			jMenuItem = new javax.swing.JMenuItem();
			jMenuItem.setText("Shuffle");
			jMenuItem.setMnemonic(java.awt.event.KeyEvent.VK_S);
			jMenuItem.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(
					java.awt.event.KeyEvent.VK_S,
					java.awt.Event.ALT_MASK,
					false));
			jMenuItem.addActionListener(new java.awt.event.ActionListener()
			{
				public void actionPerformed(java.awt.event.ActionEvent e)
				{
					shuffle();
				}
			});
		}
		return jMenuItem;
	}
	/**
	 * This method initializes jMenuItem1
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private javax.swing.JMenuItem getJMenuItem1()
	{
		if (jMenuItem1 == null)
		{
			jMenuItem1 = new javax.swing.JMenuItem();
			jMenuItem1.setText("Quit");
			jMenuItem1.setMnemonic(java.awt.event.KeyEvent.VK_Q);
			jMenuItem1.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(
					java.awt.event.KeyEvent.VK_Q,
					java.awt.Event.ALT_MASK,
					false));
			jMenuItem1.addActionListener(new java.awt.event.ActionListener()
			{
				public void actionPerformed(java.awt.event.ActionEvent e)
				{
					System.exit(0);
				}
			});
		}
		return jMenuItem1;
	}

	/**
	 * This method initializes jPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getJPanel()
	{
		if (jPanel == null)
		{
			jPanel = new javax.swing.JPanel();
			java.awt.GridLayout layGridLayout7 = new java.awt.GridLayout();
			layGridLayout7.setRows(4);
			layGridLayout7.setColumns(4);
			layGridLayout7.setHgap(10);
			layGridLayout7.setVgap(10);
			jPanel.setLayout(layGridLayout7);

			// Another way to do this, but wouldn't
			// have a visual in the editor.
			//	for (int i = 1; i <= 16; i++) {
			//		String label = String.valueOf(i);
			//		JButton b = new JButton(label);
			//		b.addMouseListener(buttonEvents);
			//		b.addMouseMotionListener(buttonEvents);
			//		jPanel.add(b);
			//	}

			jPanel.add(getJButton1(), null);
			jPanel.add(getJButton2(), null);
			jPanel.add(getJButton3(), null);
			jPanel.add(getJButton4(), null);
			jPanel.add(getJButton5(), null);
			jPanel.add(getJButton6(), null);
			jPanel.add(getJButton7(), null);
			jPanel.add(getJButton8(), null);
			jPanel.add(getJButton9(), null);
			jPanel.add(getJButton10(), null);
			jPanel.add(getJButton11(), null);
			jPanel.add(getJButton12(), null);
			jPanel.add(getJButton13(), null);
			jPanel.add(getJButton14(), null);
			jPanel.add(getJButton15(), null);
			jPanel.add(getJButton16(), null);
			jPanel.setBackground(java.awt.Color.white);
			jPanel.setBorder(
				javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
		}
		return jPanel;
	}
	/**
	 * This method initializes statusLabel
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getStatusLabel()
	{
		if (statusLabel == null)
		{
			statusLabel = new javax.swing.JLabel();
			statusLabel.setText("Number of moves: 0");
			statusLabel.setBorder(
				javax.swing.BorderFactory.createBevelBorder(
					javax.swing.border.BevelBorder.LOWERED));
		}
		return statusLabel;
	}
	/**
	 * This method initializes jMenu
	 * 
	 * @return javax.swing.JMenu
	 */
	private javax.swing.JMenu getJMenu()
	{
		if (jMenu == null)
		{
			jMenu = new javax.swing.JMenu();
			jMenu.add(getJRadioButtonMenuItem());
			jMenu.add(getJRadioButtonMenuItem1());
			jMenu.setText("Theme");
			jMenu.setMnemonic(java.awt.event.KeyEvent.VK_T);
			ButtonGroup bg = new ButtonGroup();
			bg.add(getJRadioButtonMenuItem());
			bg.add(getJRadioButtonMenuItem1());
		}
		return jMenu;
	}
	/**
	 * This method initializes jRadioButtonMenuItem
	 * 
	 * @return javax.swing.JRadioButtonMenuItem
	 */
	private javax.swing.JRadioButtonMenuItem getJRadioButtonMenuItem()
	{
		if (jRadioButtonMenuItem == null)
		{
			jRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
			jRadioButtonMenuItem.setText("Default");
			jRadioButtonMenuItem.setSelected(true);
			jRadioButtonMenuItem.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(
					java.awt.event.KeyEvent.VK_D,
					java.awt.Event.ALT_MASK,
					false));
			jRadioButtonMenuItem.setMnemonic(java.awt.event.KeyEvent.VK_D);
			jRadioButtonMenuItem
				.addActionListener(new java.awt.event.ActionListener()
			{
				public void actionPerformed(java.awt.event.ActionEvent e)
				{
					changeLnF(UIManager.getCrossPlatformLookAndFeelClassName());
				}
			});
		}
		return jRadioButtonMenuItem;
	}
	/**
	 * This method initializes jRadioButtonMenuItem1
	 * 
	 * @return javax.swing.JRadioButtonMenuItem
	 */
	private javax.swing.JRadioButtonMenuItem getJRadioButtonMenuItem1()
	{
		if (jRadioButtonMenuItem1 == null)
		{
			jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
			jRadioButtonMenuItem1.setText("System");
			jRadioButtonMenuItem1.setMnemonic(java.awt.event.KeyEvent.VK_Y);
			jRadioButtonMenuItem1.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(
					java.awt.event.KeyEvent.VK_Y,
					java.awt.Event.ALT_MASK,
					false));
			jRadioButtonMenuItem1
				.addActionListener(new java.awt.event.ActionListener()
			{
				public void actionPerformed(java.awt.event.ActionEvent e)
				{
					changeLnF(UIManager.getSystemLookAndFeelClassName());
				}
			});
		}
		return jRadioButtonMenuItem1;
	}
	/**
	 * This method initializes dragButton
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getDragButton()
	{
		if (dragButton == null)
		{
			dragButton = new javax.swing.JButton();
			dragButton.setVisible(false);
			dragButton.setBackground(new java.awt.Color(51, 102, 255));
		}
		return dragButton;
	}
	/**
	 * This method initializes highlightBorder
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getHighlightBorder()
	{
		if (highlightBorder == null)
		{
			highlightBorder = new javax.swing.JPanel();
			highlightBorder.setOpaque(false);
			highlightBorder.setBorder(
				javax.swing.BorderFactory.createLineBorder(java.awt.Color.black, 2));
			highlightBorder.setBackground(java.awt.Color.white);
			highlightBorder.setVisible(false);
		}
		return highlightBorder;
	}
} //  @jve:visual-info  decl-index=0 visual-constraint="10,10"
