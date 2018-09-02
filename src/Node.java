import java.util.ArrayList;

public class Node {

    private String nodeId,referenceNodeId,genesisReferenceNodeId,hashValue;
    private int nodeNumber;
    private ArrayList<String> childReferenceNodeId;
    private Data data;


    // Create a timeStamp

    public Node(Data data,int nodeNumber,String nodeId,String referenceNodeId,ArrayList<String> childReferenceNodeId
    ,String genesisReferenceNodeId,String hashValue){
        this.data=data;
        this.nodeNumber=nodeNumber;
        this.referenceNodeId=referenceNodeId;
        this.nodeId=nodeId;
        this.childReferenceNodeId=childReferenceNodeId;
        this.genesisReferenceNodeId=genesisReferenceNodeId;
        this.hashValue=hashValue;

    }

    public Data getData(){
        return data;
    }
    public int nodeNumber(){
        return nodeNumber;
    }
    public String getNodeId(){
        return nodeId;
    }
    public String getReferenceNodeId(){
        return referenceNodeId;
    }
    public ArrayList<String> getChildReferenceNodeId(){
        return childReferenceNodeId;
    }
    public String getGenesisReferenceNodeId(){
        return genesisReferenceNodeId;
    }
    public String getHashValue(){
        return hashValue;
    }

    public void addToChildren(String NodeId){
        childReferenceNodeId.add(NodeId);
    }
}
