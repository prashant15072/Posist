public class MainClass {

    public static void main(String[] args){
        Graph graph=new Graph();

        // 1st part -- Creating genesis Node
        Data data=new Data(1,30,"A");
        graph.addNode(data,1,"1","null",null,"1","hashvalue");

        // 2nd part -- Creating set of child Nodes of a particular node
        Data data2=new Data(2,17,"B");
        Data data3=new Data(3,10,"C");
            //pointing towards genesis node , hence the parent id is 1 that is of genesis node
        graph.addNode(data2,2,"2","1",null,"1","hashvalue");
        graph.addNode(data3,3,"3","1",null,"1","hashvalue");

        // 3rd part -- ChildNode originating from a node lets say B , since the nodeId of B=2 hence the referenceNodeId=2
        Data data4=new Data(4,7,"D");
        graph.addNode(data4,4,"4","2",null,"1","hashvalue");

        // 6th part
        //edit the value of a node
        graph.editValueOfNode("2",15);
        //edit the value of a node to the sum of its children
        graph.setValuetoSumOfChildren("1");
        
    }
}
