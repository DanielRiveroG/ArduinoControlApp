package model;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class InstructionTree {
    private DefaultTreeModel model;

    public InstructionTree() {
        initTree();
    }

    private void initTree() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Instrucciones");
        DefaultMutableTreeNode digitalIO = new DefaultMutableTreeNode("Entrada/Salida digital");
	model = new DefaultTreeModel(root);
        model.insertNodeInto(digitalIO, root, 0);
	model.insertNodeInto(new DefaultMutableTreeNode(new Instruction("Activar Salida","%WB",1)), digitalIO, 0);
        model.insertNodeInto(new DefaultMutableTreeNode(new Instruction("Desactivar Salida","%WB",1)), digitalIO, 1);
        model.insertNodeInto(new DefaultMutableTreeNode(new Instruction("Leer Entrada","%WB",1)), digitalIO, 2);
    }

    public DefaultTreeModel getModel() {
        return model;
    }
    
}
