public class Main {
    public static void main(String[] args) {
        boolean[][] schedule = new boolean[8][60];
        for(int i = 10; i < 15; i++)schedule[1][i] = true;
        for(int i = 30; i < 45; i++)schedule[1][i] = true;
        for(int i = 50; i < 60; i++)schedule[1][i] = true;
        AppointmentBook a = new AppointmentBook(schedule);
        System.out.println(a.findFreeBlock(2,15));
        System.out.println(a.findFreeBlock(2,9));
        System.out.println(a.findFreeBlock(2,20));
        for(int i = 25; i < 30; i++)schedule[1][i] = true;
        for(int i = 0; i < 15; i++)schedule[2][i] = true;
        for(int i = 41; i < 60; i++)schedule[2][i] = true;
        for(int i = 5; i < 30; i++)schedule[3][i] = true;
        for(int i = 44; i < 60; i++)schedule[3][i] = true;
        AppointmentBook b = new AppointmentBook(schedule);
        System.out.println(b.makeAppointment(2,4, 22));
        System.out.println(b.makeAppointment(3,4, 3));
        System.out.println(b.makeAppointment(2,4, 30));
    }
}
