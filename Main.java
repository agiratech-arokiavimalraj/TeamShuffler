import java.util.*;


public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Welcome to team shuffler");
        boolean finder;
        boolean mainMenu =false;
        boolean ex=false;
        int tri=0;
        do{
            System.out.println("1.Get Start 2.exit");
            short option = sc.nextShort();
            switch (option){
            case 1:{
                do {
                    System.out.println("Enter the count of the players :");
                    int playerCount = sc.nextInt();

                    if (playerCount <= 22 && playerCount > 1 && tri<=2) {
                        finder = oddEvenFinder(playerCount);
                        String[] playerName = new String[playerCount];
                        initializer(playerName,playerCount);
                        process(finder,playerName,playerCount);
                        System.out.println("");
                        mainMenu=true;
                        break;
                    } else if (tri==2) {
                        tri++;
                        System.out.println("Reschedule to main menu");
                    } else {
                        tri++;
                        System.out.println(" Please Enter a valid Number between 2 to 22");
                    }
                }while (tri<=2||mainMenu==false);
                break;
            }
            case 2:{
                tri=4;
                System.out.println("Visit again later");
                break;
            }
            default:{
                tri++;
                System.out.println("Enter a valid Number.");
                break;
            }
            }
        }while (tri<=3);
    }
    public static void initializer(String playerName[],int count){
        for(int i = 0;i<count;i++){
            i+=1;
            Scanner sa = new Scanner(System.in);
            System.out.println("Enter the player "+i+":");
            try{
                Thread.sleep(1000);}
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            String name=sa.nextLine();
            i-=1;
            playerName[i]=name;
        }
    }
    public static boolean oddEvenFinder(int count){
        int num = count;
        int value = num %2;

        if(value==0){
            return true;
        }else{
            return false;
        }
    }
    public static void process(boolean isEven,String playerName[],int count){
        String[] player = new String[count];
        Random random = new Random();
        ArrayList<Integer> generatedNumbers = new ArrayList<>();
        ArrayList teamA = new ArrayList();
        ArrayList teamB = new ArrayList();
        if(isEven){
            for (int i = 0; i < count; i++) {
                int randomNumber;
                do {
                    randomNumber = random.nextInt(count) ;
                } while (generatedNumbers.contains(randomNumber));
                generatedNumbers.add(randomNumber);
                player[randomNumber]=playerName[i];
            }

            for (int j = 0;j<count;j++){
                if (j%2==0){
                    teamA.add(player[j]);
                }else{
                    teamB.add(player[j]);
                }
            }

            System.out.println("\tTeam A");
            for (Object A:teamA) {
                System.out.println(A);
            }
            System.out.println("\n\tTeam B");
            for (Object B:teamB) {
                System.out.println(B);
            }

        }else{
            for (int i = 0; i < count; i++) {
                int randomNumber;
                do {
                    randomNumber = random.nextInt(count) ;
                } while (generatedNumbers.contains(randomNumber));
                generatedNumbers.add(randomNumber);
                player[randomNumber]=playerName[i];
            }
            String common = player[0];
            for (int j = 1;j<count;j++){
                if (j%2==0){
                    teamA.add(player[j]);
                }else{
                    teamB.add(player[j]);
                }
            }
            System.out.println("\tTeam A");
            for (Object A:teamA) {
                System.out.println(A);
            }
            System.out.println("\n\tTeam B");
            for (Object B:teamB) {
                System.out.println(B);
            }
            System.out.println("\nCommon :"+ common);

        }
    }
}