import java.util.Scanner;

class Menu
{
    static Scanner input = new Scanner(System.in);
    public static void dir_menu()
    {
        int entry ;
        while (true)
        {
            System.out.println("1-Create a new Exam\n2-Change exam fields\n3-Change Exam Students\n4-Change Exam Teacher\n5-Delete Exam\n6-show scores of students for exam\n7-Print exam info for all Exams\n8-back");
            entry =input.nextInt();
            switch (entry) {
                case 1:
                    while (true) {
                        System.out.println("PLease Follow the next instructions");
                        if (Users.creat_exam(CreateExam())) {
                            System.out.println("Creation of new Exam successful");
                            break;
                        } else {
                            System.out.println("Please try Again");
                        }
                    }
                    break;
                case 2:
                    boolean yesno = true;
                    while (true) {

                        if (yesno) {
                            Change_exam_fields();
                            System.out.println("Do you wish to change anything else?\nif you do enter y if not enter n");
                            char entry2 = input.next().charAt(0);
                            if (entry2 == 'y') {
                                yesno = true;
                            } else {
                                yesno = false;
                            }
                        } else
                            break;
                    }
                case 3:
                    System.out.println("Please enter exam code");
                    Users.exams[Search.search_exam(input.nextLong())].setStudents();
                    break;
                case 4:
                    System.out.println("Please enter exam code");
                    int i = Search.search_exam(input.nextLong());
                    System.out.println("Please enter the exam code");
                    Users.exams[i].setTeacher();
                    break;
                case 5:
                    delete_exam();
                    break;
                case 6:
                    System.out.println("Please enter exam code");
                    i = Search.search_exam(input.nextLong());
                    for (int j = 0; j < Users.exams[i].students.length; j++) {
                        System.out.println("The Mark of Student " + Users.exams[i].students[j].Username + " is : " + Users.exams[i].students[j].Score);
                    }
                    break;
                case 7:
                    print_exam_info();
                    break;
            }
            if(entry==8)
            {
                break;
            }
        }
    }
    public static Exam CreateExam()
    {
        Exam e = new Exam();
        System.out.println("Please Enter your name sir director");
        e.setDirector(input.next());
        System.out.println("Please enter Exam code");
        e.setExam_numb(input.nextInt());
        System.out.println("Please Enter date and then month and then year");
        e.setDay(input.nextInt());
        e.setMonth(input.nextInt());
        e.setYear(input.nextInt());
        System.out.println("Please Enter the time of exam in 24 hour format");
        e.setTime(input.nextByte());
        System.out.println("Please enter the length of the exam");
        e.setExamlength(input.nextByte());
        e.setExamType();
        System.out.println("PLease enter subject of the exam");
        e.setSubject(input.next());
        System.out.println("Please enter the exams code");
        e.setTeacher();
        e.setStudents();
        return e ;
    }
    public static void delete_exam()
    {
        System.out.println("Please enter the code of the exam you Wish to delete");
        System.out.println("if you do not know the cde for the exams please enter h and the information of the Exams will be shown or press c to continue");
        char Entry = input.next().charAt(0) ;
        if(Entry == 'h')
        {
            print_exam_info();
        }
        else if (Entry == 'c')
        {
            System.out.println("Please Enter Exam Code");
            int i = Search.search_exam(input.nextLong());
            System.out.println("Are you Sure you wish to delete exam if u are sure enter y if not enter n");
            Entry = input.next().charAt(0);
            if(Entry=='y')
            {
                Delete.exam_del(i);
            }
            else if(Entry == 'n')
            {
                System.out.println("Please Choose another option");
            }
        }
    }
    public static void print_exam_info()
    {
        for (int i = 0; i <Users.exams.length ; i++)
        {
            System.out.print("Exam number :"+Users.exams[i].exam_numb+" of Subject :"+Users.exams[i].subject+" and Type :"+Users.exams[i].examType);
            System.out.println(" and Director of"+Users.exams[i].director);
        }
    }
    public static void Change_exam_fields()
    {
        System.out.println("Please enter Exam Code: ");
        int Entry = input.nextInt();
        int i = Search.search_exam(Entry);
        System.out.println("So what do you wish to change?");
        System.out.println("Choose one of the options below\n1-Change Exam Type\n2-Exam Teacher\n3-Exam Subject\n4-Change exam Director\n5-Change Exam Day\n6-Change Exam Time\n7-Change Exam month\n8-Exam year\n9-Exam Length\n10-change Exam Scores");
        Entry = input.nextInt();
        switch (Entry)
        {
            case 1 :
                //System.out.print("Enter: ");
                Users.exams[i].setExamType();
                break;
            case 2 :
                System.out.print("Enter: ");
                Users.exams[i].setTeacher();
                break;
            case 3 :
                System.out.print("Enter: ");
                Users.exams[i].setSubject(input.next());
            case 4 :
                System.out.print("Enter: ");
                Users.exams[i].setDirector(input.next());
                break;
            case 5 :
                System.out.print("Enter: ");
                Users.exams[i].setDay(input.nextByte());
                break;
            case 6 :
                System.out.print("Enter: ");
                Users.exams[i].setMonth(input.nextByte());
                break;
            case 7 :
                System.out.print("Enter: ");
                Users.exams[i].setMonth(input.nextByte());
                break;
            case 8 :
                System.out.print("Enter: ");
                Users.exams[i].setYear(input.nextInt());
                break;
            case 9 :
                System.out.print("Enter: ");
                Users.exams[i].setExamlength(input.nextByte());
                break;
            case 10 :
                System.out.println("Enter: ");
                Users.exams[i].setScore();
        }
    }
    public static void teach_menu()
    {
        System.out.println("Welcome");
        boolean run= true  ;
        while(run)
        {
            System.out.println("Choose from below.\n1-set questions \n2-add question\n3-delete question \n4-change question\n5-check student answers\n6-Back to sign in menu");
            int entry = input.nextInt();
            switch (entry)
            {
                case 1 :
                    System.out.println("Please enter exam code ");
                    Users.exams[Search.search_exam(input.nextLong())].setQuestions();
                    break;
                case 2 : Exam.addQuestion();
                    break ;
                case 3 :
                    System.out.println("Please enter exam number");
                    Delete.question_delete(Search.search_exam(input.nextLong()));
                    break;
                case 4 :
                    while (true)
                    {
                        System.out.println("if you wish to wish questions please press enter v");
                        int c = input.next().charAt(0);
                        if (c == 'v')
                        {
                            print_questions();
                        }
                        change_question();
                    }
                case 5 :

                case 6 :
                    run = false ;

            }
        }
    }
    public static void change_question()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter exam number");
        long entry = input.nextLong();
        int entry2 = input.nextInt();
        System.out.println("Please enter question number");
        int a = Search.search_exam(entry);
        if(Users.exams[a].type ==1)
        {
            System.out.println("Please enter question");
            Users.exams[a].testis[entry2].question =input.nextLine();
            System.out.println("Please enter choice 1");
            Users.exams[a].testis[entry2].setAnswere1(input.nextLine());
            System.out.println("Please enter choice 2");
            Users.exams[a].testis[entry2].setAnswere2(input.nextLine());
            System.out.println("Please enter choice 3");
            Users.exams[a].testis[entry2].setAnswere3(input.nextLine());
            System.out.println("Please enter choice 4");
            Users.exams[a].testis[entry2].setAnswere4(input.nextLine());
            System.out.println("Please enter correct choice");
            Users.exams[a].testis[entry2].setCorrect_answere(input.nextByte());
        }
        else if (Users.exams[a].type ==2)
        {
            System.out.println("Please enter question");
            Users.exams[a].tashrihis[entry2].question = input.nextLine();
        }
        else if (Users.exams[a].type==3)
        {

        }
        else
        {
            System.out.println("Something went wrong please try again");
        }
    }
    public static void print_questions()
    {
        System.out.println("Please enter exam number");
        long a = input.nextLong();
        int b =Search.search_exam(a);
        if(Users.exams[b].type ==1)
        {
            for (int i = 0; i < Users.exams[b].testis.length; i++)
            {
                System.out.println(i + 1 + "-" + Users.exams[b].testis[i]);
                System.out.println("1-"+Users.exams[b].testis[i].answere1);
                System.out.println("2-"+Users.exams[b].testis[i].answere2);
                System.out.println("3-"+Users.exams[b].testis[i].answere3);
                System.out.println("4-"+Users.exams[b].testis[i].answere4);
            }
        }
        else if (Users.exams[b].type == 2)
        {
            for (int i = 0; i <Users.exams[b].tashrihis.length ; i++)
            {
                System.out.println(i+1+"-"+Users.exams[b].tashrihis[i].question);
            }
        }
        else if(Users.exams[b].type==3)
        {

        }
        else
        {
            System.out.println("something went wrong");
        }
    }
    public static void stud_menu()
    {
        System.out.println("Welcome");
        boolean run = true ;
        int entry ;
        while(run == true)
        {
            System.out.println("Choose one of the below\n1-View your exams\n2-take exam\n3-view Score");
            entry = input.nextInt();
            switch (entry)
            {
                case 1 :
                    stud_exams();
                    break;
                case 2 :
                    System.out.println("please enter your username");
                    take_exam(input.next());

            }
        }
    }
    public static void stud_exams()
    {
        System.out.println("Please enter your Username");
        String name = input.next();
        for (int i = 0; i <Users.exams.length ; i++)
        {
            for (int j = 0; j <Users.exams[i].students.length ; j++)
            {
                if(Users.exams[i].students[i].getUsername().equals(name));
                {
                    System.out.print("Exam number :"+Users.exams[i].exam_numb+" of Subject :"+Users.exams[i].subject+" and Type :"+Users.exams[i].examType);
                    System.out.println(" And Director of"+Users.exams[i].director);
                }
            }
        }
    }
    public static void take_exam(String name)
    {
        System.out.println("Please enter exam number");
        long entry = input.nextLong();
        int s = Search.search_students(name,entry);
        int n = Search.search_exam(entry);
        boolean give = true ;
        if(Users.exams[n].type == 1)
        {
            while(give)
            {
                int a ;
                print_questions();
                System.out.println("enter the Question number you wish to answer if you wish to finish enter -1");
                a = input.nextInt();
                for (int i = 0; i <Users.exams[n].testis.length ; i++)
                {
                    if(a==-1)
                    {
                        give = false ;
                        break ;
                    }
                    if(a-1==i)
                    {
                        System.out.println("enter your answer if u wish to finish exam enter -1");
                        int b = input.nextByte();
                        while(b>4||b<1)
                        {
                            System.out.println("please enter a valid answer");
                            b = input.nextByte();
                        }
                        if (b==Users.exams[n].testis[i].correct_answere)
                        {
                            Users.exams[n].students[s].Score++;
                        }
                    }
                }
            }
            give = true ;
        }
        else if(Users.exams[n].type == 2)
        {

        }
        else if(Users.exams[n].type == 3)
        {

        }
        else
        {

        }
    }
}