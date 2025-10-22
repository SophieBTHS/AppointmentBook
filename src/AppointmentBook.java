public class AppointmentBook {
    private boolean[][] schedule;

    public  AppointmentBook(boolean[][] schedule){
        this.schedule = schedule;
    }
    private boolean isMinuteFree(int period, int minute){
        return schedule[period-1][minute];
    }
    public void printSchedule(int start, int end){
        for( int i = start-1; i<end;i++){
            System.out.println("Period " + (i+1));
            for(int min = 0; min<60;min++){
                System.out.println("  Min " +(min+1)+":  " + schedule[i][min]);
            }
        }
    }
    private void reserveBlock(int period, int startMinute, int duration){
        for(int i = startMinute; i<= duration; i++){
            schedule[period-1][i] = false;
        }
    }

    public int findFreeBlock(int period, int duration){
        int amount = 0;
        int time = 0;
        while (time < schedule[period-1].length){
            if (isMinuteFree(period,time)){
                amount += 1;
                if (amount == duration){
                    return (time - (duration-1));
                }
            }
            else{
                amount = 0;
            }
            time +=1;
            //System.out.println(time + "  Amount: " + amount);
        }
        return -1;
    }
    public boolean makeAppointment(int startPeriod, int endPeriod, int duration){
        for(int i = startPeriod; i <= endPeriod; i++){
            int free = findFreeBlock(i, duration);
            if (free != -1){
                reserveBlock(i, free, duration);
                return true;
            }
        }
        return false;
    }
}
