package Main;

import Controller.FilewalkerController;
import Model.FilewalkerModel;
import View.FilewalkerView;

import javax.swing.*;
import java.awt.*;

public class FilewalkerApp {
    public static void main(String[] args) {
        FilewalkerModel model = new FilewalkerModel();
        FilewalkerView view = new FilewalkerView();
        FilewalkerController controller = new FilewalkerController(model, view);

        model.buildTree("D:\\");

        JFrame frame = new JFrame("Filewalker - JTree Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JTree tree = new JTree(model.getRoot());
        JScrollPane treeScrollPane = new JScrollPane(tree);
        JScrollPane textAreaScrollPane = new JScrollPane(view.getTextArea());

        frame.add(treeScrollPane, BorderLayout.WEST);
        frame.add(textAreaScrollPane, BorderLayout.CENTER);

        frame.setVisible(true);

        // Update the view (e.g., when user interacts with the application)
        controller.updateView(tree);
    }
}