package Todo.examples.objects;

public class Tasks {

    private boolean isCompleted;
    private String item;
    public Tasks(String item,boolean isCompleted )
    {
        this.isCompleted=isCompleted;
        this.item=item;

    }

    public boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }



}
