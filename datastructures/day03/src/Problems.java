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

        if (length < 2) {
            return true;
        }

        if (length == 2) {
            if (n.val != n.next.val) {
                return false;
            }
        }

        if (length == 3) {
            Node end = n.next;
            if (n.val != end.next.val) {
                return false;
            }
        }

        else {
        //reverse half the linked list
        Node curr = n;
        Node prev = null;
        Node next = null;
        int count = 0;
        while (count < length/2) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        if (length % 2 != 0 && length > 3) {
            next = next.next;
        }

        //compare linked list node vals (forwards) with vals in stack (popping --> backwards list)
            for (int i = 0; i < (length-1)/2; i++) {
                while (next != null && prev != null) {

                    if (next.val != prev.val) {
                        return false;
                    }
                    prev = prev.next;
                    next = next.next;
                }
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
