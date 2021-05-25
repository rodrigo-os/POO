import java.util.Scanner;
public class Note{
    String title;
    String text;
    int noteIndex;
    Tag tag = new Tag();

    public void newTag(){
        Scanner in = new Scanner(System.in);
        in.useDelimiter("\r?\n");
        System.out.println("Nome:");
        tag.name = in.nextLine();
    }

    public void printMenuTag(){
        System.out.println("Deseja inserir uma tag?");
        System.out.println("--------------------");
        System.out.println("-[1] - Sim");
        System.out.println("-[2] - Não");
        System.out.println("--------------------");
        System.out.println("Digite sua opção:");
    }
}