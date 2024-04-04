package Controller;



import Model.FilewalkerModel;
import View.FilewalkerView;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.io.File;

public class FilewalkerController {
    private FilewalkerModel model;
    private FilewalkerView view;

    public FilewalkerController(FilewalkerModel model, FilewalkerView view) {
        this.model = model;
        this.view = view;
    }

    public void updateView(JTree tree) {
        tree.addTreeSelectionListener((TreeSelectionEvent e) -> {
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
            if (selectedNode != null && selectedNode.getUserObject() instanceof File) {
                File selectedFile = (File) selectedNode.getUserObject();
                if (selectedFile.isFile()) {
                    try {
                        String content = new String(Files.readAllBytes(selectedFile.toPath()));
                        view.getTextArea().setText(content);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }
}

