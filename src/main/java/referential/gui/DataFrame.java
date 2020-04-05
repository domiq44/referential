package referential.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import referential.dao.DataDao;
import referential.dao.impl.DataDaoImpl;

public class DataFrame extends JFrame {
	private static final long serialVersionUID = 5858383594961545139L;

	private final JPanel jPanel;
	private final JLabel jLabelKey;
	private final JTextField jTextFieldKey;
	private final JButton jButtonSearch;
	private final JScrollPane jScrollPane;
	private final JTable jTable;
	private final DataModel dataTableModel;

	public DataFrame() {
		setTitle("Data List");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		jLabelKey = new JLabel("Key:");
		jTextFieldKey = new JTextField(12);
		jTextFieldKey.setToolTipText("Enter key");
		jButtonSearch = new JButton("Search");

		jPanel = new JPanel();
		jPanel.setLayout(new FlowLayout());
		jPanel.add(jLabelKey);
		jPanel.add(jTextFieldKey);
		jPanel.add(jButtonSearch);
		add(jPanel, BorderLayout.NORTH);

		dataTableModel = new DataModel();
		jTable = new JTable(dataTableModel);
		jScrollPane = new JScrollPane(jTable);
		add(jScrollPane, BorderLayout.CENTER);

		setBounds(10, 10, 500, 500);
		setVisible(true);

		jButtonSearch.addActionListener(e -> {
			try {
				final String key = jTextFieldKey.getText();
				final DataDao dataDao = new DataDaoImpl();
				dataTableModel.setDatas(dataDao.getDataByKey(key));
			} catch (final Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		});
	}

	public static void main(String[] args) {
		new DataFrame();
	}
}
