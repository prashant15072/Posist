import java.util.ArrayList;

public class Graph {

    private ArrayList<Node> adjList;
    private Node genesisNode;

    public Graph(){
        adjList = new ArrayList<>();
    }

    public Node findNode(String nodeId){
        for (int i=0;i<adjList.size();i++){
            if (adjList.get(i).equals(nodeId)){
                return adjList.get(i);
            }
        }
        return null;
    }

    public void addNode(Data data,int nodeNumber,String nodeId,String referenceNodeId,ArrayList<String> childReferenceNodeId
            ,String genesisReferenceNodeId,String hashValue){

        Node parent=findNode(referenceNodeId);

        Node newNode= new Node(data,nodeNumber,nodeId,referenceNodeId,childReferenceNodeId
                ,genesisReferenceNodeId,hashValue);
        adjList.add(newNode);

        if (adjList.size()>1){
            parent.addToChildren(nodeId);
        }else{
            genesisNode=newNode;
        }
    }

    public Node getGenesisNode(){
        return genesisNode;
    }
}
