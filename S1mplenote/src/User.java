import java.util.Scanner;
public class User{
    String email;
    String password;
    int numNotes = 0;
    int numTrash = 0;
    int numTags = 0;
    Note[] notes = new Note[999];
    Trash trash = new Trash();
    Settings settings = new Settings();

    public void newNote(){
        Note note = new Note();
        Scanner in = new Scanner(System.in);
        in.useDelimiter("\r?\n");
        System.out.println("Título:");
        note.title = in.nextLine();
        System.out.println("Texto:");
        note.text = in.nextLine();
        note.noteIndex = numNotes;
        notes[numNotes] = note;
        numNotes++;

        while(true){
            note.printMenuTag();
            int userOption = in.nextInt();
            if(userOption == 1){
                numTags++;
                note.newTag();
                break;
            }
            if(userOption == 2){
                break;
            }
        }
        System.out.println("Anotação criada com sucesso.");
    }

    public void showNote(){
        for(int i = 0; i < numNotes; i++) {
            if (notes[i] != null) {
                System.out.println("-------------------------");
                System.out.println("|" + i + "| Título: " + notes[i].title);
                System.out.println("'" + notes[i].text + "'");
                System.out.println("TAG:" + notes[i].tag.name);
                System.out.println();
            }
        }
    }

    public void deleteNote(){
        Scanner in = new Scanner(System.in);
        in.useDelimiter("\r?\n");
        System.out.println("Índice a ser deletado:");
        trash.trashIndex = in.nextInt();
        int h;

        for(h = 0;h<numNotes;h++){
            if(notes[h] != null){
                if(trash.trashIndex == notes[h].noteIndex){
                    trash.notesTrash[h] = notes[h];
                    numTrash++;
                    if(notes[h].tag.name!=null){
                        numTags--;
                    }
                    notes[h] = null;
                    trash.empty = false;
                    System.out.println("Índice [" + trash.trashIndex + "] apagado.");
                    break;
                }
            }
        }
        if(h == numNotes){
            System.out.println("Índice [" + trash.trashIndex + "] não encontrado.");
        }
    }

    public void showTrash(){
        for(int i=0;i<trash.notesTrash.length;i++){
            if (trash.notesTrash[i] != null){
                System.out.println("-------------------------");
                System.out.println("|" + i + "| Título: " + trash.notesTrash[i].title);
                System.out.println("'" + trash.notesTrash[i].text + "'");
                System.out.println("TAG:" + trash.notesTrash[i].tag.name);
                System.out.println();
            }
        }
    }

    public void clearTrash(){
        trash.amountTrash = numTrash;
        trash.emptyTrash();
    }

    public void showTag(){
        for(int i=0;i<numNotes;i++){
            if(notes[i] != null){
                System.out.println("TAG:" + notes[i].tag.name);
            }
        }
        Tag tag = new Tag();
        tag.numTags = numTags;
        tag.amountTag();
    }
    public void showSettings(){
        settings.showConfig();
    }

    public void changeSettings(){
        Scanner in = new Scanner(System.in);
        in.useDelimiter("\r?\n");
        boolean changeMenu = true;
        while(changeMenu){
            System.out.println("Ordenar?");
            System.out.println("-[1] - Sim");
            System.out.println("-[2] - Não");
            int sortOption = in.nextInt();
            switch(sortOption){
                case 1:
                    settings.sort = true;
                    break;

                case 2:
                    settings.sort = false;
                    break;

                default:
                    System.out.println("Opção invalida!");
                    System.out.println();
                    break;
            }

            System.out.println("Sincronizar?");
            System.out.println("-[1] - Sim");
            System.out.println("-[2] - Não");
            int syncOption = in.nextInt();
            switch(syncOption){
                case 1:
                    settings.sync = true;
                    break;

                case 2:
                    settings.sync = false;
                    break;

                default:
                    System.out.println("Opção invalida!");
                    System.out.println();
                    break;
            }
            changeMenu = false;
        }
    }
}
