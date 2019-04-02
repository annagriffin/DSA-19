import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CoinsOnAClock {

    public static List<char[]> coinsOnAClock(int pennies, int nickels, int dimes, int hoursInDay) {
        // TODO
        List<char[]> result = new ArrayList<>();


        int n = hoursInDay;


        coinsHelper(new char[hoursInDay], pennies, nickels, dimes, hoursInDay, n, 0, result);

        return result;
    }


    public static void coinsHelper(char[] clock, int pennies, int nickels, int dimes, int hoursInDay, int n, int pos, List<char[]> result) {


        if (pennies == 0 && nickels == 0 && dimes == 0) {
            char[] copy = clock.clone();
            result.add(copy);

        } else if (clock[pos] != 'p' && clock[pos] != 'n' && clock[pos] != 'd'){

            for (int i = 0; i < 3; i ++) {

                if (i == 0) {

                    if (pennies > 0) {

                        clock[pos] = 'p';
                        pennies -= 1;
                        n -= 1;
                        int pos_temp = pos;
                        pos = (pos + 1) % hoursInDay;
                        coinsHelper(clock, pennies, nickels, dimes, hoursInDay, n, pos, result);
                        clock[pos_temp] = '.';
                        pennies += 1;
                        n += 1;
                        pos = pos_temp;

                    }
                } else if (i == 1) {
                    if (nickels > 0) {
                        clock[pos] = 'n';
                        nickels -= 1;
                        n -= 1;
                        int pos_temp = pos;
                        pos = (pos + 5) % hoursInDay;
                        coinsHelper(clock, pennies, nickels, dimes, hoursInDay, n, pos, result);
                        clock[pos_temp] = ',';
                        nickels += 1;
                        n += 1;
                        pos = pos_temp;
                    }

                } else {
                    if (dimes > 0) {
                        clock[pos] = 'd';
                        dimes -= 1;
                        n -= 1;
                        int pos_temp = pos;
                        pos = (pos + 10) % hoursInDay;
                        coinsHelper(clock, pennies, nickels, dimes, hoursInDay, n, pos, result);
                        clock[pos_temp] = ',';
                        dimes += 1;
                        n += 1;
                        pos = pos_temp;
                        }

                    }


                }


            }
        }
    }



