import java.util.Stack;

class Test

{

    static int Prec(char ch)

    {

        switch (ch)

        {

            case '+':

            case '-':

                return 1;


            case '*':

            case '/':

                return 2;


            case '^':

                return 3;

        }

        return -1;

    }

    static String infixToPostfix(String exp)

    {


        String postfix = new String("");

        Stack<Character> operator_stack = new Stack<>();


        for (int i = 0; i<exp.length(); ++i)

        {

            char c = exp.charAt(i);


            if (Character.isLetterOrDigit(c))

                postfix += c;


            else if (c == '(')

                operator_stack.push(c);

            else if (c == ')')

            {

                while (!operator_stack.isEmpty() && operator_stack.peek() != '(')

                    postfix += operator_stack.pop();


                if (!operator_stack.isEmpty() && operator_stack.peek() != '(')

                    return "Invalid Expression";

                else

                    operator_stack.pop();

            }

            else

            {

                while (!operator_stack.isEmpty() && Prec(c) <= Prec(operator_stack.peek())){

                    if(operator_stack.peek() == '(')

                        return "Invalid Expression";

                    postfix += operator_stack.pop();

                }

                operator_stack.push(c);

            }


        }

        while (!operator_stack.isEmpty()){

            if(operator_stack.peek() == '(')

                return "Invalid Expression";

            postfix += operator_stack.pop();

        }

        return postfix;

    }


// Driver method

    public static void main(String[] args)

    {

        String exp = "(a^b*c-d)^e+f^g^h";

        System.out.println(infixToPostfix(exp));

    }

}