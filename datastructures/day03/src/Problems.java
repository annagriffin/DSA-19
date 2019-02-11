import java.util.*;
import java.lang.*;

public class Problems {

    public static class Node {
        int val;
        Node next;

        Node(int d) {
            this.val = d;
            next = null;
        }
    }


    public Problems() {


    }

    public static List<Integer> removeKDigits(int[] A, int k) {
        // TODO: your code here
        // For now, return a List that's correct size, but contains only 0s

        LinkedList<Integer> l = new LinkedList<>();

        int index = 1;
        l.add(A[0]);
        int num = k;

        while (k>0 && index <= A.length-1) {
            while (A[index] < l.getLast() && k > 0) {
                l.removeLast();
                k-=1;
                while (k != 0 && l.size() > 0 && A[index] < l.getLast()) {
                    l.removeLast();
                    k-=1;
                }
                l.add(A[index]);
                index +=1;
            }
            if (l.size() < A.length -num) {
                l.add(A[index]);
                index+=1;
            } else {
                index += 1;
                k-=1;
            }
        }

        int holdSize = l.size();
        while (l.size() < A.length - num) {
            for (int i=holdSize; i<A.length-num;i+=1) {
                l.add(A[index]);
                index+=1;

            }

        }

         return l;
    }



    public static boolean isPalindrome(Node n) {
        // TODO: your code here

        int count = 0;
        // true means dd
        Boolean flag = false;
        Node head = n;
        Node reverse = n;


        if (n == null || n.next == null) {
            return true;
        }

        if (n.val == n.next.val) {
            return true;
        }

        while (n.next != null) {
            count += 1;
            n = n.next;
        }
//        System.out.println(count);

        count += 1;

        if (count % 2 != 0) {
            flag = true;
        }

        count = count / 2;

//        System.out.print(head.next.val);

        Boolean tag = true;

        while (head.next != null && tag == true) {

            for (int i=0; i < count; i ++){

                head = head.next;
            }

            tag = false;


        }

//        System.out.print(head.val);


        if (flag == true) {
            head = head.next;
        }

        Node temp = head;
        Node curr = head;
        Node prev = null;

        while (curr.next != null) {


            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;

        }
        System.out.print("start");
        for (int i =0; i < count; i++) {

            System.out.println(temp.val);
            temp = temp.next;
        }
//        System.out.println(reverse.next.val);
//        System.out.println(temp.next.val);
        System.out.println("edn");

        head

        while (reverse == temp) {
            if (reverse.next != temp.next) {
                return false;
            } else {
                reverse = reverse.next;
                temp = temp.next;
            }
        }

        return true;
    }

    public static String infixToPostfix(String s) {
        // TODO



        Stack operators = new Stack();
        Stack values = new Stack();
        int i = 0;
        String val = "";
        String value = "";


        while ( i < s.length()) {

            if (s.charAt(i) == '(' || s.charAt(i) == ' ') {

            } else if (s.charAt(i) == '1' ||s.charAt(i) == '2'||s.charAt(i) == '3'||s.charAt(i) == '4'||s.charAt(i) == '5'||s.charAt(i) == '6' ||s.charAt(i) == '7'||s.charAt(i) == '8'||s.charAt(i) == '9') {
                values.push(s.charAt(i));
                val = val + s.charAt(i);
            } else if (s.charAt(i) == '+' || s.charAt(i) == '/' ||s.charAt(i) == '-' ||s.charAt(i) == '*') {
                operators.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                values.push(operators.pop());
                val = val + values.peek();
            }
            i+=1;

        }



        for (int ii=0;ii<val.length()-1;ii++) {
            value = value + val.charAt(ii) + " ";
        }

        value = value + val.charAt(val.length()-1);




        return value;
    }

}
