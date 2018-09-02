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
    }
}
