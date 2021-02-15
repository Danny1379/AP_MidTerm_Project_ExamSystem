import java.util.* ;
public class ExamSys
{
    //Clean Code
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("Welcome to the exam helper system.");
            while (true)
            {
                System.out.println("Enter a number:\n1- Register\n2- Sign in");
                int entry = input.nextByte() ;
                if (entry == 1)
                {
                    User a = register();
                }
                else if(entry == 2)
                {
                    Sign_in();
                }
            }
        }
    }
    //registering
    static User register()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Please Choose one of the below"+"\n1- Director of Education\n" + "2- Teacher\n" + "3- Student");
        int n = input.nextInt();
        if(n==1)
        {
            while(true)
            {
                System.out.println("Please Enter Your Username and Then your password");
                Director_of_Education d = new Director_of_Education(input.next(), input.next());
                if(d.Password.length()<4)
                    System.out.println("Password length must be more than 4 words");
                else if(Users.check_user(d))
                {
                    System.out.println("Username already exists please try again");
                }
                else
                    return d ;
            }
        }
        else if(n==2)
        {
            while (true)
            {
                System.out.println("Please Enter Your Username and Then your password");
                Teacher t = new Teacher(input.next(), input.next());
                if(t.Password.length()<4)
                    System.out.println("Please Re enter");
                else if(Users.check_user(t))
                {
                    System.out.println("Username already exists please try again");
                }
                else
                    return t ;
            }
        }
        else
        {
            while (true)
            {
                System.out.println("Please Enter Your Username and Then your password");
                Student s = new Student(input.next(), input.next());
                if(s.Password.length()<4)
                    System.out.println("Please Re enter");
                else if(Users.check_user(s))
                {
                    System.out.println("Username already exists please try again");
                }
                else
                    return s;
            }
        }
    }
    //registering end
    //Sign in
    public static void Sign_in()
    {
        while(true) {
            Scanner input = new Scanner(System.in);
            System.out.println("Please Enter your User name and Password");
            User a = new User();
            a.setUsername(input.next());
            a.setPassword(input.next());
            System.out.println(User.counter);
            if (Users.check_Sign_in(a.Username, a.Password)) {
                System.out.println("Welcome");
                if(Users.users[Search.search_user(a)] instanceof Director_of_Education&&Search.search_user(a)!=-1)
                {
                    Menu.dir_menu();
                    System.out.println("Enter t if you wish to go back to registering");
                    if(input.next().charAt(0)=='t')
                    {
                        break;
                    }
                }
                else if (Users.users[Search.search_user(a)] instanceof Teacher&&Search.search_user(a)!=-1)
                {
                    Menu.teach_menu();
                }
                else if(Users.users[Search.search_user(a)] instanceof Student&&Search.search_user(a)!=-1)
                {
                    Menu.stud_menu();
                }
            } else
            {
                System.out.println("Please Try again");
            }
        }
    }
    //sign in end
}

//Exams


