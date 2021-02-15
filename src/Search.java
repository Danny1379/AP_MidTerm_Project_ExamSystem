class Search {
    public static int search_user(User a) {
        for (int i = 0; i < Users.users.length; i++) {
            if (Users.users[i].Username.equals(a.Username) && Users.users[i].Password.equals(a.Password)) {
                return i;
            }
        }
        return 0;
    }

    public static int search_exam(long a) {
        for (int i = 0; i < Users.exams.length; i++) {
            if (Users.exams[i].exam_numb == a) {
                return i;
            }
        }
        return 0;
    }

    public static int search_students(String a, long b) {
        for (int i = 0; i < Users.exams[search_exam(b)].students.length; i++) {
            if (Users.exams[search_exam(b)].students[i].getUsername().equals(a)) {
                return i;
            }
        }
        return 0;
    }
}
