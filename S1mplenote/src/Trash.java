public class Trash{
    int trashIndex;
    int amountTrash = 0;
    boolean empty = true;
    Note[] notesTrash = new Note[999];

    public void emptyTrash(){
        for(int i=0;i<amountTrash+5;i++){
            if(notesTrash[i]!=null){
                notesTrash[i] = null;
                empty = true;
            }
        }
    }
}