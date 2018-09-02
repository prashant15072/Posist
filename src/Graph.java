import java.util.ArrayList;

public class Graph {

    private ArrayList<Node> adjList;
    private Node genesisNode;
    private ArrayList<ArrayList<String>> output;
    public int count=0,max=Integer.MIN_VALUE;

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

    public void editValueOfNode(String NodeId,int value){
        Node node=findNode(NodeId);
        node.getData().setValue(value);
    }

    public void setValuetoSumOfChildren(String NodeId){
        Node node=findNode(NodeId);
        ArrayList<String> child=node.getChildReferenceNodeId();
        int sumOfchild=0;
        if (child!=null) {
            for (int i = 0; i < child.size(); i++) {
                sumOfchild += findNode(child.get(i)).getData().getValue();
            }
        }
        node.getData().setValue(sumOfchild);
    }

    public ArrayList<String> LongestPath(String str){
        ArrayList<String> paths=new ArrayList<>();
        output=new ArrayList<>();
        Node s=findNode(str);
        paths.add(s.getNodeId());
        longestPathUtil(s,paths);
        int max=Integer.MIN_VALUE,maxIndex=0;
        for (int i=0;i<output.size();i++){
            if (output.get(i).size()>max){
                max=output.get(i).size();
                maxIndex=i;
            }
        }

        return output.get(maxIndex);
    }

    public void longestPathUtil(Node s,ArrayList<String> paths){

        if (s.getChildReferenceNodeId()==null){
            if (paths.size()>=max) {
                max = paths.size();
                output.add(new ArrayList<>(paths));
            }
        }
        if (s.getChildReferenceNodeId()!=null){
            for (String i: s.getChildReferenceNodeId()){
                Node n=findNode(i);
                paths.add(i);
                longestPathUtil(n,paths);
                paths.remove(i);
            }
        }

    }
}
