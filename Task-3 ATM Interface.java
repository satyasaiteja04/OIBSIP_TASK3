import java.util.*;
class ATM
{
    public static HashMap<Integer,ArrayList<String>>account =new HashMap<Integer,ArrayList<String>>();
    public static ArrayList<String> user=new ArrayList<>();
    public static ArrayList<ArrayList<String>>history =new ArrayList<ArrayList<String>>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("User Menu:\n1.Login into Your account\n\n2.Exit\n\nEnter Choice: ");
            int choice=sc.nextInt();
            switch(choice)
            {
                case 1:
                    login();
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter valid choice ");
            }
        }
    }
    public static void login() {
        user.add("260403");
        user.add("sai");
        user.add("10000");
        account.put(260403, user);
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Your Account Number: ");
        int acno=sc.nextInt();
        System.out.println("Enter Your Pin");
        int pin=sc.nextInt();
        String pin1=String.valueOf(pin);
        if(account.containsKey(acno))
        {
            if(pin1.equals((account.get(acno).get(0))))
            {
                System.out.println("Welcome to Banking");
                Transaction(acno);
            }
            else
            {
                System.out.println("Please Enter Valid Pin"+acno);
            }
        }
        else
            System.out.println("Enter Valid Account Number");
    }
    public static void Transaction(int acno) {
        Scanner sc=new Scanner(System.in);
        while(true)
        {
            System.out.println("User Menu:\n1.Transaction history\n2.WithDraw\n3.Deposit\n4.Transfer\n5.Exit\nEnter Choice: ");
            int choice=sc.nextInt();
            switch(choice)
            {
                case 1:
                    miniStatement(acno);
                    break;
                case 2:
                    withDraw(acno);
                    break;
                case 3:
                    Deposit(acno);
                    break;
                case 4:
                    Transfer(acno);
                    break;
               
                case 5:
                    System.out.println("Thank You!!!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter Valid Choice");
            }
        }
    }
    public static void balanceCheck(int acno) {
        System.out.println(" Balance  in your Account is: "+account.get(acno).get(2)+"Rs");
    }
    public static void withDraw(int acno) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the amount to be with drawn: ");
        int cash=sc.nextInt();
        if(cash<=Integer.parseInt(account.get(acno).get(2))){
            System.out.println(" collect your cash "+cash+"Rs");
            String amount=account.get(acno).get(2);
            int amount1=Integer.parseInt(amount);
            amount1-=cash;
            amount=String.valueOf(amount1);
            ArrayList<String> details=account.get(acno);
            details.set(2, amount);
            account.put(acno,details);
            ArrayList<String> historyDetails=new ArrayList<>();
            historyDetails.add(String.valueOf(acno));
            historyDetails.add("With Draw");
            historyDetails.add(String.valueOf(cash));
            history.add(historyDetails);
            System.out.println(" Balance Amount in your Account is: "+account.get(acno).get(2)+"Rs");
        }
        else{
            System.out.println("Insufficent Balance ");
        }
    }
    public static void Deposit(int acno) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Amount to Be Deposit: ");
        int cash=sc.nextInt();
        System.out.println("Your Amount is Credited in your Account of"+cash+"Rs");
            String amount=account.get(acno).get(2);
            int amount1=Integer.parseInt(amount);
            amount1+=cash;
            amount=String.valueOf(amount1);
            ArrayList<String> details=account.get(acno);
            details.set(2, amount);
            account.put(acno,details);
            ArrayList<String> historyDetails=new ArrayList<>();
            historyDetails.add(String.valueOf(acno));
            historyDetails.add("Deposit");
            historyDetails.add(String.valueOf(cash));
            history.add(historyDetails);
            System.out.println("The Balance Amount in your Account is: "+account.get(acno).get(2)+"Rs");
    }
    public static void miniStatement(int acno) {
        System.out.println("------------------------------------------------");
        System.out.println("| Sno. | Account Number | Transaction History | Amount | ");
        System.out.println("------------------------------------------------");
        int c=0;
        for(ArrayList<String> i:history)
        {
            if(Integer.parseInt(i.get(0))==acno){
                System.out.print("| "+c+"    ");
                for(int j=0;j<3;j++){
                    if(j==0)
                    System.out.print("| "+i.get(j)+"           ");
                    else if(j==1){
                        if(i.get(j).equals("With Draw"))
                        System.out.print("| "+i.get(j)+"   ");
                        else if(i.get(j).equals("Transfer"))
                        System.out.print("| "+i.get(j)+"    ");
                        else
                        System.out.print("| "+i.get(j)+"     ");
                    }
                    else
                    System.out.print("| "+i.get(j)+"    ");
                }
                System.out.print("|");
                System.out.println();
                c++;
            }
        }   
    }
    public static void Transfer(int acno) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Account Number to Transfer Money: ");
        int ac1=sc.nextInt();
        System.out.println("Enter Amount to be Transfer: ");
        int cash=sc.nextInt();
        if(cash<=Integer.parseInt(account.get(acno).get(2))){
            System.out.println("Amount of "+cash+"Rs"+"Transfered to "+ac1);
            String amount=account.get(acno).get(2);
            int amount1=Integer.parseInt(amount);
            amount1-=cash;
            amount=String.valueOf(amount1);
            ArrayList<String> details=account.get(acno);
            details.set(2, amount);
            account.put(acno,details);
            ArrayList<String> historyDetails=new ArrayList<>();
            historyDetails.add(String.valueOf(acno));
            historyDetails.add("Transfer");
            historyDetails.add(String.valueOf(cash));
            history.add(historyDetails);
            System.out.println("Balance Amount in your Account is: "+account.get(acno).get(2)+"Rs");
        }
        else{
            System.out.println(" Insufficent Balance!!!");
        }
    }
}