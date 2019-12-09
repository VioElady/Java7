import java.util.Scanner;

public class DuplicateElimination {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int dim[] = new int[5];

        int count = 0;
        int x = 0;
        int num = 0;

        while (x < dim.length)
        {
            System.out.println("Enter number: ");
            num = input.nextInt();

            if ((num >= 10) && (num <= 100)) {
                boolean digit = false;
                x++;

                for (int i = 0; i < dim.length; i++)
                {   if (dim[i] == num)
                    digit = true;
                }

                if (!digit) {
                    dim[count] = num;
                    count++;
                }

                else
                    System.out.println("the number was entered before \n");
            }
            else
                System.out.println("number must be between 10 and 100");

            for (int i =0;  i < x; i++) {
                System.out.print(dim[i] +" ");
            }
            System.out.println();
        }
    }
}