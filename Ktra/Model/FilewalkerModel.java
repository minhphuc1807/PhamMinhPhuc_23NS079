package Model;

import javax.swing.tree.DefaultMutableTreeNode;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

public class FilewalkerModel {
    private DefaultMutableTreeNode root;

    public FilewalkerModel() {
        root = new DefaultMutableTreeNode("Ổ D:");
    }

    public void buildTree(String path) {
        File rootDir = new File(path);
        if (rootDir.exists() && rootDir.isDirectory()) {
            buildTree(root, rootDir);
        }
    }

    private void buildTree(DefaultMutableTreeNode node, File file) {
        if (file.isDirectory()) {
            DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(file);
            node.add(childNode);
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    buildTree(childNode, f);
                }
            }
        } else {
            node.add(new DefaultMutableTreeNode(file));
        }
    }

    public DefaultMutableTreeNode getRoot() {
        return root;
    }
}