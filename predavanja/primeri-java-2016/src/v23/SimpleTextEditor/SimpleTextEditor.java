/*
 * Created on 2004.4.1
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package v23.SimpleTextEditor;

/**
 * @author Ja
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
import java.io.*;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * An example which shows off a functional simple text editor.  Includes a variety of events.
 */
public class SimpleTextEditor extends JFrame
{

	private javax.swing.JPanel jContentPane = null;
	private javax.swing.JPanel jPanel = null;
	private javax.swing.JButton jButton = null;
	private javax.swing.JButton jButton1 = null;
	private javax.swing.JButton jButton2 = null;
	private javax.swing.JScrollPane jScrollPane = null;
	private javax.swing.JTextArea jTextArea = null;
	private javax.swing.JFileChooser jFileChooser = null;
	//  @jve:visual-info  decl-index=0 visual-constraint="582,36"

	private boolean hasChanged = false;
	private static final String title = "Simple Text Editor";

	/**
	 * This method initializes 
	 * 
	 */
	public SimpleTextEditor()
	{
		super();
		initialize();
	}
	public static void main(String[] args)
	{
		SimpleTextEditor ste = new SimpleTextEditor();
		ste.show();
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
			jContentPane.add(getJPanel(), java.awt.BorderLayout.SOUTH);
			jContentPane.add(getJScrollPane(), java.awt.BorderLayout.CENTER);
			jContentPane.setBorder(
				javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
		}
		return jContentPane;
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize()
	{
		this.setContentPane(getJContentPane());
		this.setSize(480, 284);
		this.setTitle(title);
		this.setDefaultCloseOperation(
			javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new java.awt.event.WindowAdapter()
		{
			public void windowClosing(java.awt.event.WindowEvent e)
			{
				doExit();
			}
		});

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
			jPanel.add(getJButton(), null);
			jPanel.add(getJButton1(), null);
			jPanel.add(getJButton2(), null);
		}
		return jPanel;
	}
	/**
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getJButton()
	{
		if (jButton == null)
		{
			jButton = new javax.swing.JButton();
			jButton.setText("Load File");
			jButton.addActionListener(new java.awt.event.ActionListener()
			{
				public void actionPerformed(java.awt.event.ActionEvent e)
				{
					loadFile();
				}
			});
		}
		return jButton;
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
			jButton1.setText("Save File");
			jButton1.addActionListener(new java.awt.event.ActionListener()
			{
				public void actionPerformed(java.awt.event.ActionEvent e)
				{
					saveFile();
				}
			});
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
			jButton2.setText("Exit");
			jButton2.addActionListener(new java.awt.event.ActionListener()
			{
				public void actionPerformed(java.awt.event.ActionEvent e)
				{
					doExit();
				}
			});
		}
		return jButton2;
	}
	/**
	 * This method initializes jScrollPane
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private javax.swing.JScrollPane getJScrollPane()
	{
		if (jScrollPane == null)
		{
			jScrollPane = new javax.swing.JScrollPane();
			jScrollPane.setViewportView(getJTextArea());
		}
		return jScrollPane;
	}
	/**
	 * This method initializes jTextArea
	 * 
	 * @return javax.swing.JTextArea
	 */
	private javax.swing.JTextArea getJTextArea()
	{
		if (jTextArea == null)
		{
			jTextArea = new javax.swing.JTextArea();
			jTextArea.addKeyListener(new java.awt.event.KeyAdapter()
			{
				public void keyTyped(java.awt.event.KeyEvent e)
				{
					if (!hasChanged)
					{
						setTitle(title + " *");
						hasChanged = true;
					}
				}
			});
		}
		return jTextArea;
	}
	/**
	 * This method initializes jFileChooser
	 * 
	 * @return javax.swing.JFileChooser
	 */
	private javax.swing.JFileChooser getJFileChooser()
	{
		if (jFileChooser == null)
		{
			jFileChooser = new javax.swing.JFileChooser();
			jFileChooser.setMultiSelectionEnabled(false);
		}
		return jFileChooser;
	}

	private void loadFile()
	{
		int state = getJFileChooser().showOpenDialog(this);
		if (state == JFileChooser.APPROVE_OPTION)
		{
			File f = getJFileChooser().getSelectedFile();
			try
			{
				BufferedReader br = new BufferedReader(new FileReader(f));
				getJTextArea().read(br, null);
				br.close();
				setTitle(title);
				hasChanged = false;
			}
			catch (FileNotFoundException e1)
			{
				e1.printStackTrace();
			}
			catch (IOException e1)
			{
				e1.printStackTrace();
			}
		}
	}

	private void saveFile()
	{
		int state = getJFileChooser().showSaveDialog(this);
		if (state == JFileChooser.APPROVE_OPTION)
		{
			File f = getJFileChooser().getSelectedFile();
			try
			{
				BufferedWriter bw = new BufferedWriter(new FileWriter(f));
				getJTextArea().write(bw);
				bw.close();
				setTitle(title);
				hasChanged = false;
			}
			catch (FileNotFoundException e1)
			{
				e1.printStackTrace();
			}
			catch (IOException e1)
			{
				e1.printStackTrace();
			}
		}
	}

	private void doExit()
	{
		if (hasChanged)
		{
			int state =
				JOptionPane.showConfirmDialog(
					this,
					"File has been changed. Save before exit?");
			if (state == JOptionPane.YES_OPTION)
			{
				saveFile();
			}
			else if (state == JOptionPane.CANCEL_OPTION)
			{
				return;
			}
		}
		System.exit(0);
	}
} //  @jve:visual-info  decl-index=0 visual-constraint="20,27"
