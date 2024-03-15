import java.util.*;
public class Task_1_Number_game{
    public static void main(String args[]){
        //create random class
        Random random=new Random();
        //generate the random num
        int random_num=random.nextInt(100) + 1;
        //class for input
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.print("This game generates a random number, ");
        System.out.println("You can guess the number between 1 to 100");
        
        int Guessed_num;
        do{
            System.out.println("Enter your Guessed number: ");
            Guessed_num=sc.nextInt();
            
            if (Guessed_num < random_num) {
                System.out.println("Too low! Try again.");
            } else if (Guessed_num > random_num) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed it right!");
            }
        } while (Guessed_num != random_num);

        
    }
}

        
    
