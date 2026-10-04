package com.lunarstarter.client.ui;

import com.lunarstarter.client.Client;
import com.lunarstarter.client.module.Module;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

public class ClientFrame extends JFrame {
    private final Client client;
    private final DefaultListModel<String> moduleModel = new DefaultListModel<>();
    private final JList<String> moduleList = new JList<>(moduleModel);
    private final JTextArea detailsArea = new JTextArea();

    public ClientFrame(Client client) {
        this.client = client;
        initFrame();
        populateModules();
        bindSelection();
    }

    private void initFrame() {
        setTitle("Lunar-inspired Client");
        setSize(900, 560);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(12, 12));

        JPanel root = new JPanel(new BorderLayout(12, 12));
        root.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        root.setBackground(new Color(18, 18, 23));

        JPanel sidebar = new JPanel(new BorderLayout());
        sidebar.setBackground(new Color(28, 28, 36));
        sidebar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel title = new JLabel("Modules");
        title.setForeground(new Color(230, 230, 240));
        title.setFont(new Font("SansSerif", Font.BOLD, 18));
        sidebar.add(title, BorderLayout.NORTH);

        moduleList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        moduleList.setBackground(new Color(40, 40, 52));
        moduleList.setForeground(new Color(240, 240, 245));
        moduleList.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        JScrollPane scrollPane = new JScrollPane(moduleList);
        scrollPane.setPreferredSize(new Dimension(260, 0));
        sidebar.add(scrollPane, BorderLayout.CENTER);

        JPanel content = new JPanel(new BorderLayout(10, 10));
        content.setBackground(new Color(18, 18, 23));
        content.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel header = new JLabel("Client Dashboard");
        header.setForeground(new Color(255, 255, 255));
        header.setFont(new Font("SansSerif", Font.BOLD, 26));
        content.add(header, BorderLayout.NORTH);

        detailsArea.setEditable(false);
        detailsArea.setBackground(new Color(24, 24, 30));
        detailsArea.setForeground(new Color(220, 220, 220));
        detailsArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        detailsArea.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        content.add(new JScrollPane(detailsArea), BorderLayout.CENTER);

        JPanel actions = new JPanel(new FlowLayout(FlowLayout.LEFT));
        actions.setBackground(new Color(18, 18, 23));

        JButton toggleButton = new JButton("Toggle Selected");
        toggleButton.addActionListener(e -> {
            int index = moduleList.getSelectedIndex();
            if (index >= 0) {
                String name = moduleModel.getElementAt(index);
                Module module = client.getModuleManager().getByName(name);
                if (module != null) {
                    module.toggle();
                    refreshDetails(name);
                }
            }
        });

        actions.add(toggleButton);
        content.add(actions, BorderLayout.SOUTH);

        root.add(sidebar, BorderLayout.WEST);
        root.add(content, BorderLayout.CENTER);
        setContentPane(root);
    }

    private void populateModules() {
        moduleModel.clear();
        for (Module module : client.getModuleManager().getModules()) {
            moduleModel.addElement(module.getName());
        }
        if (!moduleModel.isEmpty()) {
            moduleList.setSelectedIndex(0);
        }
    }

    private void bindSelection() {
        moduleList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int index = moduleList.getSelectedIndex();
                if (index >= 0) {
                    String selected = moduleModel.getElementAt(index);
                    refreshDetails(selected);
                }
            }
        });
    }

    private void refreshDetails(String name) {
        Module module = client.getModuleManager().getByName(name);
        if (module == null) {
            detailsArea.setText("No module selected");
            return;
        }

        String state = module.isEnabled() ? "Enabled" : "Disabled";
        detailsArea.setText(
                "Name: " + module.getName() + "\n" +
                "State: " + state + "\n" +
                "Description: " + module.getDescription() + "\n\n" +
                "This module acts as a placeholder for a real in-game feature. " +
                "You can extend this by adding rendering, keybinds, and event hooks."
        );
    }
}
