public class Data {
    private int ownerId;
    private int value;
    private String name;

    public Data(int ownerId, int value, String name){
        this.ownerId=ownerId;
        this.value=value;
        this.name=name;
    }

    public int getValue(){
        return value;
    }

    public void setValue(int value){
        this.value=value;
    }

}