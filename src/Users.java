class Users {
    static User[] users = new User[0];

    //static String[] passwords = new String[User.counter];
    public static boolean check_user(User d) {
        for (int i = 0; i < users.length; i++) {
            if (d.Username.equals(users[i].Username)) {
                return true;
            }
        }
        User[] temp = new User[users.length + 1];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = new User();
        }
        //String[] temp2 = new String [users.length+1];
        for (int i = 0; i < temp.length; i++) {
            if (i < temp.length - 1) {
                //temp[i].Username = users[i].Username;
                temp[i] = users[i];
            } else {
                temp[i] = d;
            }
        }
        users = temp;
        return false;
    }

    public static boolean check_Sign_in(String u, String p) {
        for (int i = 0; i < users.length; i++) {
            if (u.equals(users[i].Username) && p.equals(users[i].Password)) {
                return true;
            }
        }
        return false;
    }

    static Exam exams[] = new Exam[Exam.counter];

    public static boolean creat_exam(Exam e) {
        for (int i = 0; i < exams.length; i++) {
            if (exams[i].exam_numb == (e.exam_numb)) {
                return false;
            }
        }
        Exam[] exams2 = new Exam[exams.length + 1];
        for (int i = 0; i < exams2.length; i++) {
            if (i < exams.length) {
                exams2[i] = exams[i];
            } else {
                exams2[i] = e;
            }
        }
        exams = exams2;
        return true;
    }
}
