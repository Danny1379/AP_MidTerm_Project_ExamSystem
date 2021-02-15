import java.util.Scanner;

class Delete
{
    public static void exam_del(int a)
    {
        Users.exams[a] = null ;
        Exam  temp = new Exam() ;
        temp = Users.exams[Users.exams.length-1] ;
        Users.exams[Users.exams.length-1] = Users.exams[a];
        Exam[] tempar = new Exam[Users.exams.length-1];
        for (int i = 0; i <Users.exams.length-1 ; i++)
        {
            tempar[i] = Users.exams[i] ;
        }
        Users.exams = tempar ;
    }
    public static void question_delete(int a)
    {
        System.out.println("Please enter question number");
        Scanner input = new Scanner(System.in);
        int entry = input.nextInt()-1;
        if(Users.exams[a].type==1)
        {
            Users.exams[a].testis[entry] = null ;
            Testi temp = Users.exams[a].testis[Users.exams[a].testis.length-1];
            Users.exams[a].testis[Users.exams[a].testis.length-1]= Users.exams[a].testis[entry] ;
            Testi[] tempar = new Testi[Users.exams[a].testis.length-1];
            for (int i = 0; i <Users.exams[a].testis.length-1 ; i++)
            {
                tempar[i] = Users.exams[a].testis[i];
            }
            Users.exams[a].testis= tempar ;
        }
        else if (Users.exams[a].type==2)
        {
            Users.exams[a].tashrihis[entry] = null ;
            Tashrihi temp = Users.exams[a].tashrihis[Users.exams[a].tashrihis.length-1];
            Users.exams[a].tashrihis[Users.exams[a].tashrihis.length-1]= Users.exams[a].tashrihis[entry] ;
            Tashrihi[] tempar = new Tashrihi[Users.exams[a].tashrihis.length-1];
            for (int i = 0; i <Users.exams[a].testis.length-1 ; i++)
            {
                tempar[i] = Users.exams[a].tashrihis[i];
            }
            Users.exams[a].tashrihis= tempar ;
        }

    }
}