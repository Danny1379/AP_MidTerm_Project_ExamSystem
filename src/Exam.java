import java.util.Scanner;

class Exam
{
    Scanner input = new Scanner(System.in);
    String director ;
    String  teacher ;
    String subject ;
    int exam_numb ;
    int day ;
    int month ;
    int year ;
    int time ;
    int examlength ;
    int questions_num ;
    String examType ;
    Student[] students ;
    static int counter=0 ;
    int nums ;
    Question[] questions ;
    Testi[] testis ;
    Tashrihi[] tashrihis ;
    Testi_Tashrihi[] testi_tashrihis;
    int[] correct ;
    int type ;
    Exam()
    {
        counter++;
    }
    public void setDirector(String director) {
        this.director = director;
    }

    public void setExam_numb(int exam_numb) {
        this.exam_numb = exam_numb;
    }

    public void setDay(int examdate) {
        this.day = examdate;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    void setYear(int year) {
        this.year = year;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setExamlength(int examlength) {
        this.examlength = examlength;
    }
    public void setExamType()
    {
        System.out.println("what kind of exam do you wish it to be ?\n1-Multiple question\n2-Narrative questions\n3-Or Both :-) ?");
        int entery  = input.nextByte();
        if(entery==1)
        {
            type = entery ;
            examType = "Multiple question" ;
        }
        else if (entery==2)
        {
            type = entery;
            examType = "Narrative questions";
        }
        else if (entery==3)
        {
            type = entery ;
            examType = "Mixed";
        }
    }

    public void setQuestions_num(int questions) {
        this.questions_num = questions;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setTeacher()
    {
        System.out.println("Type in the username of the teacher you wish to add");
        for (int i = 0; i <Users.users.length ; i++)
        {
            if(Users.users[i] instanceof Teacher)
            {
                System.out.println(i+1+"-"+Users.users[i].Username);
            }
        }
        String a = input.next();
        for (int i = 0; i <Users.users.length ; i++)
        {
            if(Users.users[i] instanceof  Teacher && Users.users[i].Username.equals(a))
            {
                teacher = a ;
                break ;
            }
            if(i== Users.users.length-1)
            {
                System.out.println("Please re enter :");
                a = input.next();
                i = 0 ;
            }
        }
    }
    public void setStudents()
    {
        int counter=0 ;
        System.out.println("Please Enter e for the students you wish to be in the exam");
        for (int i = 0; i <Users.users.length ; i++)
        {
            if(Users.users[i] instanceof Student)
            {
                System.out.println(Users.users[i].Username);
                if(input.next().charAt(0)=='e') {
                    counter++;
                }
            }
        }
        int l = 0 ;
        students = new Student[counter];
        System.out.println("Enter e again to confirm each student");
        for (int i = 0,j=0; i <Users.users.length ; i++)
        {
            if(Users.users[i] instanceof  Student)
            {
                System.out.println("enter e to confirm "+Users.users[i].Username+"if u dont wish to add that user enter n");
                if(input.next().charAt(0)=='e')
                {
                    students[j] =(Student) Users.users[i];
                    System.out.println("Student added");
                    j++;
                }
            }
            l = j ;
        }
    }
    public void setScore()
    {
//        System.out.println("Enter Score of each student for this exam");
//        for (int i = 0; i <students.length ; i++)
//        {
//            System.out.println("The Score of "+students[i].Username+" is "+students[i].Score);
//        }
    }

    public void setQuestions()
    {
        System.out.println("Please enter number of questions: ");
        setQuestions_num(input.nextByte());
        testis = new Testi[questions_num] ;
        if(type==1) {
            for (int i = 0; i < questions_num; i++)
            {
                System.out.println("PLease enter Question");
                Testi t = new Testi(input.nextLine());
                t.question = input.nextLine();
                System.out.println("Enter choice 1 please");
                t.setAnswere1(input.nextLine());
                System.out.println("Enter choice 2 please");
                t.setAnswere2(input.nextLine());
                System.out.println("Enter choice 3 please");
                t.setAnswere3(input.nextLine());
                System.out.println("Enter choice 4 please");
                t.setAnswere4(input.nextLine());
                System.out.print("Enter correct answer choice: ");
                t.setCorrect_answere(input.nextByte());
                questions[i] = t ;
            }
        }
        else if(type == 2)
        {
            for (int i = 0; i < questions_num ; i++)
            {
                System.out.println("PLease enter Question");
                Tashrihi t = new Tashrihi(input.nextLine());
                questions[i]  = t ;
            }
        }
        else if(type == 3)
        {
            System.out.println("if you wish for the q to be testi enter 1 tashrihi enter 2");
            int entry = input.nextInt();
            for (int i = 0; i <questions_num ; i++) {
                if(entry==1) {
                    System.out.println("if you wish for the q to be testi enter 1 tashrihi enter 2");
                    System.out.println("PLease enter Question");
                    Testi t = new Testi(input.nextLine());
                    t.question = input.nextLine();
                    System.out.println("Enter choice 1 please");
                    t.setAnswere1(input.nextLine());
                    System.out.println("Enter choice 2 please");
                    t.setAnswere2(input.nextLine());
                    System.out.println("Enter choice 3 please");
                    t.setAnswere3(input.nextLine());
                    System.out.println("Enter choice 4 please");
                    t.setAnswere4(input.nextLine());
                    System.out.print("Enter correct answer choice: ");
                    t.setCorrect_answere(input.nextByte());
                    questions[i] = t;
                }
                else if(entry==2)
                {
                    System.out.println("PLease enter Question");
                    Tashrihi t = new Tashrihi(input.nextLine());
                    questions[i]  = t ;
                }
                else
                {
                    System.out.println("Please re enter ");
                    i--;
                }
            }
        }
    }
    public static void addQuestion()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter Exam number");
        int entry = input.nextInt();
        if(Users.exams[Search.search_exam(entry)].type ==1) {
            Testi[] temp = new Testi[Users.exams[Search.search_exam(entry)].testis.length+1];
            //System.arraycopy( Users.exams[Search.search_exam(entry)].questions ,0,temp,0,Users.exams[Search.search_exam(enntry)].questions.length+1);
            for (int i = 0; i <temp.length-1 ; i++)
            {
                temp[i] =  Users.exams[Search.search_exam(entry)].testis[i] ;
            }
            System.out.println("Please enter new question");
            temp[Users.exams[Search.search_exam(entry)].testis.length].question = input.nextLine();
            System.out.println("Please enter Choice 1");
            temp[Users.exams[Search.search_exam(entry)].testis.length].setAnswere1(input.nextLine());
            System.out.println("Please enter Choice 2");
            temp[Users.exams[Search.search_exam(entry)].testis.length].setAnswere2(input.nextLine());
            System.out.println("Please enter Choice 3");
            temp[Users.exams[Search.search_exam(entry)].testis.length].setAnswere3(input.nextLine());
            System.out.println("Please enter Choice 4");
            temp[Users.exams[Search.search_exam(entry)].testis.length].setAnswere4(input.nextLine());
            System.out.println("Please enter correct choice");
            temp[Users.exams[Search.search_exam(entry)].testis.length].setCorrect_answere(input.nextByte());
            Users.exams[Search.search_exam(entry)].testis = temp ;
            System.out.println("Done!");
        }
        else if (Users.exams[Search.search_exam(entry)].type == 2 )
        {
            Tashrihi[] temp = new Tashrihi[Users.exams[Search.search_exam(entry)].questions.length+1];
            for (int i = 0; i <Users.exams[Search.search_exam(entry)].tashrihis.length ; i++)
            {
                temp[i] = Users.exams[Search.search_exam(entry)].tashrihis[i];
            }
            System.out.println("Please enter new question");
            temp[Users.exams[Search.search_exam(entry)].tashrihis.length].question = input.nextLine();
        }
        else
        {

        }
    }
}