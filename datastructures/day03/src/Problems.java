import java.util.*;

public class Problems {

    public static class Node {
        int val;
        Node next;

        Node(int d) {
            this.val = d;
            next = null;
        }
    }

    public static List<Integer> removeKDigits(int[] A, int k) {

        // For now, return a List that's correct size, but contains only 0s
        Stack s = new Stack();

        int count = 0;

        for (int i : A) { //for int i in array A
            while (!s.isEmpty() && count < k && (int)s.peek() > i) {
                s.pop();
                count++;
            }
            if (s.size() < A.length - k) {
                s.add(i);
            }
        }
        return s;
    }

    public static boolean isPalindrome(Node n) {

        //make new stack and put first node in it
        Stack s = new Stack();
        s.push(n);
        int length = 0;
        Node tempN = n;

        //get the length of the linked list
        while (tempN != null) {
            tempN = tempN.next;
            length++;
        }

        //put rest of nodes in stack
        Node stackN = n;
        for (int i = 0; i < length; i++) {
            s.push(stackN.val);
            stackN = stackN.next;
        }

        if (length == 2) {
            if (n.val != n.next.val) {
                return false;
            }


        }

        //compare linked list node vals (forwards) with vals in stack (popping --> backwards list)
        else {
            for (int i = 0; i < length; i++) {
                if ((int)s.peek() != n.val) {
                    return false;
                }
                s.pop();
                n = n.next;
            }
        }

        return true;
    }

    public static String infixToPostfix(String s) {
        Stack bob = new Stack();
        String returnS = "";

        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            }
            else if (s.charAt(i) == ')') {
                count--;
                returnS = returnS + bob.pop();
                if (count != 0 ) {
                    returnS = returnS + ' ';
                }
            }
            else if (s.charAt(i) != '+' && s.charAt(i) != '-' && s.charAt(i) != '*' && s.charAt(i) != '/' && s.charAt(i) != ' ') {
                returnS = returnS + s.charAt(i) + ' ';
            }
            else if (s.charAt(i) != ' ') {
                bob.push(s.charAt(i));
            }
        }
        return returnS;
    }

}
