public class FirstFailingVersion {

    public static long firstBadVersion(long n, IsFailingVersion isBadVersion) {
        // TODO

         long l = 0;
         long r = n;

        while (l < r) {
            long middle = (l + r) / 2;


            if (isBadVersion.isFailingVersion(middle)) {
                r = middle;

            } else {
                l = middle+1;
            }


        }



        return l;


    }
}
