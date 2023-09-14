import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        display(l1);
        display(l2);
        int n1 = linkedToInteger(l1);
        int n2 = linkedToInteger(l2);
        String sum = Integer.toString(n1 + n2);
        ListNode result = null;
        for(int i = 0; i < sum.length(); i++){
            result = insert(result, Character.getNumericValue(sum.charAt(i)));
        }
        display(result);
    }

    public static int linkedToInteger(ListNode l) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(l.val);
        while (l.next != null) {
            l = l.next;
            list.add(l.val);
        }
        String formated = "";
        for (int i = list.size() - 1; i >= 0; i--) {
            formated += list.get(i);
        }
        return Integer.parseInt(formated);
    }

    public static ListNode insert(ListNode root, int value) {
        ListNode aux = new ListNode();
        aux.val = value;
        aux.next = root;
        root = aux;
        return root;
    }

    public static void display(ListNode l){
        System.out.print("[");
        System.out.print(l.val+"");
        while(l.next != null){
            l = l.next;
            System.out.print(l.val+"");
        }
        System.out.print("]");
    }
}
