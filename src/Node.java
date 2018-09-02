import java.util.ArrayList;
import java.util.Calendar;

public class Node {

    private String nodeId,referenceNodeId,genesisReferenceNodeId,hashValue;
    private int nodeNumber;
    private ArrayList<String> childReferenceNodeId;
    private Data data;
    java.sql.Timestamp timestamp;

    public Node(Data data,int nodeNumber,String nodeId,String referenceNodeId,ArrayList<String> childReferenceNodeId
    ,String genesisReferenceNodeId,String hashValue){
        this.data=data;
        this.nodeNumber=nodeNumber;
        this.referenceNodeId=referenceNodeId;
        this.nodeId=nodeId;
        this.childReferenceNodeId=childReferenceNodeId;
        this.genesisReferenceNodeId=genesisReferenceNodeId;
        this.hashValue=hashValue;
        Calendar calendar = Calendar.getInstance();
        java.util.Date now = calendar.getTime();
        this.timestamp = new java.sql.Timestamp(now.getTime());

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
    public java.sql.Timestamp getTimestamp(){
        return timestamp;
    }

    public void addToChildren(String NodeId){
        if (childReferenceNodeId==null) {
            childReferenceNodeId=new ArrayList<>();
        }
        this.childReferenceNodeId.add(NodeId);
    }
}
