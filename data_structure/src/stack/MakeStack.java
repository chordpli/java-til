package stack;

import java.util.ArrayList;
import java.util.List;

public class MakeStack <T>{
    List<T> stack = new ArrayList<>();

    public MakeStack() {
        this.stack = stack;
    }

    public void push(T object){
        stack.add(object);
    }

    public void pull(){
        if (stack.isEmpty()) {
            System.out.println("stack is empty");
        }else{
            System.out.println(stack.remove(stack.size()-1));
        }

    }

    public static void main(String[] args) {
        MakeStack<Integer> st = new MakeStack<>();

        st.push(1);
        st.push(2);
        st.push(3);
        st.pull();
        st.pull();
        st.pull();
        st.pull();
    }
}
