import java.util.*;
public class AgeValidation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Age: 😁 ");
        int age = sc.nextInt();
        try{
            checkAge(age);
        }catch (AgeInvalidException e){
            System.out.println(e.getMessage());
        }finally{
            sc.close();
        }
    }
    static void checkAge(int age) throws AgeInvalidException{
        if(age < 18) throw new AgeInvalidException("Age is not valid 🤬😁😂");
        System.out.println("Eligble to vote");
    }
}

class AgeInvalidException extends  RuntimeException{
    AgeInvalidException(String msg){
        super(msg);
    }
}
