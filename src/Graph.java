import java.util.ArrayList;

public class Graph {

    private ArrayList<Node> adjList;
    private Node genesisNode;

    public Graph(){
        adjList = new ArrayList<>();
    }

    public Node findNode(String nodeId){
        for (int i=0;i<adjList.size();i++){
            if (adjList.get(i).getNodeId().equals(nodeId)){
                return adjList.get(i);
            }
        }
        return null;
    }

    public boolean checkCondition(Node parent,ArrayList<String> childReferenceNodeId,Data data){
        int parentVal=parent.getData().getValue();
        int sumOfchild=0;
        if (childReferenceNodeId!=null) {
            for (int i = 0; i < childReferenceNodeId.size(); i++) {
                sumOfchild += findNode(childReferenceNodeId.get(i)).getData().getValue();
            }
        }
        if (sumOfchild>parentVal){
            return false;
        }
        return true;
    }

    public void addNode(Data data,int nodeNumber,String nodeId,String referenceNodeId,ArrayList<String> childReferenceNodeId
            ,String genesisReferenceNodeId,String hashValue){

        Node parent=findNode(referenceNodeId);
        Node newNode= new Node(data,nodeNumber,nodeId,referenceNodeId,childReferenceNodeId
                ,genesisReferenceNodeId,hashValue);
        adjList.add(newNode);
        if (adjList.size()<=1){
            genesisNode = newNode;
        }
        else if (checkCondition(parent,childReferenceNodeId,data) && adjList.size()>1){
                parent.addToChildren(nodeId);}
        else{
            System.out.println("It doesn't satisfy the graph property");
        }
    }

    public Node getGenesisNode(){
        return genesisNode;
    }
}
