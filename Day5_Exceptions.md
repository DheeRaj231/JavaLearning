
# 📘 Java Exception Handling – Complete Notes (With Full Theory + Programs)

---

## **11.1 – What is an Exception?**

An **exception** in Java is an event that disrupts the normal flow of a program.
It occurs during the execution (runtime).  
If not handled, it causes **abnormal program termination**.

Exceptions occur when:
- You divide a number by zero  
- Access an invalid array index  
- Access a file that doesn’t exist  
- Use a null reference  

---

## **Types of Errors in Java**

Java has 3 major types of errors:

---

### **1. Compile-time Errors**
Errors caught by the compiler due to incorrect syntax.

#### **Example**
```java
class Test {
    public static void main(String[] args) {
        System.out.prinltn("Hello"); // prinltn → typo
    }
}
```

---

### **2. Logical Errors**
The program runs but produces **unexpected/wrong output** due to wrong logic.

#### **Example**
```java
int a = 10, b = 20;
System.out.println(a - b); // Wrong logic (should be a + b)
```

---

### **3. Runtime Errors (Exceptions)**
Errors that occur during execution.

#### **Example**
```java
int a = 10, b = 0;
System.out.println(a / b); // Exception: / by zero
```

---

## **Why Exception Handling?**

Exception handling ensures:
- Program does **not crash**
- Proper **error messages** are shown
- Control is transferred to a **safe block**
- Smooth, continuous program execution

---

# **11.2 – Exception Handling Using try–catch**

Java provides the **try–catch** mechanism to prevent program failure.

---

## **Critical vs Normal Code**

| Type | Description |
|------|-------------|
| **Critical Code** | Code that may throw exceptions |
| **Normal Code** | Code that runs safely |

Example of risky (critical) actions:
- File opening  
- Network operations  
- Mathematical operations  
- Null object operations  

---

## **Syntax of try–catch**

```java
try {
    // risky code
} catch (Exception e) {
    // handling code
}
```

---

## **Example Program**

```java
public class DemoTryCatch {
    public static void main(String[] args) {
        System.out.println("Start");

        try {
            int a = 10, b = 0;
            int result = a / b;
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("End");
    }
}
```

### **Output**
```
Start
Error: / by zero
End
```

---

# **11.3 – try with Multiple Catch Blocks**

A single try block can have **multiple catch blocks** to handle different exception types.

This is useful when several things inside the try block can fail differently.

---

## **Example Program with Multiple Catch Blocks**

```java
public class MultipleCatchDemo {
    public static void main(String[] args) {
        try {
            int[] arr = new int[3];
            arr[5] = 10; // ArrayIndexOutOfBoundsException

            String s = null;
            System.out.println(s.length()); // NullPointerException

            int a = 10 / 0; // ArithmeticException
        } 
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Error: " + e.getMessage());
        }
        catch (NullPointerException e) {
            System.out.println("Null Error: " + e.getMessage());
        }
        catch (ArithmeticException e) {
            System.out.println("Math Error: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("General Error: " + e.getMessage());
        }

        System.out.println("Program continues...");
    }
}
```

---

# **11.4 – Exception Hierarchy**

Java organizes all exceptions under **Throwable**.

```
Throwable
 ├── Error
 │    ├── OutOfMemoryError
 │    ├── StackOverflowError
 │    └── ThreadDeath
 └── Exception
      ├── RuntimeException
      │     ├── ArithmeticException
      │     ├── NullPointerException
      │     └── ArrayIndexOutOfBoundsException
      └── Checked Exceptions
            ├── IOException
            ├── SQLException
            └── ClassNotFoundException
```

---

## **Errors**
Errors represent **serious problems** caused by the environment:
- Memory full  
- System crash  
- JVM internal failure  

These cannot be handled with try–catch.

---

## **Exceptions**
Exceptions are conditions that can be **handled**.

---

### **Types of Exceptions**

---

## **A. Checked Exceptions (Compile-Time Exceptions)**

The compiler forces you to handle them.

Examples:
- `IOException`
- `SQLException`
- `ClassNotFoundException`

#### **Example**
```java
import java.io.*;

public class CheckedExample {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("abc.txt");
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
```

---

## **B. Unchecked Exceptions (Runtime Exceptions)**

Occur during runtime.

Examples:
- `ArithmeticException`
- `NullPointerException`
- `ArrayIndexOutOfBoundsException`

#### **Example**
```java
int n = 10 / 0; // ArithmeticException
```

---

# **11.5 – throw Keyword**

The `throw` keyword is used to **explicitly** throw an exception.

---

## **Syntax**

```java
throw new Exception("Error message");
```

---

## **Example 1: Manual ArithmeticException**

```java
public class ThrowDemo {
    public static void main(String[] args) {
        try {
            int a = 10, b = 0;

            if (b == 0) {
                throw new ArithmeticException("Denominator cannot be zero");
            }

            System.out.println(a / b);
        }
        catch (Exception e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}
```

---

## **Example 2: Custom Validation**

```java
public class AgeValidator {
    public static void checkAge(int age) {
        if (age < 18) {
            throw new ArithmeticException("Age must be 18 or above.");
        }
        System.out.println("Valid age");
    }

    public static void main(String[] args) {
        try {
            checkAge(15);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
```

---

# **11.6 – Custom Exceptions**

Custom exceptions are **user-defined exceptions** used when built-in exceptions don’t meet application requirements.

---

## **Creating a Custom Exception**

```java
class NavinException extends Exception {
    NavinException(String message) {
        super(message);
    }
}
```

---

## **Using the Custom Exception**

```java
public class CustomExceptionDemo {
    public static void main(String[] args) {
        try {
            int j = 0;

            if (j == 0) {
                throw new NavinException("j cannot be zero!");
            }

            int result = 18 / j;
            System.out.println(result);
        }
        catch (NavinException e) {
            System.out.println("Custom Error: " + e.getMessage());
        }
    }
}
```

---


