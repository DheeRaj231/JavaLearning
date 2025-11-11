# 📘 Java Lambda Expressions – Combined Notes

TELUSKO

10.13-lamda Expression

Lambda expressions provide a clear and concise way to represent the
implementation of a functional interface. A functional interface is one that
contains only a single abstract method, and with lambda expressions, we don't
have to implement the method in a traditional way. Instead, we simply write the
logic of the method, significantly reducing code.

Lambda expressions were introduced in Java SE 8 and are designed to make
coding more efficient by reducing boilerplate code, especially when working
with interfaces that have only one abstract method.

- A functional interface is an interface with a single abstract method, and
lambda expressions allow us to provide a clean implementation of this
method.

¢ The functional interface can be implemented using an anonymous inner
class, but lambda expressions simplify this further.

Lambda expressions use the syntax:

(parameters) -> { body }
The arrow -> separates the parameters from the
implementation

TELUSKO


TELUSKO

Runnable runnable = () -> System.out. (“Hello World”);
a

No parameters

interface A {
void show( );

}

public class Demo {
public static void main(String[] args)
{ A obj = () -> {
System.out.println("in show");
}5
obj.show( );

Output:

in show

Explanation:
In this example, we implemented the show() method of the A interface using a
lambda expression. No need for an anonymous inner class or separate class for

the implementation—just the logic within the lambda expression.
TELUSKO



TELUSKO

Why Use Lambda Expressions?

1. Implementation of Functional Interface: Lambda expressions provide a
quick and readable way to implement functional interfaces.

2. Less Coding: They reduce the lines of code, especially for single-method
interfaces.

3. Syntactical Sugar: This reduction in code and improved syntax
readability is often referred to as "syntactical sugar," making code easier
to read and maintain.

Lambda Expression with Parameters

When an interface method accepts parameters, lambda expressions can still be
used to implement them easily.

FileFilter filter = file -> file. i
—

Single parameter

Example of Lambda Expression with One Parameter:

ee
interface A {
void show(int i);

}

public class Demo {

public static void main(String[] args) {
A obj = i -> System.out.println("in show: "
i); obj.show(5);

}

}

TELUSKO


TELUSKO

Output:

in show:

Explanation:

In this example, we implemented the show(int i) method using a lambda
expression that accepts an integer parameter i. Notice that the type of the
parameter (int) is included before the parameter. If the method has only one
parameter, we don’t need parentheses around the parameter, and the type can
also be omitted.

Simplified Lambda Expression With Two Parentheses:

interface A {
void show(int i, int j);

}

public class Demo {

public static void main(String args[]) {
A obj = (i,j) -> System.out.println("in show: "+ t +","+
obj .show(5,6);

Output:

Explanation:

Here, the two parameters type int and parentheses around the parameter i and j
are necessary. This no parenthesis is allowed when there is only one parameter,
making the code more concise.

TELUSKO


- No need to instantiate interfaces: The compiler automatically handles
the instantiation, making the code more readable.

e Simplicity: Instead of writing a full method implementation, the
developer just focuses on the logic.

¢ Efficiency: Lambda expressions work efficiently with functional
interfaces, reducing the need for boilerplate code.

Lambda expressions are a short block of code that:
- Accept inputs as parameters.

e Return a result or perform an action without returning anything.

Yes, lambda expressions improve code readability, reduce boilerplate, and make
it easier to interact with functional interfaces, streams, and APIs introduced in
Java 8 and later.

The main limitation is that lambda expressions can only be used with functional
interfaces (i.e., interfaces that have only one abstract method).

TELUSKO


TELUSKO

10.14-Lamda Expression with return type

Introduction to Lambda Expression with Return Type

A lambda expression can also return values. When using lambda expressions
with methods that have a return type, the syntax can be optimized to reduce
code significantly.

Below, we will explore how a method with two parameters and a return type is
implemented first using an anonymous inner class and then optimized using a
lambda expression.

Example: Anonymous Inner Class with Return Type

interface A {
int add(int i, int j);

public class MyClass {
public static void main(String args[]) {
A obj = new A() {

public int add(int i, int j) f
return i + j;
}
35
int result = obj.add(5, 4);
System.out.println("The addition is: " +
regult);
}

Output:

The addition is: 9

TELUSKO


TELUSKO

Explanation:

e Inthe above example, we are using an anonymous inner class to
implement the add() method of the A interface.

e The add() method takes two integer parameters (i and j) and returns their
sum.

e This approach works, but the code is somewhat verbose.

Optimized Example: Lambda Expression with Return Type

Now, we will optimize the same implementation using a lambda expression.

interface A {
int add(int i, int j);

}
public class MyClass {

public static void main(String args[]) {
A obj = (i, j) -> i + j3
int result = obj.add(5, 4);
System.out.println("The addition is: " +
regult);
}

Output:

The addition is: 9

Explanation:

e The lambda expression (i, j) -> i+] directly implements the add()
method.

¢ No need for the return keyword, as the expression itself acts as the return
value.

TELUSKO


TELUSKO

e We don't need to specify the data type of the parameters (i and j) because
they are inferred automatically.

e This version of the code is significantly shorter and more readable
compared to the anonymous inner class implementation.

1. Return Type Omission:

o Ifthe lambda body contains a single return expression, the return
keyword can be omitted. The result of the expression is
automatically returned.

2. Parameter Type Omission:

o Ifthe method parameters have the same type, we can omit the
parameter type in the lambda expression. For example, both i and j
are integers, so their types are inferred automatically.

Lambda expressions can also be used as parameters when working with
collections. They are particularly useful in functional operations like filtering,

mapping, and sorting.

Important Points to Remember:

« Lambda expressions can only be used with functional interfaces. A
functional interface has exactly one abstract method. If an interface has
more than one method, using a lambda expression would lead to
ambiguity, as it wouldn't be clear which method the lambda is
implementing.

e Lambda expressions simplify code by reducing the need for boilerplate
code, especially when implementing interfaces with single methods.

¢ Type Inference: Java automatically infers parameter types in lambda

expressions, making the code more concise.
TELUSKO



TELUSKO

Additional Points to Consider:

Code Readability: While lambda expressions reduce the amount of code,
it's essential to use them wisely. Overusing lambda expressions in
complex logic might make the code harder to understand.

Functional Programming: Lambda expressions are part of the broader
functional programming capabilities introduced in Java 8. They work
seamlessly with streams, functional interfaces, and method references.





@FunctionalInterface
interface A{
    int Show(int a,int b);
}

public class Day4_Lambda{
    public static void main(String[] ar){
        A obj= (a,b) -> a+b;
        int res=obj.Show(10,15);
        System.out.println(res);
    }


}