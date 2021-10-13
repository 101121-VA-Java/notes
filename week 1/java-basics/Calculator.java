/* Class declaration
        - [access modifier] class [name of class]
        - Class files can only have 1 public class
        - name of the public class needs to match the name of the file
*/
public class Calculator{

    public static void main(String[] args){

        System.out.println("This is the first arg " + args[0]);

        switch(args[0]){
            case "Kevin":
                System.out.println("Hello Kevin");
                break;
            case "Friday":
                System.out.println("Can't wait for Friday");
                break;
            default:
                System.out.println("I'm not sure what you mean.");
        }

        int a = 5;

        printHi(a);

        System.out.println("b:");

        int b = 7;

        printHi(b);

        int sum = add(1,2);

        System.out.println(sum);
    }

    /*
        Method declaration:
            - [access modifier] [non-access modifiers] [return type] [name of method] ([param1], [param2]){
                reusable logic
            }
    */
    // print(a) => print(5)
    public static void printHi(int numberOfTimes){
        for(int i = 0; i < numberOfTimes; i++ ){
            System.out.println("hi");
        }
    }

    public static int add(int a, int b){
        return a + b;
    }

    public static int subtract(int a, int b){
        return 0;
    }

}