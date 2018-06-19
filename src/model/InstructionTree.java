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
	model.insertNodeInto(new DefaultMutableTreeNode(new Instruction("Salida Binaria Bit","$OB",0)), digitalIO, 0);
        model.insertNodeInto(new DefaultMutableTreeNode(new Instruction("Salida Binaria Byte Bajo","$OL",1)), digitalIO, 1);
        model.insertNodeInto(new DefaultMutableTreeNode(new Instruction("Salida Binaria Byte Alto","$OH",1)), digitalIO, 2);
        model.insertNodeInto(new DefaultMutableTreeNode(new Instruction("Salida Binaria Palabra","$OW",2)), digitalIO, 3);
        model.insertNodeInto(new DefaultMutableTreeNode(new Instruction("Conmutar Salida","$OT",3)), digitalIO, 4);
        model.insertNodeInto(new DefaultMutableTreeNode(new Instruction("Pulso Binario","$OP",4)), digitalIO, 5);
        model.insertNodeInto(new DefaultMutableTreeNode(new Instruction("Esperar entrada binaria","$WB",15)), digitalIO, 6);
        
        DefaultMutableTreeNode analogIO = new DefaultMutableTreeNode("Entrada/Salida analógica");
        model.insertNodeInto(analogIO, root, 1);
        model.insertNodeInto(new DefaultMutableTreeNode(new Instruction("Salida Analógica","$PW",14)), analogIO, 0);
        model.insertNodeInto(new DefaultMutableTreeNode(new Instruction("Esperar entrada analógica","$WA",16)), analogIO, 1);
        
        DefaultMutableTreeNode flowControl = new DefaultMutableTreeNode("Control de flujo");
        model.insertNodeInto(flowControl, root, 2);
        model.insertNodeInto(new DefaultMutableTreeNode(new Instruction("Etiqueta","$XX",5)), flowControl, 0);
        model.insertNodeInto(new DefaultMutableTreeNode(new Instruction("Espera","$XX",6)), flowControl, 1);
        model.insertNodeInto(new DefaultMutableTreeNode(new Instruction("Salto a etiqueta","$XX",7)), flowControl, 2);
        model.insertNodeInto(new DefaultMutableTreeNode(new Instruction("Salto condicional a etiqueta","$XX",8)), flowControl, 3);
        model.insertNodeInto(new DefaultMutableTreeNode(new Instruction("Subrutina","$XX",10)), flowControl, 4);
        model.insertNodeInto(new DefaultMutableTreeNode(new Instruction("Salto a subrutina","$XX",11)), flowControl, 5);
        model.insertNodeInto(new DefaultMutableTreeNode(new Instruction("Salto condicional a subrutina","$XX",13)), flowControl, 6);
        
        DefaultMutableTreeNode variables = new DefaultMutableTreeNode("Variables");
        model.insertNodeInto(variables, root, 3);
        model.insertNodeInto(new DefaultMutableTreeNode(new Instruction("Variable","$XX",9)), variables, 0);
        
        DefaultMutableTreeNode regulators = new DefaultMutableTreeNode("Reguladores");
        model.insertNodeInto(regulators, root, 4);
        model.insertNodeInto(new DefaultMutableTreeNode(new Instruction("Activar Regulador de presión","$RP 0 0",17)), regulators, 0);
        model.insertNodeInto(new DefaultMutableTreeNode(new Instruction("Cambiar consigna de presión","$RP 0 1",17)), regulators, 1);
        model.insertNodeInto(new DefaultMutableTreeNode(new Instruction("Parar Regulador de presión","$RP 0 2",18)), regulators, 2);
    }

    public DefaultTreeModel getModel() {
        return model;
    }
    
}
