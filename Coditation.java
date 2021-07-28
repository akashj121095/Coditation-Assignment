import java.lang.*;
import java.util.*;

public class Coditation
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        String ANSI_CYAN   = "\u001B[36m";
        String ANSI_WHITE  = "\u001B[37m";
        String ANSI_BRIGHT_CYAN   = "\u001B[96m";
        String ANSI_BRIGHT_WHITE  = "\u001B[97m";
        String ANSI_RESET  = "\u001B[0m";

        int X,Y;
        System.out.println("Enter X dimension: ");
        X = sc.nextInt();
        
        System.out.println("Enter Y dimension: ");
        Y = sc.nextInt();
        
        int [][] Matrix = new int[X][Y];
        System.out.println();
        for(int i =0;i<X;i++)
        {
            for(int j=0;j<Y;j++)
            {
                Matrix[i][j] = sc.nextInt();
            }
        }

        int[][] gotit = solver(Matrix,X,Y);
        
        int choice = 1;
        while(choice!=0)
        {
            int cas;
        
            System.out.println();
            System.out.println("1. Display the matrix before solving. ");
            System.out.println("2. Display the matrix after solving. ");
            System.out.println("3. Search the status of the cell  by passing cell number. ");
            System.out.println("4. Graph of Matrix. ");
            System.out.println();
            cas = sc.nextInt();
            switch(cas)
            {
                case 1:
                    System.out.println("Before solving: ");

                    for(int k =0;k<X;k++)
                    {
                        for(int l =0;l<Y;l++)
                        {
                            System.out.print(Matrix[k][l]+" ");
                        }
                        System.out.println();
                    }
                    break;

                case 2:
                    System.out.println("After Solving: ");

                    for(int q=0;q<X;q++)
                    {
                        for(int w=0;w<Y;w++)
                        {
                            System.out.print(gotit[q][w]+" ");
                        }
                        System.out.println();
                    }
                    break;

                case 3:
                    int search;
                    int count1 = 0;
                    int count =0;
                    for(int f=0;f<X;f++)
                    {
                        for(int s=0;s<Y;s++)
                        {
                            count1 =count1+1;
                        }
                    }

                    System.out.println("Matrix has "+count1+" elements.");
                    System.out.println("Enter the number of cell to check status: ");
                    search = sc.nextInt();
                    System.out.println();
                    for(int i=0;i<X;i++)
                    {
                        for(int r=0;r<Y;r++)
                        {
                            count =count+1;
                            if(count == search)
                            {
                                int num = gotit[i][r];
                                if(num == 0)
                                {
                                    System.out.println("Cell no "+search+" is DEAD.");
                                }
                                else
                                {
                                    System.out.println("Cell no "+search+" is ALIVE.");
                                }
                            }
                        }
                    }
                    break;
                
                case 4:
                    int numcol;
                    System.out.println();
                    // This code is for colored graph, it will show accurate output on online compilers.
                    // for(int i=0;i<X;i++)
                    // {
                    //     for(int j=0;j<Y;j++)
                    //     {
                    //         numcol = gotit[i][j];
                    //         if(numcol == 0)
                    //         {
                    //             System.out.print(ANSI_CYAN+ANSI_BRIGHT_CYAN+" DEAD   ");
                    //         }
                    //         else
                    //         {
                    //             System.out.print(ANSI_WHITE+ANSI_BRIGHT_WHITE+" ALIVE  ");
                    //         }
                    //     }
                    //     System.out.println(ANSI_RESET);
                    // }

                    for(int i=0;i<X;i++)
                    {
                        for(int j=0;j<Y;j++)
                        {
                            numcol = gotit[i][j];
                            if(numcol == 0)
                            {
                                System.out.print("["+i+""+j+"]"+"DEAD   ");
                            }
                            else
                            {
                                System.out.print("["+i+""+j+"]"+"ALIVE  ");
                            }
                        }
                        System.out.println();
                    }

                    break;

                default:
                    choice = 0;
                    break;
            }
        }

    }
        public static int[][] solver(int Matrix[][], int X,int Y)
        {
            int[][] solved = new int[X][Y];

            for(int i=1;i<X-1;i++)
            {
                for(int j=1;j<Y-1;j++)
                {
                    int sideN = 0;
                    for(int k=-1;k<=1;k++)
                    {
                        for(int l=-1;l<=1;l++)
                        {
                            sideN += Matrix[i+k][j+l];
                        }
                    }
                    sideN -= Matrix[i][j];

                    if((Matrix[i][j]==1) && (sideN <2))
                    {
                        solved[i][j] = 0;
                    }
                    else if((Matrix[i][j] == 1) && (sideN>3))
                    {
                        solved[i][j]=0;
                    }
                    else if((Matrix[i][j]==0) && (sideN==3))
                    {
                        solved[i][j] = 1;
                    }
                    else
                    {
                        solved[i][j] = Matrix[i][j];
                    }
                }
            }

            return solved;  
        }   
}
