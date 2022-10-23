package stack;

import java.util.ArrayList;
import java.util.List;

public class MakeStack <T>{
    private List<T> stack = new ArrayList<>();

    public MakeStack() {
        this.stack = stack;
    }

    public void push(T object){
        stack.add(object);
    }

    public T pull(){
        if (stack.isEmpty()) {
            return null;
        }else{
            return stack.remove(stack.size()-1);
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
